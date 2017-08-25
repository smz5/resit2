/**
 * MagicNumber.java
 *
 */

import java.util.Random;

public class MagicNumber {
  private int target;     // the number that is to be guessed
  private int numGuesses; // the number of guesses so far
  private boolean found;  // true iff number has been guessed
  private int maxGuesses; // the max number of guesses allowed
  
  /**
   *  Create a magic number between 1 and 100 and initialise
   *  variables; set the maximum number or guesses to 10
   */
  public MagicNumber () {
    this(10);
  }

  /**
   *  Create a magic number between 1 and 100 and initialise
   *  variables; specify the maximum allowed number of guesses
   * @param maxG the maximum number of guesses allowed
   */
  public MagicNumber (int maxG) {
    target = Math.abs(new Random().nextInt(100)+1);
    maxGuesses = maxG;
    numGuesses = 0;
    found = false;
  }

  /**
   * An attempt at guessing the number. 
   * @param g the guess
   * @return how successful the guess was
   */
  public String guess(int g) {
    if (g == target) {
      found = true;
      return "Guess was correct";
    } else if (++numGuesses >= maxGuesses) {
      return "Too many guesses";
    } else if (g > target) {
      return "Guess was too high";
    } else {
      return "Guess was too low";
    }
  }

  /**
   *  Return if the game is over
   *  @return true: if all attempts were used; false: if the player
   *          has at least one attempt left
   */
  public boolean getFinished () {
    if (numGuesses >= maxGuesses) return true;
    else return found;
  }
} // MagicNumber