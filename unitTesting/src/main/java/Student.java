/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunat
 */
import java.util.Calendar;

public class Student {
public String firstName;
public String lastName;
public String ID;
public int birthYear;

public Student(String firstName, String lastName, String id, int birthYear) {
   this.firstName = firstName;
   this.lastName = lastName;
   this.ID = id;
   this.birthYear = birthYear;
}

public String getDisplayName() {
   return firstName + " " + lastName;
}

public int getAge(){
   int age = 0;
   int currYear = Calendar.getInstance().get(Calendar.YEAR);
   age = currYear - this.birthYear;
   return age;
}
}
