package com.bgs.mylove.documentserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DocumentServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DocumentServerApplication.class,args);
        System.out.println( "Hello World!" );
    }
}
