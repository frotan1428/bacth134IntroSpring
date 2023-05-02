package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component("mailService") //when scanner start scanning it creates one obj from this class...
// default baen name for this class is "mailService"

//@Scope(value = "singleton") //by default the value is singleton which means only one instance will be created
// whenever ne call the obj it will return us the same obj
@Scope(value = "prototype") //creates new obj whenever we request the obj from the class
public class MailService implements MessageService{

    /*
     "@PostConstruct" is a Java annotation used to specify a method that needs to be executed after an object is constructed
   and all of its dependencies have been injected
   */
    @PostConstruct
    public void init(){
        System.out.println("MAIL Service Object is Created ...");
    }

    /*
"@PreDestroy" is used to annotate a method that needs to be executed just before the bean is destroyed by the container.
 This method is typically used to release any resources held by the bean before it is destroyed.
   */
    @PreDestroy
    public void Destroy(){
        System.out.println("MAIL Service Object is destroy ...");
    }

    //there are 3 ways of DI

    //1st Field Injection
    @Autowired //when spring creates instance from MailService, it will inject Repository
    @Qualifier("fileRepository")
    private Repository repository; // null

    //2nd way: Setter Injection
//    private Repository repository;
//    @Autowired
//    @Qualifier("fileRepository")
//
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }

    //3rd way: Constructor Injection
    //this way is suggested because:
        //it is more secure
        // when u test, it will be easy
        //  to read
//    private Repository repository;
//    @Autowired
//    public MailService( @Qualifier("fileRepository") Repository repository) {
//        this.repository = repository;
//    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("I am a Mail Service. I am sending this message: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        repository.save(message);
    }

    //
    @Autowired
    private Random random;
    public void createRandom(){
        //Random random = new Random();
        System.out.println(random.nextInt(100));
    }


}
