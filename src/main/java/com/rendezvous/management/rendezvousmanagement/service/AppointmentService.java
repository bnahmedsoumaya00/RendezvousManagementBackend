package com.rendezvous.management.rendezvousmanagement.service;

import com.rendezvous.management.rendezvousmanagement.model.Appointment;
import com.rendezvous.management.rendezvousmanagement.reporsitory.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsForDate(LocalDate date) {
        return appointmentRepository.findByDate(date);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}