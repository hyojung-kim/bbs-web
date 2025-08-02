package com.mysite.bbs.question;

import com.mysite.bbs.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Question getQuestion(Integer id) {
        Optional<Question> oq = questionRepository.findById(id);
        if(oq.isEmpty()){
           throw new DataNotFoundException("question not found");
        }
        return oq.get();
    }
}
