package MessageParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The purpose of this class is to have all the utility
 * methods which are common to our program
 * @author Rohan
 *
 */
public class Utility {
	
	private static final String FLAG = "F";
	private static final String LAND_MIND = "L";
	private static final String BOMB = "B";
	
	
	/**
	 * Method to return map of all possible positions of players
	 * The syntax for positions is
	 * 	<position>  ::=  A1 | A2 | A3 | A4 | A5 | A6 | A7 | A8 | A9 | A10 | A11 | A12
			|  B1 | B2 | B3 | B4 | B5 | B6 | B7 | B8 | B9 | B10 | B11 | B12
			|  C1 | C2 | C3 | C4 | C5 | C6 | C7 | C8 | C9 | C10 | C11 | C12
			|  D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D10 | D11 | D12
			|  E1 | E2 | E3 | E4 | E5 | E6 | E7 | E8 | E9 | E10 | E11 | E12
	 * @return Map
	 */
	public static Map<String, String> getPositionMap(){
		Map<String, String> positionMap = new HashMap<String, String>();
		for (char currentChar = 'A'; currentChar <= 'E'; currentChar++){
			for (int position = 1; position <= 12; position++){
				positionMap.put("" + currentChar + position, "" + currentChar + position);
			}
		}
		return positionMap;
	}
	
	
	/**
	 * Method to fetch the map of pieces
	 * <piece>     ::=  F | L | B | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 * @return Map
	 */
	public static Map<String, String> getPieces(){
		Map<String, String> pieceMap = new HashMap<String, String>();
		for (int piecePos = 1; piecePos < 10; piecePos++){
			pieceMap.put("" + piecePos, "" + piecePos);
		}
		pieceMap.put(FLAG, FLAG);
		pieceMap.put(LAND_MIND, LAND_MIND);
		pieceMap.put(BOMB, BOMB);
		return pieceMap;
	}
	
	
	/**
	 * returns true if the position is valid. Else returns false
	 * @param position
	 * @return
	 */
	public static boolean isValidPosition(String position){
		HashMap<String, String> validPositionMap = (HashMap<String, String>) Utility.getPositionMap();
		try{
			String value = validPositionMap.get(position.toString());
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	/**
	 * removes all the white spaces at the begining of the StringBuilder
	 * @param message
	 * @return StringBuilder
	 */
	public static StringBuilder removeStartBlankChars(StringBuilder message){
		int index = 0;
		while(index < message.toString().length()){
			if ( !Character.isWhitespace(message.toString().charAt(index)))
				break;
			index++;
		}
		return message.delete(0, index);
	}
	
	/**
	 * extracts all the positions from a string
	 * @param message
	 * @return ListOfPositions
	 */
	public static List extractPositionsFromString(String message){
		List<String> positions = new ArrayList<String>();
		String tempString = message.trim().charAt(0) + "";
		char[] positionChars = message.trim().substring(1).toCharArray();
		for (char eachPosition : positionChars){
			if (Character.isLetter(eachPosition) || Character.isWhitespace(eachPosition)){
				positions.add(tempString);
				tempString = eachPosition + "";
				continue;
			}
			tempString += eachPosition + "";
		}
		positions.add(tempString);
		return positions;	
	}
}
