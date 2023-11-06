package com.sparta.springpost.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String writer;
    private String pw;
    private String contents;
}
