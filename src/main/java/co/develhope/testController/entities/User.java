package co.develhope.testController.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private int age;
    private boolean isActive;


    public User() {
    }

    public User(long id, String name, String surname, int age, boolean isActive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}