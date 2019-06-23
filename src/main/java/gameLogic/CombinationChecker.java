package gameLogic;

public interface CombinationChecker {
    public boolean isRoyalFlush(Card[] drawn);
    public boolean isStraightFlush(Card[] drawn);
    public boolean isFourOfAKind(Card[] drawn);
    public boolean isFullHouse(Card[] drawn);
    public boolean isFlush(Card[] drawn);
    public boolean isStraight(Card[] drawn);
    public boolean isThreeOfAKind(Card[] drawn);
    public boolean isTwoPair(Card[] drawn);
    public boolean isJacksOrBetter(Card[] drawn);
}
