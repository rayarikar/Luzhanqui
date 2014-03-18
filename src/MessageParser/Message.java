package MessageParser;
import gamePlay.GamePlay;
import gamePlay.RandomMovesUtility;

import java.io.FileNotFoundException;
import java.util.List;


public class Message {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GamePlay game = new GamePlay();
		try {
			List commands = game.readCommands();
			while ( !commands.isEmpty()){
				game.processCommand(commands.remove(0).toString());
			}
			
			System.out.println();
//			System.out.println(Utility.getAllPossibleMovesMap());
			System.out.println(RandomMovesUtility.getRandomMove((new PlayerToReferee()).getInitialConfiguration()));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
