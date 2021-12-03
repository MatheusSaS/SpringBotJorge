package com.agenda.agendaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AgendaApiApplication {
	
	/*@Bean
	public CommandLineRunner run(@Autowired ContatoRepository repository) {
		return args -> {
			Contato contato = new Contato();
			contato.setNome("Tiago");
			contato.setEmail("tiago@teste.com");
			contato.setFavorito(false);
			repository.save(contato);
		};
	}
	*/

	// ..método principal
	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}

}
