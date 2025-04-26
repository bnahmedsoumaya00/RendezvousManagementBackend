package com.rendezvous.management.rvmang.dto;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AppointmentDTO {

    private Long id; // You already have the id field in the DTO

    @Future(message = "Date must be in the future")
    private LocalDateTime date;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Client ID is required")
    private Long clientId;

    // Constructors
    public AppointmentDTO() {}

    public AppointmentDTO(Long id, LocalDateTime date, String description, Long clientId) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.clientId = clientId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
}
