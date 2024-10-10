package com.youcode.smartbank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "request_status")
public class RequestStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    public RequestStatus(Long id, Request request, Status status, LocalDate date, String description) {
        this.id = id;
        this.request = request;
        this.status = status;
        this.date = date;
        this.description = description;
    }
    public RequestStatus() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
