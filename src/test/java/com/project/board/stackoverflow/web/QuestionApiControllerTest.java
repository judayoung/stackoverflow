package com.project.board.stackoverflow.web;

import com.project.board.stackoverflow.domain.question.Question;
import com.project.board.stackoverflow.domain.question.QuestionRepository;
import com.project.board.stackoverflow.web.dto.QuestionSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuestionApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private QuestionRepository questionRepository;

    @AfterEach
    public void tearDown() throws Exception{
        questionRepository.deleteAll();;
    }

    @DisplayName("Question 등록된다.")
    @Test
    public void question_enroll() throws Exception{
        //given
        String title="title";
        String content="content";
        QuestionSaveRequestDto requestDto=QuestionSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url="http://localhost:"+port+"/api/v1/question";

        //when
        ResponseEntity<Long> responseEntity=restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Question> all=questionRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }



}