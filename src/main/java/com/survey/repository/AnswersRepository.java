package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.entity.Answers;
import com.survey.entity.Lists;

public interface AnswersRepository extends JpaRepository<Answers, Long>{
	List<Answers> findDistinctByLists(Lists list);
	
	List<Answers> findDistinctAuthorByListsOrderByIdAsc(Lists list);
	
	List<Answers> findByListsAndAuthor(Lists list, String author);
}
