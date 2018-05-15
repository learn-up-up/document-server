package com.bgs.mylove.documentserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@EnableFeignClients
@SpringCloudApplication//替换前面的注解
public class DocumentServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DocumentServerApplication.class,args);
        System.out.println( "Hello World!" );
    }
}
