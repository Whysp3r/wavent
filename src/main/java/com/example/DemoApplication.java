package com.example;

import com.example.bean.Event;
import com.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EventRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		repository.deleteAll();

		//Create some new events
		repository.save(new Event("Apero chez Nono","Venez partager un moment agreable avec plein de jacko bitchies"));
		repository.save(new Event("Coinche bitchies","Ca joue ou sa discute bordel"));
		repository.save(new Event("Slackline au park","venez taper la slack les potos"));

		System.out.println("-------------------------------");
		for (Event event : repository.findAll()) {
			System.out.println(event);
		}
		System.out.println();

		System.out.println(repository.findEventByName("Coinche bitchies"));

	}
}
