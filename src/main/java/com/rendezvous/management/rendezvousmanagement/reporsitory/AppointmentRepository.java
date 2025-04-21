package com.rendezvous.management.rendezvousmanagement.reporsitory;

import com.rendezvous.management.rendezvousmanagement.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDate(LocalDate date); // Custom query to find appointments by date
}
