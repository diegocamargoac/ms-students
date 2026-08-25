package com.mx.controller;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.service.StudentsService;
import com.spring.common.dto.ApiResponseDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentsService studentsService;
	
	@GetMapping
	public ResponseEntity<ApiResponseDTO<List<StudentsResponseDTO>>> students() {
		List<StudentsResponseDTO> response = studentsService.findStudents();
		return ResponseEntity.ok(ApiResponseDTO.success(null, response));
	}
	
}
