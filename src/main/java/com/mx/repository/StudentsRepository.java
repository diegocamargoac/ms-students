package com.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.entity.StudentsEntity;

public interface StudentsRepository extends JpaRepository<StudentsEntity, Long> {

	@Query("""
			SELECT new com.mx.dto.response.StudentsResponseDTO(
				students.id,
				students.enrollment,
				students.name,
				students.paternalSurname,
				students.maternalSurname,
				students.email,
				students.phone,
				students.birthdate,
				students.age,
				students.gender,
				students.career,
				students.schoolYear,
				students.average,
				students.scholarship,
				students.active,
				students.registrationDate
			)
			FROM StudentsEntity students
			""")
	List<StudentsResponseDTO> findAllStudents();
	
}
