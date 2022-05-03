package src.ecriture;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ecrire  {
	private String path;
	private Double tempeature;
	private String str;

	public Ecrire(String path) {
		this.path = path;
		this.str="";

	}

	public boolean fichierExist() {

		if (new File(path).isFile()) {
			return true;
		}

		return false;
	}

	public void acquisition(String str) {

		FileWriter fw;
		try {
			fw = new FileWriter(this.path);
			@SuppressWarnings("resource")
			BufferedWriter write = new BufferedWriter(fw);
			this.str+=str+"/n";
			write.write("" + this.str);
			write.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enregistrement() {

		if (!fichierExist()) {

			try {
				new File(path).createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
		}



		}




}
