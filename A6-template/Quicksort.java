import java.util.Collections;

/**
 * Implements the Quicksort algorithm for sorting a pile of cards.
 * Uses a SortRecorder to visualize each step of the recursive sorting process.
 */
public class Quicksort {
  /**
  * Recursively sorts a given CardPile using the Quicksort algorithm.
  * A pivot is selected, and the pile is partitioned into smaller and bigger piles.
  * Sorting steps and partitions are recorded for visualization.
  *
  * @param unsorted the pile of cards to be sorted
  * @param record the recorder used to visualize sorting steps
  * @return a new CardPile containing the sorted cards
  */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    //reursion
    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    if(unsorted.size()<=1){
      return unsorted; //base case, basically already sorted
    }
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.removeFirst();  // edit this!
    
    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************
    while(unsorted.size()>0){
      Card nextCard = unsorted.removeFirst();
      if(nextCard.compareTo(pivot) < 0){
        smaller.addLast(nextCard);
      }
      else{
        bigger.addLast(nextCard);
      }
    }

    //recursive calls
    CardPile sortedSmaller = sort(smaller, record);
    CardPile sortedBigger = sort(bigger, record);

    //result 
    CardPile resultPile = new CardPile();

    //add all the sorted piles
    resultPile.addAll(sortedSmaller);
    resultPile.addLast(pivot);
    resultPile.addAll(sortedBigger);

    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }

  /**
  * Demonstrates the Quicksort algorithm by shuffling a deck of cards,
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
      deck = Quicksort.sort(deck, recorder);

      //show the sorting process
      recorder.display("Card Sort Demo: Quicksort");
  }
}
