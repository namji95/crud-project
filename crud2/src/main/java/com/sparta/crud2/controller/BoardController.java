package com.sparta.crud2.controller;

import com.sparta.crud2.dto.BoardRequestDto;
import com.sparta.crud2.dto.BoardResponseDto;
import com.sparta.crud2.service.BoardService;
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
@RequestMapping("/api/v1/boards")
public class BoardController {

  private final BoardService boardService;

  @PostMapping
  public String createBoard (
      @RequestBody BoardRequestDto requestDto) {
    boardService.createBoard(requestDto);

    return "게시글이 생성되었습니다.:";
  }

  @GetMapping
  public ResponseEntity<List<BoardResponseDto>> getBoardList () {
    List<BoardResponseDto> responseDtos = boardService.getBoardList();

    return new ResponseEntity<>(responseDtos, HttpStatus.OK);
  }

}
