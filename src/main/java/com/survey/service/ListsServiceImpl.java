package com.survey.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.survey.entity.Lists;
import com.survey.repository.ListsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListsServiceImpl implements ListsService {
	private final ListsRepository listsRepository;
	
	@Override
	public Lists createList(Lists lists) {
		return listsRepository.save(lists);
	}
	
	@Override
	public Lists listDetail(Long no) {
		return listsRepository.findById(no).get();
	}
	
	@Override
	public List<Lists> listsList() {
		return listsRepository.findAllByOrderByListIdAsc();
	}
}
