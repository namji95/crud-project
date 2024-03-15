package com.sparta.crud1.service;

import com.sparta.crud1.dto.TodoRequestDto;
import com.sparta.crud1.dto.TodoResponseDto;
import com.sparta.crud1.entity.Todo;
import com.sparta.crud1.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  public void createTodo(TodoRequestDto requestDto) {
    Todo todo = new Todo(requestDto);
    todoRepository.save(todo);
  }

  public List<TodoResponseDto> getTodo() {
    List<TodoResponseDto> responseDtos = new ArrayList<>();
    for (Todo todo : todoRepository.findAll()) {
      responseDtos.add(new TodoResponseDto(
          todo.getContent()
      ));
    }

    return responseDtos;
  }
}
