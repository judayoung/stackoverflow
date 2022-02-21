package com.project.board.stackoverflow.web.dto;

import com.project.board.stackoverflow.domain.question.Question;
import lombok.Getter;

@Getter
public class QuestionResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public QuestionResponseDto(Question entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
    }
}
