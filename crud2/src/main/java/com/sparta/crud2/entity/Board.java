package com.sparta.crud2.entity;

import com.sparta.crud2.dto.BoardRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "boards")
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String writer;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;


  public Board(BoardRequestDto requestDto) {
    this.writer = requestDto.getWriter();
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
  }
}
