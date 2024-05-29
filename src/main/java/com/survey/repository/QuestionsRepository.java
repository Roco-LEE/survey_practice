package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.entity.Lists;
import com.survey.entity.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long>{
	List<Questions> findByLists(Lists list);
}
