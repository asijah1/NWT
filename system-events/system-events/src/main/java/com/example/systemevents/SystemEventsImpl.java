package com.example.systemevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.systemevents.SystemEventsGrpc.SystemEventsImplBase;
import com.example.systemevents.SystemEventsOuterClass.Request;
import com.example.systemevents.SystemEventsOuterClass.Response;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.Timestamp;


@Component
public class SystemEventsImpl extends SystemEventsImplBase {
	
	private final AkcijaRepository akcijaRep;
	
	public SystemEventsImpl(AkcijaRepository repository) {
	    this.akcijaRep = repository;
	  }
	
	@Override
	public void start(Request request, StreamObserver<Response> responseObserver) {
		System.out.println("--->Metoda start je pozvana<---\n");
		System.out.println("Parametri:\n" + "NazivMikroservisa: " + request.getNazivMikroservisa() 
										+ "\nTipAkcije: " + request.getTip() 
										+ " \nNazivResursa: " + request.getNazivResursa()
										+ "\nTimeStamp: " + request.getTimestamp() 
										+ "\n");
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
        
        //ovdje mi baca izuzetak
        Akcija novaAkcija = new Akcija(request.getTimestamp(), request.getNazivMikroservisa(), request.getTip(), request.getNazivResursa());
        //Akcija pomocna = new Akcija();
        System.out.println(novaAkcija.toString() + "ovo je prije spremanja u repozitorij");
        //akcijaRep.save(pomocna);
        //System.out.println("Uspješno predjen konstruktor bez parametara");
        Akcija akcijaZaIspis = akcijaRep.save(novaAkcija);
        System.out.println(akcijaZaIspis.toString() + "to je to");
    	//akcijaRepository.save(new Akcija());
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        //System.out.println("--->Metoda start je završena<---\n");
    }

}
