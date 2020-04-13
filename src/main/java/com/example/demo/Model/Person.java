package com.example.demo.Model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long ID;
    private String FName;
    private String LName;
    private int Age;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Person() {
    }

    public Person(long ID, String FName, String LName, int age) {
        this.ID = ID;
        this.FName = FName;
        this.LName = LName;
        Age = age;
    }
}
