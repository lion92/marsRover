package com.adaptionsoft.games.uglytrivia;

import src.ecriture.Ecrire;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
	ArrayList players = new ArrayList();
	int[] places = new int[6];
	int[] purses  = new int[6];
	boolean[] inPenaltyBox  = new boolean[6];

	LinkedList popQuestions = new LinkedList();
	LinkedList scienceQuestions = new LinkedList();
	LinkedList sportsQuestions = new LinkedList();
	LinkedList rockQuestions = new LinkedList();
	Ecrire ecrire=new Ecrire("./src/trivia.txt");
	int currentPlayer = 0;
	boolean isGettingOutOfPenaltyBox;

	public  Game(){
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
		}
	}

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

	public boolean add(String playerName) {


		players.add(playerName);
		places[howManyPlayers()] = 0;
		purses[howManyPlayers()] = 0;
		inPenaltyBox[howManyPlayers()] = false;

		ecrire.acquisition(playerName + " was added");
		ecrire.acquisition("They are player number " + players.size());

		System.out.println(playerName + " was added");
		System.out.println("They are player number " + players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {

		ecrire.acquisition(players.get(currentPlayer) + " is the current player");
		ecrire.acquisition("They have rolled a " + roll);

		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				ecrire.acquisition(players.get(currentPlayer) + " is getting out of the penalty box");
				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

				ecrire.acquisition(""+players.get(currentPlayer));
				System.out.println(players.get(currentPlayer)
						+ "'s new location is "
						+ places[currentPlayer]);
				ecrire.acquisition("The category is " + currentCategory());
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				ecrire.acquisition(players.get(currentPlayer) + " is not getting out of the penalty box");
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}

		} else {

			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
			ecrire.acquisition(players.get(currentPlayer)
					+ "'s new location is "
					+ places[currentPlayer]);
			System.out.println(players.get(currentPlayer)
					+ "'s new location is "
					+ places[currentPlayer]);
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}

	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());
	}


	private String currentCategory() {
		if(places[currentPlayer] == 0||places[currentPlayer] == 4||places[currentPlayer] == 8) return "Pop";
		if(places[currentPlayer] == 1||places[currentPlayer] == 5||places[currentPlayer] == 9) return "Science";
		if(places[currentPlayer] == 2||places[currentPlayer] == 6||places[currentPlayer] == 10) return "Sports";

		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				ecrire.acquisition(""+players.get(currentPlayer));
				System.out.println(players.get(currentPlayer)
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");

				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;

				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}



		} else {

			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer)
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");

			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;

			return winner;
		}
	}

	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;

		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
