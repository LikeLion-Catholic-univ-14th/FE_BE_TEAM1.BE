package org.example.fe_be_team1_be.controller;

import lombok.RequiredArgsConstructor;
import org.example.fe_be_team1_be.dto.PostRequestDto;
import org.example.fe_be_team1_be.dto.PostResponseDto;
import org.example.fe_be_team1_be.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    //생성
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto){
        return ResponseEntity.status(201)
                .body(postService.createPost(requestDto));
    }

    //전체 조회
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    //상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPost(id));
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable Long id,
            @RequestBody PostRequestDto requestDto
    ){
        return ResponseEntity.ok(postService.updatePost(id, requestDto));
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(
            @PathVariable Long id
    ){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
