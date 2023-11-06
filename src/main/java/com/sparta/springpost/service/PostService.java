package com.sparta.springpost.service;

import com.sparta.springpost.dto.PostRequestDto;
import com.sparta.springpost.dto.PostResponseDto;
import com.sparta.springpost.entity.Post;
import com.sparta.springpost.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //게시글 작성
    public PostResponseDto creatPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);

        return new PostResponseDto(post);
    }

    //게시글 조회 by Id
    public PostResponseDto getPost(Long id) {
        Post post = findPost(id);
        return new PostResponseDto(post);
    }

    //게시글 전체 조회 작성일 내림차순
    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc().stream().map
                (PostResponseDto::new).toList();
    }

    //게시글 수정 by Id
    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = findPost(id);
        //비밀번호 틀리면 exception
        if(!requestDto.getPw().equals(post.getPw())) throw new IllegalArgumentException("wrong password!");
        post.update(requestDto);

        return new PostResponseDto(post);
    }


    //게시글 삭제 by Id
    public Long deletePost(Long id, String pw) {
        Post post = findPost(id);
        //비밀번호 틀리면 exception
        if(!pw.equals(post.getPw())) throw new IllegalArgumentException("wrong password!");
        postRepository.delete(post);
        return id;
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 ID값의 게시글이 없습니다."));
    }
}
