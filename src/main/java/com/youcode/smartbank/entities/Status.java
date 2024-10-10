package com.youcode.smartbank.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private Set<RequestStatus> requestStatuses = new HashSet<>();

    public Status(Long id, String status, Set<RequestStatus> requestStatuses) {
        this.id = id;
        this.status = status;
        this.requestStatuses = requestStatuses;
    }
    public Status() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<RequestStatus> getRequestStatuses() {
        return requestStatuses;
    }

    public void setRequestStatuses(Set<RequestStatus> requestStatuses) {
        this.requestStatuses = requestStatuses;
    }
}
