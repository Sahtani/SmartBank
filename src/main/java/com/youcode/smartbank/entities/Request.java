package com.youcode.smartbank.entities;

import jakarta.validation.constraints.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "requests")
public class Request {

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

    public Request(Long id, String project, String status, double amount, int duration, double monthlyPayment, String email, String phone, String title, String lastName, String firstName, String idNumber, Date dateOfBirth, Date employmentStartDate, double monthlyIncome, boolean hasExistingLoans) {
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

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getEmploymentStartDate() {
        return employmentStartDate;
    }

    public void setEmploymentStartDate(Date employmentStartDate) {
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

}
