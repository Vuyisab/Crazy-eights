import java.util.*;
public class Game{
	public static void main(String[] args){
      //System.out.println("This program lets you play the simple card game,");
     // System.out.println("guessCraze.  A card is dealt from a pile.");
     // System.out.println("Yah though");
     // System.out.println("higher or lower.  Your score in the game is the");
    //  System.out.println("number of correct predictions you make before");
     // System.out.println("you guess wrong.");
    //  System.out.println();

	Deck2 deck = new Deck2("Deck");
	deck.shuffle();
	
	System.out.println("WELCOME TO THE STREET CRAZY EIGHTS GAME, WE HAVE KEPT MOST OF THE RULES BUT THERE ARE A FEW RULES OMMITED AND ONE ADDED");
	System.out.println("PLAYING AN EIGHT WILL NOT ALLOW YOU TO DO ANYTHING SPECIAL AND YOU ARE ALLOWED TO START OR FINISHT THE GAME BY PLAYING A SPECIAL CARD");
	System.out.println("ALL THE OTHER SPECIAL CARDS DO EXIST HER WITH AN ADDITION OF THE KING ALLOWING YOU TO PLAY AGAIN");
	System.out.println("THE GAME ALLLOWS A TOTAL OF 3 PALYERS, IT SHOWS YOU YOUR HAND AND ON SQUARE BRACKETS THE INDEXES OF EACH CARD");
	System.out.println("YOU MUST PLAY A CARD BY GIVING ITS INDEX TO THE GAME, YOUR CARD MUST MATTCH THE LAST CARD ON THE DISCARD PILE WHIXH WILL BE DISPLAYED");
	System.out.println("FIRST PLAYER TO FINISH THEIR CARDS WINS...GOODLUCK!");
	
	System.out.println();
	int Deal;
	Scanner in = new Scanner(System.in);
	System.out.println("HI, HOW MANY CARDS DO YOU WANT THE GAME TO DEAL TO EACH PLAYE ?: ");
	Deal = in.nextInt();
	
	
	String[] arr = generateName();
	//String name;
	//Scanner in = new Scanner(System.in);
	//System.out.println("Hellow player, what is your name ?: ");
	//name = in.nextLine();
	
	
	
	cardCollection hand = new cardCollection(arr[0]);
	deck.deal(hand,Deal);
	//hand.display();
	//System.out.println(deck.size());
	
	cardCollection hand1 = new cardCollection(arr[1]);
	deck.deal(hand1,Deal);
	
	cardCollection hand2 = new cardCollection(arr[2]);
	deck.deal(hand2,Deal);
	//hand1.display();
	
	//System.out.println(deck.size());
	
	cardCollection discard = new cardCollection("THE DISCARD PILE");
	deck.deal(discard,1);
	//System.out.println(deck.size());
//discard.display();
	
	cardCollection drawpile = new cardCollection("THE DRAWPILE");
	deck.dealAll(drawpile);
	drawpile.shuffle();
	//drawpile.display();
	//System.out.println(deck.size());
	
	
	//System.out.println( displayDiscard(discard));
	
	
	Play(hand , drawpile ,  discard ,hand, hand1,hand2,arr);
	
	ArrayList<cardCollection> players = new ArrayList<cardCollection>();
	players.add(hand);
	players.add(hand1);
	//players.add(hand2);
	
	cardCollection hand3 = hand;
	//System.out.println(hand1 == hand3);
	
	//System.out.println (hand == nextPlayer(hand2, hand , hand1,  hand2));
	
	
	
	}
	public static boolean isKing(Card played){
		if (played.getValue() == 13){
		return true;
		}
		return false;
	}//checks if played card is king
	
	public static boolean isSeven(Card played){
		if (played.getValue() == 7){
			return true;
		}
		return false;
	}//checks if card played is seven
	
	public static boolean isEight(Card played){
		if (played.getValue() == 8){
		return true;	
		}
		return false;
	}//checks if card played is an eight
	
	public static boolean isTwo(Card played){
		if(played.getValue() == 2){
		return true;
		}
		return false;
	}//checks if played card is a two
	
	public static boolean isJump(Card played){
		if(played.getValue() == 11){
		return true;	
		}
		return false;
	}//checks if played card is a jump
	
	public static int Eight(){
		int Response;
		Scanner in = new Scanner(System.in);
		System.out.println("PLease select suit from 0 to 4 where(spades =0; Hearts =1;Diamond =2,Clubs =3");
		Response = in.nextInt();
		
		return Response;
	}
	
	//public static void Special(Card card, Card played){
     //    if (isSeven(played)){
		//	 Reverse
		// }
		
		
	//}//checks for special cards

    public static cardCollection nextPlayer(cardCollection current, cardCollection hand ,cardCollection hand1,cardCollection hand2){
		if(current == hand){
			return hand1;
		}else if (current == hand1) {
		return hand2;
		}
		return hand;

	}//switch from one player to another	
	public static cardCollection takeTwo(cardCollection current, cardCollection hand ,cardCollection hand1,cardCollection hand2,cardCollection drawpile,String[] arr){
		
		
		if(current == hand){
			
			hand1.addCard(drawpile.popCard());
			hand1.addCard(drawpile.popCard());
			System.out.println();
			System.out.println(arr[0] + " PLAYED A TWO, THEREFORE, " + arr[1] +" PICKS UP TWO CARDS!");
			return hand1;
		}else if (current == hand1) {
		hand2.addCard(drawpile.popCard());
		hand2.addCard(drawpile.popCard());
		System.out.println();
		System.out.println(arr[1] + " PLAYED A TWO, THEREFORE, " + arr[2] +" PICKS UP TWO CARDS!");
		return hand2;
		}
		hand.addCard(drawpile.popCard());
		hand.addCard(drawpile.popCard());
		System.out.println();
		System.out.println(arr[2] + " PLAYED A TWO, THEREFORE, " + arr[0] +"  PICKS UP TWO CARDS!");
		return hand;

	}//switch from one player to another
	

	
	 public static cardCollection Again(cardCollection current, cardCollection hand ,cardCollection hand1,cardCollection hand2, String[] arr){
		if(current == hand){
			System.out.println();
			System.out.println(arr[0] + " PLAYED A KING, THEREFORE, " + arr[0] +" CAN PLAY AGAIN!");
			return hand;
		}else if (current == hand1) {
			System.out.println();
			System.out.println(arr[0] + " PLAYED A KING, THEREFORE, " + arr[0] +" CAN PLAY AGAIN!");
		return hand;
		}
		System.out.println();
			System.out.println(arr[0] + " PLAYED A KING, THEREFORE, " + arr[0] +" CAN PLAY AGAIN!");
		return hand2;

	}//switch from one player to another	
	
	  public static cardCollection Jump(cardCollection current, cardCollection hand ,cardCollection hand1,cardCollection hand2,String [] arr){
		  
		if(current == hand){
			System.out.println();
			System.out.println(arr[0] + " PLAYED A J, THEREFORE, " + arr[1] +" HAS BEEN JUMPED");
			return hand2;
		}else if (current == hand1) {
		System.out.println();
		System.out.println(arr[1] + " PLAYED A J, THEREFORE, " + arr[2] +" HAS BEEN JUMPED");
		return hand;
		}
		System.out.println();
		System.out.println(arr[2] + " PLAYED A J, THEREFORE, " + arr[0] +" HAS BEEN JUMPED");
		return hand1;

	}//switch from one player to another
	
	 public static cardCollection Reverse(cardCollection current, cardCollection hand ,cardCollection hand1,cardCollection hand2, String [] arr){
		
		if(current == hand){
			System.out.println();
			System.out.println(arr[0] + " PLAYED A 7, THEREFORE PLAY ORDER HAS BEEN REVERSED");
			return hand2;
		}else if (current == hand1) {
			System.out.println();
			System.out.println(arr[1] + " PLAYED A 7, THEREFORE PLAY ORDER HAS BEEN REVERSED");
		return hand;
		}
		System.out.println();
		System.out.println(arr[2] + " PLAYED A 7, THEREFORE PLAY ORDER HAS BEEN REVERSED");
		return hand1;

	}//switch from one player to another	
	
	

    public static String[] generateName(){
		String[] arr = new String[3];
		String Name;
		for (int i = 0; i < 3; i++){
		System.out.println("HELLO PLAYER, WHAT IS YOUR NAME? : ");
	    Scanner in = new Scanner(System.in);
		Name = in.nextLine();
		
		arr[i] = Name;
		}
     
        return arr;
	}//generates player names	

	
	public int numPlayers(){
		
		int Response;
		System.out.println("High how many players will be playing (1-8)?: ");
		Scanner in = new Scanner(System.in);
		Response = in.nextInt();
		return Response;
		
		
		
	}//returns the number of players
	
	
	
	
	
	
	public static Card Response(Card played,Card table,cardCollection hand,int n,cardCollection deck,cardCollection drawpile){
		int num = drawpile.size();                                                                
		Card card = drawpile.getCard(num-1);
		
		if (isValid(played,table)){
			hand.popCard(n);
			deck.addCard(played);
			return played;
		}
		
		
		hand.addCard(card);
		Card add =drawpile.popCard(n);
		hand.addCard(add);
		return table;
		
		
		
	}
	
	public static boolean isValid(Card played, Card table){
		if(played.getSuit() == table.getSuit() || played.getValue() == table.getValue()){
			return true;
		}
		return false;
	}//checks if the card played is valid
	
	public static boolean isDone(cardCollection player){
    if (player.size() == 0){
		return true;
	}
	return false;
	}//checks if hand is empty
	
	
	
	public static void Play(cardCollection player, cardCollection drawpile, cardCollection discard,cardCollection hand, cardCollection hand1, cardCollection hand2, String[] arr ){
		//player.display();
		//System.out.println();
		//System.out.println("There are " + drawpile.size()+" cards in the drawpile");
		//discard.display();
	
	
		int ans;
	
	while(!isDone(player)){
		//System.out.println(player == hand);
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		player.display();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("THERE ARE " + drawpile.size()+" CARDS IN THE DRAWPILE");
		System.out.println();
		System.out.println();
		System.out.println();
		discard.display();
		
	     System.out.println("PLAY A CARD FROM YOUR HAND BY GIVING ITS INDEX (FOUND ON THE SUARE BRACKETS AT ITS RIGHT): "  );
	     Scanner in = new Scanner(System.in);
	     ans = in.nextInt();
	
	     Card played = player.getCard(ans);
		// special(played);
		 int size = discard.size();
	     Card table = discard.getCard(size-1);
		 
		 Response(played ,table , player , ans , discard , drawpile);
		 
		 if (isSeven(played)&& isValid(played,table)){
			 player = Reverse( player, hand , hand1, hand2,arr);
		 }else if (isJump(played) && isValid(played,table)){
			 player = Jump(player,hand,hand1,hand2,arr);
		 }else if (isKing(played) && isValid(played,table)){
			 System.out.println("YOU PLAYED A KING, PLAY AGAIN");
			 player = Again(player,hand,hand1,hand2,arr);
		 }else if(isTwo(played) && isValid(played,table)){
			 player = takeTwo(player,hand,hand1,hand2,drawpile,arr);
		 }else if(player.size() == 0){
			 System.out.println(" CONGRATULATIONS" + player.getLabel() + ", YOU ARE A CHAMPION!");
		 }else{
			 player = nextPlayer(player,hand,hand1,hand2);
		 }
		 
		 }
		
		 
		 
	}
}
		 
		 //player.display();
	
		 
		 
		 
		 
	
	     //Card Legal = Response(played,table,hand,ans,discard,drawpile);
	
	      //discard.addCard(Response(played,table,hand,ans,discard));
	
	     //hand.display();
	     //discard.display();
	
		
		
		//System.out.println("YOU ARE A CHAMPION!");
		
	
		
	///plays the game
	

	//public Player nextPlayer(Player current){
	//	if(current == one){
		//	return two;
	//	}else{
	//		return one;
	//	}
//}/
	
	
