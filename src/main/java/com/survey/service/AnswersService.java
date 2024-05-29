package com.survey.service;

import java.util.List;

import com.survey.entity.Answers;

import jakarta.transaction.Transactional;

@Transactional
public interface AnswersService {
	Answers createAnswer(Answers answer);
	
	Answers answerDetail(Answers answer);
	List<Answers> answersList(Long listNo);

	List<String> authorsList(Long listNo);
	
	boolean dupCheck(Long listNo, String author);
}
