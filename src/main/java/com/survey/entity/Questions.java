package com.survey.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "QUESTIONS_SEQ_GENERATOR", sequenceName = "QUESTIONS_SEQ", initialValue = 1, allocationSize = 1)
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTIONS_SEQ_GENERATOR")
	private Long id;
	@Column
	private Long no;
	@Column
	private String question;
	@Column
	private String type;
	@Column
	private String ans1;
	@Column
	private String ans2;
	@Column
	private String ans3;
	@Column
	private String ans4;
	@Column
	private String ans5;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "listId")
	private Lists lists;
}
