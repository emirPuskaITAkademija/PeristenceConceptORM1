package model;

import java.io.Serializable;

/**
 * POJO Plain Old Java Object
 * <p>
 * JAVA Bean
 * <li>1. Serializable</li>
 * <li>2. GET SET</li>
 * <li>3. Konstruktor bez parametara</li>
 */
public class Person implements Serializable {

    private String nationalIdentificationNumber;
    private String name;
    //transient
    private String surname;
    private int age;

    public Person() {

    }

    public Person(String nationalIdentificationNumber, String name, String surname, int age) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
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

    @Override
    public String toString() {
        return "Person{" +
                "nationalIdentificationNumber='" + nationalIdentificationNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
