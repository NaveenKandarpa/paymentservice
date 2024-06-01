package com.example.paymentservice.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {
    @Value("${razorpay.key.id}")
    String razorPayKeyId;

    @Value("${razorpay.key.secret}")
    String getRazorPayKeySecret;

    @Bean
    public RazorpayClient getRazorPayClient() throws RazorpayException {
        return new RazorpayClient(razorPayKeyId, getRazorPayKeySecret);
    }
}
