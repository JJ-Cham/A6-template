import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;

public class MergeSortTimer{
  
  public static CardPile sort(CardPile unsorted) {
    
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
    }
    // return the sorted result here
    CardPile sortedPile = queue.removeFirst();
    return sortedPile;
  }
    //return queue.remove();

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
  


