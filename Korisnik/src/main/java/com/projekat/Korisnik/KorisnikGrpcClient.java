package com.projekat.Korisnik;

import org.springframework.context.annotation.Configuration;
import com.google.protobuf.Timestamp;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class KorisnikGrpcClient {
	
	public void pozovi(Timestamp timestamp, String nazivMikroservisa, SystemEventsOuterClass.Request.tipAkcije tip, String nazivResursa, Integer statusniKod) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8086).usePlaintext().build();
		
		SystemEventsGrpc.SystemEventsBlockingStub systemEventsBlockingStub = SystemEventsGrpc.newBlockingStub(channel);
		SystemEventsOuterClass.Request request = SystemEventsOuterClass.Request.newBuilder()
		     .setTimestamp(timestamp)
		     .setNazivMikroservisa(nazivMikroservisa)
		     .setTip(tip)
		     .setNazivResursa(nazivResursa)
		     .build();
		
		SystemEventsOuterClass.Response response = systemEventsBlockingStub.start(request);
			
		channel.shutdown();
	}
	
}
