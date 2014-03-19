package gamePlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import MessageParser.InitialConfiguration;
import MessageParser.Utility;

/**
 * This class has all utility methods required to generate random moves.
 * All the logic related to randomizing the moves will go here
 * @author Rohan
 *
 */
public class RandomMovesUtility {


	/**
	 * method which generates a list of source and destination position.
	 * Random moves are generated this way. 
	 * 
	 * TODO - This is a very crude
	 * implementation of random move generator. Need to modify
	 * it later on. The time complexity of the current method is 
	 * too high
	 * 
	 * @param currentBoardConfig
	 * @return List
	 */
	public static List<String> getRandomMove(Map<String, String> currentBoardConfig){
		List<String> moves = new ArrayList<String>();
		moves = getSourcePositionForMove(currentBoardConfig);
		// gets the moves until the moves are valid
		while (moves.get(1).toString().equals("")){
			moves = getSourcePositionForMove(currentBoardConfig);
		}
		return moves;
	}


	/**
	 * generates a random position which suggests move to be made by us
	 * @param currentBoardConfig
	 * @return List
	 */
	public static List<String> getSourcePositionForMove(Map<String, String> currentBoardConfig){
		List<String> possiblePositions = new ArrayList<String>();
		String key = "";
		for (int row = 1; row <=12; row++){
			for (char col = 'A'; col <= 'E'; col++){
				key = "" + col + row;
				// if the position is head-quarter / false / true / camp then ignore
				if (currentBoardConfig.get(key).equals("B2") || 
						currentBoardConfig.get(key).equals("D4") ||
						currentBoardConfig.get(key).equals("B12") ||
						currentBoardConfig.get(key).equals("D12") ||
						currentBoardConfig.get(key).equals(InitialConfiguration.EMPTY_POSITION) ||
						currentBoardConfig.get(key).equals(InitialConfiguration.FILLED_POSITION) ||
						currentBoardConfig.get(key).equals(InitialConfiguration.CAMP))
					continue;
				possiblePositions.add(key);
			}
		}

		Random rand = new Random();
		int randomPos = rand.nextInt(possiblePositions.size());
		// we get out players position at this point
		String sourcePos = possiblePositions.get(randomPos);

		List<String> possibleMoves = Utility.getAllPossibleMovesMap().get(sourcePos);
		String destinationPos = "";
		for (String eachPos : possibleMoves){
			// move the piece only if it is a head-quarter / true / false / camp
			if ( currentBoardConfig.get(eachPos).equals(InitialConfiguration.EMPTY_POSITION) ||
					currentBoardConfig.get(eachPos).equals(InitialConfiguration.FILLED_POSITION) ||
					currentBoardConfig.get(eachPos).equals(InitialConfiguration.CAMP)){
				destinationPos = eachPos;
				break;
			}
		}

		List<String> moves = new ArrayList<String>();
		moves.add(sourcePos);
		moves.add(destinationPos);
		return moves;
	}
}
