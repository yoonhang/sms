package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.provider.SmsProvider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

    private final SmsProvider smsProvider;

    public ResponseEntity<String> sendSms(String to) {
        boolean isSuccess = smsProvider.sendSms(to);
        String message = isSuccess ? "SMS sent successfully to " + to : "Failed to send SMS to " + to;
        HttpStatus status = isSuccess ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(message, status);
    }
}