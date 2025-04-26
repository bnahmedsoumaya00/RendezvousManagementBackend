package com.rendezvous.management.rvmang.controller;

import com.rendezvous.management.rvmang.dto.AppointmentDTO;
import com.rendezvous.management.rvmang.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;         // ← import this for validation
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get appointments for a specific date
    @GetMapping("/{date}")
    public List<AppointmentDTO> getAppointments(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return appointmentService.getAppointmentsForDate(localDate);
    }

    // Create a new appointment with validation
    @PostMapping
    public AppointmentDTO createAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.saveAppointment(appointmentDTO);
    }

    // Get all appointments
    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Delete an appointment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
