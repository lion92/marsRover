
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.GameGolden;
import src.lecture.Lire;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		new GameRunner().mainWriter();

		new GameRunnerGolden().mainWriter();
		if(new Lire("./src/Golden.txt").lecture().equals(new Lire("./src/trivia.txt").lecture())){
			System.out.println("YESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		}else{
			System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		}

	}

	public static void mainWriter(){
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		Random rand = new Random(1);

		do {

			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}



		} while (notAWinner);
	}



}
