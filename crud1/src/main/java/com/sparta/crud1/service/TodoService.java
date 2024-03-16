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

  public List<TodoResponseDto> getTodoList() {
    List<TodoResponseDto> responseDtos = new ArrayList<>();
    for (Todo todo : todoRepository.findAll()) {
      responseDtos.add(new TodoResponseDto(
          todo.getContent()
      ));
    }

    return responseDtos;
  }

  public TodoResponseDto getTodo(Long todoId) {
    Optional<Todo> todo = todoRepository.findById(todoId);
    if (todo.isEmpty()) {
      throw new IllegalArgumentException("선택하신 일정이은 없는 일정입니다.");
    }

    TodoResponseDto responseDto = new TodoResponseDto(
        todo.get().getContent());
    return responseDto;
  }

  public void updateTodo(
      Long todoId,
      TodoRequestDto requestDto) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(()
        -> new IllegalArgumentException("일치하는 일정이 없습니다."));

    todo.updateTodo(requestDto);
  }


}
