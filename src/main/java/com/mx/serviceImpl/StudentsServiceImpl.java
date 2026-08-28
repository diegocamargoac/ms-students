package com.mx.serviceImpl;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.entity.StudentsEntity;
import com.mx.enums.Gender;
import com.mx.mapper.StudentsMapper;
import com.mx.repository.StudentsRepository;
import com.mx.service.StudentsService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class StudentsServiceImpl implements StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private StudentsMapper studentsMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<StudentsResponseDTO> findStudents(
			String career,
			Integer age,
			Gender gender,
			Boolean scholarship,
			Boolean active
			) {
		log.info("Consultant StudentsServiceImpl.findStudents({}, {}, {}, {}, {})", career, age, gender, scholarship, active);
		List<StudentsResponseDTO> response = studentsRepository.findStudents(career, age, gender, scholarship, active);
		log.info("Size of the list of students consulted: " + response.size());
		return studentsMapper.toResponseListDTO(response);
	}
	
	@Override
	@Transactional(readOnly = true)
	public StudentsResponseDTO findById(Long id) {
		log.info("Consultant StudentsServiceImpl.findById({})", id);
		Optional<StudentsEntity> optionalResponse = studentsRepository.findById(id);
		if (optionalResponse.isEmpty()) {
			throw new NoSuchElementException(
					"Student with id = " + id + " not found"
					);
		}
		StudentsEntity response = optionalResponse.get();
		log.info("Id of the student consulted: {}", response.getId());
		return studentsMapper.toResponse(response);
	}
	
	@Override
	@Transactional(readOnly = true)
	public StudentsResponseDTO findByEnrollment(String enrollment) {
		log.info("Consultant StudentsServiceImpl.findStudents({})", enrollment);
		Optional<StudentsEntity> optionalResponse = studentsRepository.findByEnrollment(enrollment);
		if (optionalResponse.isEmpty()) {
			throw new NoSuchElementException(
					"Student with enrollment = " + enrollment + " not found"
					);
		}
		StudentsEntity response = optionalResponse.get();
		log.info("Id of the student consulted: {}", response.getId());
		return studentsMapper.toResponse(response);
	}
	
	@Override
	@Transactional(readOnly = true)
	public StudentsResponseDTO findByIdAndEnrollment(
			Long id,
			String enrollment
			) {
		log.info("Consultant StudentsServiceImpl.findByIdAndEnrollment({}, {})", id, enrollment);
		Optional<StudentsEntity> optionalResponse = studentsRepository.findByIdAndEnrollment(id, enrollment);
		if (optionalResponse.isEmpty()) {
			throw new NoSuchElementException(
					"Student with id = " + id + ", and enrollment = " + enrollment + " not found"
					);
		}
		StudentsEntity response = optionalResponse.get();
		log.info("Id of the student consulted: {}", response.getId());
		return studentsMapper.toResponse(response);
	}
	
	@Override
	@Transactional(readOnly = true)
	public StudentsResponseDTO getStudent(Long id, String enrollment) {
		log.info("Consultant StudentsServiceImpl.getStudent({}, {})", id, enrollment);

		if (id != null && enrollment != null) {
			return findByIdAndEnrollment(id, enrollment);
		}
		
		if (id != null && enrollment == null) {
			return findById(id);
		}
		
		if (id == null && enrollment != null) {
			return findByEnrollment(enrollment);
		}
		
		throw new IllegalArgumentException(
				"It is necessary id and/or enrollment for searching a student"
				);
	}
	
}
