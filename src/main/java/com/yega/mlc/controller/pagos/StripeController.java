package com.yega.mlc.controller.pagos;

import com.yega.mlc.dto.pagos.TokenDTO;
import com.stripe.exception.StripeException;
import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface StripeController {

    public ResponseEntity<PaymentIntentDTO> payment(@RequestBody TokenDTO tokenDTO) throws StripeException ;
    public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException ;
    public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException ;
}
