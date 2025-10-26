import java.util.Collections;

public class QuicksortTimer {
  
  public static CardPile sort(CardPile unsorted) {
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
    CardPile sortedSmaller = sort(smaller);
    CardPile sortedBigger = sort(bigger);

    //result 
    CardPile resultPile = new CardPile();

    //add all the sorted piles
    resultPile.addAll(sortedSmaller);
    resultPile.addLast(pivot);
    resultPile.addAll(sortedBigger);

    
    // return the sorted result here
    return result;
  }
  /** Starts the program running */
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      sort(cards);
      
    }
} 
}

