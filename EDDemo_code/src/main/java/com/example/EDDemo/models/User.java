package com.example.EDDemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class User {
    @Id
    private Integer id;

    private String name;

    private String surname;

    private String gender;

    private String birthDate;

    private String workAddress;
    
    private String homeAddress;


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