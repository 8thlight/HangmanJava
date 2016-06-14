package com.hangman.players;

import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {
	private List<Character> previousGuesses = new ArrayList<>();

	private char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private char[] vowels = "aeiouy".toCharArray();
	private char[] charByFrequency = "etaoinshrdlcumwfgypbvkjxqz".toCharArray();

	private Map<Integer, char[]> clueLengthToCharacters = new HashMap<>();

    @Override
    public char getGuess(List<Character> currentClue) {
	    setClueCharacter();
	    char guess;

	    do{
		    guess = getGuessExecute(currentClue);
	    }while(previousGuesses.contains(guess));

		previousGuesses.add(guess);

	    return guess;
    }

	private char getGuessExecute(List<Character> currentClue){
		char guess;

		if(currentClue.contains('q') && !previousGuesses.contains('u')) {
			guess = 'u';
		}else if(currentClue.contains('t') && !previousGuesses.contains('h')){
			guess = 'h';
		}else {
			guess = getCleanCharByFrequency(currentClue).get(0);
		}

		return guess;
	}

	private List<Character> getCleanCharByFrequency(List<Character> currentClue){
		List<Character> cleanArray = new ArrayList<>();
		char[] characterList = getCharacterList(currentClue);
		for(char letter : characterList){
			if(!previousGuesses.contains(letter)){
				cleanArray.add(letter);
			}
		}

		return cleanArray;
	}

	private char[] getCharacterList(List<Character> currentClue){
		if(currentClue.size() > 20){
			return charByFrequency;
		}else{
			char[] charList =  clueLengthToCharacters.get(currentClue.size());
			if(previousGuesses.size() >= charList.length){
				return charByFrequency;
			}else{
				return charList;
			}
		}
	}

	private void setClueCharacter(){
		clueLengthToCharacters.put(1	,"ai".toCharArray());
		clueLengthToCharacters.put(2	,"aoumbh".toCharArray());
		clueLengthToCharacters.put(3	,"aeouyhbck".toCharArray());
		clueLengthToCharacters.put(4	,"aeouysbf".toCharArray());
		clueLengthToCharacters.put(5	,"seaouyh".toCharArray());
		clueLengthToCharacters.put(6	,"eiusY".toCharArray());
		clueLengthToCharacters.put(7	,"iaus".toCharArray());
		clueLengthToCharacters.put(8	,"iaou".toCharArray());
		clueLengthToCharacters.put(9	,"iaou".toCharArray());
		clueLengthToCharacters.put(10	,"ioau".toCharArray());
		clueLengthToCharacters.put(11	,"ioad".toCharArray());
		clueLengthToCharacters.put(12	,"ioaf".toCharArray());
		clueLengthToCharacters.put(13	,"ieoa".toCharArray());
		clueLengthToCharacters.put(14	,"ieo".toCharArray());
		clueLengthToCharacters.put(15	,"iea".toCharArray());
		clueLengthToCharacters.put(16	,"ieh".toCharArray());
		clueLengthToCharacters.put(17	,"ier".toCharArray());
		clueLengthToCharacters.put(18	,"iea".toCharArray());
		clueLengthToCharacters.put(19	,"iea".toCharArray());
		clueLengthToCharacters.put(20	,"ie".toCharArray());
	}

	public void setPreviousGuesses(Character... guesses){
		previousGuesses.addAll(Arrays.asList(guesses));
	}

	public int getGuessCount(){
		return previousGuesses.size();
	}
}
