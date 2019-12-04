package ru.geekbrains.java.lesson1;

public class HomeTask {
    private static double calculate(int arg1, int arg2, int arg3, int arg4) {
        double result;
        double f=1;
        result=arg1*(arg2+(f*arg3/arg4));
        return result;
    }
    private static boolean  task10and20(int arg1, int arg2){
        boolean result;
        result=((arg1+arg2)>=10)&&((arg1+arg2)<=20);
        return result;
    }

    public static void isPositiveOrNegative(int arg1){
        if (arg1>=0) {
            System.out.println("Это положительное число");
        }
        else {
            System.out.println("Это отрицательное число");
        }
    }

    public static void greetings(String name) {
        System.out.println("Привет, "+ name);
    }

    public static void isYearLeapOrNot(int YearForCheck){
        if (YearForCheck%4!=0||(YearForCheck%100==0&&YearForCheck%400!=0)) {
            System.out.println("Год невисокосный");
        }
            else {
            System.out.println("Год високосный");
        }

    }
    public static void main(String[] args) {

        System.out.println(calculate(2,5,8,3));
        System.out.println(task10and20(9,1));
        isPositiveOrNegative(-10);
        greetings("Анна");
        isYearLeapOrNot(400);

        }

}
