package com.survey.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.survey.entity.Questions;
import com.survey.service.AnswersService;
import com.survey.service.ListsService;
import com.survey.service.QuestionsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/lists")
@RequiredArgsConstructor
public class SurveyViewController {
	private final ListsService listsService;
	private final AnswersService answersService;
	private final QuestionsService questionsService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping
	public String lists(Model model) {
		model.addAttribute("listsList", listsService.listsList());
		return "list";
	}
	
	@GetMapping("/{listId}")
	public String list(@CookieValue("userName") String userName, @PathVariable(name = "listId") Long listId, Model model) {
		model.addAttribute("listDetail", listsService.listDetail(listId));
		List<Questions> list = questionsService.questionsList(listId);
			int maxSize = 0;
			for (Questions questions : list) {
				int tempSize = 0;
				if(questions.getAns5() != null) {
					tempSize=5;
				} else if (questions.getAns4() != null) {
					tempSize=4;
				} else if (questions.getAns3() != null) {
					tempSize=3;
				} else {
					tempSize=2;
				}
				if(tempSize >= maxSize) maxSize=tempSize;
			}
		model.addAttribute("maxSize", maxSize);
		model.addAttribute("dupCheck", answersService.dupCheck(listId, userName));
		return "detail";
	}
	
	@GetMapping("/admin/{listId}")
	public String admin(@PathVariable(name = "listId") Long listId, Model model) {
		model.addAttribute("listDetail", listsService.listDetail(listId));
		model.addAttribute("authorsList", answersService.authorsList(listId));
		model.addAttribute("answersList", answersService.answersList(listId));
		List<Questions> list = questionsService.questionsList(listId);
		model.addAttribute("questionsList", list);
		model.addAttribute("questionsCnt", list.size());
		return "admin";
	}
	
	@GetMapping("/post")
	public String createList() {
		return "post";
	}
	
}
