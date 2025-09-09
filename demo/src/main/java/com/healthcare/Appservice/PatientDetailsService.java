package com.healthcare.Appservice;

import com.healthcare.Appmodel.Patient;

public interface PatientDetailsService {
    String savePatient(Patient pDetails);
    
    Patient getPatientDetails(Long id);
}
