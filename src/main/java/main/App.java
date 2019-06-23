package main;

import gameLogic.Game;
import gameLogic.Player;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to virtual 'Jacks and Better' console video game");
        System.out.println("--------------------");
        System.out.println("Insert 1 score credit and start playing");
        System.out.println("--------------------");
        System.out.println("Please input your Player name");
        System.out.println("--------------------");
        String name = sc.nextLine();
        Game g = new Game();
        Player p = new Player(0, name);
        g.play(p, sc);
    }
}
