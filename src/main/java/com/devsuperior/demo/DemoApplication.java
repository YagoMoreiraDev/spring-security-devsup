package com.devsuperior.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("ENCODE = " + passwordEncoder.encode("123456"));
		
		//Como o Spring compara a senha passada pelo usuario com o hash criado pelo Bcrypt:
		boolean result = passwordEncoder.matches("123456", "$2a$10$aHRdy5X04TZBty2IPJxx5.t.cly/99ztZTcHe594Hd625VfbAHj4u");
		
		System.out.println(result);
	}
	
}
