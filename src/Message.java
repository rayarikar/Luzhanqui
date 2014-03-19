

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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
