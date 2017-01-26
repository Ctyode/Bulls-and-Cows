package org.flamie;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // я знаю, что ее можно уронить вводом строки вместа числа ¯\_(ツ)_/¯

    private static int bullCounter;
    private static int cowCounter;
    private static ArrayList<Integer> randomArray;
    private static ArrayList<Integer> userArray;
    private static Scanner in;

    public static void main(String[] args) {
        Random random = new Random();
        in = new Scanner(System.in);
        randomArray = new ArrayList<>(3);
        userArray = new ArrayList<>(3);

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
    }

    private static void input() {
        bullCounter = 0;
        cowCounter = 0;
        int elementsCounter = 0;
        while(elementsCounter != 4) {
            System.out.print("Введите " + (elementsCounter + 1) + " число: ");
            int num = in.nextInt();
            if(num <= 9 && num >= 0) {
                userArray.set(elementsCounter, num);
                elementsCounter += 1;
            } else {
                System.out.println("Число должно быть от нуля до девяти");
            }
        }
    }

    private static void count() {
        for(int i = 0; i <= 3; i++) {
            if(Objects.equals(userArray.get(i), randomArray.get(i))) {
                bullCounter += 1;
            }
            if(userArray.contains(randomArray.get(i)) && !Objects.equals(userArray.get(i), randomArray.get(i))) {
                cowCounter += 1;
            }
        }
    }

    private static void result() {
        System.out.println("Пользователь: " + userArray);
        System.out.println("Быки: " + bullCounter);
        System.out.println("Коровы: " + cowCounter);
    }
}
