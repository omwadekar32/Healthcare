package com.healthcare.Appcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.Appmodel.Patient;
import com.healthcare.Appmodel.User;
import com.healthcare.Appservice.PatientService;
import com.healthcare.Appservice.UserService;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @PostMapping("/SavePatient")
    public String SavePatient(@RequestBody Patient PDetails) {

        System.out.println(PDetails);

        return patientService.savePatient(PDetails);
    }

    public Patient getPatientDetails(Long id) {

        return new Patient(); // Placeholder return, should be replaced with actual retrieval logic
    }
    // Additional methods for handling patient-related requests can be added here

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signup(@RequestBody User newUser) {

        Map<String, String> response = new HashMap<>();
        if (userService.findByUsername(newUser.getUsername()) != null) {

            response.put("message", "Username already exists");

            return ResponseEntity.badRequest().body(response);
        }

        userService.save(newUser);

        response.put("message", "Sign up successful");
        return ResponseEntity.ok(response);
    }

   

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User loginUser) {
        System.out.println(loginUser);

        Map<String, String> response = new HashMap<>();
        User user = userService.findByUsername(loginUser.getUsername());

        if (user == null || !user.getPassword().equals(loginUser.getPassword())) {

            response.put("message", "Invalid username or password");
            return ResponseEntity.status(401).body(response);
        }

        response.put("message", "Login successful");
        return ResponseEntity.ok(response);
    }
}
