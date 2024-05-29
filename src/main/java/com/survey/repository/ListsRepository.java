package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.entity.Lists;

public interface ListsRepository extends JpaRepository<Lists, Long>{
	List<Lists> findAllByOrderByListIdAsc();
}
