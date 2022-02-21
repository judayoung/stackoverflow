package com.project.board.stackoverflow.service.question;

import com.project.board.stackoverflow.domain.question.QuestionRepository;
import com.project.board.stackoverflow.web.dto.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private  final QuestionRepository questionRepository;


}
