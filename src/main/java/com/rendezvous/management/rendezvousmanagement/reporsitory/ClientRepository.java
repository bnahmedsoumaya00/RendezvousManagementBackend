package com.rendezvous.management.rendezvousmanagement.reporsitory;



import com.rendezvous.management.rendezvousmanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
