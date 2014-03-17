package gamePlay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadReferee {


	/**
	 * reads referee command from the file and returns the list
	 * @return
	 * @throws FileNotFoundException
	 */
	protected List getCommands() throws FileNotFoundException{
		Scanner reader = new Scanner(new File("RefereeMoves.txt"));
		List<String> lines = new ArrayList<String>();
		while (reader.hasNext()) {
			lines.add(reader.nextLine());
		}
		return lines;
	}

}
