package ru.geekbrains.java.lesson5;

public class Dog extends Animal {
    private static int RunningDistance=500;
    private static double JumpingHeight=0.5;
    private static int SwimmingDistance=10;
    private static double deviation=0.2;
    private int TempVar1;
    private double TempVar2;
    private int TempVar3;

    public Dog (String Name, int age){
        super(Name, age);
        TempVar1=RunningDistance+(int)((Math.random()*(2*RunningDistance*deviation+1)) - RunningDistance*deviation);
        setDistance(TempVar1);
        TempVar2=JumpingHeight+Math.round(((Math.random()*(2*JumpingHeight*deviation+0.1)) - JumpingHeight*deviation)*10)/10.0;
        setHeight(TempVar2);
        TempVar3=SwimmingDistance+(int)((Math.random()*(2*SwimmingDistance*deviation+1)) - SwimmingDistance*deviation);
        setSwDistance(TempVar3);
    }

    @Override
    public String running(int Distance){
        if (Distance<=getDistance()){
            return "Собачка "+ getName() +" пробежала "+ Distance + " м.!";
        }
        else return "Собачка "+ getName() +" пробежала "+getDistance()+" м., устала и не смогла пробежать "+Distance+" м.!";

    }
    @Override
    public String jumping(double Height){
        if (Height<=getHeight()){
            return "Собачка "+ getName() + " подпрыгнула на "+ Height + " м.!";
        }
        else return "Собачка "+ getName() +" не смогла подпрыгнуть на "+Height+" м.! Она подпрыгнула на "+getHeight()+" м.";
    }
    @Override
    public String swimming (int SwDistance){
        if (SwDistance<=getSwDistance()) {
            return "Собачка "+ getName() +" проплыла "+ SwDistance + " м.!";
        }
        else return "Собачка "+ getName() +" проплыла "+getSwDistance()+" м., устала и не смогла проплыть "+SwDistance+" м.!";
    }
}
