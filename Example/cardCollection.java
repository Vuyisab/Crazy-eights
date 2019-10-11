import java.util.*;
public class cardCollection{
	private String label;
	private  ArrayList<Card> cards;//this cards is a list of Card objects
	
	public cardCollection(String label){
	this.label = label;
    this.cards = new ArrayList<Card>();	
	}//constructor
	
	public void addCard(Card card){
		this.cards.add(card);
	}//adds a card to list
	
	public ArrayList<Card> getCards(){
		return this.cards;
	}//gets arraylist of cards
	
	/*
	this method is from the think java textbook
	*/
	public Card popCard(int i){
		return cards.remove(i);
	}//removes card at index i
	
	public int size(){
		return cards.size();
	}//returns list size
	
	/*
	this method is from the think java textbook
	*/
	public Card popCard(){
		int i = size() - 1;
		return popCard(i);
	}//removes and returns last card
	
	public boolean empty(){
		return cards.size() ==0;
	}//checks emptiness of list
	/*
	this method is from the think java textbook
	*/
	public void deal(cardCollection that, int n){
		for (int i = 0; i < n;i++){
			Card card = popCard();//takes last card in the list
			that.addCard(card);
			
		}
	}//deals card from called Card list to the collection in the parameter
	
	public void dealAll(cardCollection that){
		int n = size();
		deal(that,n);
	}//moves remaining cards to the given collection
	
	public Card getCard(int i ){
		return cards.get(i);//ArrayList method
	}//gets single card from a specific list of cards
	
//	public int getIndex(){
		
	//}//returns index
	
	public String getLabel(){
		return this.label;
	}
	
	public void swapCards(int i, int j){
		Card temp = cards.get(i);
		cards.set(i,cards.get(j));
		cards.set(j,temp);
	}//swaps cards

	public void shuffle(){
		Random random = new Random();
		for(int i = size()-1;i>0;i--){
			int j = random.nextInt(i);
			swapCards(i,j);
		}
	}//implements a shuffle
	
	/*
	this method is from the think java textbook
	*/
	public void display(){
		System.out.println(getLabel() + ": ");
		for (int i = 0; i < size(); i++){
			System.out.println(getCard(i)+ "[ " +i+"]");
			//System.out.println
		}
		System.out.println();
		
		
		
	}//displays hand of cards
}