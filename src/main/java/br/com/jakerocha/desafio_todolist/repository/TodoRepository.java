package br.com.jakerocha.desafio_todolist.repository;

import br.com.jakerocha.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.InterfaceAddress;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
