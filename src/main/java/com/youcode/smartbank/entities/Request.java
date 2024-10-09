package com.youcode.smartbank.entities;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "requeste", cascade = CascadeType.ALL)
    private Set<RequestStatus> requestStatuses = new HashSet<>();

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String project;
    @NotNull
    @NotBlank
    private String status;
    @NotNull
    @DecimalMin("0.0")
    private double amount;
    @NotNull
    @Min(1)
    private int duration;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal monthlyPayment;

    @Email
    private String email;
    @NotNull
    @Pattern(regexp = "\\d{10}")
    private String phone;
    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @NotNull
    @Size(max = 50)
    private String firstName;


    @Size(max = 20)
    private String cin;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate employmentStartDate;

    @NotNull
    @DecimalMin("0.0")
    private Double monthlyIncome;

    private boolean hasExistingLoans;

    public Request(Long id, String project, String status, double amount, int duration, BigDecimal monthlyPayment, String email, String phone, String title, String lastName, String firstName, String cin, LocalDate dateOfBirth, LocalDate employmentStartDate, double monthlyIncome, boolean hasExistingLoans) {
        this.id = id;
        this.project = project;
        this.status = status;
        this.amount = amount;
        this.duration = duration;
        this.monthlyPayment = monthlyPayment;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
        this.cin = cin;
        this.dateOfBirth = dateOfBirth;
        this.employmentStartDate = employmentStartDate;
        this.monthlyIncome = monthlyIncome;
        this.hasExistingLoans = hasExistingLoans;
    }

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<RequestStatus> getRequestStatuses() {
        return requestStatuses;
    }

    public void setRequestStatuses(Set<RequestStatus> requestStatuses) {
        this.requestStatuses = requestStatuses;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(LocalDate employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public boolean isHasExistingLoans() {
        return hasExistingLoans;
    }

    public void setHasExistingLoans(boolean hasExistingLoans) {
        this.hasExistingLoans = hasExistingLoans;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", duration=" + duration +
                ", monthlyPayment=" + monthlyPayment +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", cin='" + cin + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", employmentStartDate=" + employmentStartDate +
                ", monthlyIncome=" + monthlyIncome +
                ", hasExistingLoans=" + hasExistingLoans +
                '}';
    }
}
