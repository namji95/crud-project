package com.sparta.crud3.controller;

import com.sparta.crud3.dto.PostRequestDto;
import com.sparta.crud3.dto.PostResponseDto;
import com.sparta.crud3.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

  private final PostService postSerivce;

  @PostMapping
  public String createPost (
      @RequestBody PostRequestDto requestDto) {
    postSerivce.createPost(requestDto);

    return "포스트가 생성되었습니다.";
  }

  @GetMapping
  public ResponseEntity<List<PostResponseDto>> getPostList() {
    List<PostResponseDto> responseDtos = postSerivce.getPostList();

    return new ResponseEntity<>(responseDtos, HttpStatus.OK);
  }

  @GetMapping("/{postId}")
  public ResponseEntity<PostResponseDto> getPost(
      @PathVariable Long postId) {
    PostResponseDto responseDto = postSerivce.getPost(postId);

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

}
