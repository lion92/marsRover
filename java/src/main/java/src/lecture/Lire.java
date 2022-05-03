package src.lecture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lire  {
	private String path;

	public Lire(String path) {
		this.path = path;

	}

	public String lecture() {
		StringBuilder builder = new StringBuilder();

		// try block to check for exceptions where
		// object of BufferedReader class us created
		// to read filepath
		try (BufferedReader buffer = new BufferedReader(
				new FileReader(this.path))) {

			String str;

			// Condition check via buffer.readLine() method
			// holding true upto that the while loop runs
			while ((str = buffer.readLine()) != null) {

				builder.append(str).append("\n");
			}
		}

		// Catch block to handle the exceptions
		catch (IOException e) {

			// Print the line number here exception occured
			// using printStackTrace() method
			e.printStackTrace();
		}

		// Returning a string
		return builder.toString();

	}





}
