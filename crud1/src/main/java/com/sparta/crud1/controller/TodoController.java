package com.sparta.crud1.controller;

import com.sparta.crud1.dto.TodoRequestDto;
import com.sparta.crud1.dto.TodoResponseDto;
import com.sparta.crud1.service.TodoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TodoController {

  private final TodoService todoService;

  @PostMapping
  public String createTodo (@RequestBody TodoRequestDto requestDto) {
    todoService.createTodo(requestDto);

    return "게시글 생성 성공";
  }



}
