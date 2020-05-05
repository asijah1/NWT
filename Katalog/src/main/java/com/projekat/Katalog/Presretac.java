package com.projekat.Katalog;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.google.protobuf.Timestamp;

@Component
public class Presretac extends HandlerInterceptorAdapter{
	
	private static final Logger log = LoggerFactory.getLogger(Presretac.class);
	
	@Value("${spring.application.name}")
    private String mikroservis;
	
	@Autowired
    private KatalogGrpcClient katalogGrpcClient;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    // your code - samo provjera
		log.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI());
	    return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	    // your code - samo provjera
		log.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI());
	}
	
	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        pozoviKlijenta(request, response);
        super.afterCompletion(request, response, handler, ex);
    }

    private void pozoviKlijenta(HttpServletRequest request, HttpServletResponse response) {

        SystemEventsOuterClass.Request.tipAkcije tipAkcije = getTipAkcije(request.getMethod());
        String resurs = request.getRequestURI();
        Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
        Integer statusniKod = response.getStatus();
        katalogGrpcClient.pozovi(timestamp, mikroservis, tipAkcije, resurs, statusniKod);
    
    }

    private SystemEventsOuterClass.Request.tipAkcije getTipAkcije(String requestMethod) {
            if(requestMethod.equals("GET"))
                return SystemEventsOuterClass.Request.tipAkcije.GET;
            else if(requestMethod.equals("UPDATE"))
                return SystemEventsOuterClass.Request.tipAkcije.UPDATE;
            else if(requestMethod.equals("CREATE"))
                return SystemEventsOuterClass.Request.tipAkcije.CREATE;
            else if(requestMethod.equals("DELETE"))
                return SystemEventsOuterClass.Request.tipAkcije.DELETE;
            else
            	return SystemEventsOuterClass.Request.tipAkcije.UNRECOGNIZED;
    }
	
}
