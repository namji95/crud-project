package com.sparta.crud3.repository;

import com.sparta.crud3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
