package com.survey.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "LISTS_SEQ_GENERATOR", sequenceName = "LISTS_SEQ", initialValue = 1, allocationSize = 1)
public class Lists {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LISTS_SEQ_GENERATOR")
	private Long listId;
	@Column
	private String title;
	@Column
	private String contents;
	@Column
	private String author;
	@ToString.Exclude
	@OneToMany(mappedBy = "lists", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Questions> questions;
	@ToString.Exclude
	@OneToMany(mappedBy = "lists", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Answers> answers;
	
}
