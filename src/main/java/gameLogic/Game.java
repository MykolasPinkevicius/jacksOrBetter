package gameLogic;

import lombok.Data;

import java.util.Scanner;

@Data
public class Game {
    private boolean isOn = false;

    public Card[] draw() {

        return null;
    }

    public void play(Player player, Scanner sc) {
        isOn = true;
        int choice = 0;
        while (isOn) {
            System.out.println("--------------------");
            System.out.println("Select 1 to Start game");
            System.out.println("Select 2 to Change name");
            System.out.println("Select 3 to View score");
            System.out.println("Select 4 to Exit gameLogic");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    int weRollingBaby = 0;
                    while(weRollingBaby == 0) {
                        player.setScore(player.getScore()-1);
                        System.out.println("--------------------");
                        System.out.println("One score token taken");
                        System.out.println("--------------------");
                        System.out.println("Drawing five cards");
                        System.out.println("--------------------");
                        Deck d = new Deck();
                        Card[] drawn = d.drawCards(d.resetDeck());
                        System.out.println("--------------------");
                        System.out.println("We drawn");
                        System.out.println("--------------------");
                        for (int i = 0; i < 5; i++) {
                            System.out.println(drawn[i].getValue() + " of " + drawn[i].getSuit());
                        }
                        System.out.println("--------------------");
                        System.out.println("Select which cards you want to keep");
                        System.out.println("Just type true or false");
                        System.out.println("--------------------");
                        Boolean[] bool = new Boolean[5];
                        String[] str = new String[5];

                        System.out.println("First :");
                        str[0] = sc.nextLine();
                        str[0] = sc.nextLine();
                        if (str[0].toLowerCase().equals("true") || str[0].toLowerCase().equals("false")) {
                            bool[0] = Boolean.valueOf(str[0]);
                        } else {
                            System.out.println("False input, please input true or false");
                            str[0] = sc.nextLine();
                            bool[0] = Boolean.valueOf(str[0]);
                        }
                        System.out.println("Second :");
                        str[1] = sc.nextLine();
                        if (str[1].toLowerCase().equals("true") || str[1].toLowerCase().equals("false")) {
                            bool[1] = Boolean.valueOf(str[1]);
                        } else {
                            System.out.println("False input, please input true or false");
                            str[1] = sc.nextLine();
                            bool[1] = Boolean.valueOf(str[1]);
                        }
                         System.out.println("Third :");
                        str[2] = sc.nextLine();
                        if (str[2].toLowerCase().equals("true") || str[2].toLowerCase().equals("false")) {
                            bool[2] = Boolean.valueOf(str[2]);
                        } else {
                            System.out.println("False input, please input true or false");
                            str[2] = sc.nextLine();
                            bool[2] = Boolean.valueOf(str[2]);
                        }
                        System.out.println("Fourth :");
                        str[3] = sc.nextLine();
                        if (str[3].toLowerCase().equals("true") || str[3].toLowerCase().equals("false")) {
                            bool[3] = Boolean.valueOf(str[3]);
                        } else {
                            System.out.println("False input, please input true or false");
                            str[3] = sc.nextLine();
                            bool[3] = Boolean.valueOf(str[3]);
                        }
                        System.out.println("Fifth :");
                        str[4] = sc.nextLine();
                        if (str[4].toLowerCase().equals("true") || str[4].toLowerCase().equals("false")) {
                            bool[4] = Boolean.valueOf(str[4]);
                        } else {
                            System.out.println("False input, please input true or false");
                            str[4] = sc.nextLine();
                            bool[4] = Boolean.valueOf(str[4]);
                        }
                        for (int i = 0, j = 5; i < 5 && j < 10; i++, j++) {
                            if (bool[i]) {
                                drawn[i] = drawn[i];
                            } else {
                                drawn[i] = drawn[j];
                            }
                        }
                        System.out.println("--------------------");
                        System.out.println("We drawn");
                        System.out.println("--------------------");
                        for (int i = 0; i < 5; i++) {
                            System.out.println( drawn[i].getValue() +" of " + drawn[i].getSuit());
                        }

                        player.setScore(player.getScore() + d.getScore(drawn));
                        System.out.println("--------------------");
                        System.out.println("Player " + player.getName() + " total score is " + player.getScore());
                        System.out.println("--------------------");
                        System.out.println("--------------------");
                        System.out.println("Do you want to play more?");
                        System.out.println("Yes for repeat, no for exit");
                        System.out.println("--------------------");
                        String keepPlaying = sc.nextLine().toLowerCase();
                        if (keepPlaying.equals("yes")) {
                            weRollingBaby = 0;
                        } else {
                            weRollingBaby = 1;
                        }
                        System.out.println("--------------------");
                    }
                    break;

                case 2:
                    String newName;
                    System.out.println("What is your new name");
                    newName = sc.nextLine();
                    newName = sc.nextLine();
                    player.setName(newName);
                    System.out.println("Your new name is " + player.getName());
                    break;
                case 3:
                    System.out.println(player.getName() + " score is " + player.getScore());
                    break;
                case 4:
                    isOn = false;
            }
        }
    }

}
