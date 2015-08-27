# Hangman in Java - for code sparring.

This program tries to solve a game of hangman. It doesn't do a very good job - it's your job to fork it and create a new solution for it.

## How To

Fork this repo then clone it. To run the tests:

To test:
```shell
gradle test
```

To run:
```shell
gradle run
```

When you run the hangman program you'll see something like this:
```shell
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
Current Clue Is _ _ _ _ _ _
com.hangman.Game Over
```

What the hangman game does is play hangman against a computer player. Each blank space represents a letter that hasn't been guessed. When your player guesses correctly it's displayed on the screen.

Currently your player only guesses the letter "A".  You will edit YourPlayer.java in an effort to make it a better Hangman player. The player's code can be found in YourPlayer.java and the tests can be found in YourPlayerTest.java. You are not allowed to change anything else.
Tough stuff. To run the program:

What this means is is that the clue length was five characters, and your player successfully guessed....nothing. To see why let's take a look at YourPlayer.java.

```java
public class YourPlayer implements Player {
  @Override
  public char GetGuess(List<Character> clue) {
    return 'a';
  }
}
```

That's right `YourPlayer` - regardless of the clue - will guess the letter `a`. If it got `a` right, it guessed `a`. Wrong? `a`. It's a pretty stupid player.

So to complete this exercise you will need to delete return 'a' - and instead return better guesses. How? Well look the parameter:

`List<Character> clue`. The clue is exactly what you're seeing on screen. It is an array of characters where the '_' character means that you haven't gotten that location correct yet.

This stumps people so let's go through an example. Let's assume the secret word is "aaron". The first time GetGuess is called it will get:

`['_', '_', '_', '_', '_']`

`YourPlayer` will guess 'a'. The next time GuetGuess is called it will look like:

`['a', 'a', '_', '_', '_']`

Naturally `YourPlayer` will guess 'a' again, because it is stupid. To complete this exercise you need to make `YourPlayer` good at hangman.

## Tips

* Maybe keep track of what you've guessed.
* Vowels are good.
* Your testing WILL BE GRADED! in YourPlayer.java and the tests can be found in YourPlayerTest.java. You are not allowed to change anything else.
