package com.project.board.stackoverflow.domain.question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @AfterEach
    public void cleanup(){
        questionRepository.deleteAll();
    }

    @DisplayName("질문글 저장 불러오기")
    @Test
    public void save_find(){
        //given
        String title="테스트 게시글";
        String content="테스트 본문";

        questionRepository.save(Question.builder()
                .title(title)
                .content(content)
                .author("author")
                .build());

        //when
        List<Question> questionList=questionRepository.findAll();

        //then
        Question question=questionList.get(0);
        assertThat(question.getTitle()).isEqualTo(title);
        assertThat(question.getContent()).isEqualTo(content);
    }

    @DisplayName("BaseTimeEntity를 등록하는 테스트")
    @Test
    public void test_BaseTimeEntity(){
        //given
        LocalDateTime now=LocalDateTime.of(2022,02,22,12,19,0,0);
        questionRepository.save(Question.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Question> questionList=questionRepository.findAll();

        //then
        Question question=questionList.get(0);

        System.out.println(">>>>>>>> createdDate="+question.getCreatedDate()+", modifiedDate="+question.getModifiedDate());
        assertThat(question.getCreatedDate()).isAfter(now);
        assertThat(question.getModifiedDate()).isAfter(now);

    }

}