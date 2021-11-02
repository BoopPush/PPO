package com.example.lab2_attempt2;

import java.util.ArrayList;
import java.util.List;

public class Enrollee {
    private String firstName;
    private String middleName;
    private String lastName;
    /*private Integer markMath;
    private Integer markProg;
    private Integer markLang;*/

    public Enrollee(String firstName,String middleName,String lastName/*,Integer markLang,Integer markMath,Integer markProg*/){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        /*this.markLang = markLang;
        this.markProg = markProg;
        this.markMath = markMath;*/
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFIO(){
        return firstName+" "+middleName+" "+lastName;
    }

    /*public Integer getMarkMath(){
        return markMath;
    }

    public void setMarkMath(Integer markMath){
        this.markMath = markMath;
    }
    public Integer getMarkProg(){
        return markProg;
    }

    public void setMarkProg(Integer markProg){
        this.markProg = markProg;
    }
    public Integer getMarkLang(){
        return markLang;
    }

    public void setMarkLang(Integer markLang){
        this.markLang = markLang;
    }*/

    /*public Integer averageMark(){
        return (markLang+markMath+markProg)/3;
    }

    public String getMarks(){
        return Integer.toString(markProg) + " " + Integer.toString(markLang) + " " + Integer.toString(markMath);
    }*/
}
