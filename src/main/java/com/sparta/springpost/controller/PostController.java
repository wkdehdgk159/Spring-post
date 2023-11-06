package com.sparta.springpost.controller;

import com.sparta.springpost.dto.PostRequestDto;
import com.sparta.springpost.dto.PostResponseDto;
import com.sparta.springpost.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //게시글 작성
    @PostMapping("/post")
    public PostResponseDto creatPost(@RequestBody PostRequestDto requestDto) {
        return postService.creatPost(requestDto);
    }

    //게시글 조회 by Id
    @GetMapping("/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    //게시글 전체 조회 작성일 내림차순
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }


    //게시글 수정 by Id
    @PutMapping("/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }


    //게시글 삭제 by Id
    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id, @RequestParam String pw) {
        return postService.deletePost(id, pw);
    }
}
