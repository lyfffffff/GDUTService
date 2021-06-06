package com.test.demo.service;

import com.test.demo.entity.*;
import com.test.demo.mapper.CollectMapper;
import com.test.demo.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    //插入
    public FeedbackResult insert(Feedback feedback) {
        FeedbackResult feedbackResult = new FeedbackResult();
        feedbackResult.setSuccess(false);
        feedbackResult.setDetail(null);
        feedbackMapper.insert(feedback);
        feedbackResult.setMsg("反馈成功~");
        feedbackResult.setSuccess(true);
        feedbackResult.setDetail(feedback);
        return feedbackResult;
    }
    //搜索
    public List<Feedback> select(Feedback feedback) {
        return feedbackMapper.select(feedback.getUsername());
    }
}
