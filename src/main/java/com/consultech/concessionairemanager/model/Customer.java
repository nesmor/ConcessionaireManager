package com.consultech.concessionairemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import  com.consultech.concessionairemanager.model.enumeration.CustomerStatus;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Pattern(regexp = "[0-9]*")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Column(name = "deleted_date", nullable = true)
    private Instant deletedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status;

    @ManyToOne
    @Cascade(CascadeType.REFRESH)
    @JsonIgnoreProperties("customers")
    private Agency agency;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Customer documentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Customer phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Customer createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public Customer updatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Instant getDeletedDate() {
        return deletedDate;
    }

    public Customer deletedDate(Instant deletedDate) {
        this.deletedDate = deletedDate;
        return this;
    }

    public void setDeletedDate(Instant deletedDate) {
        this.deletedDate = deletedDate;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public Customer status(CustomerStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public Agency getAgency() {
        return agency;
    }

    public Customer agency(Agency agency) {
        this.agency = agency;
        return this;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
   

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        if (customer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", documentNumber='" + getDocumentNumber() + "'" +
            ", name='" + getName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", updatedDate='" + getUpdatedDate() + "'" +
            ", deletedDate='" + getDeletedDate() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
