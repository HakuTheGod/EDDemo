package com.example.EDDemo.entities;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity

public class User {
    @Id
    @GeneratedValue
    private Integer id; 

    private String name;

    private String surname;

    private String gender;

    private String birthDate;

    private String workAddress;
    
    private String homeAddress;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getBirthDate(){
        return birthDate;
    }
    
    public void seBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public String getWorkAddress(){
        return workAddress;
    }
    
    public void setWorkAddress(String workAddress){
        this.workAddress = workAddress;
    }

    public String getHomeAddress(){
        return homeAddress;
    }
    
    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }
}