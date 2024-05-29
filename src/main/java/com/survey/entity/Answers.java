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
@SequenceGenerator(name = "ANSWERS_SEQ_GENERATOR", sequenceName = "ANSWERS_SEQ", initialValue = 1, allocationSize = 1)
public class Answers {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWERS_SEQ_GENERATOR")
	private Long id;
	@Column
	private Long no;
	@Column
	private String answer;
	@Column
	private String author;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "listId")
	private Lists lists;
}
