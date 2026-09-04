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
	
	public StudentsEntity toResponseEntity(StudentsResponseDTO dto) {
		
		if (dto == null) {
			return null;
		}
		
		StudentsEntity entity = new StudentsEntity();
		entity.setId(dto.getId());
		entity.setEnrollment(dto.getEnrollment());
		entity.setName(dto.getName());
		entity.setPaternalSurname(dto.getPaternalSurname());
		entity.setMaternalSurname(dto.getMaternalSurname());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setBirthdate(dto.getBirthdate());
		entity.setAge(dto.getAge());
		entity.setGender(dto.getGender());
		entity.setCareer(dto.getCareer());
		entity.setSchoolYear(dto.getSchoolYear());
		entity.setAverage(dto.getAverage());
		entity.setScholarship(dto.getScholarship());
		entity.setActive(dto.getActive());
		entity.setRegistrationDate(dto.getRegistrationDate());
		
		return entity;
	}
	
	public List<StudentsEntity> toResponseEntityList(List<StudentsResponseDTO> dtoList) {
		
		return dtoList.stream()
				.map(this::toResponseEntity)
				.toList();
		
	}
	
}
