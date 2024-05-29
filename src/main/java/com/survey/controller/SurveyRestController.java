package com.survey.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.survey.entity.Answers;
import com.survey.entity.Lists;
import com.survey.entity.Questions;
import com.survey.service.AnswersService;
import com.survey.service.ListsService;
import com.survey.service.QuestionsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SurveyRestController {
	private final ListsService listsService;
	private final QuestionsService questionsService;
	private final AnswersService answersService;
	
	@PostMapping("lists/post")
	public String createListAction(@RequestBody List<Map<String, Object>> questions) {
		Map<String, Object> ques1 = questions.get(0);
		
		Lists list = Lists.builder()
				.title((String)ques1.get("title"))
				.author((String)ques1.get("author"))
				.contents((String)ques1.get("contents")).build();
		listsService.createList(list);
		
		Long count = 1L;
		
		for (Map<String, Object> map : questions) {
			Questions dto = null;
			
			if(((String)map.get("questionType")).equals("객관식")) {
				dto = Questions.builder()
						.lists(list)
						.no(count++)
						.question((String)map.get("question"))
						.type((String)map.get("optionCount"))
						.build();

				int optCnt = Integer.parseInt((String)map.get("optionCount"));
				List<String> opt = (List<String>)map.get("options");
				
				dto.setAns1(opt.get(0));
				dto.setAns2(opt.get(1));
				
				if (optCnt > 2) {
				    dto.setAns3(opt.get(2));
				}
				if (optCnt > 3) {
				    dto.setAns4(opt.get(3));
				}
				if (optCnt > 4) {
				    dto.setAns5(opt.get(4));
				}
				
			} else {
				dto = Questions.builder()
						.lists(list)
						.no(count++)
						.question((String)map.get("question"))
						.type("1")
						.build();
			}
			
			questionsService.createQuestion(dto);
			
		}
		
		return "good";
	}

	
	@PostMapping("lists/submit")
	public String createAnswerAction(@RequestBody List<Map<String, Object>> answers) {
		for (Map<String, Object> map : answers) {
			Answers ans = Answers.builder()
					.lists(listsService.listDetail(Long.parseLong(((String)map.get("listId")))))
					.author((String)map.get("author"))
					.no(Long.valueOf((int)map.get("no")))
					.answer((String)map.get("answer"))
					.build();
			answersService.createAnswer(ans);
		}
		
		return "good";
	}
}
