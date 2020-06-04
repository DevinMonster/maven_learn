package com.devin.entity;

import java.util.Date;

public class Student {
    private String studentID;
    private String studentName;
    private String studentNo;
    private String gender;
    private Integer age;
    private String className;
    private Date timeRenew;


    public Student(String studentID, String studentName, String studentNo, String gender, Integer age, String className, Date timeRenew) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentNo = studentNo;
        this.gender = gender;
        this.age = age;
        this.className = className;
        this.timeRenew = timeRenew;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", timeRenew=" + timeRenew +
                '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getTimeRenew() {
        return timeRenew;
    }

    public void setTimeRenew(Date timeRenew) {
        this.timeRenew = timeRenew;
    }
}
