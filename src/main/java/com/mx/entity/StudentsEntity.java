package com.mx.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mx.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 20)
	private Long id;
	
	@Column(name = "enrollment", nullable = false)
	private String enrollment;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "paternal_surname", nullable = false)
	private String paternalSurname;
	
	@Column(name = "maternal_surname", nullable = false)
	private String maternalSurname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "career", nullable = false)
	private String career;
	
	@Column(name = "school_year", nullable = false)
	private Integer schoolYear;
	
	@Column(name = "average", nullable = false, precision = 4, scale = 2)
	private BigDecimal average;
	
	@Column(name = "scholarship", nullable = false)
	private Boolean scholarship;
	
	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@Column(name = "registration_date", nullable = true)
	private LocalDateTime registrationDate;
	
}
