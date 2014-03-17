package MessageParser;
import java.util.HashMap;
import java.util.Map;


public class InitialConfiguration {

	static Map<String, String> rankInfoMap;
	public Map<String, String> boardPositionMap;
	// constants for name of the pieces
	public static final String ENGINEER = "Engineer"; 
	public static final String PLATOON_COMMANDAR = "Platoon Commandar"; 
	public static final String CAPTAIN = "Captain"; 
	public static final String MAJOR ="Major"; 
	public static final String COLONEL ="Colonel"; 
	public static final String BRIGADIER_GENERAL ="Brigadier General"; 
	public static final String MAJOR_GENERAL ="Major General"; 
	public static final String GENERAL ="General";
	public static final String FIELD_MARSHELL ="Field Marshell"; 
	public static final String FLAG ="Flag"; 
	public static final String LANDMINE ="Landmine"; 
	public static final String BOMB ="Bomb";
	// constants for player ranks
	public static final String ENGINEER_RANK= "1"; 
	public static final String PLATOON_COMMANDAR_RANK= "2"; 
	public static final String CAPTAIN_RANK= "3"; 
	public static final String MAJOR_RANK ="4"; 
	public static final String COLONEL_RANK="5"; 
	public static final String BRIGADIER_GENERAL_RANK="6"; 
	public static final String MAJOR_GENERAL_RANK="7"; 
	public static final String GENERAL_RANK="8";
	public static final String FIELD_MARSHELL_RANK="9"; 
	public static final String FLAG_RANK="F"; 
	public static final String BOMB_RANK="B"; 
	public static final String LANDMINE_RANK="L";
	public static final String EMPTY_POSITION="false";
	public static final String FILLED_POSITION="true";
	// constants for position
	public static final String A = "A";
	public static final String B = "B";
	public static final String C = "C";
	public static final String D = "D";
	public static final String E = "E";
	public static final String ONE = "1"; 
	public static final String TWO= "2"; 
	public static final String THREE= "3";
	public static final String FOUR = "4";
	public static final String FIVE = "5";
	public static final String SIX = "6";
	public static final String SEVEN = "7";
	public static final String EIGHT = "8";
	public static final String NINE = "9";
	public static final String  TEN = "10";
	public static final String  ELEVEN = "11";
	public static final String  TWELVE  = "12";
	// constants for round parenthesis
	private static final String LEFT_PARENTHESIS = "(";
	private static final String RIGHT_PARENTHESIS = ")";
	// global program constant for Camp
	public static final String CAMP = "CAMP";
	
	
	/**
	 * Initialize the map so that we can come to know
	 * the name of the piece based on the rank of the
	 * piece
	 * KEY -> Rank of the piece
	 * VALUE -> Name of the piece
	 */	
	static{
		rankInfoMap = new HashMap<String, String>();
		rankInfoMap.put(ENGINEER_RANK, ENGINEER);
		rankInfoMap.put(PLATOON_COMMANDAR_RANK, PLATOON_COMMANDAR);
		rankInfoMap.put(CAPTAIN_RANK, CAPTAIN);
		rankInfoMap.put(MAJOR_RANK, MAJOR);
		rankInfoMap.put(COLONEL_RANK, COLONEL);
		rankInfoMap.put(BRIGADIER_GENERAL_RANK, BRIGADIER_GENERAL);
		rankInfoMap.put(MAJOR_GENERAL_RANK, MAJOR_GENERAL);
		rankInfoMap.put(GENERAL_RANK, GENERAL);
		rankInfoMap.put(FIELD_MARSHELL_RANK, FIELD_MARSHELL);
		rankInfoMap.put(FLAG_RANK, FLAG);
		rankInfoMap.put(BOMB_RANK, BOMB);
		rankInfoMap.put(LANDMINE_RANK, LANDMINE);		
	}
	
	
	InitialConfiguration(){
		setBoardPositions();
	}

	/**
	 * This method populates the positions of the 
	 * player on the board.
	 */
	private void setBoardPositions(){
		boardPositionMap = new HashMap<String, String>();
		boardPositionMap.put(A + ONE, CAPTAIN_RANK);
		boardPositionMap.put(B + ONE, MAJOR_RANK);
		boardPositionMap.put(C + ONE, LANDMINE_RANK);
		boardPositionMap.put(D + ONE, FLAG_RANK);
		boardPositionMap.put(E + ONE, LANDMINE_RANK);
		boardPositionMap.put(A + TWO, CAPTAIN_RANK);
		boardPositionMap.put(B + TWO, CAPTAIN_RANK);
		boardPositionMap.put(C + TWO, ENGINEER_RANK);
		boardPositionMap.put(D + TWO, LANDMINE_RANK);
		boardPositionMap.put(E + TWO, ENGINEER_RANK);
		boardPositionMap.put(A + THREE, MAJOR_GENERAL_RANK);
		boardPositionMap.put(B + THREE, CAMP);
		boardPositionMap.put(C + THREE, PLATOON_COMMANDAR_RANK);
		boardPositionMap.put(D + THREE, CAMP);
		boardPositionMap.put(E + THREE, FIELD_MARSHELL_RANK);
		boardPositionMap.put(A + FOUR, COLONEL_RANK);
		boardPositionMap.put(B + FOUR, ENGINEER_RANK);
		boardPositionMap.put(C + FOUR, CAMP);
		boardPositionMap.put(D + FOUR, MAJOR_RANK);
		boardPositionMap.put(E + FOUR, COLONEL_RANK);
		boardPositionMap.put(A + FIVE, BOMB_RANK);
		boardPositionMap.put(B + FIVE, CAMP);
		boardPositionMap.put(C + FIVE, GENERAL_RANK);
		boardPositionMap.put(D + FIVE, CAMP);
		boardPositionMap.put(E + FIVE, BOMB_RANK);
		boardPositionMap.put(A + SIX, PLATOON_COMMANDAR_RANK);
		boardPositionMap.put(B + SIX, BRIGADIER_GENERAL_RANK);
		boardPositionMap.put(C + SIX, MAJOR_GENERAL_RANK);
		boardPositionMap.put(D + SIX, BRIGADIER_GENERAL_RANK);
		boardPositionMap.put(E + SIX, PLATOON_COMMANDAR_RANK);
		boardPositionMap.put(E + SIX, PLATOON_COMMANDAR_RANK);
		boardPositionMap.put(A + SEVEN, FILLED_POSITION);
		boardPositionMap.put(B + SEVEN, FILLED_POSITION);
		boardPositionMap.put(C + SEVEN, FILLED_POSITION);
		boardPositionMap.put(D + SEVEN, FILLED_POSITION);
		boardPositionMap.put(E + SEVEN, FILLED_POSITION);
		boardPositionMap.put(A + EIGHT, FILLED_POSITION);
		boardPositionMap.put(B + EIGHT, CAMP);
		boardPositionMap.put(C + EIGHT, FILLED_POSITION);
		boardPositionMap.put(D + EIGHT, CAMP);
		boardPositionMap.put(E + EIGHT, FILLED_POSITION);
		boardPositionMap.put(A + NINE, FILLED_POSITION);
		boardPositionMap.put(B + NINE, FILLED_POSITION);
		boardPositionMap.put(C + NINE, CAMP);
		boardPositionMap.put(D + NINE, FILLED_POSITION);
		boardPositionMap.put(E + NINE, FILLED_POSITION);
		boardPositionMap.put(A + TEN, FILLED_POSITION);
		boardPositionMap.put(B + TEN, CAMP);
		boardPositionMap.put(C + TEN, FILLED_POSITION);
		boardPositionMap.put(D + TEN, CAMP);
		boardPositionMap.put(E + TEN, FILLED_POSITION);
		boardPositionMap.put(A + ELEVEN, FILLED_POSITION);
		boardPositionMap.put(B + ELEVEN, FILLED_POSITION);
		boardPositionMap.put(C + ELEVEN, FILLED_POSITION);
		boardPositionMap.put(D + ELEVEN, FILLED_POSITION);
		boardPositionMap.put(E + ELEVEN, FILLED_POSITION);
		boardPositionMap.put(A + TWELVE, FILLED_POSITION);
		boardPositionMap.put(B + TWELVE, FILLED_POSITION);
		boardPositionMap.put(C + TWELVE, FILLED_POSITION);
		boardPositionMap.put(D + TWELVE, FILLED_POSITION);
		boardPositionMap.put(E + TWELVE, FILLED_POSITION);	
	}
	
	/**
	 *  This method prints the positions to the standard
	 *  output in the following format
	 *  (A11) -> This means at position A1, the piece
	 *  with rank 1 (Engineer) is placed
	 */
	protected void printInitialConfiguration(){
		for (char row = 'A'; row <= 'E'; row++){
			for (int column = 1; column <= 6; column++){
				
				// if it is a camp position do not print
				if (boardPositionMap.get(row + "" + column + "")
						.equalsIgnoreCase(CAMP))
					continue;				
				// prints the position
				System.out.print(LEFT_PARENTHESIS + 
						(row + "" + column + "") + " " + 
						boardPositionMap.get(row + "" + column + "") + 
						RIGHT_PARENTHESIS);
			}
		}
	}
	
	/**
	 * returns initial configuration of the game
	 * @return Map
	 */
	public Map getInitialConfiguration(){
		return boardPositionMap;
	}

}
