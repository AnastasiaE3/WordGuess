package com.github.zipcodewilmington;


import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

    public static Scanner scanner = new Scanner(System.in);
    static String [] word = wordGenerator();
    static int turn = 0;
    static boolean run = true;
    static String currentStatus = makeWord(word);

    public static void main(String[] args) {
        while (run) {
            System.out.println("Guess a letter: ");
            String userInput = scanner.nextLine();
            turn ++;

            checkGuess(userInput);
            System.out.println(currentStatus);
            whatIsWord(word);
            checkIfWin(args);

        }
    }

    public static void checkIfWin(String[] args) {
        if (!currentStatus.contains("_")) {
            System.out.println("You Win!");
            run = false;
        } else if (turn > word.length - 1) {
            System.out.println("You are loser!");
            run = false;
        }
    }

    public static void checkGuess (String guess) {
        for (int i = 0; i < word.length; i++) {
            if (guess.equals(word[i])) {
                if (i == 0) {
                    currentStatus = guess.charAt(0) + currentStatus.substring(i + 1);
                } else if (i > 0 && i != word.length - 1) {
                    currentStatus = currentStatus.substring(0, i) + guess.charAt(0) + currentStatus.substring(i + 1);
                }
                  else if (i == word.length -1) {
                    currentStatus = currentStatus.substring(0, i) + guess.charAt(0);
                }
            }
        }
    }

    public static String [] wordGenerator() {
        String [] wordList = {"Cat", "Dog", "Fly", "Bug"};
        String word = wordList[(int) (Math.random()*wordList.length)];
        String [] generatedWord = word.split("");
        return generatedWord;
    }
    public static String makeWord (String [] word) {
        String newBoard = "";
        for (int i = 0; i < word.length; i++) {
            newBoard += "_";
        }
        return newBoard;
    }

    public static void whatIsWord (String [] array) {
        String answer = "";
        for (int i = 0; i < array.length; i++) {
            String newArray = array[i].toString();
            answer += newArray;
        }
        System.out.println(answer);
    }


}
