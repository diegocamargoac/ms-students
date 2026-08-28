package com.mx.service;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.enums.Gender;

import java.util.List;

public interface StudentsService {

	List<StudentsResponseDTO> findStudents(
			String career,
			Integer age,
			Gender gender,
			Boolean scholarship,
			Boolean active
			);
	
	StudentsResponseDTO findById(Long id);
	
	StudentsResponseDTO findByEnrollment(String enrollment);
	
	StudentsResponseDTO findByIdAndEnrollment(
			Long id,
			String enrollment
			);
	
	StudentsResponseDTO getStudent(
			Long id,
			String enrollment
			);
	
}
