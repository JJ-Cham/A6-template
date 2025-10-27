import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;

/**
 * Implements the Merge Sort algorithm for sorting a pile of cards.
 * Uses a SortRecorder to visualize each step of the sorting process.
 */
public class MergeSort {
  
  /**
  * Sorts a given CardPile using the Merge Sort algorithm.
  * Each card is initially placed in its own pile, and piles are merged
  * pairwise until a single sorted pile remains. Sorting steps are recorded.
  *
  * @param unsorted the pile of cards to be sorted
  * @param record the recorder used to visualize sorting steps
  * @return a new CardPile containing the sorted cards
  */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    record.add(unsorted);
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************
    Iterator<Card> iterator = unsorted.iterator();

    //make each card its own pile and add to queue
    while(iterator.hasNext()){
      Card nextCard = iterator.next();
      CardPile singleCardPile = new CardPile();
      singleCardPile.add(nextCard);
      queue.addLast(singleCardPile);
    }

    //merge piles until only one pile remains
    while(queue.size() > 1){
      //remove first two piles from queue
      CardPile pile1 = queue.remove();
      CardPile pile2 = queue.remove();

      //merge the two piles
      CardPile mergedPile = merge(pile1, pile2);

      //add merged pile back to queue
      queue.addLast(mergedPile);
      //record progress
      record.next();
      record.add(mergedPile);
    }
    // return the sorted result here
    CardPile sortedPile = queue.removeFirst();
    return sortedPile;
  }
    //return queue.remove();

  /**
  * Merges two sorted CardPiles into a single sorted pile.
  *
  * @param leftPile the first sorted pile
  * @param rightPile the second sorted pile
  * @return a merged and sorted CardPile
  */
  public static CardPile merge(CardPile leftPile, CardPile rightPile) {
    CardPile mergedPile = new CardPile();

    while(!leftPile.isEmpty() && !rightPile.isEmpty()) {
      if (leftPile.peek().compareTo(rightPile.peek()) <= 0) {
        mergedPile.add(leftPile.removeFirst());
      } 
      else {
        mergedPile.add(rightPile.removeFirst());
      }
    }
    //add remaining cards from left pile, if any
    while(!leftPile.isEmpty()) {
      mergedPile.add(leftPile.removeFirst());
    }
    //add remaining cards from right pile, if any
    while(!rightPile.isEmpty()) {
      mergedPile.add(rightPile.removeFirst());  
    }
    return mergedPile;
  }

  /**
  * Demonstrates the Merge Sort algorithm by shuffling a deck of cards,
  * sorting them, and displaying the process using a SortRecorder.
  *
  * @param args command-line arguments (not used)
  */
  public static void main(String args[]) {  
      //set up sorting recorder
      SortRecorder recorder = new SortRecorder();

      //load card images
      Card.loadImages(recorder);

      //make deck
      CardPile deck = new CardPile(Card.newDeck(true), 2, 2);

      Collections.shuffle(deck);
      deck = MergeSort.sort(deck, recorder);

      recorder.display("Card Sort Demo: MergeSort");
      
  }
}
