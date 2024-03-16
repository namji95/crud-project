package com.sparta.crud2.service;

import com.sparta.crud2.dto.BoardRequestDto;
import com.sparta.crud2.entity.Board;
import com.sparta.crud2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public void createBoard(BoardRequestDto requestDto) {
    Board board = new Board(requestDto);

    boardRepository.save(board);
  }
}
