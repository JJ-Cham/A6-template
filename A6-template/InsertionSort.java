import java.util.Collections;
import java.util.Iterator;

/**
 * Implements the Insertion Sort algorithm for sorting a pile of cards.
 * Uses a SortRecorder to visualize each step of the sorting process.
 */
public class InsertionSort {
  
  /**
  * Sorts a given CardPile using the Insertion Sort algorithm.
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
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:

    // ***********************************************************
    while(unsorted.size()>0){

      //taking a card from unsorted pile
      Card nextCard = unsorted.removeFirst();

      //find where it should go in sorted pile
      int insertIndex = 0;
      Iterator<Card> iterator = sorted.iterator();
      while(iterator.hasNext()){
        Card currentCard = iterator.next();
        if(nextCard.compareTo(currentCard) < 0){
          //stop when we find a card larger than nextCard
          break;
      }
        insertIndex++; //move to next index
      }
      //insert the card into sorted pile at the correct index
      sorted.add(insertIndex, nextCard);

      // record progress
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }
    // return the sorted result here
    return sorted;
  }

  /**
  * Demonstrates the Insertion Sort algorithm by shuffling a deck of cards,
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
      CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

      Collections.shuffle(cards);
      cards = InsertionSort.sort(cards, recorder);

     recorder.display("Card Sort Demo: InsertionSort");
      
  }
}
