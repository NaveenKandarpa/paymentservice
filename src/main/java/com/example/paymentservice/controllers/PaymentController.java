package com.example.paymentservice.controllers;

import com.example.paymentservice.dtos.InitiatePaymentRequestDto;
import com.example.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
     public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) {
        try {
            return paymentService.initiatePayment(requestDto.getOrderId(),
                    requestDto.getAmount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}