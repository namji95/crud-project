package com.sparta.crud4.controller;

import com.sparta.crud4.dto.CommentRequestDto;
import com.sparta.crud4.dto.CommentResponseDto;
import com.sparta.crud4.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

  private final CommentService commentService;

  @PostMapping
  public String createComment (
      @RequestBody CommentRequestDto requestDto) {
    commentService.createComment(requestDto);

    return "댓글이 생성되었습니다.";
  }

  @GetMapping
  public ResponseEntity<List<CommentResponseDto>> getCommentList() {
    List<CommentResponseDto> responseDtos = commentService.getCommentList();

    return new ResponseEntity<>(responseDtos, HttpStatus.OK);
  }

  @GetMapping("/{commentId}")
  public ResponseEntity<CommentResponseDto> getComment (
      @PathVariable Long commentId) {
    CommentResponseDto responseDto = commentService.getComment(commentId);

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  @PutMapping("/{commentId}")
  public String updateComment(
      @RequestBody CommentRequestDto requestDto,
      @PathVariable Long commentId) {
    commentService.updateComment(requestDto, commentId);

    return "댓글이 수정되었습니다.";
  }

  @DeleteMapping("/{commentId}")
  public String deleteComment(
      @PathVariable Long commentId) {
    commentService.deleteComment(commentId);

    return "댓글이 삭제되었습니다.";
  }
}
