import java.util.Collections;
import java.util.Iterator;


/**
 * Implements the Selection Sort algorithm for sorting a pile of cards.
 * Uses a SortRecorder to visualize each step of the sorting process.
 */
public class SelectionSort {
  
  /**
    * Sorts a given CardPile using the Selection Sort algorithm.
    * Records each step of the sorting process using the provided SortRecorder.
    *
    * @param unsorted the pile of cards to be sorted
    * @param record the recorder used to visualize sorting steps
    * @return a new CardPile containing the sorted cards
    */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
    //CardPile unsorted = new CardPile(); 
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************
    Collections.shuffle(unsorted); //shuffle unsorted pile to start
    // //record progress
    while (unsorted.size() > 0) {
      // move one card between piles
      //find smallest card in unsorted pile
      Card smallestCard = findSmallest(unsorted);
      //remove it 
      unsorted.remove(smallestCard);
      //add it to sorted pile
      sorted.addLast(smallestCard);
      // record progress
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }
    return sorted;
  }

    //iterate through unsorted pile to find smallest card
  /**
   * Finds and returns the smallest card in the given CardPile.
   * @param pile
   * @return smallest card in pile
   */
  public static Card findSmallest(CardPile pile) {
      Iterator<Card> iterator = pile.iterator();
      Card smallestCard = iterator.next();
      while (iterator.hasNext()) {
        Card nextCard = iterator.next();
        if (nextCard.compareTo(smallestCard) < 0) {
          smallestCard = nextCard;
        }
      }
      return smallestCard;
    }

  /**
   * Demonstrates the Selection Sort algorithm by shuffling a deck of cards,
   * sorting them, and displaying the process using a SortRecorder.
   * @param args
   */
  public static void main(String args[]) {  
      //set up sorting recorder
      SortRecorder recorder = new SortRecorder();

      //load card images
      Card.loadImages(recorder);

      //make new deck 
      CardPile deck = new CardPile(Card.newDeck(true), 2, 2);

      //shuffle
      Collections.shuffle(deck);

      //sort the deck
      deck = SelectionSort.sort(deck, recorder);

      //print sorted deck
      System.out.println(deck);

      //Display the animation
      recorder.display("Selection Sort Animation");

    // return the sorted result here
    //return sorted;
  }
}
