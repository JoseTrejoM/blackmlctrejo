package com.yega.mlc.service.impl;


import com.yega.mlc.common.Correo;
import com.yega.mlc.common.Decrypt;
import com.yega.mlc.common.Encrypt;
import com.yega.mlc.entity.UsuarioEntity;
import com.yega.mlc.repository.PersonaFisicaRepository;
import com.yega.mlc.repository.UserRepository;
import com.yega.mlc.service.PasswordRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class PasswordRecoveryServiceImpl implements PasswordRecoveryService {

    @Autowired
    private PersonaFisicaRepository personaFisicaRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private Correo correo;

    @Override
    public String sendEmail(String token) {

        String msg = "";

        try{

            String cipherCurp = Encrypt.encrypt(token);

            String decipher = Decrypt.decrypt(cipherCurp);

            System.out.println("curp cifrada: " + cipherCurp);
            System.out.println("curp descifrada: " + decipher);

            var pf = personaFisicaRepository.findByCurp(decipher);

            if(null != pf){
                Optional<UsuarioEntity> usrOpt =  userRepository.findByPersonaFisicaId(pf.getPersonaFisicaId());

                if (usrOpt.isPresent()){

                    UsuarioEntity userEntity =  usrOpt.get();
                    String messageBody = String.join(
                            System.getProperty("line.separator"),
                            "<h1>MLC Restablecimiento de Contraseña</h1>",
                            "<p>Escuchamos que olvidó su contraseña, lo sentimos, pero no se preocupe, para restablecerla utilice el siguiente link. ",
                            "<a href='http://localhost/"+cipherCurp+"'>Restablecimiento de su contraseña</a>",
                            ""
                    );

                    String subject = "Recuperación de contraseña";
                   // correo.sendEmailRecoverPassword(userEntity.getUsuario(), "guillermo.cdbt@gmail.com", messageBody, subject);
                    msg ="Se envió el correo de manera exitosa";
                }else{
                    msg = "ERROR >> no existe persona física asociada a la CURP";
                }
            }else {
                msg = "No existe curp";
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return msg;
    }
}
