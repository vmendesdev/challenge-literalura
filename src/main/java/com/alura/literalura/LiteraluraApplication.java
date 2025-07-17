package com.alura.literalura;

import com.alura.literalura.controller.MenuPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.iniciarMenu();
	}
}

