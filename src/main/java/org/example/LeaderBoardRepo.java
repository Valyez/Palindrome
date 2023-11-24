package org.example;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeaderBoardRepo {

    private List<User> leaderBoard;
    private static LeaderBoardRepo instance;


    private LeaderBoardRepo() {
        leaderBoard = new ArrayList<>();
    }

    public static LeaderBoardRepo getInstance() {
        if(instance == null) {
            instance = new LeaderBoardRepo();
        }
        return instance;
    }
    public boolean saveUser(String username, int score) {
        for(int i = 0; i < 5; i++) {
            if(leaderBoard.size() < 5) {
                leaderBoard.add(new User(username,score));
            }
            if(leaderBoard.get(i).getScore() < score){
                leaderBoard.set(i, new User(username, score));
                if(leaderBoard.get(6) != null) {
                    leaderBoard.remove(6);
                }
                return true;
            }
        }
        return false;
    }







}
