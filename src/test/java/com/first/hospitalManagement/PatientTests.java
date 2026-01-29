package com.first.hospitalManagement;

import com.first.hospitalManagement.entity.Patient;
import com.first.hospitalManagement.repository.PatientRepository;
import com.first.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);

    }

    @Test
    public void testTransactionMethods() {
//        Patient patient = patientService.getPatientById(1L);

//        Patient patient = patientRepository.findById(1L)
//                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: 1"));

//        Patient patient = patientRepository.findByName("Rohit Patil");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(
//                LocalDate.of(1995, 8, 22), "aarav.sharma@example.com");

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1989, 5, 13));

        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(1, 4, Sort.by("name")));

        for (Patient patient : patientList) {
            System.out.println(patient);
        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (Object[] object : bloodGroupList) {
//            System.out.println(object[0] + " " + object[1]);
//        }

//        int rowsUpdated = patientRepository.updateIdByName("Sneha Joshi", 6L);
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (BloodGroupCountResponseEntity bloodGroupCountResponse : bloodGroupList) {
//            System.out.println(bloodGroupCountResponse);
//        }
    }
}
