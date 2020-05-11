package com.example.systemevents;

import org.springframework.stereotype.Component;
import com.example.systemevents.SystemEventsGrpc.SystemEventsImplBase;
import com.example.systemevents.SystemEventsOuterClass.Request;
import com.example.systemevents.SystemEventsOuterClass.Response;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.Timestamp;

@Component
public class SystemEventsImpl extends SystemEventsImplBase {
	
	@Override
	public void start(Request request, StreamObserver<Response> responseObserver) {
		System.out.println("--->Metoda start je pozvana<---\n");
		System.out.println("Parametri:\n" + "NazivMikroservisa: " + request.getNazivMikroservisa() + "\nTipAkcije: " + request.getTip() + "\nTimeStamp: " + request.getTimestamp() + "\n");
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
