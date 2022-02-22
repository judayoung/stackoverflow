package com.project.board.stackoverflow.web;

import com.project.board.stackoverflow.service.question.QuestionService;
import com.project.board.stackoverflow.web.dto.QuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final QuestionService questionService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("question",questionService.findAllDesc());
        return "index";
    }

    @GetMapping("/question/save")
    public String questionSave(){
        return "question-save";
    }

    @GetMapping("/question/update/{id}")
    public String questionUpdate(@PathVariable Long id, Model model){
        QuestionResponseDto dto=questionService.findById(id);
        model.addAttribute("question",dto);

        return "question-update";
    }


}
