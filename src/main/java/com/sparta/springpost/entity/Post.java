package com.sparta.springpost.entity;

import com.sparta.springpost.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "post")
public class Post extends Timestamp{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "writer")
    private String writer;
    @Column(name = "pw", nullable = false)
    private String pw;
    @Column(name = "contents", nullable = false)
    private String contents;

    public Post() {
    }

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.pw = requestDto.getPw();
        this.contents = requestDto.getContents();
    }

    //비밀번호는 건들지 말자.
    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.contents = requestDto.getContents();
    }
}
