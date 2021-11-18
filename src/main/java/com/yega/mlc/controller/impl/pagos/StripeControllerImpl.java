package com.yega.mlc.controller.impl.pagos;

import com.yega.mlc.dto.pagos.PaymentIntentDTO;
import com.yega.mlc.dto.pagos.TokenDTO;
import com.yega.mlc.service.pagos.PaymentService;


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.yega.mlc.controller.pagos.StripeController;
import com.yega.mlc.service.TransaccionPagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class StripeControllerImpl implements StripeController {

    @Autowired
    TransaccionPagoService paymentService;

    @PostMapping("/pagoservice/pagar")
    @Override
    public ResponseEntity<PaymentIntentDTO> payment(@RequestBody TokenDTO tokenDTO) throws StripeException{
        PaymentIntentDTO paymentIntentDTO = paymentService.paymentIntent(tokenDTO);
       
        return ResponseEntity.status(HttpStatus.OK).body(paymentIntentDTO);
       }

    @PostMapping("/confirmar/{id}")
    public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.confirm(id);
        String paymentStr = paymentIntent.toJson();
     System.out.println(paymentStr); 
        
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }

    @PostMapping("/cancelar/{id}")
    public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.cancel(id);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
    }
}
