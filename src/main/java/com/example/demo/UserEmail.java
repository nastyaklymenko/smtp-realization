package com.example.demo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.soap.SAAJResult;

@Entity
@Table(name = "user_email")
public class UserEmail implements Serializable {

    @Id
    private String email;

    @Column
    private String pib;

    public UserEmail() {};

    public UserEmail(String email, String pib){
        this.email = email;
        this.pib = pib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
