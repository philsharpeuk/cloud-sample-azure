package org.sharpeideas.cloud.sample.azure.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by phil on 09/04/2016.
 */

@SpringBootApplication
@ComponentScan({"org.sharpeideas.cloud.sample..azure.account"})
public class AccountServiceApp {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args
     *            Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApp.class, args);
    }

}
