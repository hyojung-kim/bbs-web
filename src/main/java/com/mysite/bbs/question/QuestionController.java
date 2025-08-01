package com.mysite.bbs.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
QuestionService questionService;

    @GetMapping("/list")
    public String list(){
        return "question_list";
    }

}
