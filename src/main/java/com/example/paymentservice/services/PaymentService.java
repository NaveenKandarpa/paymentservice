package com.example.paymentservice.services;

import com.example.paymentservice.paymentgateways.PaymentGateway;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId, Long amount) throws RazorpayException, StripeException {
        return paymentGateway.generatePaymentLink(orderId, amount);
    }
}
