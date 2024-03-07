package com.example.projeto_escola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.projeto_escola.models.curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public curso inserir(curso curso) {
        entityManager.merge(curso);
        return curso;
    }

    public List<curso> ObterTodos() {
        return entityManager.createQuery("SELECT c FROM curso c", curso.class)
            .getResultList();
    }

    public List<curso> obterPorNome(String nome) {
        String jpql = "select c from curso c where c.nome like :nome";
        TypedQuery<curso> query = entityManager.createQuery(jpql, curso.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
}
