package com.example.systemevents;

import com.example.systemevents.SystemEventsGrpc.SystemEventsImplBase;
import com.example.systemevents.SystemEventsOuterClass.Request;
import com.example.systemevents.SystemEventsOuterClass.Response;

import io.grpc.stub.StreamObserver;

public class SystemEventsImpl extends SystemEventsImplBase {

	
	@Override
	public void start(Request request, StreamObserver<Response> responseObserver) {
 
        String odgovorNaAkciju = new StringBuilder()
          .append("Servis, ")
          .append(request.getTimestamp())
          .append(request.getNazivMikroservisa())
          .append(request.getTip())
          .append(request.getNazivResursa())
          .toString();
 
        Response response = Response.newBuilder()
          .setOdgovorNaAkciju(odgovorNaAkciju)
          .build();
 
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
	 
	
}
