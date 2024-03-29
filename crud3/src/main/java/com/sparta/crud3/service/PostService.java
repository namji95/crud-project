package com.sparta.crud3.service;

import com.sparta.crud3.dto.PostRequestDto;
import com.sparta.crud3.dto.PostResponseDto;
import com.sparta.crud3.entity.Post;
import com.sparta.crud3.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  @Transactional
  public void createPost(PostRequestDto requestDto) {
    Post post = new Post(requestDto);

    postRepository.save(post);
  }

  @Transactional
  public List<PostResponseDto> getPostList() {
    List<PostResponseDto> responseDtoList = new ArrayList<>();
    for (Post post : postRepository.findAll()) {
      responseDtoList.add(new PostResponseDto(
          post.getWriter(),
          post.getContent(),
          post.getCreatedAt()));
    }

    return responseDtoList;
  }

  @Transactional
  public PostResponseDto getPost(Long postId) {
    Post post = postRepository.findById(postId).orElseThrow(() ->
        new IllegalArgumentException("선택한 포스트가 존재하지 않습니다."));
    PostResponseDto responseDto = new PostResponseDto(
        post.getWriter(),
        post.getContent(),
        post.getCreatedAt());

    return responseDto;
  }

  @Transactional
  public void updatePost(PostRequestDto requestDto, Long postId) {
    Post post = postRepository.findById(postId).orElseThrow(() ->
        new IllegalArgumentException("선택한 포스트가 존재하지 않습니다."));

    post.updatePost(requestDto);
  }

  @Transactional
  public void deletePost(Long postId) {
    postRepository.deleteById(postId);
  }
}
