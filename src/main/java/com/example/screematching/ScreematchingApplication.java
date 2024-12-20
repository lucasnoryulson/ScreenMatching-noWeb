package com.example.screematching;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.screematching.model.DadosSerie;
import com.example.screematching.service.ConsumoApi;
import com.example.screematching.service.ConverteDados;

@SpringBootApplication
public class ScreematchingApplication implements  CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreematchingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
	

}
