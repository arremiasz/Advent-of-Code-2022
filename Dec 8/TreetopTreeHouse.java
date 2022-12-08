/*
 * https://adventofcode.com/2022/day/8
 * this code is most inefficient :)
 */

import java.io.File;
import java.util.Scanner;

public class TreetopTreeHouse {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 8/input.txt");
        part1(file);
        part2(file);
    }
    
    public static void part1(File file) throws Exception {
        Scanner in = new Scanner(file);
        int rows = in.nextLine().length();
        int col = 1;
        while (in.hasNextLine()) {
            in.nextLine();
            col++;
        }
        in = new Scanner(file);
        
        int[][] input = new int[rows][col];
        for (int i = 0; i < rows; i++) {
            String line = in.nextLine();
            for (int j = 0; j < col; j++) {
                input[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        
        in = new Scanner(file);
        int visible = rows + (col-1) + (rows-1) + (col-2);
        for (int i = 1; i < rows-1; i++) {
            for (int j = 1; j < col-1; j++) {
                boolean v = false;
                // check north
                for (int s = i-1; s >= 0; s--) {
                    if (input[i][j] > input[s][j]) {
                        v = true;
                        
                    }
                    if (input[i][j] == input[s][j]) {
                        v = false;
                        break;
                    }
                    if (input[i][j] < input[s][j]) {
                        v = false;
                        break;
                    }
                }
                
                if (v) {
                    visible++;
                    continue;
                }
                
                // check south
                for (int s = i+1; s < col; s++) {
                    if (input[i][j] > input[s][j]) {
                        v = true;
                    }
                    if (input[i][j] == input[s][j]) {
                        v = false;
                        break;
                    }
                    if (input[i][j] < input[s][j]) {
                        v = false;
                        break;
                    }
                }
                
                
                if (v) {
                    visible++;
                    continue;
                }
                
                // check east
                for (int s = j+1; s < rows; s++) {
                    if (input[i][j] > input[i][s]) {
                        v = true;
                    }
                    if (input[i][j] == input[i][s]) {
                        v = false;
                        break;
                    }
                    if (input[i][j] < input[i][s]) {
                        v = false;
                        break;
                    }
                }
                
                if (v) {
                    visible++;
                    continue;
                }
                
                // check west
                for (int s = j-1; s >= 0; s--) {
                    if (input[i][j] > input[i][s]) {
                        v = true;
                    }
                    if (input[i][j] == input[i][s]) {
                        v = false;
                        break;
                    }
                    if (input[i][j] < input[i][s]) {
                        v = false;
                        break;
                    }
                }
                
                if (v) {
                    visible++;
                    continue;
                }
                
            }
        }
        
        System.out.println(visible);
    }

    public static void part2(File file) throws Exception {
        Scanner in = new Scanner(file);
        int rows = in.nextLine().length();
        int col = 1;
        while (in.hasNextLine()) {
            in.nextLine();
            col++;
        }
        in = new Scanner(file);
        
        int[][] input = new int[rows][col];
        for (int i = 0; i < rows; i++) {
            String line = in.nextLine();
            for (int j = 0; j < col; j++) {
                input[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        
        in = new Scanner(file);
        int high = 0;
        for (int i = 1; i < rows-1; i++) {
            for (int j = 1; j < col-1; j++) {
                int temp = 0;
                int visible = 1;
                // check north
                for (int s = i-1; s >= 0; s--) {
                    if (input[i][j] > input[s][j]) {
                        temp++;
                    }
                    if (input[i][j] == input[s][j]) {
                        temp++;
                        break;
                    }
                    if (input[i][j] < input[s][j]) {
                        temp++;
                        break;
                    }
                }
                visible = visible * temp;
                temp = 0;
                
               
                
                // check south
                for (int s = i+1; s < col; s++) {
                    if (input[i][j] > input[s][j]) {
                        temp++;
                    }
                    if (input[i][j] == input[s][j]) {
                        temp++;
                        break;
                    }
                    if (input[i][j] < input[s][j]) {
                        temp++;
                        break;
                    }
                }
                visible = visible * temp;
                temp = 0;
                
                
                // check east
                for (int s = j+1; s < rows; s++) {
                    if (input[i][j] > input[i][s]) {
                        temp++;
                    }
                    if (input[i][j] == input[i][s]) {
                        temp++;
                        break;
                    }
                    if (input[i][j] < input[i][s]) {
                        temp++;
                        break;
                    }
                }
                visible = visible * temp;
                temp = 0;
                
                
                // check west
                for (int s = j-1; s >= 0; s--) {
                    if (input[i][j] > input[i][s]) {
                        temp++;
                    }
                    if (input[i][j] == input[i][s]) {
                        temp++;
                        break;
                    }
                    if (input[i][j] < input[i][s]) {
                        temp++;
                        break;
                    }
                }
                visible = visible * temp;
                temp = 0;
                 
                if (visible > high) high = visible;
            }
        }
        
        System.out.println(high);
    }
}
