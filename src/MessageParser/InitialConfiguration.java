package MessageParser;
import java.util.HashMap;
import java.util.Map;


public class InitialConfiguration {

	static Map<String, String> rankInfoMap;
	private Map<String, String> boardPositionMap;
	// constants for name of the pieces
	private static final String ENGINEER = "Engineer"; 
	private static final String PLATOON_COMMANDAR = "Platoon Commandar"; 
	private static final String CAPTAIN = "Captain"; 
	private static final String MAJOR ="Major"; 
	private static final String COLONEL ="Colonel"; 
	private static final String BRIGADIER_GENERAL ="Brigadier General"; 
	private static final String MAJOR_GENERAL ="Major General"; 
	private static final String GENERAL ="General";
	private static final String FIELD_MARSHELL ="Field Marshell"; 
	private static final String FLAG ="Flag"; 
	private static final String LANDMINE ="Landmine"; 
	private static final String BOMB ="Bomb";
	// constants for player ranks
	private static final String ENGINEER_RANK= "1"; 
	private static final String PLATOON_COMMANDAR_RANK= "2"; 
	private static final String CAPTAIN_RANK= "3"; 
	private static final String MAJOR_RANK ="4"; 
	private static final String COLONEL_RANK="5"; 
	private static final String BRIGADIER_GENERAL_RANK="6"; 
	private static final String MAJOR_GENERAL_RANK="7"; 
	private static final String GENERAL_RANK="8";
	private static final String FIELD_MARSHELL_RANK="9"; 
	private static final String FLAG_RANK="F"; 
	private static final String BOMB_RANK="B"; 
	private static final String LANDMINE_RANK="L";
	// constants for position
	private static final String A = "A";
	private static final String B = "B";
	private static final String C = "C";
	private static final String D = "D";
	private static final String E = "E";
	private static final String ONE = "1"; 
	private static final String TWO= "2"; 
	private static final String THREE= "3";
	private static final String FOUR = "4";
	private static final String FIVE = "5";
	private static final String SIX = "6";
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
