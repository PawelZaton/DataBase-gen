package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);

		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		List<Bank> list = new ArrayList<Bank>();
		list.add(new Bank("mBank"));
		list.add(new Bank("Milenium"));
		list.add(new Bank("ING"));
		list.add(new Bank("BNP"));

		for(Bank v:list) {
			entityManager.persist(v);
		}



		entityManager.getTransaction().commit();
		entityManagerFactory.close();


	}

}
