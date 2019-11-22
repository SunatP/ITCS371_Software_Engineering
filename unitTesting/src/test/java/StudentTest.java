/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Sunat
 */
public class StudentTest {
    Student stu;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
         stu = new Student("Wudhichart","Sawangphol", "99999999", 1986);
    }

    @After
    public void tearDown() throws Exception {
    }



   @Test
   public void getDisplayName() {
       String displayName = stu.getDisplayName();
       assertEquals("Wudhichart Sawangphol", displayName);
   }

    /**
     * Test of getDisplayName method, of class Student.
     */

    /**
     * Test of getAge method, of class Student.
     */
    @Test
    public void GetAge() {
        int getage = stu.getAge();
        int target = Calendar.getInstance().get(Calendar.YEAR) - 1986;
        assertEquals(target, getage);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Student.
     */
    @ParameterizedTest(name="TestDisplayName for {2}")
    @CsvSource({
       "Wudhichart,Sawangphol,Wudhichart Sawangphol",
       "Morakot,    Choetkiertikul,   Morakot Choetkiertikul",
       "Chaiyong,  Ragkhitwetsagul, Chaiyong Ragkhitwetsagul"
    })
    void getDisplayNames(String firstName, String lastName, String expectedResult){
    Student stu1 = new Student(firstName,lastName,"9999999",1986);
    assertEquals(expectedResult,stu1.getDisplayName(), firstName + " " + lastName + "should be " + expectedResult);
}

    
}
