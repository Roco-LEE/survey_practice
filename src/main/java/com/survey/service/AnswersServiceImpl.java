package com.survey.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.survey.entity.Answers;
import com.survey.entity.Lists;
import com.survey.repository.AnswersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswersServiceImpl implements AnswersService {
	private final AnswersRepository answersRepository;
	private final ListsService listsService;
	
	@Override
	public Answers createAnswer(Answers answer) {
		return answersRepository.save(answer);
	}
	
	@Override
	public Answers answerDetail(Answers answer) {
		return answersRepository.findById(answer.getId()).get();
	}
	
	@Override
	public List<Answers> answersList(Long listNo) {
		return answersRepository.findDistinctByLists(listsService.listDetail(listNo));
	}
	
	@Override
	public List<String> authorsList(Long listId) {
		Lists list = listsService.listDetail(listId);
		List<Answers> answers= answersRepository.findDistinctAuthorByListsOrderByIdAsc(list);
		Set<String> authorSet = new HashSet();

		for (Answers ans : answers) {
		    authorSet.add(ans.getAuthor());
		}

		List<String> authors = new ArrayList<>(authorSet);
		
		return authors;
	}
	
	@Override
	public boolean dupCheck(Long listNo, String author) {
		Lists list = listsService.listDetail(listNo);
		List<Answers> ans = answersRepository.findByListsAndAuthor(list, author);
		boolean result = false;
		if(ans.size() > 0) result = true;
		return result;
	}
}
