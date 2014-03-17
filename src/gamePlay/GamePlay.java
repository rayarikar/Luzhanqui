package gamePlay;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import MessageParser.PlayerToReferee;
import MessageParser.RefereeToPlayer;

public class GamePlay {
	RefereeToPlayer r2p = new RefereeToPlayer();	
	PlayerToReferee p2r = new PlayerToReferee();
	Map<String, String> currentBoardConfig;


	/**
	 * returns the list of commands
	 * @return List of Commands
	 * @throws FileNotFoundException
	 */
	public List readCommands() throws FileNotFoundException{
		ReadReferee readRef = new ReadReferee();
		List commands = readRef.getCommands();
		System.out.println(commands);
		return commands;

	}


	// stub moves <-  read as pairs of 2
	List<String> goPositions = new ArrayList(Arrays.asList("C5", "D5", "C3", "C4", "B6", "C6", "C3", "C4", "C6", "C8"));


	/**
	 * processes the referee command and prints the output
	 * @param command
	 */
	public void processCommand(String command){
		List values = r2p.processRefereeMessage(command);
		// sane check for referee message
		if (!values.isEmpty()){			
			if (values.get(0).equals(r2p.INIT))
				executeInitCommand(values.get(1).toString());
			if (values.get(0).equals(r2p.GO) && values.get(1).toString().equals(r2p.PLAYER_NUMBER))
				p2r.sendMoveToReferee(goPositions.remove(0), goPositions.remove(0));
			if (values.get(0).equals(r2p.OUTCOME)){
				currentBoardConfig = p2r.processMoveSentToReferee(currentBoardConfig, values);
				p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
			}
		}
		else
			System.out.println("Invalid command by referee!");
	}

	/**
	 * Executes the init command and returns the initial config
	 * @param playerNumber
	 */
	private void executeInitCommand(String playerNumber){
		currentBoardConfig = p2r.getInitialConfiguration();
		r2p.setPlayerNumber(playerNumber);
		p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
	}
}
