package org.example.fe_be_team1_be.service;

import lombok.RequiredArgsConstructor;
import org.example.fe_be_team1_be.dto.PostRequestDto;
import org.example.fe_be_team1_be.dto.PostResponseDto;
import org.example.fe_be_team1_be.entity.Post;
import org.example.fe_be_team1_be.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    //게시글 생성
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .writer("익명")
                .build();

        Post savedPost = postRepository.save(post);
        savedPost.setWriter("익명" + savedPost.getId());
        postRepository.save(savedPost);
        return toDto(savedPost);

    }

    //전체 조회
    public List<PostResponseDto> getAllPosts() {

        return postRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    //상세 조회
    public PostResponseDto getPost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
        return toDto(post);
    }

    //수정
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());

        Post updatedPost = postRepository.save(post);
        return toDto(updatedPost);
    }

    //삭제
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    //Entity -> DTO 변환
    private PostResponseDto toDto(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .writer(post.getWriter())
                .build();
    }

}
