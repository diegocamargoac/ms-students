package com.mx.repository;

import com.mx.dto.response.StudentsResponseDTO;
import com.mx.entity.StudentsEntity;
import com.mx.enums.Gender;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
			WHERE (:career IS NULL OR :career = students.career)
			  AND (:age IS NULL OR :age = students.age)
			  AND (:gender IS NULL OR :gender = students.gender)
			  AND (:scholarship IS NULL OR :scholarship = students.scholarship)
			  AND (:active IS NULL OR :active = students.active)
			""")
	List<StudentsResponseDTO> findStudents(
			@Param("career") String career,
			@Param("age") Integer age,
			@Param("gender") Gender gender,
			@Param("scholarship") Boolean scholarship,
			@Param("active") Boolean active
			);
	
	Optional<StudentsEntity> findById(Long id);
	
	Optional<StudentsEntity> findByEnrollment(String enrollement);

	Optional<StudentsEntity> findByIdAndEnrollment(
			Long id,
			String enrollment
			);
	
}
