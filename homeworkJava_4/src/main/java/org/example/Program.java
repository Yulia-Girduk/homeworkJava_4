package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Program {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ArrayList<String> familyName = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> middleName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        while (true){
            System.out.println("Введите фамилию -> ");
            familyName.add(scanner.nextLine());
            System.out.println("Введите имя -> ");
            name.add(scanner.nextLine());
            System.out.println("Введите отчество -> ");
            middleName.add(scanner.nextLine());
            System.out.println("Введите возраст -> ");
            age.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол -> ");
            gender.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(gender.size()-1);
            System.out.println("При завершении ввода нажмите : н!!! -> ");
            String endInput = scanner.nextLine();
            if (endInput.toLowerCase().contains("н")) break;
        }

        for (int i = 0; i < familyName.size(); i++) {
            System.out.println(familyName.get(i) + " " + name.get(i).toUpperCase().charAt(0) + "." + middleName.get(i).toUpperCase().charAt(0) + "." + " " + age.get(i) + " " + (gender.get(i) ? "Ж" : "М"));

        }

        System.out.println("-".repeat(20));


        System.out.println("Сортировка по возрасту: ");
        SortAge(familyName, name, middleName, age, gender, id);

        System.out.println("-".repeat(20));
        System.out.println("-".repeat(20));

        System.out.println("Сортировка по возрасту и полу: ");
        SortAgeGender(familyName, name, middleName, age, gender, id);

    }

    static public void SortAge(ArrayList<String> familyName, ArrayList<String> name, ArrayList<String> middleName, ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id){
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return age.get(o1) - age.get(o2);
            }
        });
        for (int i = 0; i < id.size(); i++) {
            System.out.println(familyName.get(id.get(i)) + " " + name.get(id.get(i)).toUpperCase().charAt(0) + "." + middleName.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + age.get(id.get(i)) + " " + (gender.get(id.get(i)) ? "Ж" : "М"));
        }
    }

    static void SortAgeGender(ArrayList<String> familyName, ArrayList<String> name, ArrayList<String> middleName, ArrayList<Integer> age, ArrayList<Boolean> gender, ArrayList<Integer> id){
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (gender.get(o1)==false) return 1;
                else return -1;
            }

        });
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (gender.get(o1) == gender.get(o2)) return age.get(o1) - age.get(o2);
                return 0;
            }
        });
        for (int i = 0; i < id.size(); i++) {
            System.out.println(familyName.get(id.get(i)) + " " + name.get(id.get(i)).toUpperCase().charAt(0) + "." + middleName.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + age.get(id.get(i)) + " " + (gender.get(id.get(i)) ? "Ж" : "М"));
        }
    }


}
