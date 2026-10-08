package com.example.HibernateDemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(
        name="student_name",
        nullable = false,
        length = 100
    )
    private String name;
    @Column (
        unique=true,
        nullable = false,
        length = 150,
        insertable=true,
        updatable=true
    )
    private String email;

    private Long age;

    @ElementCollection 
    @CollectionTable (
        name = "student_address",
        joinColumns = @JoinColumn (name="student_id")
    )
    private Set<Address>addresses;
    
    // @Embedded 
    // @AttributeOverrides ({
    //     @AttributeOverride (
    //         name = "houseNo",
    //         column = @Column (name = "current_house_no")
    //     ),
    //     @AttributeOverride (
    //         name = "street",
    //         column = @Column (name = "current_street")
    //     ),
    //     @AttributeOverride (
    //         name = "city",
    //         column = @Column (name = "current_city")
    //     ),
    //     @AttributeOverride (
    //         name = "state",
    //         column = @Column (name = "current_state")
    //     ),
    //     @AttributeOverride (
    //         name = "pincode",
    //         column = @Column (name = "current_pincode")
    //     )
    // })
    // @Embedded
    // private Address permanentAddress;
    
    @Column (precision = 5, scale=2)
    private BigDecimal percentage;

    @Column(name="dateOfBirth")
    private LocalDate dateOfBirth;

    @Enumerated (EnumType.STRING)
    private StudetStatus status;

    @Lob 
    private String profileDescription;

    @Transient 
    private String displayName;

    @Column(name = "is_monitor")
    @Convert(converter = BooleanToStringConverter.class)
    private Boolean isMonitor;

    private LocalDateTime createdAt;

    public Student(Long id, String name, String email, Long age, Set<Address> addresses, BigDecimal percentage,
            LocalDate dateOfBirth, StudetStatus status, String profileDescription, String displayName,
            Boolean isMonitor, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.addresses = addresses;
        this.percentage = percentage;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.profileDescription = profileDescription;
        this.displayName = displayName;
        this.isMonitor = isMonitor;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StudetStatus getStatus() {
        return status;
    }

    public void setStatus(StudetStatus status) {
        this.status = status;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getIsMonitor() {
        return isMonitor;
    }

    public void setIsMonitor(Boolean isMonitor) {
        this.isMonitor = isMonitor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Student() {
    }

   


}
