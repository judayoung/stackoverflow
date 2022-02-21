package com.project.board.stackoverflow.web.dto;

import com.project.board.stackoverflow.domain.question.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class QuestionSaveRequestDto {

    //private int num;
    private String title;
    private String content;
    private String author;
    //private Date date;

    @Builder
    public QuestionSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Question toEntity(){
        return Question.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
