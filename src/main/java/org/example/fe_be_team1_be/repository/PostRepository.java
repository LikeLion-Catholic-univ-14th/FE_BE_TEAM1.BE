package org.example.fe_be_team1_be.repository;

import org.example.fe_be_team1_be.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
