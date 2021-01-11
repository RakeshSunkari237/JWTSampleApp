package com.jwtsampleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.Claims;

@SpringBootApplication
public class JwtSampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSampleAppApplication.class, args);
		String key="amma";
		//String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNDMiLCJzdWIiOiJSYWtlc2giLCJpc3MiOiJSYWtlc2giLCJpYXQiOjE2MTAwODEwNzEsImV4cCI6MTYxMDA4MTEzMX0.vY5UtV5d1-rK0Hr2lNHUq6a4wzvfPtzTS1R9rqJR7-g";
		
		JwtUtil util=new JwtUtil();
		// 1. Token Generation
		
		  String token = util.genereateToken("143", "Rakesh", key);
		  System.out.println(token);
		 
		
		//2. Reading Token Details
		Claims claims = util.getClaims(key, token);
		System.out.println(claims.getId());
		System.out.println(claims.getSubject());
		System.out.println(claims.getExpiration());
		
		//3. Reading Subject only
		System.out.println("Subject is : "+util.getSubject(key, token));
		
		//4. Checking Token is Expired or not
		System.out.println("isValid Token : "+util.isValidToken(key, token));
	}

}
