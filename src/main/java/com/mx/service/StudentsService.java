package com.mx.service;

import com.mx.dto.response.StudentsResponseDTO;

import java.util.List;

public interface StudentsService {

	List<StudentsResponseDTO> findStudents();
	
}
