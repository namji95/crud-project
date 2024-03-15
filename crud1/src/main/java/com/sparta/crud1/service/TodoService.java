package com.sparta.crud1.service;

import com.sparta.crud1.dto.TodoRequestDto;
import com.sparta.crud1.dto.TodoResponseDto;
import com.sparta.crud1.entity.Todo;
import com.sparta.crud1.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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


}
