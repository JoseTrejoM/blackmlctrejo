package com.yega.mlc.common;

import com.yega.mlc.dto.ContactoPersonaDTO;
import com.yega.mlc.dto.MembresiaDTO;
import com.yega.mlc.dto.PersonaFisicaDTO;
import com.yega.mlc.dto.PersonaMailDTO;
import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import com.yega.mlc.entity.ConfiguracionSysEntity;
import com.yega.mlc.repository.ConfiguracionSysRepository;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Correo")
public class Correo {

    @Autowired
    private ConfiguracionSysRepository configuracionRepository;
    private static String from;
    private static String host;
    private static String to;
    private static String puerto;
    private static String password;
    private static String urlSistema;
    private static String correoSoporte;

    private Optional<ConfiguracionSysEntity> configuracion;

    public String inicio(String plantilla) {
        configuracion = configuracionRepository.findByNombre("ServidorCorreo");
        host = configuracion.get().getValor();
        configuracion = configuracionRepository.findByNombre("Correoenvios");
        from = configuracion.get().getValor();
        configuracion = configuracionRepository.findByNombre("ContraseniaCorreo");
        password = configuracion.get().getValor();
        configuracion = configuracionRepository.findByNombre("PuertoSalida");
        puerto = configuracion.get().getValor();

        configuracion = configuracionRepository.findByNombre("CorreoSoporte");
        correoSoporte = configuracion.get().getValor();
        configuracion = configuracionRepository.findByNombre("URLSistema");
        urlSistema = configuracion.get().getValor();
        configuracion = configuracionRepository.findByNombre(plantilla);
        return configuracion.get().getValor();
    }

    public void envia(PersonaMailDTO personaTo, String plantilla) {
        try {
            String mensaje = inicio(plantilla);
            String mailTo = personaTo.getContacto().getContacto();
            String[] cadena = mensaje.split("\\|");
            String asunto = cadena[0];
            mensaje = cadena[1];
            mensaje = reemplaza(personaTo, mensaje);
            mensaje = mensaje.replace("[URLSistema]", urlSistema);
            mensaje = mensaje.replace("[CorreoSoporte]", correoSoporte);
            asunto = reemplaza(personaTo, asunto);
            enviaCorreo(mailTo, from, asunto, mensaje);
        } catch (IllegalArgumentException iae) {
            System.out.println("Se pasaron mal los argumentos" + iae.getMessage());
        } catch (IllegalAccessException iace) {
            System.out.println("Error al en los accesores de la clase" + iace.getMessage());
        } catch (InvocationTargetException ite) {
            System.out.println("Error en el destino" + ite.getMessage());
        }
    }

    public static void enviaCorreo(String emailTo, String emailFrom, String asunto, String messageBody) {

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", puerto);
        properties.put("mail.smtp.mail.sender", emailFrom);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.user", emailFrom);
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, password);
            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            message.setSubject(asunto);
            //message.setText(messageBody);
            message.setContent(messageBody, "text/html");
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public String reemplaza(PersonaMailDTO persona, String mensaje) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<PersonaMailDTO> clasePersona = PersonaMailDTO.class;
        Method[] metodoClase = clasePersona.getMethods();
        for (Method metodo : metodoClase) {
            if (metodo.getName().contains("get")) {
                switch (metodo.getName()) {
                    case "getContacto":
                        Class<ContactoPersonaDTO> contactoPersona = ContactoPersonaDTO.class;
                        Method[] metodosContacto = contactoPersona.getMethods();
                        for (Method metodoContacto : metodosContacto) {
                            if (metodoContacto.getName().startsWith("get") && Modifier.isPublic(metodoContacto.getModifiers())
                                    && !metodoContacto.getName().contains("Class")) {
                                String variable = "[" + metodoContacto.getName().replace("get", "") + "]";
                                //System.out.println(variable);
                                if (metodoContacto.invoke(persona.getContacto()) != null) {
                                    String valor = metodoContacto.invoke(persona.getContacto()).toString();
                                   // System.out.println(metodoContacto.invoke(persona.getContacto()));
                                   // System.out.println(variable + "-" + valor);
                                    mensaje = mensaje.replace(variable, valor);
                                }
                            }
                        }
                        break;
                    case "getPersona":
                        Class<PersonaFisicaDTO> personaFisica = PersonaFisicaDTO.class;
                        Method[] metodosPersonaFisica = personaFisica.getMethods();
                        for (Method metodoPersonaFisica : metodosPersonaFisica) {
                            if (metodoPersonaFisica.getName().startsWith("get") && Modifier.isPublic(metodoPersonaFisica.getModifiers())
                                    && !metodoPersonaFisica.getName().contains("Class")) {
                                String variable = "[" + metodoPersonaFisica.getName().replace("get", "") + "]";
                                if (metodoPersonaFisica.invoke(persona.getPersona()) != null) {
                                    String valor = metodoPersonaFisica.invoke(persona.getPersona()).toString();
                                    //System.out.println(variable + "-" + valor);
                                    mensaje = mensaje.replace(variable, valor);
                                }
                            }
                        }
                        break;
                    case "getMembresia":
                        Class<MembresiaDTO> membresia = MembresiaDTO.class;
                        Method[] metodosMembresia = membresia.getMethods();
                        for (Method metodoMembresia : metodosMembresia) {
                            if (metodoMembresia.getName().startsWith("get") && Modifier.isPublic(metodoMembresia.getModifiers())
                                    && !metodoMembresia.getName().contains("Class")) {
                                //  System.out.println(metodoPersonaFisica.getName());
                                //  System.out.println((String) metodoPersonaFisica.invoke(persona.getPersona()).toString());
                                String variable = "[" + metodoMembresia.getName().replace("get", "") + "]";
                                if (metodoMembresia.invoke(persona.getMembresia()) != null) {
                                    String valor = metodoMembresia.invoke(persona.getMembresia()).toString();
                                    //System.out.println(variable + "-" + valor);
                                    mensaje = mensaje.replace(variable, valor);
                                }
                            }
                        }
                        break;
                    case "getPago":
                        Class<PaymentIntentDTO> paymentIntentDTO = PaymentIntentDTO.class;
                        Method[] metodosPaymentIntentDTO = paymentIntentDTO.getMethods();
                        for (Method metodoPaymentIntentDTO : metodosPaymentIntentDTO) {
                            if (metodoPaymentIntentDTO.getName().startsWith("get") && Modifier.isPublic(metodoPaymentIntentDTO.getModifiers())
                                    && !metodoPaymentIntentDTO.getName().contains("Class")) {
                                //  System.out.println(metodoPersonaFisica.getName());
                                //  System.out.println((String) metodoPersonaFisica.invoke(persona.getPersona()).toString());
                                String variable = "[" + metodoPaymentIntentDTO.getName().replace("get", "") + "]";
                                if (metodoPaymentIntentDTO.invoke(persona.getPago()) != null) {
                                    String valor = metodoPaymentIntentDTO.invoke(persona.getPago()).toString();
                                  //  System.out.println(variable + "-" + valor);
                                    mensaje = mensaje.replace(variable, valor);
                                }
                            }
                        }
                        break;
                }
            }
        }
        return mensaje;
    }

    public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Correo mail = new Correo();
        PersonaMailDTO personaMail = new PersonaMailDTO();
        personaMail.setPersona(new PersonaFisicaDTO());
        personaMail.setContacto(new ContactoPersonaDTO());
        personaMail.setMembresia(new MembresiaDTO());
        personaMail.getPersona().setCurp("BEGO731126HDFLMS02");
        personaMail.getPersona().setNombre("OSCAR");
        personaMail.getPersona().setPrimerApellido("BELMONT");
        personaMail.getPersona().setSegundoApellido("GOMEZ");
        personaMail.getContacto().setContacto("obelmontg@gmail.com");
        personaMail.getMembresia().setNumMembresia("000001");
        personaMail.getMembresia().setConsecutivo(0);

        //  personaMail.getContacto().setActivo(true);
        /*  mail.mensaje = "Asunto:Envio de correo|Mensaje:CORREO DE BIENVENIDA Y SOLICITUD DE CAMBIO DE CONTRASEÑA\n"
                + "¡ Hola [Nombre] [PrimerApellido] [SegundoApellido] !\n"
                + "¡ Bienvenid(o/a) a México Lindo Contigo!\n"
                + "Felicidades por dar un paso importante para asegurar que tus necesidades y las de tu famillia estén atendidas! \n"
                + "Los datos con los que podrás ingresar a la App  de MLC son:\n"
                + "Usuario: [Contacto]\n"
                + "Contraseña Temporal: [Temporal]\n"
                + "Al entrar por primera vez podrás crear tu propia  contraseña. \n"
                + "o\n"
                + "Haz click en el siguiente link para entrar y cambiar tu contraseña en el portal. \n"
                + "[UrlSistema]\n"
                + "Disfruta tu experiencia con nosotros! Estamos para servirte!\n"
                + "México Lindo Contigo  - Tranquilidad A Tu Alcance";
        mail.reemplaza(personaMail);*/
    }
}
