package org.flamie;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // я знаю, что ее можно уронить вводом строки вместа числа ¯\_(ツ)_/¯

    private static int bullCounter;
    private static int cowCounter;
    private static int attemptCounter;
    private static ArrayList<Integer> uniqueCows;
    private static ArrayList<Integer> randomArray;
    private static ArrayList<Integer> userArray;
    private static Scanner in;

    public static void main(String[] args) {
        Random random = new Random();
        in = new Scanner(System.in);
        randomArray = new ArrayList<>(3);
        userArray = new ArrayList<>(3);
        uniqueCows = new ArrayList<>();

        for(int i = 0; i <= 3; i++) {
            randomArray.add(i, random.nextInt(9));
            userArray.add(i, 0);
        }

        input();
        count();
        result();
        while(bullCounter != 4) {
            input();
            count();
            result();
        }
        System.out.println("Игра пройдена за " + attemptCounter + attemptFormat(attemptCounter));
    }

    private static void input() {
        bullCounter = 0;
        cowCounter = 0;
        int elementsCounter = 0;
        while(elementsCounter != 4) {
            System.out.print("Введите " + (elementsCounter + 1) + " число: ");
            if(in.hasNextInt()) {
                int num = in.nextInt();
                if (num <= 9 && num >= 0) {
                    userArray.set(elementsCounter, num);
                    elementsCounter += 1;
                } else {
                    System.out.println("Число должно быть от нуля до девяти");
                }
            } else {
                in.next();
                System.out.println("Неверный ввод!");
            }
        }
    }

    private static void count() {
        uniqueCows.clear();
        for(int i = 0; i <= 3; i++) {
            if(Objects.equals(userArray.get(i), randomArray.get(i))) {
                bullCounter += 1;
            } else if(userArray.contains(randomArray.get(i)) && !uniqueCows.contains(randomArray.get(i))) {
                cowCounter += 1;
                uniqueCows.add(randomArray.get(i)); // <3
            }
        }
    }

    private static void result() {
        //System.out.println("Рандом: " +  randomArray);
        System.out.println("Пользователь: " + userArray);
        System.out.println("Быки: " + bullCounter);
        System.out.println("Коровы: " + cowCounter);
        attemptCounter += 1;
    }

    private static String attemptFormat(int attemptCounter) {
        if(attemptCounter == 1) {
            return " попытку";
        } else if(attemptCounter >= 2 && attemptCounter <= 4) {
            return " попытки";
        } else {
            return " попыток";
        }
    }
}
