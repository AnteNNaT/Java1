package ru.geekbrains.java.lesson5;

public class Cat extends Animal {

    private static int RunningDistance=200;
    private static double JumpingHeight=2;
    private static double deviation=0.2;
    private int TempVar1;
    private double TempVar2;

    public Cat (String Name, int age){
        super(Name, age);
        TempVar1=RunningDistance+(int)((Math.random()*(2*RunningDistance*deviation+1)) - RunningDistance*deviation);
        setDistance(TempVar1);
        TempVar2=JumpingHeight+Math.round(((Math.random()*(2*JumpingHeight*deviation+0.1)) - JumpingHeight*deviation)*10)/10.0;
        setHeight(TempVar2);
        setSwDistance(0);
    }

    @Override
    public String running(int Distance){
        if (Distance<=getDistance()){
            return "Котик "+ getName() +" пробежал "+ Distance + " м.!";
        }
        else return "Котик "+ getName() +" пробежал "+getDistance()+" м., устал и не смог пробежать "+Distance+" м.!";

    }

    @Override
    public String jumping(double Height){
        if (Height<=getHeight()){
            return "Котик "+ getName() + " подпрыгнул на "+ Height + " м.!";
        }
        else return "Котик "+ getName() +" не смог подпрыгнуть на "+Height+" м.! Он подпрыгнул на "+getHeight()+" м.";
    }
    @Override
    public String swimming (int SwimmingDistance){
        return "Котик "+ getName() +" боится намочить лапки.";
    }
}
