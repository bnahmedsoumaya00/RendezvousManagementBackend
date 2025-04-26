package com.rendezvous.management.rvmang.reporsitory;



import com.rendezvous.management.rvmang.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
