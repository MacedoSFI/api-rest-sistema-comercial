package net.felipemacedo.equipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EquipesDeProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipesDeProjetoApplication.class, args);
	}
//depois procurar no projeto onde tiver ManyToMany conf o fetch para EAGER, que por padrao é LAZY
}


/*
 *DICA PARA FACILITAR:
 *PASSO A PASSO - INICIAR O SISTEMA:

1- descomentar o método main da classe WebSecurity...;
2- executá-lo como java application;
vai gerar a senha criptogravada de 1234: $2a$10$Qc7QIH6VH3oqr5mX.pQPzOeWHncynPoP28wRPoaph91Td9yUGf4yy

atualizar essa senha no banco de dados no registro do usuário;

3- fazer um POST no Postman url: http://localhost:8080/auth     opção json, no campo raw:

{
    "username":"felipebbmacedo@gmail.com",
    "password":"1234"
}

4- na aba headers      adiciona Key: Content-Type Value: application/json
vai obter de retorno:

{
    "tipo": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgUHJvamV0b3MgZGUgRmVsaXBlIiwic3ViIjoiMSIsImlhdCI6MTYxOTUyNzQzMywiZXhwIjoxNjE5NjEzODMzfQ.DV9kGAnuH4HfaCZHHlkm5STB15Y9hwqYvq_kympJUZk",
    "token": "Bearer"
}

O que fazer com essa informação????

configurar o postman:

1- aba authorization, type Bearer token, cola o token (o que está entre aspas) acima no campo correspondente SEM AS ASPAS, 

pronto, só ver no controller os endpoints e métodos PUT, POST, GET, E DELETE
 * 
 * */