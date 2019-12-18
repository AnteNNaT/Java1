package ru.geekbrains.java.lesson5;

public abstract class Animal {
    private String Name;
    private int age;
    private int Distance;
    private double Height;
    private int SwDistance;

    public Animal (String Name, int age) {
        this.Name=Name;
        this.age=age;
    }
    public String getName() { return Name; }
    public int getAge() { return age; }
    public int getDistance() { return Distance; }
    public double getHeight() { return Height; }
    public int getSwDistance() { return SwDistance; }
    public void setName(String name) { Name = name; }
    public void setAge(int age) { this.age = age; }
    public void setDistance(int Distance){this.Distance=Distance;}
    public void setHeight(double height) { Height = height; }
    public void setSwDistance(int swDistance) { SwDistance = swDistance; }

    public abstract String running(int Distance);
    public abstract String jumping(double Height);
    public abstract String swimming (int SwDistance);


}
