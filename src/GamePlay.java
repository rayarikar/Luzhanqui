

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


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
//		System.out.println(commands);
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
//				p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
			}
			// process flag message
			if (values.get(0).equals(r2p.FLAG))
				processFlagPositions(values.get(1).toString(), 
						values.get(2).toString());
			// process the <game_end> message
			if (values.get(0).equals(r2p.GAME_END))
				declareResults(values.get(1).toString(), r2p.PLAYER_NUMBER);
			// if the referee sends illegal message then do nothing
			if (values.get(0).equals(r2p.ILLEGAL)){
				// do nothing
			}
		}
		// if we want to print the board
		// hack added to print the board
		else if (command.equals((new Message()).PRINT_DEBUG))
			p2r.printBoardPositionsToStandardOutput(currentBoardConfig);
		else
			System.out.println("\nInvalid command by referee!");
	}

	/**
	 * Executes the init command and returns the initial config
	 * @param playerNumber
	 */
	private void executeInitCommand(String playerNumber){
		currentBoardConfig = p2r.getInitialConfiguration();
		r2p.setPlayerNumber(playerNumber);
		System.out.print(p2r.LEFT_PARENTHESIS);
		p2r.printInitConfigToStandardOutput(currentBoardConfig);
		System.out.print(p2r.RIGHT_PARENTHESIS);
	}
	
	/**
	 * Executes the <game_end> message.
	 * If we are the winner then exit with status 0 else with status 1
	 */
	private void declareResults(String winner, String playerNumber){
		// if we are the winner end with status 0 else 1
		if (winner.equals(playerNumber))
		{
			System.out.println("\nExiting with status 0");
			System.exit(0);
		}
		System.out.println("\nExiting with status 1");
		System.exit(1);
	}
	
	/**
	 * Sets the opponents' flag position
	 * @param player
	 * @param flagPositon
	 */
	private void processFlagPositions(String player, String flagPositon){
		// if the player is opponent then only store the player number
		if ( !player.equals(r2p.PLAYER_NUMBER)){
			r2p.setOpponentFlagPosition(flagPositon);
			currentBoardConfig.put(flagPositon, InitialConfiguration.FLAG);
//			System.out.println("\n Opp Flag pos : " + r2p.OPPONENT_FLAG_POSITION);
		}
	}
}
