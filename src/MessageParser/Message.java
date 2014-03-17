package MessageParser;
import gamePlay.GamePlay;

import java.io.FileNotFoundException;
import java.util.List;


public class Message {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PlayerToReferee p2r = new PlayerToReferee();
//		System.out.println("The initial board congif is :");
//		Map<String, String> currentBoardConfig = p2r.getInitialConfiguration();
//		p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
//		currentBoardConfig = p2r.sendMoveToReferee(currentBoardConfig, "A1", "A10");
//		System.out.println("\nThe modified board congif is :");
//		p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
//		
////		--------------------------------------------------------------
//		
//		System.out.println();
//		
//		RefereeToPlayer r2p = new RefereeToPlayer();
//		List b = r2p.processRefereeMessage("(go 1)");
//		System.out.println("<turn>: (go 1)" + "  valid: " + b);
//		
//		b = r2p.processRefereeMessage("(end 0)");
//		System.out.println("<game_end>: (end 0)" + "  valid: " + b);
//		
//		b = r2p.processRefereeMessage("(flag 1 A5)");
//		System.out.println("<flag>: (flag 1 A3)" + "  valid: " + b);
//		
//		b = r2p.processRefereeMessage("(init 2 time/move 10)");
//		System.out.println("\n\n<msg0>: (init 2 time/move 10)" + "  valid: " + b);
//		
//		b = r2p.processRefereeMessage("(illegal (A1 A12))");
//		System.out.println("<illegal>: (illegal (A1 A12))" + "  valid: " + b);		
//		
//		b = r2p.processRefereeMessage("(outcome (A1 A12))");
//		System.out.println("<outcome>: (outcome (A1 A12))" + "  valid: " + b);
//		
//		b = r2p.processRefereeMessage("(outcome > (A1 A12))");
//		System.out.println("<outcome>: (outcome > (A1 A12))" + "  valid: " + b);
//		
//		System.out.println();
		
		GamePlay game = new GamePlay();
		try {
			List commands = game.readCommands();
			int index = 0;
			while ( !commands.isEmpty()){
				game.processCommand(commands.remove(0).toString());
//				System.out.println("\n\nThe index is : " + index);
				index++;
//				if (index == 5)
//					break;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
