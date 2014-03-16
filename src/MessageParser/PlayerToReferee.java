package MessageParser;
import java.util.List;
import java.util.Map;

/**
Player to Referee message format
<msg_p2r>   ::=  <initial>    |  <move>
<initial>   ::=  ( <inits> )
<inits>     ::=      |  <init> <inits>
<init>      ::=  ( <position> <piece> )
<position>  ::=  A1 | A2 | A3 | A4 | A5 | A6 | A7 | A8 | A9 | A10 | A11 | A12
    			|  B1 | B2 | B3 | B4 | B5 | B6 | B7 | B8 | B9 | B10 | B11 | B12
    			|  C1 | C2 | C3 | C4 | C5 | C6 | C7 | C8 | C9 | C10 | C11 | C12
    			|  D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D10 | D11 | D12
    			|  E1 | E2 | E3 | E4 | E5 | E6 | E7 | E8 | E9 | E10 | E11 | E12
<piece>     ::=  F | L | B | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
<move>      ::=  ( <position> <position> )

 **/
public class PlayerToReferee {	

	private final String LEFT_PARENTHESIS = "(";
	private final String RIGHT_PARENTHESIS = ")";
	private final String LESS_THAN = "<";
	private final String GREATER_THAN = ">";
	private final String EQUAL = "=";

	/**
	 * this method returns the initial configuration Map
	 * @return Map
	 */
	public Map getInitialConfiguration(){
		InitialConfiguration init = new InitialConfiguration();
		return init.getInitialConfiguration();
	}

	/**
	 * this method prints the board configuration
	 * on the console
	 */
	public void printBoardPositionsToStandardOutput(Map<String, String> boardPosition){
		for (char row = 'A'; row <= 'E'; row++){
			System.out.println();
			for (int column = 1; column <= 12; column++){
				try{
					// if it is a camp position do not print
					if (boardPosition.get(row + "" + column + "")
							.equalsIgnoreCase(InitialConfiguration.CAMP))
						continue;				
					// prints the position
					System.out.print(LEFT_PARENTHESIS + 
							(row + "" + column + "") + " " + 
							boardPosition.get(row + "" + column + "") + 
							RIGHT_PARENTHESIS);
				} catch (Exception e){
					continue;
				}
			}
		}
	}


	/**
	 * prints the move sent to referee
	 * @param positionOne
	 * @param positionTwo
	 */
	public void sendMoveToReferee(String positionOne, String positionTwo){
		String move = LEFT_PARENTHESIS + positionOne + " " + positionTwo + RIGHT_PARENTHESIS;
		System.out.println("\n\nMove sent to referee: " + move);
	}

	/**
	 * this method processes the move sent to referee once the referee
	 * gives the <outcome> message and 
	 * returns the modified board position
	 * @param currentBoardConfig
	 * @param outcomes
	 * @return Map / null
	 */
	public Map processMoveSentToReferee(Map currentBoardConfig, List outcomes){
		Map<String, String> modifiedMap = makeMove(currentBoardConfig, outcomes);
		if (modifiedMap != null){
			String move = LEFT_PARENTHESIS + outcomes.get(outcomes.size() - 2).toString() +
					" " + outcomes.get(outcomes.size() - 1).toString() + RIGHT_PARENTHESIS;
			System.out.println("\n\nMove made: " + move);
			return modifiedMap;
		}
		else {
			System.out.println("Invalid moves");
			return null;
		}
	}

	/**
	 * this method takes in the positions to move and moves the 
	 * player from position 1 to 2. Returns the modified board 
	 * returns NULL if the positions are not valid
	 * @param currentBoardConfig
	 * @param positionOne
	 * @param positionTwo
	 * @return Map / null
	 */
	private Map makeMove(Map currentBoardConfig, List outcomes){
		String positionOne = outcomes.get(outcomes.size() - 2).toString();
		String positionTwo = outcomes.get(outcomes.size() - 1).toString();

		if ( !Utility.isValidPosition(positionOne) 
				|| !Utility.isValidPosition(positionTwo) || outcomes.size() > 4){
			return null;
		}
		// if the list size is 3 that means its (outcome <move>) message
		if (outcomes.size() == 3){
			return modifyBoardPositions(currentBoardConfig, positionOne, positionTwo);
		}
		// if list size is 4 that means it is (outcome <compare> <move>) message
		if (outcomes.size() == 4) {
			// if the <outcome> message is {<, =} that means we remove our piece from board
			if (outcomes.get(1).toString().equals(LESS_THAN) || 
					outcomes.get(1).toString().equals(EQUAL))
				return removeOurPieceFromBoard(currentBoardConfig, positionOne, positionTwo);
			// if the <outcome> message is {>} that means we move our piece from pos1 to pos2
			else if (outcomes.get(1).toString().equals(GREATER_THAN))
				return modifyBoardPositions(currentBoardConfig, positionOne, positionTwo);
		}
		return null;
	}

	private Map modifyBoardPositions(Map currentBoardConfig, String positionOne, String positionTwo){
		String rankOfPlayer = 
				currentBoardConfig.get(positionOne.toUpperCase()).toString();
		currentBoardConfig.put(positionTwo, rankOfPlayer);
		currentBoardConfig.remove(positionOne.toString());
		return currentBoardConfig;
	}

	private Map removeOurPieceFromBoard(Map currentBoardConfig, String positionOne, String positionTwo){
		currentBoardConfig.remove(positionOne);
		return currentBoardConfig;
	}

}
