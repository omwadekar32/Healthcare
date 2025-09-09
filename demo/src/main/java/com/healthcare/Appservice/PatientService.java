package com.healthcare.Appservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.Appmodel.Patient;
import com.healthcare.Apprepository.PatientRepository;

@Service
public class PatientService implements PatientDetailsService {

    @Autowired
    private  PatientRepository patientRepository;
    
    @Override
    public String savePatient(Patient pDetails) {
       
        patientRepository.save(pDetails); 
         // This is a placeholder implementation
        return "Patient saved successfully";
    }

    @Override
    public Patient getPatientDetails(Long id) {
        // Logic to retrieve patient details from the database by ID
        // This is a placeholder implementation
        return new Patient(); // Should be replaced with actual retrieval logic
    }

    public Object findByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

	
    
}
