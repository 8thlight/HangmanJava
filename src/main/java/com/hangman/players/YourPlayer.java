package com.hangman.players;
import com.hangman.Player;
import com.hangman.WordList;

import java.util.*;

public class YourPlayer implements Player {
    private boolean hasOneRightGuess;
    List<Character> attemptedCharacters;
  char[] frequentUsedChars = "etaoinshrdlcumwfgypbvkjxqz".toCharArray();
  int index;
    private char lastCharGuessed;
    private String lastClue;
    private boolean lastAttemptResult;
    public static final boolean RIGHT_GUESS = true;
    public static final boolean WRONG_GUESS = false;
    private String[] words;

    public YourPlayer () {
      attemptedCharacters = new ArrayList<Character>();
      index = 0;
      hasOneRightGuess = false;
      words = WordList.words.clone();
      for (int i=0; i < words.length; i++) {
          words[i] = words[i].toLowerCase();
      }

  }

  public static List<String> getWordMatchingLength(String[] words, int length) {
      List<String> matchingStrings = new ArrayList<String>();
      for(String word : words) {
          if ( word.length() == length ) {
              matchingStrings.add(word);
          }
      }
      return matchingStrings;
  }


  @Override
  public char GetGuess(List<Character> clue) {

      StringBuilder sb = new StringBuilder(clue.size());
      for (Character c : clue)
          sb.append(c);
      String clueAsString = sb.toString();

      if (clueAsString.equals(lastClue) || lastClue == null) {
          lastAttemptResult = WRONG_GUESS;
      }
      else {
          lastAttemptResult = RIGHT_GUESS;
          hasOneRightGuess = true;
      }

          List<String> wordList = YourPlayer.getWordMatchingLength(words,clue.size());
          words = new String[wordList.size()];
          words = wordList.toArray(words);



          wordList = YourPlayer.getWordMatchingPattern(words,clue);
          words = new String[wordList.size()];
          words = wordList.toArray(words);


          if(getLastAttemptResult() == WRONG_GUESS) {
              wordList = YourPlayer.getWordsWithoutChars(words, getLastCharGuessed());
              words = new String[wordList.size()];
              words = wordList.toArray(words);

          }




         if(words.length > 0 ) {
              lastCharGuessed = getMostFrequentChar(words);
          }
          else{
              while(attemptedCharacters.contains(frequentUsedChars[index])){
                  index++;
              }
              lastCharGuessed = frequentUsedChars[index++];
          }
      attemptedCharacters.add(lastCharGuessed);
      lastClue = clueAsString;
      return lastCharGuessed;
  }


    public static List<String> getWordMatchingPattern(String[] words, List<Character> pattern) {
        List<String> matchingStrings = new ArrayList<String>(Arrays.asList(words));
        for(int index=0; index < pattern.size(); index++) {
            if(pattern.get(index) == '_') {
                continue;
            }
            for(String word : words) {
                if(word.charAt(index) != pattern.get(index)) {
                    matchingStrings.remove(word);
                    continue;
                }
            }
        }
        return matchingStrings;
    }

    public static List<String> getWordsWithoutChars(String[] words, char chars) {
        List<String> matchingStrings = new ArrayList<String>(Arrays.asList(words));

            for(String word: words) {
                if ( word.indexOf(chars) != -1) {
                    matchingStrings.remove(word);
                    continue;
                }
            }

        return matchingStrings;
    }

    public char getLastCharGuessed() {
        return lastCharGuessed;
    }

    public boolean getLastAttemptResult() {
        return lastAttemptResult;
    }

    public boolean hasOneRightGuess() {
        return hasOneRightGuess;
    }

    public static char getMostFrequentChar(String[] words) {
        Map<Character,Integer> counter = new HashMap<Character, Integer>();

        for(String word : words) {
            for(char character: word.toCharArray()) {
                try {
                    counter.get(character);
                    if ( counter.get(character) == null ) {
                        counter.put(character,0);
                    }
                }
                catch (Exception e){
                    counter.put(character, 0);
                }

                counter.put(character, counter.get(character) + 1);
            }
        }

        char highest = 'a';
        int highest_count = 0;
        for(Character character: counter.keySet()) {
            if(counter.get(character) > highest_count ) {
                highest = character;
                highest_count = counter.get(character);
            }
        }
        return highest;
    }
}
