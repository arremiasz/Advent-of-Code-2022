/*
 * https://adventofcode.com/2022/day/2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 2/input.txt");
        part1(file);
        part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        int score = 0;
        while (in.hasNext()) {
            int round = 0;
            String opponent = in.next();
            String you = in.next();
            // if opponent is rock
            if (opponent.equals("A")) {
                // rock + rock
                if (you.equals("X")) round += 1+3;
                // rock + paper
                else if (you.equals("Y")) round += 2+6;
                // rock + scissors
                else if (you.equals("Z")) round += 3;
            } // if opponent is paper
            else if (opponent.equals("B")) {
                // paper + rock
                if (you.equals("X")) round += 1;
                // paper + paper
                else if (you.equals("Y")) round += 2+3;
                // paper + scissors
                else if (you.equals("Z")) round += 3+6;
            } // if opponent is scissors
            else if (opponent.equals("C")) {
                // scissors + rock
                if (you.equals("X")) round += 1+6;
                // scissors + paper
                else if (you.equals("Y")) round += 2;
                // scissors + scissors
                else if (you.equals("Z")) round += 3+3;
            }

            score += round;
        }
        in.close();
        System.out.println(score);
    }


    public static void part2(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        int score = 0;
        while (in.hasNext()) {
            int round = 0;
            String opponent = in.next();
            String you = in.next();
            // if opponent is rock
            if (opponent.equals("A")) {
                // you need to lose choose scissors
                if (you.equals("X")) round += 3;
                // you need to draw choose rock
                else if (you.equals("Y")) round += 1+3;
                // you need to win choose paper
                else if (you.equals("Z")) round += 2+6;
            } // if opponent is paper
            else if (opponent.equals("B")) {
                // you need to lose choose rock
                if (you.equals("X")) round += 1;
                // you need to draw choose paper
                else if (you.equals("Y")) round += 2+3;
                // you need to win choose scissors
                else if (you.equals("Z")) round += 3+6;
            } // if opponent is scissors
            else if (opponent.equals("C")) {
                // you need to lose choose paper
                if (you.equals("X")) round += 2;
                // you need to draw choose scissors
                else if (you.equals("Y")) round += 3+3;
                // you need to win choose rock
                else if (you.equals("Z")) round += 1+6;
            }

            score += round;
        }
        in.close();
        System.out.println(score);
    }
}
