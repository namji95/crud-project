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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  @Transactional
  public void createTodo(TodoRequestDto requestDto) {
    Todo todo = new Todo(requestDto);
    todoRepository.save(todo);
  }

  @Transactional(readOnly = true)
  public List<TodoResponseDto> getTodoList() {
    List<TodoResponseDto> responseDtos = new ArrayList<>();
    for (Todo todo : todoRepository.findAll()) {
      responseDtos.add(new TodoResponseDto(
          todo.getContent()
      ));
    }

    return responseDtos;
  }

  @Transactional(readOnly = true)
  public TodoResponseDto getTodo(Long todoId) {
    Optional<Todo> todo = todoRepository.findById(todoId);
    if (todo.isEmpty()) {
      throw new IllegalArgumentException("선택하신 일정이은 없는 일정입니다.");
    }

    TodoResponseDto responseDto = new TodoResponseDto(
        todo.get().getContent());
    return responseDto;
  }

  @Transactional
  public void updateTodo(
      Long todoId,
      TodoRequestDto requestDto) {
    Todo todo = todoRepository.findById(todoId).orElseThrow(()
        -> new IllegalArgumentException("일치하는 일정이 없습니다."));

    todo.updateTodo(requestDto);
  }

  @Transactional
  public void deleteTodo(Long todoId) {
    todoRepository.deleteById(todoId);
  }
}
