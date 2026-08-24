package com.mx.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mx.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentsResponseDTO {

	private Long id;
	
	private String enrollment;
	
	private String name;
	
	private String paternalSurname;
	
	private String maternalSurname;
	
	private String email;
	
	private String phone;
	
	private LocalDate birthdate;
	
	private Integer age;
	
	private Gender gender;
	
	private String career;
	
	private Integer schoolYear;
	
	private BigDecimal average;
	
	private Boolean scholarship;
	
	private Boolean active;
	
	private LocalDateTime registrationDate;
	
}
