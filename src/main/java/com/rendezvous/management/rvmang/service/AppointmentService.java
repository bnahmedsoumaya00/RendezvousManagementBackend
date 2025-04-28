// AppointmentService.java
package com.rendezvous.management.rvmang.service;

import com.rendezvous.management.rvmang.dto.AppointmentDTO;
import com.rendezvous.management.rvmang.mapper.AppointmentMapper;
import com.rendezvous.management.rvmang.model.Appointment;
import com.rendezvous.management.rvmang.model.Client;
import com.rendezvous.management.rvmang.reporsitory.AppointmentRepository;
import com.rendezvous.management.rvmang.reporsitory.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<AppointmentDTO> getAppointmentsForDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        return appointmentRepository.findByDateBetween(startOfDay, endOfDay)
                .stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {
        Client client = clientRepository.findById(appointmentDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + appointmentDTO.getClientId()));

        Appointment appointment = AppointmentMapper.toEntity(appointmentDTO, client);
        return AppointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO updatedAppointmentDTO) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

        Client client = clientRepository.findById(updatedAppointmentDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + updatedAppointmentDTO.getClientId()));

        existingAppointment.setDate(updatedAppointmentDTO.getDate());
        existingAppointment.setDescription(updatedAppointmentDTO.getDescription());
        existingAppointment.setClient(client);

        Appointment savedAppointment = appointmentRepository.save(existingAppointment);
        return AppointmentMapper.toDTO(savedAppointment);
    }
}

