package ru.geekbrains.java.lesson2;
import java.util.Arrays;
/**
 * Домашняя работа №2.
 * Таланкина Анна Владимировна.
 * Создан: 2019.12.09
 */

public class Lesson2 {

    //Функция для печати двумерного массива.
    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    */
    public static void ChangeArr(int[] arr){
        for (int i=0;i<arr.length;i++) {
            arr[i]=(arr[i]==0)? 1 : 0;
         }
    }
    /*
    Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22
     */
    public static void FillArr(int[] arr){
        for (int i=0;i<arr.length;i++) {
            arr[i]=(i==0)? 1 : arr[i-1]+3;
        }
    }
    /*
     Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
     написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     */
    public static void DiffArrElements(int[] arr){
        for (int i=0; i<arr.length; i++) {
            arr[i]=(arr[i]<6)? arr[i]*2 : arr[i];
        }
    }
    /*
    Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
     */
    public static int MaxElement(int[] arr){
        int MaxEl=arr[0];
        for (int i=0; i<arr.length; i++) {
            MaxEl=(arr[i]>MaxEl)? arr[i] : MaxEl;
        }
        return MaxEl;
    }
    public static int MinElement(int[] arr){
        int MinEl=arr[0];
        for (int i=0; i<arr.length; i++) {
            MinEl=(arr[i]>MinEl)?  MinEl : arr[i];
        }
        return MinEl;
    }
    /*
    Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    заполнить его диагональные элементы единицами, используя цикл(ы);
     */
    public static void Diagonals(int[][] arr){
        for (int i=0; i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j]=(i==j||((i+j)==(arr.length-1)))? 1 : arr[i][j];
            }
        }
    }
    /*
     Написать метод, в который передается не пустой одномерный целочисленный массив,
     метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
      Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
      checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||,
      эти символы в массив не входят
     */
    public static boolean checkBalance(int[] arr){
        int RightPart = 0;
        int LeftPart = 0;
        boolean EqualityVar=false;
        for (int i=0;i<arr.length;i++) {
            for (int j=arr.length-1;j>i;j--){
                RightPart=(j==(arr.length-1))? arr[j] : (RightPart+arr[j]);
            }
            LeftPart=(i==0)? arr[i] : (LeftPart+arr[i]);
            if (LeftPart==RightPart){EqualityVar=(LeftPart==RightPart);};
        }
        return EqualityVar;
    }
    /*
    Написать метод, которому на вход подаётся одномерный массив и число n
     (может быть положительным, или отрицательным), при этом метод должен циклически сместить
      все элементы массива на n позиций.
     */
    public static void ShiftOfElements(int[] arr, int ShiftVar) {

        int[] ExtraArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ExtraArr[i] = arr[i];
        }
        ShiftVar=(ShiftVar>arr.length)? ShiftVar%arr.length : ShiftVar;

        if (ShiftVar > 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ((i + (arr.length - ShiftVar)) < arr.length) ?
                        ExtraArr[i + (arr.length - ShiftVar)] : ExtraArr[i - ShiftVar];
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ((i - ShiftVar) < arr.length) ?
                        ExtraArr[i - ShiftVar] : ExtraArr[i - (arr.length + ShiftVar)];
            }
        }
    }
    /*
    Не пользоваться вспомогательным массивом при решении задачи 7.
     */
    public static void SingleShift(int[] arr, int ShiftVar){
        int tempVar1;
        int tempVar2;
        ShiftVar=(ShiftVar>=arr.length)? ShiftVar%arr.length : ShiftVar;
        if (ShiftVar>0) {
            for(int j=1;j<=ShiftVar;j++){
                tempVar1=arr[0];
                arr[0]=arr[arr.length-1];
                for (int i=1;i<arr.length;i++) {
                    tempVar2 = arr[i];
                    arr[i] = tempVar1;
                    tempVar1 = tempVar2;
                }
            }
        } else if(ShiftVar<0) {
            for(int j=1;j<=-ShiftVar;j++){
                tempVar1=arr[arr.length-1];
                arr[arr.length-1]=arr[0];
                for (int i=arr.length-2;i>=0;i--){
                    tempVar2 = arr[i];
                    arr[i] = tempVar1;
                    tempVar1 = tempVar2;
                }
            }

        }

    }

    public static void main(String[] arr) {
        int[] arr1 = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arr2 = new int[8];
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arr4 = arr3;
        int[][] arr5 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        int[] arr6={1, 1, 1, 2, 1};
        int[] arr7={1,2,3,4,5};
        int[] arr8={1,2,3,4,5};
        ChangeArr(arr1);
        System.out.println("Результат выполнения задания 1 :" + Arrays.toString(arr1));
        FillArr(arr2);
        System.out.println("Результат выполнения задания 2: "+Arrays.toString(arr2));
        DiffArrElements(arr3);
        System.out.println("Результат выполнения задания 3: "+Arrays.toString(arr3));
        System.out.println("Максимальный элемент массива " + Arrays.toString(arr4) + " (задание 4): " + MaxElement(arr4));
        System.out.println("Минимальный элемент массива " + Arrays.toString(arr4) + " (задание 4): " + MinElement(arr4));
        Diagonals(arr5);
        System.out.println("Результат выполнения задания 5:");
        printArr(arr5);
        System.out.println("В массиве есть место, в котором сумма левой и правой части массива равны (задание 6): "+
                checkBalance(arr6));
        ShiftOfElements(arr7,-2);
        System.out.println("Результат выполнения задания 7: "+Arrays.toString(arr7));
        SingleShift(arr8, -2);
        System.out.println("Результат выполнения задания 8: "+Arrays.toString(arr8));
    }

}
