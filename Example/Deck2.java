import java.util.*;
public class Deck2 extends cardCollection{
	public Deck2(String label){
		super(label);//calling the super class and its attributes(cardCollection)
		
		for (int suit = 0; suit <= 3; suit ++){
			for (int rank = 1; rank <=13; rank++){
				getCards().add(new Card(rank,suit));//we keep on adding new card objects
			}
		}//populating it with 52 cards
		
	}//returns a deck of 52 cards
	
	
}