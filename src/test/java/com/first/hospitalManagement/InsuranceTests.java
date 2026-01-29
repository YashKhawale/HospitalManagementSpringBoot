package com.first.hospitalManagement;

import com.first.hospitalManagement.entity.Appointment;
import com.first.hospitalManagement.entity.Insurance;
import com.first.hospitalManagement.entity.Patient;
import com.first.hospitalManagement.repository.PatientRepository;
import com.first.hospitalManagement.service.AppointmentService;
import com.first.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

        var newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);

    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0))
                .reason("Cancer")
                .build();
        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);

        System.out.println(updatedAppointment);
    }

    @Test
    public void homework() {
        Appointment appointment1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 2, 2, 14, 0))
                .reason("Flu")
                .build();
        Appointment appointment2 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 2, 3, 12, 0))
                .reason("Malaria")
                .build();
        Appointment appointment3 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 2, 4, 10, 0))
                .reason("Cancer")
                .build();
        var newAppointment1 = appointmentService.createNewAppointment(appointment1, 2L, 3L);
        var newAppointment2 = appointmentService.createNewAppointment(appointment2, 3L, 3L);
        var newAppointment3 = appointmentService.createNewAppointment(appointment3, 1L, 3L);
        System.out.println(newAppointment1);
        System.out.println(newAppointment2);
        System.out.println(newAppointment3);
    }

    @Test
    public void homeworkContinue() {
        Patient patient = patientRepository.findById(3L).orElseThrow();
        patientRepository.delete(patient);
    }
}
