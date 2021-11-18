package com.yega.mlc.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import com.yega.mlc.dto.pagos.TokenDTO;
import org.springframework.stereotype.Service;


@Service
public interface TransaccionPagoService {

    public PaymentIntentDTO paymentIntent(TokenDTO tokenDTO) throws StripeException;

    public PaymentIntent confirm(String id) throws StripeException;

    public PaymentIntent cancel(String id) throws StripeException;
}
