package com.project.board.stackoverflow.web;

import com.project.board.stackoverflow.service.question.QuestionService;
import com.project.board.stackoverflow.web.dto.QuestionResponseDto;
import com.project.board.stackoverflow.web.dto.QuestionSaveRequestDto;
import com.project.board.stackoverflow.web.dto.QuestionUpdateRequestDto;
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

    @PutMapping("/api/v1/question/{id}")
    public Long update(@PathVariable Long id, @RequestBody QuestionUpdateRequestDto requestDto){
        return questionService.update(id, requestDto);
    }

    @GetMapping("/api/v1/question/{id}")
    public QuestionResponseDto findById(@PathVariable Long id){
        return questionService.findById(id);
    }
}
