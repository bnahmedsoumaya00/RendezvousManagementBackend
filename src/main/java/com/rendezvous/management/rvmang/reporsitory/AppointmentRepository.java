package com.rendezvous.management.rvmang.reporsitory;

import com.rendezvous.management.rvmang.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
