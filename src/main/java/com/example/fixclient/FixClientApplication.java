package com.example.fixclient;

import io.allune.quickfixj.spring.boot.starter.EnableQuickFixJClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import quickfix.*;

@SpringBootApplication
public class FixClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FixClientApplication.class, args);
    }


    @Bean
    public Initiator clientInitiator(
            Application clientApplication,
            MessageStoreFactory clientMessageStoreFactory,
            SessionSettings clientSessionSettings,
            LogFactory clientLogFactory,
            MessageFactory clientMessageFactory) throws ConfigError {

        return new ThreadedSocketInitiator(clientApplication, clientMessageStoreFactory, clientSessionSettings,
                clientLogFactory, clientMessageFactory);
    }
}
