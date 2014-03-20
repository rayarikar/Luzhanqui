import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The purpose of this class is to have all the utility methods which 
 * are common to our program
 * 
 * @author Rohan
 * 
 */
public class Utility {

	private static final String FLAG = "F";
	private static final String LAND_MIND = "L";
	private static final String BOMB = "B";

	/**
	 * Method to return map of all possible positions of players The 
	 * syntax for positions is 
	 * <position> ::= 
	 * A1 | A2 | A3 | A4 | A5 | A6 | A7 | A8 | A9 | A10 | A11 | A12 
	 * | B1 | B2 | B3 | B4 | B5 | B6 | B7 | B8 | B9 | B10 | B11 | B12 
	 * | C1 | C2 | C3 | C4 | C5 | C6 | C7 | C8 | C9 | C10 | C11 | C12 
	 * | D1 | D2 | D3 | D4 | D5 | D6 | D7 | D8 | D9 | D10 | D11 | D12 
	 * | E1 | E2 | E3 | E4 | E5 | E6 | E7 | E8 | E9 | E10 | E11 | E12
	 * 
	 * @return Map
	 */
	public static Map<String, String> getPositionMap() {
		Map<String, String> positionMap = new HashMap<String, String>();
		for (char currentChar = 'A'; currentChar <= 'E'; currentChar++) {
			for (int position = 1; position <= 12; position++) {
				positionMap.put("" + currentChar + position, ""
						+ currentChar + position);
			}
		}
		return positionMap;
	}

	/**
	 * Method to fetch the map of pieces 
	 * <piece> ::= F | L | B | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
	 * 
	 * @return Map
	 */
	public static Map<String, String> getPiecesMap() {
		Map<String, String> pieceMap = new HashMap<String, String>();
		for (int piecePos = 1; piecePos < 10; piecePos++) {
			pieceMap.put("" + piecePos, "" + piecePos);
		}
		pieceMap.put(FLAG, FLAG);
		pieceMap.put(LAND_MIND, LAND_MIND);
		pieceMap.put(BOMB, BOMB);
		return pieceMap;
	}

	/**
	 * returns true if the position is valid and not a camp. 
	 * Else returns false
	 * 
	 * @param position
	 * @return
	 */
	public static boolean isValidPosition(String position) {
		HashMap<String, String> validPositionMap = 
				(HashMap<String, String>) Utility.getPositionMap();
		try {
			String value = validPositionMap.get(position.toString());
			if (value == null)
				return false;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * if the first position in a move is empty or the headquarters then 
	 * return false
	 * 
	 * @param boardConfiguration
	 * @param positionOne
	 * @param positionTwo
	 * @return boolean
	 */
	public static boolean isValidMove(Map boardConfiguration,
			String positionOne, String positionTwo) {
		// if the value corresponding to position 1 is false return false
		if (boardConfiguration.get(positionOne).equals(
				InitialConfiguration.EMPTY_POSITION))
			return false;
		// if the first position corresponds to B1, D1, B12 or D12 
		// return false
		if (positionOne.equals("B1") || positionOne.equals("D1")
				|| positionOne.equals("D1") || positionOne.equals("D12"))
			return false;
		return true;
	}

	/**
	 * removes all the white spaces at the begining of the StringBuilder
	 * 
	 * @param message
	 * @return StringBuilder
	 */
	public static StringBuilder removeStartBlankChars
	(StringBuilder message) {
		int index = 0;
		while (index < message.toString().length()) {
			if (!Character.isWhitespace(message.toString().charAt(index)))
				break;
			index++;
		}
		return message.delete(0, index);
	}

	/**
	 * extracts all the positions from a string
	 * 
	 * @param message
	 * @return ListOfPositions
	 */
	public static List extractPositionsFromString(String message) {
		List<String> positions = new ArrayList<String>();
		String tempString = message.trim().charAt(0) + "";
		char[] positionChars = message.trim().substring(1).toCharArray();
		for (char eachPosition : positionChars) {
			if (Character.isLetter(eachPosition)
					|| Character.isWhitespace(eachPosition)) {
				positions.add(tempString);
				tempString = eachPosition + "";
				continue;
			}
			tempString += eachPosition + "";
		}
		positions.add(tempString);
		return positions;
	}

	/**
	 * returns map of all possible position from each position. For head
	 * quarters it returns an empty list as values
	 * 
	 * @return Map
	 */
	public static Map<String, List<String>> getAllPossibleMovesMap() {
		List<String> allPossibleMoves = new ArrayList<String>();
		List<String> emptyMoves = new ArrayList<String>();
		Map<String, List<String>> allMovesMap = new HashMap<String,

		List<String>>();

		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.ONE);
		allMovesMap.put(InitialConfiguration.A + InitialConfiguration.ONE,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allMovesMap.put(InitialConfiguration.B + InitialConfiguration.ONE,

		emptyMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.ONE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.ONE);
		allMovesMap.put(InitialConfiguration.C + InitialConfiguration.ONE,

		allPossibleMoves);

		allMovesMap.put(InitialConfiguration.D + InitialConfiguration.ONE,

		emptyMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.ONE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TWO);
		allMovesMap.put(InitialConfiguration.E + InitialConfiguration.ONE,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.ONE);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allMovesMap.put(InitialConfiguration.A + InitialConfiguration.TWO,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.ONE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TWO);
		allMovesMap.put(InitialConfiguration.B + InitialConfiguration.TWO,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.ONE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allMovesMap.put(InitialConfiguration.C + InitialConfiguration.TWO,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.ONE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TWO);
		allMovesMap.put(InitialConfiguration.D + InitialConfiguration.TWO,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.ONE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allMovesMap.put(InitialConfiguration.E + InitialConfiguration.TWO,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allMovesMap.put(InitialConfiguration.A +

		InitialConfiguration.THREE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allMovesMap.put(InitialConfiguration.B +

		InitialConfiguration.THREE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TWO);
		allMovesMap.put(InitialConfiguration.C +

		InitialConfiguration.THREE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FOUR);
		allMovesMap.put(InitialConfiguration.D +

		InitialConfiguration.THREE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TWO);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FOUR);
		allMovesMap.put(InitialConfiguration.E +

		InitialConfiguration.THREE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allMovesMap.put(
				InitialConfiguration.A + InitialConfiguration.FOUR,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allMovesMap.put(
				InitialConfiguration.B + InitialConfiguration.FOUR,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allMovesMap.put(
				InitialConfiguration.C + InitialConfiguration.FOUR,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FOUR);
		allMovesMap.put(
				InitialConfiguration.D + InitialConfiguration.FOUR,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.THREE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FIVE);
		allMovesMap.put(
				InitialConfiguration.E + InitialConfiguration.FOUR,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allMovesMap.put(
				InitialConfiguration.A + InitialConfiguration.FIVE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SIX);
		allMovesMap.put(
				InitialConfiguration.B + InitialConfiguration.FIVE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allMovesMap.put(
				InitialConfiguration.C + InitialConfiguration.FIVE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FOUR);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SIX);
		allMovesMap.put(
				InitialConfiguration.D + InitialConfiguration.FIVE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FOUR);
		allMovesMap.put(
				InitialConfiguration.E + InitialConfiguration.FIVE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.SIX);
		allMovesMap.put(InitialConfiguration.A + InitialConfiguration.SIX,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SIX);
		allMovesMap.put(InitialConfiguration.B + InitialConfiguration.SIX,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.SIX);
		allMovesMap.put(InitialConfiguration.C + InitialConfiguration.SIX,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SIX);
		allMovesMap.put(InitialConfiguration.D + InitialConfiguration.SIX,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.FIVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SEVEN);
		allMovesMap.put(InitialConfiguration.E + InitialConfiguration.SIX,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allMovesMap.put(InitialConfiguration.A +

		InitialConfiguration.SEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SEVEN);
		allMovesMap.put(InitialConfiguration.B +

		InitialConfiguration.SEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allMovesMap.put(InitialConfiguration.C +

		InitialConfiguration.SEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SEVEN);
		allMovesMap.put(InitialConfiguration.D +

		InitialConfiguration.SEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SIX);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.EIGHT);
		allMovesMap.put(InitialConfiguration.E +

		InitialConfiguration.SEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allMovesMap.put(InitialConfiguration.A +

		InitialConfiguration.EIGHT, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allMovesMap.put(InitialConfiguration.B +

		InitialConfiguration.EIGHT, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allMovesMap.put(InitialConfiguration.C +

		InitialConfiguration.EIGHT, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.NINE);
		allMovesMap.put(InitialConfiguration.D +

		InitialConfiguration.EIGHT, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.SEVEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.NINE);
		allMovesMap.put(InitialConfiguration.E +

		InitialConfiguration.EIGHT, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allMovesMap.put(
				InitialConfiguration.A + InitialConfiguration.NINE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allMovesMap.put(
				InitialConfiguration.B + InitialConfiguration.NINE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allMovesMap.put(
				InitialConfiguration.C + InitialConfiguration.NINE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.NINE);
		allMovesMap.put(
				InitialConfiguration.D + InitialConfiguration.NINE,

				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.EIGHT);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TEN);
		allMovesMap.put(
				InitialConfiguration.E + InitialConfiguration.NINE,
				allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allMovesMap.put(InitialConfiguration.A + InitialConfiguration.TEN,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.ELEVEN);
		allMovesMap.put(InitialConfiguration.B + InitialConfiguration.TEN,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allMovesMap.put(InitialConfiguration.C + InitialConfiguration.TEN,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.ELEVEN);
		allMovesMap.put(InitialConfiguration.D + InitialConfiguration.TEN,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.NINE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allMovesMap.put(InitialConfiguration.E + InitialConfiguration.TEN,

		allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.TWELVE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allMovesMap.put(InitialConfiguration.A +

		InitialConfiguration.ELEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TWELVE);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.ELEVEN);
		allMovesMap.put(InitialConfiguration.B +

		InitialConfiguration.ELEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.TWELVE);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allMovesMap.put(InitialConfiguration.C +

		InitialConfiguration.ELEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TWELVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.ELEVEN);
		allMovesMap.put(InitialConfiguration.D +

		InitialConfiguration.ELEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TEN);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.TWELVE);
		allMovesMap.put(InitialConfiguration.E +

		InitialConfiguration.ELEVEN, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.A +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TWELVE);
		allMovesMap.put(InitialConfiguration.A +

		InitialConfiguration.TWELVE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allMovesMap.put(InitialConfiguration.B +

		InitialConfiguration.TWELVE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.B +

		InitialConfiguration.TWELVE);
		allPossibleMoves.add(InitialConfiguration.C +

		InitialConfiguration.ELEVEN);
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TWELVE);
		allMovesMap.put(InitialConfiguration.C +

		InitialConfiguration.TWELVE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allMovesMap.put(InitialConfiguration.D +

		InitialConfiguration.TWELVE, allPossibleMoves);

		allPossibleMoves = new ArrayList<String>();
		allPossibleMoves.add(InitialConfiguration.D +

		InitialConfiguration.TWELVE);
		allPossibleMoves.add(InitialConfiguration.E +

		InitialConfiguration.ELEVEN);
		allMovesMap.put(InitialConfiguration.E +

		InitialConfiguration.TWELVE, allPossibleMoves);

		return allMovesMap;
	}

}
