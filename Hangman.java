package problem_2;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		String[] fruit = {"apple", "banana", "watermelon", "guava", "orange"};
//		String[] animal = {"dog", "cat", "elephant", "tiger", "bird"};
//		String[] country = {"indonesia", "france", "usa", "china", "japan", "korea"};
		
//		String [] words =
//			{"apple", "banana", "watermelon", "guava", "orange",
//			"dog", "cat", "elephant", "tiger", "bird",
//			"indonesia", "france", "usa", "china", "japan", "korea"};
		
//		String[] fruit;
//		fruit = new String[5];
//		fruit[0] = "apple";
//		fruit[1] = "banana";
//		fruit[2] = "watermelon";
//		fruit[3] = "guava";
//		fruit[4] = "orange";
//		
//		String[] animal;
//		animal = new String[5];
//		animal[0] = "dog";
//		animal[1] = "cat";
//		animal[2] = "elephant";
//		animal[3] = "tiger";
//		animal[4] = "bird";
//		
//		String[] country;
//		country = new String[5];
//		country[0] = "indonesia";
//		country[1] = "france";
//		country[2] = "usa";
//		country[3] = "china";
//		country[4] = "japan";
//		country[5] = "korea";
	
//		char[] randomWordToGuess = [fruit[random.nextInt(fruit.length)].toCharArray()] 
//		[animal[random.nextInt(animal.length)].toCharArray()],
//		[country[random.nextInt(country.length)].toCharArray()];
		
		boolean weArePlaying = true;
		while(weArePlaying){
			System.out.println("Welcome to the game of Hangman");
			char[] randomWordToGuess = fruit[random.nextInt(fruit.length)].toCharArray();
			

			int amountOfGuesses = randomWordToGuess.length;
			char[] playerGuess = new char[amountOfGuesses];
			
			for(int i=0; i<playerGuess.length; i++){
				playerGuess[i] = '_';
			}
			
			boolean wordIsGuessed = false;
			int tries = 0;
			
			while(!wordIsGuessed && tries != amountOfGuesses){
				System.out.println("Current guesses: ");
				printArray(playerGuess);
				System.out.printf("You have %d tries left\n", amountOfGuesses - tries);
				System.out.println("Enter a single character: ");
				char input = sc.nextLine().charAt(0);
				tries++;
				
				if(input == '-'){
					weArePlaying = false;
					wordIsGuessed = true;
				}else{
					for(int i=0; i<randomWordToGuess.length; i++){
						if(randomWordToGuess[i] == input){
							playerGuess[i] = input;
						}
					}
					
					if(isTheWordGuessed(playerGuess)){
						wordIsGuessed = true;
						System.out.println("Correct!");
					}
				}
					
			}
			
			if(!wordIsGuessed){
				System.out.println("Game over.");
			}
			
 		}
		
		System.out.println("Game over.");
	}
	
	public static void printArray(char[] array){
		for(int i=0; i<array.length; i++){
			System.out.printf(array[i] + " ");
			
		}
		System.out.println();
	}

	public static boolean isTheWordGuessed(char[] array){
		for(int i=0; i<array.length; i++){
			if(array[i] == '_'){
				return false;
			}
		}
		return true;
	}
}
