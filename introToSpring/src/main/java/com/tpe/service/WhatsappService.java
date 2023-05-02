package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class WhatsappService implements MessageService{


    @Override
    public void sendMessage(Message message) {
        System.out.println("I am a WhatsApp Service. I am sending this message: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

    }
}
