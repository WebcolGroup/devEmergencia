package com.cmc.app.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan({"com.cmc.app.commons.user.entity"})
@SpringBootApplication
public class DesarrolloEmergenciasServiceUserRestresourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesarrolloEmergenciasServiceUserRestresourceApplication.class, args);
	}

}
