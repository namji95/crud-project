package com.sparta.crud2.service;

import com.sparta.crud2.dto.BoardRequestDto;
import com.sparta.crud2.dto.BoardResponseDto;
import com.sparta.crud2.entity.Board;
import com.sparta.crud2.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional
  public void createBoard(BoardRequestDto requestDto) {
    Board board = new Board(requestDto);

    boardRepository.save(board);
  }

  @Transactional(readOnly = true)
  public List<BoardResponseDto> getBoardList() {
    List<BoardResponseDto> responseDtoList = new ArrayList<>();

    for (Board board : boardRepository.findAll()) {
      responseDtoList.add(new BoardResponseDto(
          board.getWriter(),
          board.getContent()));
    }

    return responseDtoList;
  }

  @Transactional(readOnly = true)
  public BoardResponseDto getBoard(Long boardId) {
    Board board = boardRepository.findById(boardId).orElseThrow(() ->
        new IllegalArgumentException("일치하는 게시글이 없습니다."));
    BoardResponseDto responseDto = new BoardResponseDto(
        board.getWriter(),
        board.getContent());

    return responseDto;
  }

  @Transactional
  public void updateBoard(BoardRequestDto requestDto, Long boardId) {
    Board board = boardRepository.findById(boardId).orElseThrow(() ->
        new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));

    board.updateBoard(requestDto);
  }

  @Transactional
  public void deleteBoard(Long boardId) {
    boardRepository.deleteById(boardId);
  }
}
