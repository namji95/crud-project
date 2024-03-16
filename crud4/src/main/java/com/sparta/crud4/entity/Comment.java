package com.sparta.crud4.entity;

import com.sparta.crud4.dto.CommentRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "comments")
@Getter
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;
  private LocalDateTime createdAt;

  public Comment(CommentRequestDto requestDto) {
    this.content = requestDto.getContent();
    this.createdAt = LocalDateTime.now();
  }

  public void updateComment(CommentRequestDto requestDto) {
    this.content = requestDto.getContent();
  }
}
