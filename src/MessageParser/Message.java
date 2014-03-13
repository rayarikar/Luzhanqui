package MessageParser;
import java.util.Map;


public class Message {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerToReferee p2r = new PlayerToReferee();
		System.out.println("The initial board congif is :");
		Map<String, String> currentBoardConfig = p2r.getInitialConfiguration();
		p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
		currentBoardConfig = p2r.sendMoveToReferee(currentBoardConfig, "A1", "A10");
		System.out.println("\nThe modified board congif is :");
		p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
		
//		--------------------------------------------------------------
		
		RefereeToPlayer r2p = new RefereeToPlayer();
		boolean b = r2p.processRefereeMessage("(init 2 time/move 10)");
		System.out.println("\n\n<msg0>: (init 2 time/move 10)" + "  valid: " + b);
		
		b = r2p.processRefereeMessage("(end 0)");
		System.out.println("<game_end>: (end 0)" + "  valid: " + b);
		
		b = r2p.processRefereeMessage("(go 1)");
		System.out.println("<turn>: (go 1)" + "  valid: " + b);
		
		b = r2p.processRefereeMessage("(flag 1 A3)");
		System.out.println("<flag>: (flag 1 A3)" + "  valid: " + b);
		
		b = r2p.processRefereeMessage("(illegal (A1 A12))");
		System.out.println("<illegal>: (illegal (A1 A12))" + "  valid: " + b);		
		
		b = r2p.processRefereeMessage("(outcome (A1 A12))");
		System.out.println("<outcome>: (outcome (A1 A12))" + "  valid: " + b);
		
		b = r2p.processRefereeMessage("(outcome > (A1 A12))");
		System.out.println("<outcome>: (outcome > (A1 A12))" + "  valid: " + b);
		
	}

}
