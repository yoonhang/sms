package com.example.demo.provider;

//import org.glassfish.jaxb.runtime.v2.runtime.unmarshaller.XsiNilLoader.Single;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Component
public class SmsProvider {

    private final DefaultMessageService messageService;

    @Value("${sms.from-number}")
    String FROM;

    // @Value("${sms.api-key}")
    // private String API_KEY;

    public SmsProvider(

            @Value("${sms.api-key}") String API_KEY,
            @Value("${sms.api-secret-key}") String API_SECRET_KEY,
            @Value("${sms.domain}") String DOMAIN

    ) {

        // this.messageService = NurigoApp.INSTANCE.initialize(apiKey:null,
        // apiSecretKey:null, domain:null);
        this.messageService = NurigoApp.INSTANCE.initialize(API_KEY, API_SECRET_KEY, DOMAIN);
    }

    public boolean sendSms(String to) {

        Message message = new Message();
        message.setFrom(FROM);
        message.setTo(to);
        message.setText("내용");

        SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));

        String statusCode = response.getStatusCode();
        boolean result = statusCode.equals("2000");
        
        // 로그 출력으로 전송 결과를 확인
        System.out.println("SMS 전송 상태 코드: " + statusCode);
        System.out.println("SMS 전송 성공 여부: " + result);
        

        return result;
    }

}
