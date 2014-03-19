package gamePlay;

import java.io.FileNotFoundException;
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


	/**
	 * processes the referee command and prints the output
	 * @param command
	 */
	public void processCommand(String command){
		List values = r2p.processRefereeMessage(command);
		// sane check for referee message
		if (!values.isEmpty()){
			// process init referee message
			if (values.get(0).equals(r2p.INIT))
				executeInitCommand(values.get(1).toString());
			// process go command of referee
			if (values.get(0).equals(r2p.GO) && values.get(1).toString().equals(r2p.PLAYER_NUMBER)){
				List<String> randomMoves = RandomMovesUtility.getRandomMove(currentBoardConfig);
				p2r.sendMoveToReferee(randomMoves.get(0), randomMoves.get(1));
			}
			// process the outcome message of referee
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
