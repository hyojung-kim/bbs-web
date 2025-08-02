package com.mysite.bbs.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public void create(QuestionForm questionForm) {
        Question q = new Question();
        q.setSubject(questionForm.getSubject());
        q.setContent(questionForm.getContent());
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);
    }
}
