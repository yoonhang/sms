package com.example.demo.service.implementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImplementation implements TestService {

    private final SmsProvider smsProvider;

    @Override
    public ResponseEntity<String> sendSms(String to) {

        // throw new UnsupportedOperationException(message:"Unimplemented method 'sendSms'");

        try {
            boolean result smsProvider.sendSms(to);
            if (!result) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body:"메세지 전송 오류");
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body:"메세지 전송 예외 발생");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body:"메세지 전송 예외 발생");

    }
}
