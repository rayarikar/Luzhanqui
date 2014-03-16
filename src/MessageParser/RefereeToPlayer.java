package MessageParser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class reads the input message from the console and checks
 * whether the message is a valid message or not
 * @author Rohan
 *
 */
public class RefereeToPlayer {
	private static Pattern pattern;
	private static Matcher matcher;
	private final String REGEX = "^\\d+$";
	public final String INIT = "init";
	private final String TIME_MOVE = "time/move";
	private final String GAME_END = "end";
	public final String GO = "go";
	private final String FLAG = "flag";
	private final String ILLEGAL = "illegal";
	public final String OUTCOME = "outcome";
	private final String DOT = ".";
	private final char LEFT_PARENTHESIS = '(';
	private final char RIGHT_PARENTHESIS = ')';
	private final char LESS_THAN = '<';
	private final char GREATER_THAN = '>';
	private final char EQUAL = '=';
	final char ZERO = '0';
	final char ONE = '1';
	private final char TWO = '2';
	private List<Object> returnList = new ArrayList<Object>();
	private List<Object> emptyList = new ArrayList<Object>();

	// compiles the pattern defined globally
	public RefereeToPlayer(){
		pattern = Pattern.compile(REGEX);		
	}

	/**
	 * Matches the input string with the pattern. If the match 
	 * is found it returns true else false
	 * @param input
	 * @return boolean
	 */
	private boolean isValidDigit(String input){
		matcher = pattern.matcher(input);
		return matcher.find();
	}

	/**
	 * Checks the passed message with the expected message
	 * and returns true if the message is valid, else false
	 * @param message
	 * @return boolean
	 */
	public List processRefereeMessage(String message){
		StringBuilder messageBuilder = new StringBuilder(message);
		// return false if message does not have opening and closing parenthesis
		if (messageBuilder.charAt(0) != LEFT_PARENTHESIS || 
				messageBuilder.charAt
				(messageBuilder.length() - 1) != RIGHT_PARENTHESIS)
			return emptyList;
		// remove the parenthesis and process message
		messageBuilder.deleteCharAt(0);
		messageBuilder.deleteCharAt(messageBuilder.length() - 1);
		return checkForMessageType
				(new StringBuilder(messageBuilder.toString().trim()));
	}


	private List checkForMessageType(StringBuilder innerMessage){		
		try{
			returnList.clear();
			// <turn>
			if (innerMessage.toString().substring(0, 2).equals(GO))
				return checkForGoMessage(innerMessage);						
			// <game_end>
			if (innerMessage.toString().substring(0, 3).equals(GAME_END))
				return checkForGameEndMessage(innerMessage);
			// <flag>
			if (innerMessage.toString().substring(0, 4).equals(FLAG))
				return checkForFlagMessage(innerMessage);		
			// <msg0>
			if (innerMessage.toString().substring(0, 4).equals(INIT))
				return checkInnerMessage(innerMessage);
			// <illegal>
			if (innerMessage.toString().substring(0, 7).equals(ILLEGAL))
				return checkForIllegalMessage(innerMessage);
			// <outcome>
			if (innerMessage.toString().substring(0, 7).equals(OUTCOME))
				return checkForOutcomeMessage(innerMessage);
			
			return emptyList;
		}
		catch (Exception e){
			return emptyList;
		}
	}


	/**
	 * This helper method validates the message and checks for
	 * strings go <which> time/move <seconds>
	 * @param innerMessage
	 * @return boolean
	 */
	private List checkInnerMessage(StringBuilder innerMessage){
		innerMessage.delete(0, 4);
		innerMessage = Utility.removeStartBlankChars(innerMessage);
		if (innerMessage.charAt(0) != ONE && innerMessage.charAt(0) != TWO)			
			return emptyList;
		int player = Integer.parseInt("" + innerMessage.charAt(0));
		innerMessage.deleteCharAt(0);
		innerMessage = Utility.removeStartBlankChars(innerMessage);		
		if ( !innerMessage.toString().substring(0, 9).equals(TIME_MOVE))
			return emptyList;
		innerMessage.delete(0, 9);
		innerMessage = Utility.removeStartBlankChars(innerMessage);
		if ( !checkForSeconds(innerMessage.toString().trim()))
			return emptyList;
		returnList.add(INIT);
		returnList.add(player);
		returnList.add(Double.parseDouble(innerMessage.toString().trim()));
		return returnList;
	}

	/**
	 * This helper method takes the <seconds> input in string 
	 * form and checks for the input having valid digits
	 * @param secondsInput
	 * @return boolean
	 */
	private boolean checkForSeconds(String secondsInput){
		// here split the builder by '.' and check the regex				
		if (secondsInput.contains(DOT))
			return checkForDigitsWithDecimal(secondsInput);
		else if (isValidDigit(secondsInput))
			return isNonZeroNumber(secondsInput);			
		return false;
	}

	/**
	 * This method checks if the passed input is a valid digit
	 * or not based on the grammar
	 * @param secondsInput
	 * @return boolean
	 */
	private boolean checkForDigitsWithDecimal(String secondsInput){
		String[] digits = secondsInput.split("\\.");
		if (digits.length == 2)
			if (isValidDigit(digits[0]) && isValidDigit(digits[1]))
				return (isNonZeroNumber(digits[0]) ||
						isNonZeroNumber(digits[1]));
		return false;
	}
	
	/**
	 * This method checks for the zeros in the string
	 * @param input
	 * @return boolean
	 */
	private boolean isNonZeroNumber(String input){
		if (Integer.parseInt(input) != 0)
			return true;
		return false;
	}

	/**
	 * this method checks for the <game_end> message syntax
	 * @param innerMessage
	 * @return boolean
	 */
	private List checkForGameEndMessage(StringBuilder innerMessage){
		innerMessage.delete(0, 3);
		innerMessage = Utility.removeStartBlankChars(innerMessage);
		if (Integer.parseInt(innerMessage.toString().charAt(0) +"") <= 2 &&
				Integer.parseInt(innerMessage.toString().charAt(0) +"") >= 0){
			returnList.add(GAME_END);
			returnList.add(Integer.parseInt(innerMessage.toString().charAt(0) +""));
			return returnList;
		}
		return emptyList;
	}

	/**
	 * this method checks for the <turn> message syntax
	 * @param innerMessage
	 * @return List
	 */
	private List checkForGoMessage(StringBuilder innerMessage){
		if (innerMessage.toString().length() < 2)
			return emptyList;
		innerMessage.delete(0, 2);
		innerMessage = Utility.removeStartBlankChars(innerMessage);
		if (Integer.parseInt(innerMessage.toString().charAt(0) +"") == 1 ||
				Integer.parseInt(innerMessage.toString().charAt(0) +"") == 2){
			returnList.add(GO);
			returnList.add(Integer.parseInt(innerMessage.toString().charAt(0) +""));
			return returnList;
		}
		return emptyList;
	}


	/**
	 * this method checks for the <flag> message syntax
	 * @param innerMessage
	 * @return boolean
	 */
	private List checkForFlagMessage(StringBuilder innerMessage){
		if (innerMessage.toString().length() < 6)
			return emptyList;
		innerMessage.delete(0, 4);
		innerMessage = Utility.removeStartBlankChars(innerMessage);
		if (Integer.parseInt(innerMessage.toString().charAt(0) +"") > 2 ||
				Integer.parseInt(innerMessage.toString().charAt(0) +"") <= 0)
			return emptyList;
		innerMessage.deleteCharAt(0);
		innerMessage = Utility.removeStartBlankChars(innerMessage);
		String position = innerMessage.toString().substring(0, innerMessage.toString().trim().length());
		if ( !Utility.getPositionMap().containsKey(position))
			return emptyList;
		returnList.add(FLAG);
		returnList.add(position);
		return returnList;
	}


	/**
	 * this method chaecks for <illegal> message syntax
	 * @param innerMessage
	 * @return boolean
	 */
	private List checkForIllegalMessage(StringBuilder innerMessage){
		innerMessage.delete(0, 7);
		String modifiedMessage = innerMessage.toString().trim();
		returnList.add(ILLEGAL);
		if (modifiedMessage.charAt(0) == LEFT_PARENTHESIS &&
				modifiedMessage.charAt(modifiedMessage.length() - 1) == RIGHT_PARENTHESIS){
			List illegalList = 
					checkForPositions(modifiedMessage.toString().trim().substring(1, modifiedMessage.length() - 1));
			if (illegalList.size() == 3)
				return illegalList;
		}
		return emptyList;
	}


	/**
	 * method to check for valid positions
	 * @param innerMessage
	 * @return boolean
	 */
	private List checkForPositions(String innerMessage){
		List<String> positions = Utility.extractPositionsFromString(innerMessage);
		if (positions.size() < 2)
			return emptyList;
		for (String eachPosition : positions){
			if (eachPosition.trim().length() == 0)
				continue;
			if ( !Utility.getPositionMap().containsKey(eachPosition))
				return emptyList;
			returnList.add(eachPosition);
		}
		return returnList;
	}

	/**
	 * Checks the <outcome> message syntax
	 * @param innerMessage
	 * @return boolean
	 */
	private List checkForOutcomeMessage(StringBuilder innerMessage){
		innerMessage.delete(0, 7);
		innerMessage = Utility.removeStartBlankChars(innerMessage);
		returnList.add(OUTCOME);
		// if it is <compare><move>
		if (innerMessage.charAt(0) == LESS_THAN || 
				innerMessage.charAt(0) == GREATER_THAN ||
				innerMessage.charAt(0) == EQUAL){
			// check for <move>
			returnList.add(innerMessage.charAt(0) + "");
			innerMessage.deleteCharAt(0);
			innerMessage = Utility.removeStartBlankChars(innerMessage);
			List moveList = checkMoveMessage(innerMessage);
			if (moveList.size() == 4)
				return moveList;
			else
				return emptyList;					
		}
		// if it is <move>
		else{
			List moveList = 
			checkForPositions(innerMessage.toString().trim().
					substring(0, innerMessage.length()));
			if (moveList.size() == 3)
				return moveList;
			else
				return emptyList;
		}
	}
	
	/**
	 * checks the <move> message
	 * @param innerMessage
	 * @return boolean
	 */
	private List checkMoveMessage(StringBuilder innerMessage){
		if (innerMessage.charAt(0) == LEFT_PARENTHESIS &&
				innerMessage.charAt(innerMessage.length() - 1) == RIGHT_PARENTHESIS)
			return checkForPositions(innerMessage.toString().trim().substring(1, innerMessage.length() - 1));
		return emptyList;
	}

}
