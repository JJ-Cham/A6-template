import java.util.Collections;
import java.util.Iterator;

public class InsertionSortTimer {
  
  public static CardPile sort(CardPile unsorted) {

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
    }
    // return the sorted result here
    return sorted;
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

