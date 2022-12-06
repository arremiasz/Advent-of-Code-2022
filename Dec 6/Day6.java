/*
 * https://adventofcode.com/2022/day/6
 */

import java.io.File;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 6/input.txt");
        part1(file);
        part2(file);
    }
    
    public static void part1(File file) throws Exception {
        Scanner in = new Scanner(file);
        String line = in.nextLine();
        
        for (int i = 0; i < line.length(); i++) {
            String[] characters = new String[4];
            for (int j = 0; j < 4; j++) {
                characters[j] = line.substring(i+j, i+j+1);
            }
            
            if (!checkForDuplicates(characters)) {
                System.out.println(i+4);
                break;
            }
        }
    }

    public static void part2(File file) throws Exception {
        Scanner in = new Scanner(file);
        String line = in.nextLine();
        
        for (int i = 0; i < line.length(); i++) {
            String[] characters = new String[14];
            for (int j = 0; j < 14; j++) {
                characters[j] = line.substring(i+j, i+j+1);
            }
            
            if (!checkForDuplicates(characters)) {
                System.out.println(i+14);
                break;
            }
            
        }
    }
    
    private static boolean checkForDuplicates(String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] != null && array[i].equals(array[j])) {
                    return true;
                }
            }
        }
     
        return false;
    }
}
