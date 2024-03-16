package com.sparta.crud4.service;

import com.sparta.crud4.dto.CommentRequestDto;
import com.sparta.crud4.dto.CommentResponseDto;
import com.sparta.crud4.entity.Comment;
import com.sparta.crud4.repository.CommentRepository;
import java.io.Serial;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;

  @Transactional
  public void createComment(CommentRequestDto requestDto) {
    Comment comment = new Comment(requestDto);

    commentRepository.save(comment);
  }

  @Transactional(readOnly = true)
  public List<CommentResponseDto> getCommentList() {
    List<Comment> comments = commentRepository.findAll();
    List<CommentResponseDto> responseDtos = comments.stream().map(
        comment -> new CommentResponseDto(
            comment.getContent(), comment.getCreatedAt())).toList();

    return responseDtos;
  }

  @Transactional(readOnly = true)
  public CommentResponseDto getComment(Long commentId) {
    Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
        new IllegalArgumentException("일치하는 댓글이 없습니다."));

    CommentResponseDto responseDto = new CommentResponseDto(
        comment.getContent(), comment.getCreatedAt());

    return responseDto;
  }

  @Transactional
  public void updateComment(CommentRequestDto requestDto, Long commentId) {
    Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
        new IllegalArgumentException("댓글이 존재하지 않습니다.!"));
    comment.updateComment(requestDto);
  }
  @Transactional
  public void deleteComment(Long commentId) {
    commentRepository.deleteById(commentId);
  }
}
