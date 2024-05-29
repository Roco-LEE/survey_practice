package com.survey.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.survey.entity.Lists;
import com.survey.entity.Questions;
import com.survey.repository.QuestionsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {
	private final QuestionsRepository questionsRepository;
	private final ListsService listsService;
	
	@Override
	public Questions createQuestion(Questions question) {
		return questionsRepository.save(question);
	}
	
	@Override
	public Questions questionDetail(Questions question) {
		return questionsRepository.findById(question.getId()).get();
	}
	
	@Override
	public List<Questions> questionsList(Long listId) {
		return questionsRepository.findByLists(listsService.listDetail(listId));
	}
}
