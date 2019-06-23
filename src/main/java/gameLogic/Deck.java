package gameLogic;

import lombok.Data;

import java.util.*;

@Data
public class Deck{
    private List<Card> deck = new ArrayList<>();
    private static String[] deckRanks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    private String[] deckSuits = {"Cups", "Coins", "Clubs", "Swords"};

    public static Map<String, Integer> getValuesMap() {
        Map<String, Integer> valuesMap = new HashMap<>();
        for (int i = 0, j = 2; i < deckRanks.length && j < 15; i++, j++) {
            valuesMap.put(deckRanks[i], j);
        }
        return valuesMap;
    }

    public Card[] resetDeck() {
        Card[] realDeck = new Card[52];

        for (int u = 0; u < 52; u++) {
            for (int i = 0; i < deckRanks.length; i++) {
                for (int j = 0; j < deckSuits.length; j++) {
                    Card temp = new Card(deckRanks[i], deckSuits[j]);
                    deck.add(temp);
                }
            }
            realDeck[u] = deck.get(u);
        }
        return realDeck;
    }

    public Card[] drawCards(Card[] drawn) {
        Card[] drawnCards = new Card[10];
        List<Integer> col = new ArrayList<>();
        for (int i = 1; i < 52; i++) {
            col.add(i);
        }
        Collections.shuffle(col);
        for (int i = 0; i < 10; i++) {
            int temp = col.get(i);
            drawnCards[i] = drawn[temp];
        }
        return drawnCards;
    }

    public int getScore(Card[] drawn) {
        int score = 0;
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (c.isRoyalFlush(drawn)) {
            score += 800;
        } else if(c.isStraightFlush(drawn)) {
            score += 50;
        } else if(c.isFourOfAKind(drawn)) {
            score += 25;
        } else if(c.isFullHouse(drawn)) {
            score += 9;
        } else if(c.isFlush(drawn)) {
            score += 6;
        } else if(c.isStraight(drawn)) {
            score += 4;
        } else if(c.isThreeOfAKind(drawn)) {
            score += 3;
        } else if(c.isTwoPair(drawn)) {
            score +=2;
        } else if (c.isJacksOrBetter(drawn)) {
            score +=1;
        } else {
            System.out.println("Better luck next time");
        }
        return score;
    }
}
