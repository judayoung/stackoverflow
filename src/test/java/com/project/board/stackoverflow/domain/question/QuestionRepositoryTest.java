package com.project.board.stackoverflow.domain.question;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

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

}