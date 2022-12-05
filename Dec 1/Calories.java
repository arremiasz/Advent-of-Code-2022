/*
 * https://adventofcode.com/2022/day/1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Calories {

    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 1/input.txt");
        Scanner in = new Scanner(file);
        int biggest = 0;
        while (in.hasNextLine()) {
            int sum = 0;
            String n = in.nextLine();
            do {
                sum += Integer.parseInt(n);
                if (in.hasNextLine())
                    n = in.nextLine();
                else break;
            }
            while (!n.equals(""));
            if (sum > biggest) biggest = sum;
        }
        in.close();
        System.out.println(biggest);
    }

    public static void part2() throws FileNotFoundException {
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 1/input.txt");
        Scanner in = new Scanner(file);
        int biggest = 0;
        int second = 0;
        int third = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNextLine()) {
            int sum = 0;
            String n = in.nextLine();
            do {
                sum += Integer.parseInt(n);
                if (in.hasNextLine())
                    n = in.nextLine();
                else break;
            }
            while (!n.equals(""));
            list.add(sum);
            if (sum > biggest) biggest = sum;
            else if (sum > second) second = sum;
            else if (sum > third) third = sum;
        }
        list.sort(null);
        biggest = list.get(list.size()-1);
        second = list.get(list.size()-2);
        third = list.get(list.size()-3);

        in.close();
        System.out.print(biggest+second+third);
    }

}
