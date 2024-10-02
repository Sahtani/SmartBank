package com.youcode.smartbank.entities;

import jakarta.validation.constraints.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "requests")
public class CreditRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private double monthlyPayment;

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

    @NotNull
    @Size(max = 20)
    private String idNumber;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date employmentStartDate;

    @NotNull
    @DecimalMin("0.0")
    private double monthlyIncome;

    private boolean hasExistingLoans;

    public CreditRequest(Long id, String project, String status, double amount, int duration, double monthlyPayment, String email, String phone, String title, String lastName, String firstName, String idNumber, Date dateOfBirth, Date employmentStartDate, double monthlyIncome, boolean hasExistingLoans) {
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
        this.idNumber = idNumber;
        this.dateOfBirth = dateOfBirth;
        this.employmentStartDate = employmentStartDate;
        this.monthlyIncome = monthlyIncome;
        this.hasExistingLoans = hasExistingLoans;
    }

    public CreditRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank @Size(max = 100) String getProject() {
        return project;
    }

    public void setProject(@NotNull @NotBlank @Size(max = 100) String project) {
        this.project = project;
    }

    public @NotNull @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotNull @NotBlank String status) {
        this.status = status;
    }

    @NotNull
    @DecimalMin("0.0")
    public double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull @DecimalMin("0.0") double amount) {
        this.amount = amount;
    }

    @NotNull
    @Min(1)
    public int getDuration() {
        return duration;
    }

    public void setDuration(@NotNull @Min(1) int duration) {
        this.duration = duration;
    }

    @NotNull
    @DecimalMin("0.0")
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(@NotNull @DecimalMin("0.0") double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotNull @Pattern(regexp = "\\d{10}") String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull @Pattern(regexp = "\\d{10}") String phone) {
        this.phone = phone;
    }

    public @NotNull @Size(max = 100) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Size(max = 100) String title) {
        this.title = title;
    }

    public @NotNull @Size(max = 50) String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Size(max = 50) String lastName) {
        this.lastName = lastName;
    }

    public @NotNull @Size(max = 50) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Size(max = 50) String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @Size(max = 20) String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(@NotNull @Size(max = 20) String idNumber) {
        this.idNumber = idNumber;
    }

    public @NotNull @Past Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull @Past Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull Date getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(@NotNull Date employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    @NotNull
    @DecimalMin("0.0")
    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(@NotNull @DecimalMin("0.0") double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public boolean isHasExistingLoans() {
        return hasExistingLoans;
    }

    public void setHasExistingLoans(boolean hasExistingLoans) {
        this.hasExistingLoans = hasExistingLoans;
    }
}
