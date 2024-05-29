package com.survey.service;

import java.util.List;

import com.survey.entity.Questions;

import jakarta.transaction.Transactional;

@Transactional
public interface QuestionsService {
	Questions createQuestion(Questions question);
	
	Questions questionDetail(Questions question);
	List<Questions> questionsList(Long ListId);
}
