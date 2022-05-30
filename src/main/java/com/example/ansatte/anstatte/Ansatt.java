package com.example.ansatte.anstatte;

import javax.persistence.*;

@Entity
@Table
public class Ansatt {

    @Id
    @SequenceGenerator(
            name="ansatt_sequence",
            sequenceName = "ansatt_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ansatt_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String address;
    private String streetNr;
    private Integer zipCode;
    private Integer phoneNr;


    public Ansatt() {

    }

    public Ansatt(Long id, String name, String email, String gender, String address, String streetNr, Integer zipCode, Integer phoneNr) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.streetNr = streetNr;
        this.zipCode = zipCode;
        this.phoneNr = phoneNr;
    }

    public Ansatt(String name, String email, String gender, String address, String streetNr, Integer zipCode, Integer phoneNr) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.streetNr = streetNr;
        this.zipCode = zipCode;
        this.phoneNr = phoneNr;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(Integer phoneNr) {
        this.phoneNr = phoneNr;
    }

    @Override
    public String toString() {
        return "Ansatt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", streetNr='" + streetNr + '\'' +
                ", zipCode=" + zipCode +
                ", phoneNr=" + phoneNr +
                '}';
    }
}
