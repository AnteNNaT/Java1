package ru.geekbrains.java.lesson5;

public class Lesson5 {


    public static void main (String[] args){

        Animal[] arr=new Animal[12];
        arr[0]=new Cat("Бегемот",10);
        arr[1]=new Cat("Толстяк", 2);
        arr[2]=new Cat("Килька", 1);
        arr[3]=new Dog("Сосиска", 5);
        arr[4]=new Dog("Беляшик", 4);
        arr[5]=new Dog("Шарик", 2);
        arr[6]=new Bird("Капитан Флинт", 50);
        arr[7]=new Bird("Жорик", 10);
        arr[8]=new Bird("Булочка", 7);
        arr[9]=new Horse("Черничка", 4);
        arr[10]=new Horse("Быстрый", 2);
        arr[11]=new Horse("Звездочка", 2);

        for (int i=0;i<arr.length;i++) {
            if (arr[i] instanceof Cat) {
                System.out.println(arr[i].running(210));
                System.out.println(arr[i].jumping(2));
                System.out.println(arr[i].swimming(10));
            }
            if (arr[i] instanceof Dog) {
                System.out.println(arr[i].running(500));
                System.out.println(arr[i].jumping(0.6));
                System.out.println(arr[i].swimming(10));
            }
            if (arr[i] instanceof Bird) {
                System.out.println(arr[i].running(5));
                System.out.println(arr[i].jumping(0.2));
                System.out.println(arr[i].swimming(10));
            }
            if (arr[i] instanceof Horse) {
                System.out.println(arr[i].running(1600));
                System.out.println(arr[i].jumping(3.1));
                System.out.println(arr[i].swimming(100));
            }
        }

    }
}
