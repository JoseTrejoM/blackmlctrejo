package com.yega.mlc.service.pagos;

import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Service;


@Service
public interface PaymentService{

     public PaymentIntentDTO paymentIntent(PaymentIntentDTO intencionPagoDto) throws StripeException ;

    public PaymentIntent confirm(String id) throws StripeException ;

    public PaymentIntent cancel(String id) throws StripeException;
}
