package com.mx.mapper;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.entity.StudentsEntity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentsMapper {

	public StudentsResponseDTO toResponse(StudentsEntity request) {
		
		if (request == null) {
			return null;
		}
		
		StudentsResponseDTO dto = new StudentsResponseDTO();
		dto.setId(request.getId());
		dto.setEnrollment(request.getEnrollment());
		dto.setName(request.getName());
		dto.setPaternalSurname(request.getPaternalSurname());
		dto.setMaternalSurname(request.getMaternalSurname());
		dto.setEmail(request.getEmail());
		dto.setPhone(request.getPhone());
		dto.setBirthdate(request.getBirthdate());
		dto.setAge(request.getAge());
		dto.setGender(request.getGender());
		dto.setCareer(request.getCareer());
		dto.setSchoolYear(request.getSchoolYear());
		dto.setAverage(request.getAverage());
		dto.setScholarship(request.getScholarship());
		dto.setActive(request.getActive());
		dto.setRegistrationDate(request.getRegistrationDate());
		
		return dto;
		
	}
	
	public List<StudentsResponseDTO> toResponseList(List<StudentsEntity> requestList) {
		
		return requestList.stream()
				.map(this::toResponse)
				.toList();
		
	}
	
	public StudentsResponseDTO toResponseDTO(StudentsResponseDTO request) {
		
		if (request == null) {
			return null;
		}
		
		StudentsResponseDTO dto = new StudentsResponseDTO();
		dto.setId(request.getId());
		dto.setEnrollment(request.getEnrollment());
		dto.setName(request.getName());
		dto.setPaternalSurname(request.getPaternalSurname());
		dto.setMaternalSurname(request.getMaternalSurname());
		dto.setEmail(request.getEmail());
		dto.setPhone(request.getPhone());
		dto.setBirthdate(request.getBirthdate());
		dto.setAge(request.getAge());
		dto.setGender(request.getGender());
		dto.setCareer(request.getCareer());
		dto.setSchoolYear(request.getSchoolYear());
		dto.setAverage(request.getAverage());
		dto.setScholarship(request.getScholarship());
		dto.setActive(request.getActive());
		dto.setRegistrationDate(request.getRegistrationDate());
		
		return dto;
		
	}
	
	public List<StudentsResponseDTO> toResponseListDTO(List<StudentsResponseDTO> requestList) {
		
		return requestList.stream()
				.map(this::toResponseDTO)
				.toList();
		
	}
	
}
