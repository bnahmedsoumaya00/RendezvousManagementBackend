package com.rendezvous.management.rendezvousmanagement.controller;

import com.rendezvous.management.rendezvousmanagement.model.Appointment;
import com.rendezvous.management.rendezvousmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get appointments for a specific date
    @GetMapping("/{date}")
    public List<Appointment> getAppointments(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return appointmentService.getAppointmentsForDate(localDate);
    }

    // Create a new appointment
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Delete an appointment
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
