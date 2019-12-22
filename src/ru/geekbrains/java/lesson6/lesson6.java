package ru.geekbrains.java.lesson6;

import java.io.*;
import java.util.Scanner;

/**
 * Домашняя работа №6.
 * Таланкина Анна Владимировна.
 * Создан: 2019.12.20
 */
/*
    1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
    2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
   *3. Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей)
  **4. Написать метод, проверяющий, есть ли указанное слово в папке
 */

public class lesson6 {

//Метод для задания №1
    public static void UnionFiles (File FileName1, File FileName2, File ResultFileName){
        try {
            FileInputStream fis1 = new FileInputStream(FileName1);
            FileInputStream fis2 = new FileInputStream(FileName2);
            FileOutputStream fos1 = new FileOutputStream(ResultFileName);
            int b;
            while ((b=fis1.read()) != -1) {
                fos1.write((byte)b);
            }
            fis1.close();
            fos1.close();
            FileOutputStream fos2 = new FileOutputStream(ResultFileName, true);
            while ((b=fis2.read()) != -1) {
                fos2.write((byte)b);
            }
            fis2.close();
            fos2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
//Метод для задания №2. возвращает индекс первого найденного вхождения искомой строки в текст (или -1, если ничего не найдено).
    public static int FindSymbols(File Name, String SearchedString){
        try {
            FileInputStream fis = new FileInputStream(Name);
            byte[] b=new byte[fis.available()];
            fis.read(b);
            fis.close();
            byte[] s= new byte[SearchedString.length()];
            s=SearchedString.getBytes();
            for (int i=0;i<(b.length-s.length+1);i++){
                if ((s[0]==b[i])&&(s.length==1)) return (i+1);
                else if (s[0]==b[i]){
                    int j=1;
                    while((j<s.length)&&(b[i+j]==s[j])){
                        j++;
                        }
                    if (j==s.length) return (i+1);
                    }

                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
    //Метод со строками для задания №2. Возвращает индекс первого найденого вхождения строки в абзац (или -1, если ничего не найдено).
    public static int FindSymbols2(File Name, String SearchedString){
        try {
            FileInputStream fis = new FileInputStream(Name);
            Scanner sc=new Scanner(fis);
           // sc.useDelimiter("A");
            do {
                String Str=sc.nextLine();
                int index1;
                index1=Str.indexOf(SearchedString);
                if (index1!=-1) {
                    fis.close();
                    return index1;}
            } while(sc.hasNext());
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    //Метод для задания №4 (не учитывает подпапки)
    public static boolean FindSymbolsInDir (File dir, String SearchedString){
        FilenameFilter filter = new FilenameFilter() {  //для отбора файлов с расширением *.txt. Честно, не очень понимаю, как работает
            public boolean accept(File dir, String Name) {
                return Name.endsWith(".txt");
            }
        };
        File[] cn = dir.listFiles(filter);
        for(int i = 0;i< cn.length; i++){
           if (FindSymbols(cn[i],SearchedString)!=-1)  return true;
        }
        return false;
    }

    public static void main(String[] args) {

        File File1=new File ("Hobbit1.txt");
        File File2=new File ("Hobbit2.txt");
        File File3=new File ("Hobbit.txt");
        File dir=new File("C://Users/Anna/IdeaProjects/Java1.git/Java1");
        String str="hobbit";
        File FileForSearch=File1;
        File DirForSearch=dir;
        UnionFiles(File1, File2, File3);
        System.out.println("Задача №3: Слово " + str + " в файле " + FileForSearch +
                ((FindSymbols(File3,str)!=-1)? " найдено." : " не найдено."));
        System.out.println("Задача №3: Слово " + str + " в файле " + FileForSearch +
                ((FindSymbols2(File3,str)!=-1)? " найдено." : " не найдено."));
        System.out.println("Задача 4: Слово "+ str+ " в папке " + dir+ (FindSymbolsInDir(dir,str)? " найдено.":" не найдено."));

    }
}
