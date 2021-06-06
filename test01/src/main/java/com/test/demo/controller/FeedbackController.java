package com.test.demo.controller;

import com.test.demo.entity.Collect;
import com.test.demo.entity.CollectResult;
import com.test.demo.entity.Feedback;
import com.test.demo.entity.FeedbackResult;
import com.test.demo.service.CollectService;
import com.test.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    //    将意见反馈信息插入
    @PostMapping(value = "/insert")
    public FeedbackResult insert(Feedback feedback) {
        return feedbackService.insert(feedback);
    }
    //    搜索意见反馈信息
    @PostMapping(value = "/select")
    public List<Feedback> select(Feedback feedback){
        return feedbackService.select(feedback);
    }
}
