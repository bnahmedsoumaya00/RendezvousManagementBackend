// AppointmentMapper.java
package com.rendezvous.management.rvmang.mapper;

import com.rendezvous.management.rvmang.dto.AppointmentDTO;
import com.rendezvous.management.rvmang.model.Appointment;
import com.rendezvous.management.rvmang.model.Client;

public class AppointmentMapper {

    public static AppointmentDTO toDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getDate(),
                appointment.getDescription(),
                appointment.getClient().getId()
        );
    }

    public static Appointment toEntity(AppointmentDTO appointmentDTO, Client client) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setDescription(appointmentDTO.getDescription());
        appointment.setClient(client);
        return appointment;
    }
}
