package com.epicode.capstone.Capstone.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.*;

@SpringBootApplication
public class CapstoneBackendApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(CapstoneBackendApplication.class, args);


//		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//
//
//		keyPairGenerator.initialize(2048);
//
//
//		KeyPair keyPair = keyPairGenerator.generateKeyPair();
//
//
//		PublicKey publicKey = keyPair.getPublic();
//		PrivateKey privateKey = keyPair.getPrivate();
//
//		System.out.println("Chiave pubblica: " + publicKey);
//		System.out.println("Chiave privata: " + privateKey);
	}

}
