import java.util.Collections;
import java.util.Iterator;

public class SelectionSortTimer {
  
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
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.out.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      sort(cards);
      
    }
  //  public static void main(String args[]) {
  //   if (args.length < 1) {
  //     System.err.println("Please specify how many cards to sort!");
  //     return;
  //   }

  //   int numCards = Integer.parseInt(args[0]);
  //   Card[] deck = Card.newDeck(true);
  //   CardPile cards = new CardPile();

  //   for (int i = 0; i < numCards; i++) {
  //     cards.add(deck[(int)(52 * Math.random())]);
  //   }

  //   System.out.println("Sorting " + numCards + " cards...");

  //   long startTime = System.currentTimeMillis();

  //   sort(cards);

  //   long endTime = System.currentTimeMillis();
  //   long elapsedMillis = endTime - startTime;

  //   double seconds = elapsedMillis / 1000.0;
  //   double minutes = seconds / 60.0;

  //   System.out.printf("Selection Sort took %.3f seconds (%.2f minutes)%n", seconds, minutes);
  // }

  }

