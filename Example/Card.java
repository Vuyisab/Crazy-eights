/**
	 * We got this card class from http://math.hws.edu/javanotes/c5/s4.html
     * Creates a card with a specified suit and value.
     
     */

public class Card {

    public final static int SPADES = 0;   
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public final static int ACE = 1;      
    public final static int JACK = 11;    
    public final static int QUEEN = 12;   
    public final static int KING = 13;

    
    private final int suit; 

    
    private final int value;

  
    public Card() {
        suit = JOKER;
        value = 1;
    }//Constructor

    /**
	 * We got this from http://math.hws.edu/javanotes/c5/s4.html
     * Creates a card with a specified suit and value.
     
     */
    public Card(int theValue, int theSuit) {
        if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && 
                theSuit != CLUBS && theSuit != JOKER)
            throw new IllegalArgumentException("Illegal playing card suit");
        if (theSuit != JOKER && (theValue < 1 || theValue > 13))
            throw new IllegalArgumentException("Illegal playing card value");
        value = theValue;
        suit = theSuit;
    }
	public boolean isRank(Card that){
		return this.value == that.value;
	}//compares ranks
	
	public boolean isSuit(Card that){
		return this.suit == that.suit;
	}//compares suits
	
	public boolean equals(Card that){
		return this.value == that.value && this.suit == that.suit;
		
	}//

    /**
     * Returns the suit of this card.
     * @returns the suit, which is one of the constants Card.SPADES, 
     * Card.HEARTS, Card.DIAMONDS, Card.CLUBS, or Card.JOKER
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the value of this card.
     * @return the value, which is one of the numbers 1 through 13, inclusive for
     * a regular card, and which can be any value for a Joker.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a String representation of the card's suit.
     * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
     * or "Joker".
     */
    public String getSuitAsString() {
        switch ( suit ) {
        case SPADES:   return "Spades";
        case HEARTS:   return "Hearts";
        case DIAMONDS: return "Diamonds";
        case CLUBS:    return "Clubs";
        default:       return "Joker";
        }
    }

    /**
     * Returns a String representation of the card's value.
     * @return for a regular card, one of the strings "Ace", "2",
     * "3", ..., "10", "Jack", "Queen", or "King".  For a Joker, the 
     * string is always numerical.
     */
    public String getValueAsString() {
        if (suit == JOKER)
            return "" + value;
        else {
            switch ( value ) {
            case 1:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case 11:  return "Jack";
            case 12:  return "Queen";
            default:  return "King";
            }
        }
    }

    /**
     * Returns a string representation of this card, including both
     * its suit and its value (except that for a Joker with value 1,
     * the return value is just "Joker").  Sample return values
     * are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades",
     * "Joker", "Joker #2"
     */
    public String toString() {
        if (suit == JOKER) {
            if (value == 1)
                return "Joker";
            else
                return "Joker #" + value;
        }
        else
            return getValueAsString() + " of " + getSuitAsString();
    }
    
	

} // end class Card
