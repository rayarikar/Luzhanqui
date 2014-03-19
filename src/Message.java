

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Message {

	public final String PRINT_DEBUG = "(print board)";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GamePlay game = new GamePlay();
		try {
			// List commands = game.readCommands();			
			Scanner reader = new Scanner(System.in);
			while (reader.hasNext()){

				List<String> commands = new ArrayList<String>();
				commands.add(reader.nextLine());

				while ( !commands.isEmpty()){
					game.processCommand(commands.remove(0).toString());
					System.out.println();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
