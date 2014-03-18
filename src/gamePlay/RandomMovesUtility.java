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
	 * generates a random position which suggests move to be made by us
	 * @param currentBoardConfig
	 * @return List
	 */
	public String getSourcePositionForMove(Map<String, String> currentBoardConfig){
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
				possiblePositions.add(currentBoardConfig.get(key));
			}
		}
		
		Random rand = new Random();
		int randomPos = rand.nextInt(possiblePositions.size());
		// we get out players position at this point
		String sourcePos = possiblePositions.get(randomPos).toString();
		
		List<String> possibleMoves = Utility.getAllPossibleMovesMap().get(sourcePos);
		String destinationPos = "";
		while (destinationPos != ""){
			for (String eachPos : possibleMoves){
				// move the piece only if it is a head-quarter / true / false / camp
//				@TODO work on this
			}
		}
		
		return sourcePos;
	}
	
	
//	public String getDestinationPositionForMove(Map<String, String> currentBoardConfig, String sourcePos){
//		
//	}
}
