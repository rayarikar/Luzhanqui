package MessageParser;
import java.util.HashMap;
import java.util.Map;


public class InitialConfiguration {

	static Map<String, String> rankInfo;
	private Map<String, String> boardPosition;
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
		rankInfo = new HashMap<String, String>();
		rankInfo.put(ENGINEER_RANK, ENGINEER);
		rankInfo.put(PLATOON_COMMANDAR_RANK, PLATOON_COMMANDAR);
		rankInfo.put(CAPTAIN_RANK, CAPTAIN);
		rankInfo.put(MAJOR_RANK, MAJOR);
		rankInfo.put(COLONEL_RANK, COLONEL);
		rankInfo.put(BRIGADIER_GENERAL_RANK, BRIGADIER_GENERAL);
		rankInfo.put(MAJOR_GENERAL_RANK, MAJOR_GENERAL);
		rankInfo.put(GENERAL_RANK, GENERAL);
		rankInfo.put(FIELD_MARSHELL_RANK, FIELD_MARSHELL);
		rankInfo.put(FLAG_RANK, FLAG);
		rankInfo.put(BOMB_RANK, BOMB);
		rankInfo.put(LANDMINE_RANK, LANDMINE);		
	}
	
	
	InitialConfiguration(){
		setBoardPositions();
	}

	/**
	 * This method populates the positions of the 
	 * player on the board.
	 */
	private void setBoardPositions(){
		boardPosition = new HashMap<String, String>();
		boardPosition.put(A + ONE, CAPTAIN_RANK);
		boardPosition.put(B + ONE, MAJOR_RANK);
		boardPosition.put(C + ONE, LANDMINE_RANK);
		boardPosition.put(D + ONE, FLAG_RANK);
		boardPosition.put(E + ONE, LANDMINE_RANK);
		boardPosition.put(A + TWO, CAPTAIN_RANK);
		boardPosition.put(B + TWO, CAPTAIN_RANK);
		boardPosition.put(C + TWO, ENGINEER_RANK);
		boardPosition.put(D + TWO, LANDMINE_RANK);
		boardPosition.put(E + TWO, ENGINEER_RANK);
		boardPosition.put(A + THREE, MAJOR_GENERAL_RANK);
		boardPosition.put(B + THREE, CAMP);
		boardPosition.put(C + THREE, PLATOON_COMMANDAR_RANK);
		boardPosition.put(D + THREE, CAMP);
		boardPosition.put(E + THREE, FIELD_MARSHELL_RANK);
		boardPosition.put(A + FOUR, COLONEL_RANK);
		boardPosition.put(B + FOUR, ENGINEER_RANK);
		boardPosition.put(C + FOUR, CAMP);
		boardPosition.put(D + FOUR, MAJOR_RANK);
		boardPosition.put(E + FOUR, COLONEL_RANK);
		boardPosition.put(A + FIVE, BOMB_RANK);
		boardPosition.put(B + FIVE, CAMP);
		boardPosition.put(C + FIVE, GENERAL_RANK);
		boardPosition.put(D + FIVE, CAMP);
		boardPosition.put(E + FIVE, BOMB_RANK);
		boardPosition.put(A + SIX, PLATOON_COMMANDAR_RANK);
		boardPosition.put(B + SIX, BRIGADIER_GENERAL_RANK);
		boardPosition.put(C + SIX, MAJOR_GENERAL_RANK);
		boardPosition.put(D + SIX, BRIGADIER_GENERAL_RANK);
		boardPosition.put(E + SIX, PLATOON_COMMANDAR_RANK);		
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
				if (boardPosition.get(row + "" + column + "")
						.equalsIgnoreCase(CAMP))
					continue;				
				// prints the position
				System.out.print(LEFT_PARENTHESIS + 
						(row + "" + column + "") + " " + 
						boardPosition.get(row + "" + column + "") + 
						RIGHT_PARENTHESIS);
			}
		}
	}
	
	/**
	 * returns initial configuration of the game
	 * @return Map
	 */
	public Map getInitialConfiguration(){
		return boardPosition;
	}

}
