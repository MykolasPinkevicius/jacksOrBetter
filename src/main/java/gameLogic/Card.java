package gameLogic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {
    private String value;
    private String suit;
}