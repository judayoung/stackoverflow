package com.project.board.stackoverflow.service.question;

import com.project.board.stackoverflow.domain.question.Question;
import com.project.board.stackoverflow.domain.question.QuestionRepository;
import com.project.board.stackoverflow.web.dto.QuestionResponseDto;
import com.project.board.stackoverflow.web.dto.QuestionSaveRequestDto;
import com.project.board.stackoverflow.web.dto.QuestionUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private  final QuestionRepository questionRepository;

    @Transactional
    public Long save(QuestionSaveRequestDto requestDto){
        // Dto 를 Entity로 변환하는 것을 볼 수 있습니다.
        return questionRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, QuestionUpdateRequestDto requestDto){
        Question question=questionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        question.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public QuestionResponseDto findById(Long id){
        Question entity=questionRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new QuestionResponseDto(entity);
    }



}
