package gupta.alex;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import animal.Animal;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Main {
	
	private static File namesFile = new File("names.txt");
	private static File outputFile = new File("output.txt");
	private static Scanner fileReader;
	private static BufferedWriter fileWriter;
	private static Scanner reader = new Scanner(System.in);
	private static ArrayList<Animal> animalList = new ArrayList<Animal>();
	private static int input;

	public static void main(String[] args) {
	
//6. Ask the user how many lions and how many giraffes they would like.
		System.out.println("How many Giraffes?");
		input = reader.nextInt();
		createAnimal("Giraffe");
		
		System.out.println("How many Lions?");
		input = reader.nextInt();
		createAnimal("Lion");
	
//8. Create an output file, and loop through the list of Animals created from step 7 and output a message with the name and type of the animals.
		try {
			fileWriter = new BufferedWriter(new FileWriter(outputFile));
			for(Animal thisAnimal : animalList) {
				fileWriter.write("" + thisAnimal.getName() + " is a " + thisAnimal.getType() + "\n");
				System.out.println("" + thisAnimal.getName() + " is a " + thisAnimal.getType());
			}
			fileWriter.close();
			System.out.println("Successfully outputted to file!\n" + outputFile.getAbsolutePath());
		}catch(Exception e) {
			System.out.println("Error!");
		}
	}
	
//7. Using a loop, create a Lion for each lion the user asked for, using the names from the file to create the name.  Do the same thing for the giraffes (you can use the same name list for both).  I recommend using an ArrayList.
	public static void createAnimal(String animal) {
		try {
			fileReader = new Scanner(namesFile);
			if(animal.equalsIgnoreCase("Giraffe")) {
				for(int i = input; i > 0; i--) {
					animalList.add(new Giraffe(fileReader.nextLine()));
				}
			}
			else if(animal.equalsIgnoreCase("Lion")) {
				for(int i = input; i > 0; i--) {
					animalList.add(new Lion(fileReader.nextLine()));
				}
			}
			fileReader.close();
		}catch(Exception e) {
			System.out.println("Error!");
		}
	}
	
}
