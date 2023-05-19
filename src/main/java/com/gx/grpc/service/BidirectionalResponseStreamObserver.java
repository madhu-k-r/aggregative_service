package com.gx.grpc.service;

import java.util.concurrent.TimeUnit;

import com.esotericsoftware.minlog.Log;
import com.google.common.util.concurrent.Uninterruptibles;
//import com.gx.grpc.generatedcode.BidirectionalClientRequest;
//import com.gx.grpc.generatedcode.BidirectionalServerResponse;
//import com.gx.grpc.service.Message.MessageType;

import io.grpc.stub.StreamObserver;
import tmt.pcrf.grpc.ClientMessage;
import tmt.pcrf.grpc.MessageType;
import tmt.pcrf.grpc.ServerMessage;

public class BidirectionalResponseStreamObserver implements StreamObserver<ServerMessage> {

	private StreamObserver<ClientMessage> requestStreamObserver;

	int count = 1;
	String message = "{\r\n"
			+ "\"header\":\r\n"
			+ "{\r\n"
			+ "\"commandCode\":272,\r\n"
			+ "\"flag\":2,\r\n"
			+ "\"application-id\":0,\r\n"
			+ "\"hop-by-hop-id\": \"String\",\r\n"
			+ "\"end-to-end-id\": \"String\"\r\n"
			+ "},\r\n"
			+ "\"message\": {\r\n"
			+ "\"Session-Id\": \"seagull.mydomain0.com;109629839100043;1\",\r\n"
			+ " \"Origin-Host\": \"seagull.mydomain.com\",\r\n"
			+ "\"Origin-Realm\" : \"seagull.mydomain.com\",\r\n"
			+ "\"Origination\" : \"\",\r\n"
			+ " \"Vendor-Specific-Application-Id\":\r\n"
			+ " {\r\n"
			+ " \"Vendor-Id\": 10415,\r\n"
			+ "\"Auth-Application-Id\": 4\r\n"
			+ "},\r\n"
			+ "\"CC-Request-Type\": 1,\r\n"
			+ "\"CC-Request-Number\":1,\r\n"
			+ "\"IP-CAN-Type\":0,\r\n"
			+ " \"Subscription-Id\":\r\n"
			+ "{\r\n"
			+ " \"Subscription-Id-Type\":0,\r\n"
			+ "\"Subscription-Id-Data\":\"919555101011\"\r\n"
			+ " },\r\n"
			+"\"Framed-IP-Address\": \"10.105.22.56\",\r\n" 
            +"\"Framed-Ipv6-Prefix\": \"10.124.3.12\"\r\n" 
			+ " }\r\n"
			+ "}";
	
	/////////////////////////////////////////////////////
	
//	MessageType messageType;
	long moduleId;
	int status;
	String uniqueRefId;
	String messageKey;
	String sessionId;

//	enum MessageType {
//		NW_REQUEST, NW_RESPONSE, APP_REQUEST, APP_RESPONSE, OTHERS
//	}
	/////////////////////////////////////////////////////
	
	@Override
	public void onNext(ServerMessage value) {
		Log.info(value.getMessage());
		this.sendtoServer();
	}

	@Override
	public void onError(Throwable t) {

		
	}

	@Override
	public void onCompleted() {

		
	}

	public void startsendRequest(StreamObserver<ClientMessage> requestStreamObserver) {
		this.requestStreamObserver = requestStreamObserver;
		this.sendtoServer();
	}

	 private void sendtoServer(){
	        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	        ClientMessage clientMessage = ClientMessage.newBuilder().setMessage(message).setModuleId(moduleId)
	        		.setStatus(status).setUniqueRefId("qwererty").setMessageKey("key")
	        		.setMessageType(MessageType.NW_REQUEST
	        				).build();
	        Log.info("sending request to server: " +count);
	        count++;
	        requestStreamObserver.onNext(clientMessage);
	    }


}
