package com.yega.mlc.service.impl.pagos;

import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.yega.mlc.business.PagosDelegate;
import com.yega.mlc.constants.EnumMoneda;
import com.yega.mlc.dto.pagos.TokenDTO;
import com.yega.mlc.service.TransaccionPagoService;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransaccionPagoServiceImpl implements TransaccionPagoService {


    @Value("${stripe.key.secret}")
    String secretKey;
    @Autowired
    @Qualifier("pagosDelegate")
    private PagosDelegate pagosDelegate;
    
    public PaymentIntentDTO paymentIntent(TokenDTO tokenDTO) throws StripeException {
        PaymentIntentDTO paymentIntentDto = tokenDTO.getPaymentIntent();
        Stripe.apiKey = secretKey;
        List<String> paymentMethodTypes = new ArrayList();
        paymentMethodTypes.add("card");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentIntentDto.getMonto() * 1000);
        params.put("currency", paymentIntentDto.getMoneda());
        params.put("description", paymentIntentDto.getDescripcion() + " " + tokenDTO.getCurp());
        params.put("payment_method_types", paymentMethodTypes);
        params.put("payment_method", "pm_card_visa");
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        paymentIntent = paymentIntent.confirm();
        paymentIntentDto.setEstatustransaccion(paymentIntent.getStatus());
        paymentIntentDto.setMoneda(EnumMoneda.valueOf(paymentIntent.getCurrency().toUpperCase()));
        if (paymentIntent.getStatus().equalsIgnoreCase("succeeded")) {
            paymentIntentDto.setDescripcion(paymentIntent.getDescription());
            paymentIntentDto.setTransaccion(paymentIntent.getCreated().toString());
            paymentIntentDto.setMonto((int) (paymentIntent.getAmount() / 1000));
            paymentIntentDto.setTraza("1.-El pago fue realizado exitosamente <p>"); 
            if (!pagosDelegate.crearTransaccionPago(tokenDTO, paymentIntentDto)) {
                 paymentIntentDto.setTraza(paymentIntentDto.getTraza() + " Ocurrio un error al guardar su información <p> Comuniquese a soporte \n"); 
             }
        } else {
            paymentIntentDto.setDescripcion(paymentIntent.getDescription());
            paymentIntentDto.setTransaccion("");
            paymentIntentDto.setMonto(0);
            paymentIntentDto.setFechaFinVigencia("");
            paymentIntentDto.setFechaInicioVigencia("");
            paymentIntentDto.setTraza("No se pudo realizar el pago");
        }
        return paymentIntentDto;
    }

    @Override
    public PaymentIntent confirm(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");
        paymentIntent.confirm(params);
        return paymentIntent;
    }

    @Override
    public PaymentIntent cancel(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        paymentIntent.cancel();
        return paymentIntent;
    }

}
