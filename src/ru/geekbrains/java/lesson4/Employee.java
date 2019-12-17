package ru.geekbrains.java.lesson4;

public class Employee {

    private String FullName;
    private String position;
    private String phone;
    private float salary;
    private int age;
    private int id;
    private static int CountId=1;

    public Employee(String FullName, String position, String phone, float salary, int age) {
        this.FullName=FullName;
        this.position=position;
        this.phone=phone;
        this.salary=salary;
        this.age=age;
        this.id=CountId;
        CountId++;
    }
    public String getFullName() {
        return FullName;
    }
    public String getPosition() {
        return position;
    }
    public String getPhone() {
        return phone;
    }
    public float getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    public void SalaryUp(int age, int raise){
        if (this.age>age){
            this.salary=this.salary+raise;
        }

   }
}
