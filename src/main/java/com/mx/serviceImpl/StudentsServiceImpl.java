package com.mx.serviceImpl;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.mapper.StudentsMapper;
import com.mx.repository.StudentsRepository;
import com.mx.service.StudentsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private StudentsMapper studentsMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<StudentsResponseDTO> findStudents() {
		List<StudentsResponseDTO> response = studentsRepository.findStudents();
		return studentsMapper.toResponseListDTO(response);
	}
	// Prueba
}
