package ru.geekbrains.java.lesson4;
import java.lang.String;
/**
 * Домашняя работа №4.
 * Таланкина Анна Владимировна.
 * Создан: 2019.12.14
 */
/*
    1. Coздать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
    2.Конструктор класса должен заполнять эти поля при создании объекта;
    3.Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    4.Вывести при помощи методов из пункта 3 ФИО и должность.
    5.Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    6.* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    7.*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный
     идентификационный порядковый номер
 */
public class Lesson4 {

    public static void main(String[] args) {

        Employee e0= new Employee ("Иванов Одиссей Соломонович","Путешественник во времени",
                "89049112111", 70000, 35);
        Employee e1= new Employee("Кузнецов Филлип Платонович", "Аналитик","89119711111",
                60000, 30);
        Employee e2=new Employee("Петрова Агата Анатольевна","Охранник","89222222222",
                25000, 25);
        System.out.println("Задание 4: ФИО сотрудника: " + e0.getFullName()+". Должность: "+ e0.getPosition());

        Employee[] EmpArr = new Employee[5];
        EmpArr[0]=e0;
        EmpArr[1]=e1;
        EmpArr[2]=e2;
        EmpArr[3]= new Employee("Носкова Агрофена Феофановна", "Лаборант", "89011111111",
                20000, 50);
        EmpArr[4]=new Employee("Штука Ферропонт Олегович","Охотник на мамонтов","23713190",
                50000, 46);
        System.out.println("Список сотрудников, старше 40 лет (задание 5):");
        for (int i=0;i<EmpArr.length;i++){
            if (EmpArr[i].getAge()>40){
                System.out.println("ФИО сотрудника: "+ EmpArr[i].getFullName()+ " Должность: "+ EmpArr[i].getPosition()
                + " Телефон: "+EmpArr[i].getPhone()+" Оклад: "+EmpArr[i].getSalary()+"руб. Возраст: "+EmpArr[i].getAge());
            }
        }
        System.out.println("Результат работы метода, повышающего оклад (задание 6):");
        for (int i=0;i<EmpArr.length;i++) {
                EmpArr[i].SalaryUp(45,5000);
                System.out.println("ФИО сотрудника: "+ EmpArr[i].getFullName()+ " Оклад: "+ EmpArr[i].getSalary());


        }
        System.out.println("ID сотрудников (задание 7):");
        for (int i=0;i<EmpArr.length;i++){
            System.out.println("ID: "+EmpArr[i].getId()+" ФИО сотрудника: "+ EmpArr[i].getFullName());
        }
    }
}
