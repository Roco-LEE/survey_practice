package com.survey.service;

import java.util.List;

import com.survey.entity.Lists;

import jakarta.transaction.Transactional;

@Transactional
public interface ListsService {
	Lists createList(Lists lists);
	
	Lists listDetail(Long no);
	List<Lists> listsList();
}
