package com.hangman.players;

import com.hangman.Player;

import java.util.ArrayList;
import java.util.List;

public class YourPlayer implements Player {

		private List<Character> attemptedChars =  new ArrayList<>();

		private String wordLength1CharsProto = "ai";
		private String wordLength2CharsProto = "aoeimhnustyblpxdfrwgjk";
		private String wordLength3CharsProto = "aeoitsuprndbgmylhwfckxvjzq";
		private String wordLength4CharsProto = "aesoirltnudpmhcbkgywfvjzxq";
		private String wordLength5CharsProto = "searioltnudcypmhgbkfwvzxjq";
		private String wordLength6CharsProto = "esariolntducmpghbykfwvzxjq";
		private String wordLength7CharsProto = "esiarntolducgpmhbyfkwvzxjq";
		private String wordLength8CharsProto = "esiarntoldcugmphbyfkwvzxqj";
		private String wordLength9CharsProto = "esirantolcdugmphbyfvkwzxqj";
		private String wordLength10CharsProto = "eisrantolcdugmphbyfvkwzxqj";


		public List<Character> wordLength1Chars = convertStringToList(wordLength1CharsProto);
		public List<Character> wordLength2Chars = convertStringToList(wordLength2CharsProto);
		public List<Character> wordLength3Chars = convertStringToList(wordLength3CharsProto);
		public List<Character> wordLength4Chars = convertStringToList(wordLength4CharsProto);
		public List<Character> wordLength5Chars = convertStringToList(wordLength5CharsProto);
		public List<Character> wordLength6Chars = convertStringToList(wordLength6CharsProto);
		public List<Character> wordLength7Chars = convertStringToList(wordLength7CharsProto);
		public List<Character> wordLength8Chars = convertStringToList(wordLength8CharsProto);
		public List<Character> wordLength9Chars = convertStringToList(wordLength9CharsProto);
		public List<Character> wordLength10Chars = convertStringToList(wordLength10CharsProto);

	public void setAttemptedChars(List<Character> attemptedChars) {
		this.attemptedChars = attemptedChars;
	}

	private String protoPopularChars = "etaoinshrdlcumwfgypbvkjxqz";

	public List<Character> getAttemptedChars() {
		return attemptedChars;
	}

	public List<Character> getPopularChars() {
		return popularChars;
	}

	private List<Character> popularChars = convertStringToList(protoPopularChars);

    @Override
    public char getGuess(List<Character> currentClue) {
	    if (this.popularChars == null) {
		    System.out.println("setting a strategy");
					setCharStrategy(currentClue);
	    }
	    return _getGuess();
    }

    public void setCharStrategy(List<Character> currentClue) {
      Integer size = currentClue.size();
      switch (size) {
	      case 1: popularChars = wordLength1Chars;
	              break;
	      case 2: popularChars = wordLength2Chars;
	              break;
	      case 3: popularChars = wordLength3Chars;
	              break;
	      case 4: popularChars = wordLength4Chars;
	              break;
	      case 5: popularChars = wordLength5Chars;
	              break;
	      case 6: popularChars = wordLength6Chars;
	              break;
	      case 7: popularChars = wordLength7Chars;
	              break;
	      case 8: popularChars = wordLength8Chars;
	              break;
	      case 9: popularChars = wordLength9Chars;
	              break;
	      case 10: popularChars = wordLength10Chars;
	              break;
	      default: popularChars = wordLength10Chars;
	              break;

      }

    }

    public char _getGuess() {
	    char guess = popularChars.get(0);
	    this.attemptedChars.add(guess);
	    this.popularChars.remove(0); //hmm
	    return guess;
    }

    private List<Character> convertStringToList(String blob) {
	    List<Character> newChars = new ArrayList<>();
	    for (Character c : blob.toCharArray()) {
	      newChars.add(c);
	    }
	    return newChars;
    }

}
