package com.sparta.springpost.dto;

import com.sparta.springpost.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String writer;

    //pw는 제외?
//    private String pw;
    private String contents;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.writer = post.getWriter();;
        this.contents = post.getContents();
    }
}
