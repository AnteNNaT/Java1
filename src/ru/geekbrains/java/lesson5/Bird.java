package ru.geekbrains.java.lesson5;

public class Bird extends Animal {
    private static int RunningDistance=5;
    private static double JumpingHeight=0.2;
    private static double deviation=0.5;
    private int TempVar1;
    private double TempVar2;

    public Bird (String Name, int age){
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
            return "Птичка "+ getName() +" пробежала "+ Distance + " м.!";
        }
        else return "Птичка "+ getName() +" пробежала "+getDistance()+" м., устала и не смогла пробежать "+Distance+" м.!";

    }

    @Override
    public String jumping(double Height){
        if (Height<=getHeight()){
            return "Птичка "+ getName() + " подпрыгнула на "+ Height + " м.!";
        }
        else return "Птичка "+ getName() +" не смогла подпрыгнуть на "+Height+" м.! Она подпрыгнула на "+getHeight()+" м.";
    }
    @Override
    public String swimming (int SwimmingDistance){
        return "Птичка "+ getName() +" боится, что ее съест крокодил.";
    }
}
