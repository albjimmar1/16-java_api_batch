package com.example.batch.models;

import java.util.Date;

public class Person {
    private long id;
    private String name;
    private int age;
    private String job;
    private String industry;
    private String country;
    private int salary;
    private int bonus;
    private String currency;
    private Date registrationDate;

    public Person() {
    }

    public Person(String name, int age, String job, String industry, String country, int salary, int bonus, String currency) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.industry = industry;
        this.country = country;
        this.salary = salary;
        this.bonus = bonus;
        this.currency = currency;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", industry='" + industry + '\'' +
                ", country='" + country + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", currency='" + currency + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public String toCSV() {
        return id +
                ";" + name +
                ";" + age +
                ";" + job +
                ";" + industry +
                ";" + country +
                ";" + salary +
                ";" + bonus +
                ";" + currency +
                ";" + registrationDate
                ;
    }
}
