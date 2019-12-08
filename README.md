# Unit Test โดยใช้ Maven

## Maven คืออะไร

Maven คือเครื่องมือช่วยสร้างโปรเจค(Build Project) และช่วยหา Library ที่เหมาะสมให้กับตัวโปรเจคนั้นๆด้วย โดย Maven จะมีชื่อเรียกอีกแบบคือ **build/project management tool** ไฟล์หลักนั้นจะเป็นไฟล์ชื่อ **pom.xml** ซึ่งมีการ config library สำหรับการ Build Project ด้วยเช่นกัน หน้าตา pom.xml จะมีลักษณะประมาณนี้

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- ข้อมูลตัวโปรเจค -->
    <groupId>itcs371.ict.mahidol.ac.th</groupId>
    <artifactId>unitTesting</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!-- Project Infomation -->

    <!-- ตรงนี้คือ Output Package -->
    <packaging>jar</packaging> 
    <!-- Output Package -->

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
    <!-- ตรงนี้คือ Dependencies -->
   <dependency>
       <groupId>org.junit.jupiter</groupId>
       <artifactId>junit-jupiter</artifactId>
       <version>5.5.1</version>
       <scope>test</scope>
   </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-core</artifactId>
            <version>1.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-source-plugin</artifactId>
    <version>3.1.0</version>
    </dependency>
    <dependency>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-javadoc-plugin</artifactId>
    <version>3.1.1</version>
    </dependency>
    <dependency>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-deploy-plugin</artifactId>
    <version>3.0.0-M1</version>
    </dependency>
    <dependency>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>3.0.0-M4</version>
      <type>maven-plugin</type>
    </dependency>
    <!-- จบ Dependencies -->
    </dependencies>
    
<build> 
<!-- ตรงนี้คือเริ่มต้น Plugin ของ Build -->
   <plugins>
       <plugin>
           <artifactId>maven-compiler-plugin</artifactId>
           <version>3.8.1</version>
       </plugin>
       <plugin>
           <artifactId>maven-surefire-plugin</artifactId>
           <version>2.22.2</version>
       </plugin>
       <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.19.1</version>
        </plugin>
   </plugins>
   <!-- จบ Plugin Build -->
</build>
</project>
```

### Path Structure หรือโครงสร้างแฟ้มสำหรับ Maven

```bash
unitTesting
├── nbprojects # ตัวนี้เราใช้ NetBeanIDE มันเลยมีแฟ้มตัวนี้สร้างมาให้
├── .settings
|   |   ├── **/*.prefs
├── src
|   ├── main
|   |   ├── java
|   |   |    ├── **/*.java 
|   ├── test
|   |   ├── java
|   |   |    ├── **/*.java
├── target
|   ├── classes
|   ├── generated-sources
|   ├── generated-test-sources
|   ├── maven-status
|   ├── test-classes
├── .classpath
├── .project
├── pom.xml # พระเอกเราคือตัวนี้
```

หรือแบบนี้ (บน IntelliJ IDEA)
![1](https://3.bp.blogspot.com/-XjFEBOMzJxo/Wr99Ts2_d2I/AAAAAAAAWJw/AgE_USIGjwgGRhtMjYZwBLn3sf7-gUB_ACK4BGAYYCw/s400/Screen%2BShot%2B2561-03-31%2Bat%2B19.20.22.png)

### ไฟล์และหลักการทำงาน pom.xml

ไฟล์ pom.xml จะมี **Attributes** ที่สำคัญอยู๋ 3 อย่างคือ 
1.  groupid คือ ชื่อ package (ควรใช้ตัวอักษรตัวเล็กทั้งหมด[lowercase])
2.  artifactid คือชื่อ project ที่ทำ
3.  version คือ version ที่ใช้ในการ build project เช่น 1.0-SNAPSHOT

ในการจะใช้งาน Maven ในการทำโปรเจค maven จะต้องทำการโหลด dependency ดังนั้นเราเลยต้องระบุ Attributes ทั้งสามให้ถูกต้องและครบถ้วน ไม่งั้นโปรเจคอาจจะ build&test ไม่ได้ก็เป็นได้

หลักการทำงานของ pom.xml
![2](https://miro.medium.com/max/700/1*E5K0nC9PsZo7mqO11zLSDQ.gif)

### Keyword ที่จำเป็นต้องจำ

 **groupId** คือชื่อ source code package hierarchyที่ปกติเราสร้างขึ้นมาเอง แต่ maven จะให้เราตั้งชื่อ groupId ในขั้นตอนการสร้าง project ตัวอย่างการตั้งค่า เช่น com.somchai.app อะไรแบบนี้
 **artifactId**  เป็นการตั้งชื่อ app ของเรา โดยต้องกำหนดเป็นค่า unique
 **version** เป็นการตั้งค่า version ของ app เรา
 **Dependency** เป็นการนำ concept DI (Dependency Injection) มาใช้งาน โดยเราอยากใช้งาน Library ไหน ก็ใส่ Project ผ่านการ config pom.xml ได้เลย
 **Repository** เหมือนถังไว้เก็บ Library นั่นแหละ

 ### Life Cycle ของ Maven มีอะไรบ้าง

1.  validate คือขั้นตอนการตรวสอบ pom.xml ที่เราได้ทำการ config ไว้
2.  compile จะเป็นขั้นตอนการโหลด Library เข้ามาเก็บไว้ตาม pom.xml ที่เราได้ config และจะทำการคอมไพล์ตัวเองเป็น binary class เมื่อทำเสร็จจะสร้างโฟลเดอร์ชื่อ target ที่อยู่ในโฟลเดอร์ src สำหรับเก็บ binary class
3.  test คือการเช็คแต่ละ test case ตามที่เราอยากจะให้มัน test 
4.  package เมื่อเทสเสร็จตัว binary source code จะทำการเก็บโค้ดไปไว้ที่ target folder 
5.  install นำไฟล์ jar ไปเก็บไว้ที่ local maven repository
6.  deploy คือปล่อยขึ้น server

คำสั่งที่ใช้ประจำ<br>
![3](https://miro.medium.com/max/875/1*_j_tZ7LfAe3mcSZKN_5_WQ.gif)

### ใช้ maven ทำเทส student 

หลังจากที่เราได้ทำการตั้งค่า maven เสร็จหมดแล้วให้เราทำการสร้างไฟล์ student.java ขึ้นมา

```java
import java.util.Calendar;

public class Student {
public String firstName;
public String lastName;
public String ID;
public int birthYear;

public Student(String firstName, String lastName, String id, int birthYear) 
{
   this.firstName = firstName;
   this.lastName = lastName;
   this.ID = id;
   this.birthYear = birthYear;
}

public String getDisplayName() 
{
   return firstName + " " + lastName;
}

public int getAge()
    {
        int age = 0;
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        age = currYear - this.birthYear;
        return age;
    }
}

```

หลังจากที่สร้างเสร็จแล้วกดคลิกขวาที่ ฟังก์ขั่นหรือเมธอดชื่อ **getDisplayName()** แล้วกด Generate -> Test จากนั้นเลือกเมธอด getDisplayName() แล้วเลือก Setup() และ tearDown() ตัวโปรแกรมจะสร้าง Test Unit ออกมาให้โดยอัตโนมัติซึ่งก็คือไฟล์ใหม่นั่นเอง จากนั้นเข้าไปที่ไฟล์ใหม่ที่ได้จากการ generate มานั้นแก้ไฟล์เพิ่มอีกหน่อยก็สามารถทำการ Test ได้แล้วนั่นเอง
