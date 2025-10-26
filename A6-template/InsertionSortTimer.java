import java.util.Collections;
import java.util.Iterator;

public class InsertionSortTimer {
  
  public static CardPile sort(CardPile unsorted) {
    
    // register the starting configuration with the recorder
    //record.add(unsorted);

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
      //record.next();
      //record.add(sorted);
      //record.add(unsorted);
    }
    // return the sorted result here
    return sorted;
  }

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

