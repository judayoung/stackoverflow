package com.project.board.stackoverflow.web;

import com.project.board.stackoverflow.service.question.QuestionService;
import com.project.board.stackoverflow.web.dto.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class QuestionApiController {

    private final QuestionService questionService;

    @PostMapping("/api/v1/question")
    public Long save(@RequestBody QuestionSaveRequestDto requestDto){
        return questionService.save(requestDto);
    }


}
