package com.example.projeto_escola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projeto_escola.models.curso;
import com.example.projeto_escola.repositories.CursoRepository;

@SpringBootApplication
public class ProjetoEscolaApplication {

	@Bean
	public CommandLineRunner init(@Autowired CursoRepository cursoRepository) {
		return args -> {
			cursoRepository.inserir(new curso(0l, "teste",2000));
			cursoRepository.inserir(new curso(0l, "teste2", 2050));

			System.out.println("Exemplo Listar Todos");
			List<curso> listaCursos = cursoRepository.ObterTodos();
			listaCursos.forEach(System.out::println);

			System.out.println("Exemplo Listar por nome");
			listaCursos = cursoRepository.obterPorNome("teste2");
			listaCursos.forEach(System.out::println);
		};
}





	public static void main(String[] args) {
		SpringApplication.run(ProjetoEscolaApplication.class, args);
	}

}
