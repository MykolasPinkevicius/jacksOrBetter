package gameLogic;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
public class CombinationCheckerImpl implements CombinationChecker {
    @Override
    public boolean isRoyalFlush(Card[] drawn) {
        List<Integer> temp = new ArrayList<>();
        Map<String, Integer> valuesMap = Deck.getValuesMap();
        for (int i = 0; i < 5; i++) {
            String suit = drawn[0].getSuit();
            temp.add(valuesMap.get(drawn[i].getValue()));
            if (!suit.equals(drawn[i].getSuit())) {
                return false;
            }
        }
        Collections.sort(temp);
        List<Integer> royalFlushList = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            royalFlushList.add(i);
        }
        if (temp.equals(royalFlushList)) {
            System.out.println("--------------------");
            System.out.println("You've got a Royal Flush!!! Lucky Winner of 800 score!");
            System.out.println("--------------------");
        }
        return temp.equals(royalFlushList);
    }

    @Override
    public boolean isStraightFlush(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c.isRoyalFlush(drawn)) {
            String suit = drawn[0].getSuit();
            List<Integer> temp = new ArrayList<>();
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
                if (!suit.equals(drawn[i].getSuit())) {
                    return false;
                }
            }
            Collections.sort(temp);
            int straightSteps = 0;
            for (int i = 0; i < 4; i++) {
                if (!temp.get(i + 1).equals(temp.get(i) + 1)) {
                    return false;
                } else {
                    straightSteps++;
                }
                if (straightSteps >= 4) {
                    System.out.println("--------------------");
                    System.out.println("You've got a Straight Flush!");
                    System.out.println("--------------------");
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFourOfAKind(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c.isRoyalFlush(drawn) || !c.isStraightFlush(drawn)) {
            int repeatedNumbers = 0;
            List<Integer> temp = new ArrayList<>();
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
            }
            for (int i = 0; i < 5; i++) {
                repeatedNumbers = 0;
                for (int j = 0; j < 5; j++) {
                    if (temp.get(i).equals(temp.get(j))) {
                        repeatedNumbers++;
                        if (repeatedNumbers >= 4) {
                            System.out.println("--------------------");
                            System.out.println("You've got a Four of a Kind!");
                            System.out.println("--------------------");
                            return true;
                        }
                    }
                }

            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFullHouse(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c.isFourOfAKind(drawn) || !c.isStraightFlush(drawn) || !c.isRoyalFlush(drawn)) {
            int repeatedNumbers = 0;
            int repeatedReverseNumbers = 0;
            List<Integer> temp = new ArrayList<>();
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
            }
            Collections.sort(temp);
            for(int i = 0, k = 4; i < 1 && k > 3; i++, k--) {
                repeatedNumbers = 0;
                repeatedReverseNumbers = 0;
                for (int j = 0; j < 5; j++) {
                    if (temp.get(i).equals(temp.get(j))){
                        repeatedNumbers++;
                    }
                    if (temp.get(k).equals(temp.get(j))) {
                        repeatedReverseNumbers++;
                    }
                    if ((repeatedNumbers >= 2 && repeatedReverseNumbers >= 3) || (repeatedNumbers >= 3 && repeatedReverseNumbers >= 2)) {
                        System.out.println("--------------------");
                        System.out.println("You've got a Full House!");
                        System.out.println("--------------------");
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFlush(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c.isFullHouse(drawn) || !c.isFourOfAKind(drawn) || !c.isStraightFlush(drawn) || !c.isRoyalFlush(drawn)) {
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            String suit = drawn[0].getSuit();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
                if (!suit.equals(drawn[i].getSuit())) {
                    return false;
                }
            }
            System.out.println("--------------------");
            System.out.println("You've got a Flush!");
            System.out.println("--------------------");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isStraight(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c. isFlush(drawn) || !c.isFullHouse(drawn) || !c.isFourOfAKind(drawn) || !c.isStraightFlush(drawn) || !c.isRoyalFlush(drawn)) {
            List<Integer> temp = new ArrayList<>();
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
            }
            Collections.sort(temp);
            int straightSteps = 0;
            for (int i = 0; i < 4; i++) {
                if (!temp.get(i + 1).equals(temp.get(i) + 1)) {
                    return false;
                } else {
                    straightSteps++;
                }
                if (straightSteps >= 4) {
                    System.out.println("--------------------");
                    System.out.println("You've got a Straight!");
                    System.out.println("--------------------");
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean isThreeOfAKind(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c.isStraight(drawn) || !c. isFlush(drawn) || !c.isFullHouse(drawn) || !c.isFourOfAKind(drawn) || !c.isStraightFlush(drawn) || !c.isRoyalFlush(drawn)) {
            int repeatedNumbers = 0;
            List<Integer> temp = new ArrayList<>();
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
            }
            for (int i = 0; i < 5; i++) {
                repeatedNumbers = 0;
                for (int j = 0; j < 5; j++) {
                    if (temp.get(i).equals(temp.get(j))) {
                        repeatedNumbers++;
                        if (repeatedNumbers >= 3) {
                            System.out.println("--------------------");
                            System.out.println("You've got a Three of a Kind!");
                            System.out.println("--------------------");
                            return true;
                        }
                    }
                }

            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean isTwoPair(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c.isThreeOfAKind(drawn) || !c.isStraight(drawn) || !c. isFlush(drawn) || !c.isFullHouse(drawn) || !c.isFourOfAKind(drawn) || !c.isStraightFlush(drawn) || !c.isRoyalFlush(drawn)) {
            int repeatedNumbers = 0;
            int repeatedReverseNumbers = 0;
            List<Integer> temp = new ArrayList<>();
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
            }
            for(int i = 0, k = 4; i < 3 && k > 2; i++, k--) {
                repeatedNumbers = 0;
                repeatedReverseNumbers = 0;
                for (int j = 0; j < 5; j++) {
                    if (temp.get(i).equals(temp.get(j))){
                        repeatedNumbers++;
                    }
                    if (temp.get(k).equals(temp.get(j))) {
                        repeatedReverseNumbers++;
                    }
                    if ((repeatedNumbers >= 2 && repeatedReverseNumbers >= 2)) {
                        System.out.println("--------------------");
                        System.out.println("You've got a Two Pair!");
                        System.out.println("--------------------");
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean isJacksOrBetter(Card[] drawn) {
        CombinationCheckerImpl c = new CombinationCheckerImpl();
        if (!c.isThreeOfAKind(drawn) || !c.isStraight(drawn) || !c. isFlush(drawn) || !c.isFullHouse(drawn) || !c.isFourOfAKind(drawn) || !c.isStraightFlush(drawn) || !c.isRoyalFlush(drawn) || !c.isTwoPair(drawn)) {
            Map<String, Integer> valuesMap = Deck.getValuesMap();
            int repeatedNumbers = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                temp.add(valuesMap.get(drawn[i].getValue()));
            }
            for (int i = 0; i < 5; i++) {
                repeatedNumbers = 0;
                for (int j = 0; j < 5; j++) {
                    if (temp.get(i).equals(temp.get(j)) && temp.get(i) > 10) {
                        repeatedNumbers++;
                        if (repeatedNumbers >= 2) {
                            System.out.println("--------------------");
                            System.out.println("Jacks and Better!");
                            System.out.println("--------------------");
                            return true;
                        }
                    }
                }

            }
            return false;
        } else {
            return false;
        }
    }
}
