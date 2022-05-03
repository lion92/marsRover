package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.GameGolden;


public class GameRunnerGolden {

    private static boolean notAWinner;

   public static void mainWriter(){
       GameGolden aGameGolden = new GameGolden();

       aGameGolden.add("Chet");
       aGameGolden.add("Pat");
       aGameGolden.add("Sue");

       Random rand = new Random(1);

       do {

           aGameGolden.roll(rand.nextInt(5) + 1);

           if (rand.nextInt(9) == 7) {
               notAWinner = aGameGolden.wrongAnswer();
           } else {
               notAWinner = aGameGolden.wasCorrectlyAnswered();
           }



       } while (notAWinner);


   }
    public static void main(String[] args) {
        GameGolden aGameGolden = new GameGolden();

        aGameGolden.add("Chet");
        aGameGolden.add("Pat");
        aGameGolden.add("Sue");

        Random rand = new Random();

        do {

            aGameGolden.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGameGolden.wrongAnswer();
            } else {
                notAWinner = aGameGolden.wasCorrectlyAnswered();
            }



        } while (notAWinner);

    }
}
