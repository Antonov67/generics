package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Сколько раз сыграем?");
        Computer computer = new Computer(1,10);
        Computer computer2 = new Computer(1,10);
        Human human = new Human();
        Human human2 = new Human();
        // Game game = new Game(in.nextInt(), human, computer);
        // game.gameProcess();
        // System.out.println("Итоговый счет " + game.getScore());
        //компы играют между собой
        UniversGame universGame = new UniversGame(in.nextInt(),computer,computer2);
        universGame.GameProcess();
        System.out.println("Итоговый счет \n" + universGame.getScore());
        //человек играет с компом
        UniversGame universGame2 = new UniversGame(in.nextInt(),computer,human);
        universGame2.GameProcess();
        System.out.println("Итоговый счет \n" + universGame2.getScore());
    }
}
abstract class Gamer{
    abstract int getNumber();
}
class Computer extends Gamer{
    private int a,b;
    public Computer(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getNumber(){
        return (int) (Math.random()*(b-a+1) + a);
    }
}
class Human extends Gamer{
    private int number;
    public int getNumber(){
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        return number;
    }
}
class Game{
    private int count, score=0;
    Human human;
    Computer computer;

    public Game(int count, Human human, Computer computer) {
        this.count = count;
        this.human = human;
        this.computer = computer;
    }

    public int getScore() {
        return score;
    }

    public void gameProcess(){
        for (int i=1;i<=count;i++){
            System.out.println("Введите число от 1 до 10:");
            int r, h;
            r = computer.getNumber();
            h = human.getNumber();
            if (r==h) {
                System.out.println("вы угадали");
                score++;
                System.out.println("счет: " + score);
            }
            else {
                System.out.println("Число введено неверно");
                System.out.println("Я загадал " + r);
            }
        }
    }
}

class UniversGame<G extends Gamer>{
    private int count, score1=0, score2;
    private G gamer1, gamer2;
    public UniversGame(int count,G gamer1, G gamer2){
        this.count = count;
        this.gamer1 = gamer1;
        this.gamer2 = gamer2;
    }
    public void GameProcess(){
        System.out.println("Игра началась");
        for (int i=1;i<=count;i++){
            int g1, g2;
            g1 = gamer1.getNumber();
            g2 = gamer2.getNumber();
            System.out.println("кон " + g1 + " " + g2);
            if (g1==g2) {
                System.out.println("вы угадали");
                score1++;
            }
            else {
                score2++;
                System.out.println("Число введено неверно");
                System.out.println("Я загадал " + g2);
            }
        }
    }
    public String getScore() {
        return "1 игрок " + score1 + "\n" + "2 игрок " + score2;
    }
}
