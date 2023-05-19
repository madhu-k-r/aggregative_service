package com.gx.grpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gx.grpc.service.GxSessionClientService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class GxSessionClientController {

    @Autowired
    private GxSessionClientService gxSessionClientService;

//    
//    @GetMapping("/process")
//    public void processreq(){
//    	String value = "{\r\n"
//				+ "\"header\":\r\n"
//				+ "{\r\n"
//				+ "\"commandCode\":272,\r\n"
//				+ "\"flag\":2,\r\n"
//				+ "\"application-id\":0,\r\n"
//				+ "\"hop-by-hop-id\": \"String\",\r\n"
//				+ "\"end-to-end-id\": \"String\"\r\n"
//				+ "},\r\n"
//				+ "\"message\": {\r\n"
//				+ "\"Session-Id\": \"seagull.mydomain0.com;109629839100018;1\",\r\n"
//				+ " \"Origin-Host\": \"seagull.mydomain.com\",\r\n"
//				+ "\"Origin-Realm\" : \"seagull.mydomain.com\",\r\n"
//				+ "\"Origination\" : \"\",\r\n"
//				+ " \"Vendor-Specific-Application-Id\":\r\n"
//				+ " {\r\n"
//				+ " \"Vendor-Id\": 10415,\r\n"
//				+ "\"Auth-Application-Id\": 4\r\n"
//				+ "},\r\n"
//				+ "\"CC-Request-Type\": 1,\r\n"
//				+ "\"CC-Request-Number\":0,\r\n"
//				+ " \"Subscription-Id\":\r\n"
//				+ "{\r\n"
//				+ " \"Subscription-Id-Type\":0,\r\n"
//				+ "\"Subscription-Id-Data\":\"0844098440\"\r\n"
//				+ " }\r\n"
//				+ " }\r\n"
//				+ "}";
////    	String request = "demo";
////        return this.gxSessionClientService.processRequest(value);
//    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/bidirectionaltestProcess")
    public Flux<Object> bidirectionalProcess(){
        try {
			return this.gxSessionClientService.bidirectionaltest();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
    }
    
}
