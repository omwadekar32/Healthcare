package com.healthcare.Apprepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.Appmodel.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
