package org.sharpeideas.cloud.sample.azure.account;


import org.sharpeideas.cloud.sample.azure.account.AccountController;
import org.sharpeideas.cloud.sample.azure.account.AccountServiceApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Created by phil on 09/04/2016.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountServiceApp.class)
public class AccountServer {

    public static void main(String[] args) {
        // Will configure using accounts-server.yml
        System.setProperty("spring.config.name", "account-server");

        SpringApplication.run(AccountServiceApp.class, args);
    }
}