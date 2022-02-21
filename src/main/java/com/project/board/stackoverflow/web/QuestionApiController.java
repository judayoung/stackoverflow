package com.project.board.stackoverflow.web;

import com.project.board.stackoverflow.service.question.QuestionService;
import com.project.board.stackoverflow.web.dto.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class QuestionApiController {

    private final QuestionService questionService;


}
