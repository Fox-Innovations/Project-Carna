package com.FoxInnovations.Information;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PatientInfo {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dob;
    private AdmissionInfo admission;

    public PatientInfo(String patientFirstName, String patientLastName, int patientAge, LocalDate patientDateOfBirth,
            AdmissionInfo patientAdmission) {
        firstName = patientFirstName;
        lastName = patientLastName;
        age = patientAge;
        dob = patientDateOfBirth;
        admission = patientAdmission;
    }

    public static String getJSONPath() {
        // #TODO add in project carna to this file name, this does not work on other
        // computers
        // C:\Users\swedi\OneDrive\Documents\Github\Project-Carna\Project-Carna\src\main\java\com\FoxInnovations\JSON_files
        return File.separator + System.getProperty("user.dir") + File.separator + "Project-Carna" + File.separator
                + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator
                + "FoxInnovations" + File.separator + "JSON_files" + File.separator + "patient.json";
    }

    public static void writeJSONFile(PatientInfo patient) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(getJSONPath());
        writer.write(gson.toJson(patient));
        writer.close();
    }

    public static PatientInfo readJSONFile() throws FileNotFoundException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(getJSONPath()));
        PatientInfo patient = gson.fromJson(bufferedReader, PatientInfo.class);
        return patient;
    }

    public String toString() {
        String toReturn = "fname: " + firstName + "|| lname: " + lastName + "|| age: " + age + "|| dob: "
                + "|| admission: {" + admission + "}";
        return toReturn;
    }

    public String getPatientFirstName() {
        return firstName;
    }

    public String getPatientLastName() {
        return lastName;
    }

    public int getPatientAge() {
        return age;
    }

    public LocalDate getPatientDateOfBirth() {
        return dob;
    }

    public AdmissionInfo getAdmission() {
        return admission;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAdmission(AdmissionInfo admission) {
        this.admission = admission;
    }
}