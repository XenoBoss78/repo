package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter extends java.lang.Object {
	static MorseCodeTree abcTree = new MorseCodeTree();
	
	public static String printTree(){
		String ans = "";
		for (String a: abcTree.toArrayList()) {
			ans += a + " ";
		}
		return ans;
	}
	
	public static java.lang.String convertToEnglish(String code){
		String eng = "";
		String[] words = code.split(" / ");

		for(String w: words) {
			String[] letter = w.split(" ");
			for (String l: letter) {
					eng += abcTree.fetch(l);
			}
			eng += " ";
		}
		return eng;
	}
	
	public static String convertToEnglish(File input) throws FileNotFoundException {
		String eng = "";
		Scanner scanner = new Scanner(input);
		while(scanner.hasNextLine()) {
			eng += convertToEnglish(scanner.nextLine()) + "\n";
		}
		scanner.close();
		return eng;
	}
}
