package com.gx.grpc.service;

import org.springframework.stereotype.Service;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import reactor.core.publisher.Flux;
import tmt.pcrf.grpc.ClientMessage;
import tmt.pcrf.grpc.TmtGrpcServiceGrpc;

@Service
public class GxSessionClientService {


	@GrpcClient("gxgrpcservice")
	private TmtGrpcServiceGrpc.TmtGrpcServiceStub normalStub;

	public Flux<Object> bidirectionaltest() throws InterruptedException {
		BidirectionalResponseStreamObserver bidirectionalResponseStreamObserver = new BidirectionalResponseStreamObserver();
		StreamObserver<ClientMessage> requestStreamObserver = this.normalStub.processGrpcMessage(bidirectionalResponseStreamObserver);
		bidirectionalResponseStreamObserver.startsendRequest(requestStreamObserver);
		return null;
	}
}
