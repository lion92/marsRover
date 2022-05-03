package src.temperature;


import src.ecriture.Ecrire;
import src.lecture.Lire;

public class Main {

	public static void main(String[] args) {
		//new Ecrire("C:\\Users\\kriss\\IdeaProjects\\trivia\\java\\src\\main\\java\\src\\Golden").acquisition("eee");


		String tetxGolden =new Lire("./src/trivia.txt").lecture();
		System.out.println(tetxGolden);
	}

}
