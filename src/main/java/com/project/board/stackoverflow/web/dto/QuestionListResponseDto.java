package com.project.board.stackoverflow.web.dto;

import com.project.board.stackoverflow.domain.question.Question;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QuestionListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public QuestionListResponseDto(Question entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.author= entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();
    }
}
