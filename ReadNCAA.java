import java.util.Scanner;
import java.io.*;

public class ReadNCAA {

	public static void main(String[] args)  throws FileNotFoundException {
		Scanner reader = new Scanner(new File("ncaa2014.csv"));

		while (reader.hasNextLine()) {
			String next = reader.nextLine();
			String[] values = next.split(",");

			for (String s : values) {
				System.out.print(s + " ");
			}

			System.out.println();
		}
	}

}