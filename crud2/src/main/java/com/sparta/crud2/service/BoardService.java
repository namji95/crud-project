package com.sparta.crud2.service;

import com.sparta.crud2.dto.BoardRequestDto;
import com.sparta.crud2.dto.BoardResponseDto;
import com.sparta.crud2.entity.Board;
import com.sparta.crud2.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
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

  public List<BoardResponseDto> getBoardList() {
    List<BoardResponseDto> responseDtoList = new ArrayList<>();

    for (Board board : boardRepository.findAll()) {
      responseDtoList.add(new BoardResponseDto(
          board.getWriter(),
          board.getContent()));
    }

    return responseDtoList;
  }
}
