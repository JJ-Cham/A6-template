import java.util.Collections;
import java.util.Iterator;

/**
 * Implements the Selection Sort algorithm for sorting a pile of cards.
 */
public class SelectionSortTimer {
  
  /**
  * Sorts a given CardPile using the Selection Sort algorithm.
  *
  * @param unsorted the pile of cards to be sorted
  * @return a new CardPile containing the sorted cards
  */
  public static CardPile sort(CardPile unsorted) {

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
    //Collections.shuffle(unsorted); //shuffle unsorted pile to start
  
    while (unsorted.size() > 0) {
      // move one card between piles
      //find smallest card in unsorted pile
      Card smallestCard = findSmallest(unsorted);
      //remove it 
      unsorted.remove(smallestCard);
      //add it to sorted pile
      sorted.addLast(smallestCard);
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
  /** Starts the program running */
  /**
   * Demonstrates the Selection Sort algorithm by shuffling a deck of cards,
   * sorting them.
   * @param args
   */
  public static void main(String[] args) {
    if (args.length < 1) {
        System.err.println("Please specify how many cards to sort!");
        return;
    }

    int count = Integer.parseInt(args[0]);
    Card[] deck = Card.newDeck(true);
    CardPile cards = new CardPile();

    for (int i = 0; i < count; i++) {
        cards.add(deck[(int)(52 * Math.random())]);
    }

    // Time the sort
    long start = System.nanoTime();
    CardPile sorted = sort(cards); // your algorithm here
    long end = System.nanoTime();

    System.out.println("Elapsed time: " + (end - start)/1_000_000 + " ms");
}


  }

