package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class Game {
    private LeaderBoardRepo leaderBoardRepo;

    private int currentScore;
    private HashSet<String> usedWords;
    private boolean isRunning;
    private int i = 0;


    public Game() {
        currentScore = 0;
        usedWords = new HashSet<String>();
        isRunning = true;
        leaderBoardRepo = LeaderBoardRepo.getInstance();
    }

    public void startGame() {
        while (isRunning) {
            String word = getNewWord();
            word = removeSpaces(word);
            if (isPalindrome(word)) {
                if (usedWords.contains(word)) {
                    //вывод сообщения "Вы уже использолвали это слово"на view
                } else {
                    usedWords.add(word);
                    changeScore(word.length());
                }
            } else {
                //Вывод сообщения "Введенная фраза не является палиндромом" на view
            }
        }
        String username = getUsername(); // получение имени с Gui либо ввод с калвиатуры
        leaderBoardRepo.saveUser(username,currentScore);
    }

    private String getUsername() {
        // получение имени с Gui либо ввод с калвиатуры
    }

    private String getNewWord() {
        //получение фразы от пользователя
    }


    public boolean isPalindrome(String word) {
        char[] massiveOfChar = word.toCharArray();
        int pos = massiveOfChar.length;
        char[] reverseMassiveOfChar = new char[pos];
        for (int i = 0; i < pos; i++) {
            reverseMassiveOfChar[i] = massiveOfChar[pos - 1 - i];
        }
        return Arrays.toString(massiveOfChar).equalsIgnoreCase(Arrays.toString(reverseMassiveOfChar));
    }

    private void changeScore(int i) {
        currentScore += i;
    }

    private String removeSpaces(String word) {
        return word.replace(" ", "");
    }

    public void exit() {
        isRunning = false;
    }
}
