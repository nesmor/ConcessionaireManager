package com.consultech.concessionairemanager.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Agency.
 */
@Entity
@Table(name = "agency")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Agency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne    @JoinColumn(unique = true)
    @Cascade(CascadeType.REFRESH)
    private Location location;

    @OneToMany(mappedBy = "agency")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Customer> customers = new HashSet<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Agency name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public Agency location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Agency customers(Set<Customer> customers) {
        this.customers = customers;
        return this;
    }

    public Agency addCustomer(Customer customer) {
        this.customers.add(customer);
        customer.setAgency(this);
        return this;
    }

    public Agency removeCustomer(Customer customer) {
        this.customers.remove(customer);
        customer.setAgency(null);
        return this;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Agency agency = (Agency) o;
        if (agency.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), agency.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Agency{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
