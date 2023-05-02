package com.tpe.main;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Your order has been shipped...");

        // this is how we did in core...
//        MessageService mailService = new MailService();
//        mailService.sendMessage(message);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        //MailService mailService1 =  context.getBean(MailService.class);
       // MessageService mailService1 =  context.getBean(MailService.class);
        MessageService mailService1 =  context.getBean("mailService", MessageService.class); //spring is smart enough that it finds the the concrete class
        //  which extends from the interface
        mailService1.sendMessage(message);
        // we get method from Mailservice class, without using new keyword

//        MessageService smsService =  context.getBean("smsService", MessageService.class);
//        smsService.sendMessage(message);


        //new instance for save method
//        MessageService mailService2 =  context.getBean("mailService", MessageService.class);
//        mailService2.sendMessage(message);
//        mailService2.saveMessage(message);

        //example for Bean - Random class
//       MailService mailService3 =  context.getBean(MailService.class);
//       mailService3.createRandom();

        //let s test if Spring creates single obj
//        MessageService service4 = context.getBean(MailService.class);
//        MessageService service5 = context.getBean(MailService.class);
//
//        if(service4 == service5){
//            System.out.println("They are the same obj");
//            System.out.println(service4);
//            System.out.println(service5);
//        }else {
//            System.out.println("They are NOT the same obj");
//            System.out.println(service4);
//            System.out.println(service5);
//        }

//        SmsService service3= context.getBean(SmsService.class);
//        service3.createRandom();
//        service3.sendMessage(message);
//        service3.printContact();
//        service3.printProperties();

        //how to see all bean that are Created with Spring Container

//       String [] beanNames = context.getBeanDefinitionNames();
//       for (String name :beanNames){
//           System.out.println(name);
//       }



        context.close(); //this will destroy the beans created

    }
}
