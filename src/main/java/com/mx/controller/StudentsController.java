package com.mx.controller;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.enums.Gender;
import com.mx.service.StudentsService;
import com.mx.utils.StringUtils;
import com.spring.common.dto.ApiResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@Log4j2
public class StudentsController {

	@Autowired
	private StudentsService studentsService;
	
	@GetMapping
	public ResponseEntity<ApiResponseDTO<List<StudentsResponseDTO>>> getStudents(
			@RequestParam(value = "career", required = false) String career,
			@RequestParam(value = "age", required = false) Integer age,
			@RequestParam(value = "gender", required = false) Gender gender,
			@RequestParam(value = "scholarship", required = false) Boolean scholarship,
			@RequestParam(value = "active", required = false) Boolean active,
			HttpServletRequest request
			) {
		log.info("Consultant endpoint [GET]/students");
		String trimCareer = StringUtils.trimString(career);
		log.info("RequestParam: carrer = {}", trimCareer);
		log.info("RequestParam: age = {}", age);
		log.info("RequestParam: gender = {}", gender);
		log.info("RequestParam: scholarship = {}", scholarship);
		log.info("RequestParam: active = {}", active);
		List<StudentsResponseDTO> response = studentsService.findStudents(trimCareer, age, gender, scholarship, active);
		log.info("Consultation completed");
		return ResponseEntity.ok(ApiResponseDTO.success(null, response, request));
	}
	
	@GetMapping("/student")
	public ResponseEntity<ApiResponseDTO<StudentsResponseDTO>> getStudent(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "enrollment", required = false) String enrollment,
			HttpServletRequest request
			) {
		log.info("Consultant endpoint [GET]/students/student");
		log.info("RequestParam: id = {}", id);
		log.info("RequestParam: enrollment = {}", enrollment);
		StudentsResponseDTO response = studentsService.getStudent(id, enrollment);
		log.info("Consultation completed");
		return ResponseEntity.ok(ApiResponseDTO.success(null, response, request));
	}
	
	@PostMapping("/student")
	public ResponseEntity<ApiResponseDTO<Object>> postStudent(
			@RequestBody StudentsResponseDTO dtoRequest,
			HttpServletRequest request
			) {
		log.info("Consultant endpoint [POST]/students/student");
		log.info("RequestParam: enrollment = {}", dtoRequest.getEnrollment());
		studentsService.saveStudent(dtoRequest);
		log.info("Consultation completed");
		return ResponseEntity.ok(ApiResponseDTO.success("Student saved correctly", null, request));
	}
	
	@PostMapping("/students")
	public ResponseEntity<ApiResponseDTO<Object>> postStudents(
			@RequestBody List<StudentsResponseDTO> requestList,
			HttpServletRequest request
			) {
		log.info("Consultant endpoint [POST]/students/students");
		studentsService.saveStudentsList(requestList);
		log.info("Consultation completed");
		return ResponseEntity.ok(ApiResponseDTO.success("Students saved correctly", null, request));
	}
	
	@PatchMapping("/update-active")
	public ResponseEntity<ApiResponseDTO<Object>> updateActive(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "enrollment", required = false) String enrollment,
			@RequestParam(value = "active", required = true) Boolean active,
			HttpServletRequest request
			) {
		log.info("Consultant endpoint [POST]/students/update-active");
		log.info("RequestParam: id = {}", id);
		log.info("RequestParam: enrollment = {}", enrollment);
		studentsService.updateActiveByIdOrEnrollment(id, enrollment, active);
		log.info("Consultation completed");
		return ResponseEntity.ok(ApiResponseDTO.success("Updated active student", null, request));
	}
	
	@DeleteMapping("/delete-student")
	public ResponseEntity<ApiResponseDTO<Object>> deleteStudent(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "enrollment", required = false) String enrollment,
			HttpServletRequest request
			) {
		log.info("Consultant endpoint [POST]/students/delete-student");
		log.info("RequestParam: id = {}", id);
		log.info("RequestParam: enrollment = {}", enrollment);
		studentsService.deleteByIdOrEnrollment(id, enrollment);
		return ResponseEntity.ok(ApiResponseDTO.success("Deleted student correctly", null, request));
	}
	
}
