package com.sparta.crud3.entity;

import com.sparta.crud3.dto.PostRequestDto;
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
@Getter
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String writer;

  private String title;

  private String content;

  private LocalDateTime createdAt;

  public Post(PostRequestDto requestDto) {
    this.writer = requestDto.getWriter();
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.createdAt = LocalDateTime.now();
  }
}
