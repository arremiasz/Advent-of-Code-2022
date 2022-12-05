/*
 * https://adventofcode.com/2022/day/4
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CampCleanup {

    public static void main (String[] args) throws Exception {
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 4/input.txt");
        part1(file);
        part2(file);
    }
    
    public static void part1(File file) throws Exception  {
        String line = "";
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            line = line + in.nextLine() + "\n";
        }
        line = line.replaceAll("-", " ");
        line = line.replaceAll(",", " , ");
        int pairs = 0;
        in = new Scanner(line);
        while (in.hasNextLine()) {
            ArrayList<Integer> pair1 = new ArrayList<>();
            ArrayList<Integer> pair2 = new ArrayList<>();
            
            Scanner nextline = new Scanner(in.nextLine());
            String next = nextline.next();
            while (!next.equals(",")) {
                pair1.add(Integer.parseInt(next));
                next = nextline.next();
            } 
            do {
                next = nextline.next();
                pair2.add(Integer.parseInt(next));
            }
            while (nextline.hasNext());
           
            
            if ((pair2.get(0) >= pair1.get(0) && pair2.get(1) <= pair1.get(1)) || 
                (pair1.get(0) >= pair2.get(0) && pair1.get(1) <= pair2.get(1))) {
                pairs++;
            }
            
            
        }
        System.out.println(pairs);
    }

    public static void part2(File file) throws Exception  {
        String line = "";
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            line = line + in.nextLine() + "\n";
        }
        line = line.replaceAll("-", " ");
        line = line.replaceAll(",", " , ");
        int pairs = 0;
        in = new Scanner(line);
        while (in.hasNextLine()) {
            ArrayList<Integer> pair1 = new ArrayList<>();
            ArrayList<Integer> pair2 = new ArrayList<>();
            
            Scanner nextline = new Scanner(in.nextLine());
            String next = nextline.next();
            while (!next.equals(",")) {
                pair1.add(Integer.parseInt(next));
                next = nextline.next();
            } 
            do {
                next = nextline.next();
                pair2.add(Integer.parseInt(next));
            }
            while (nextline.hasNext());
           
            
            if ((pair2.get(0) >= pair1.get(0) && pair2.get(0) <= pair1.get(1)) || 
                (pair1.get(0) >= pair2.get(0) && pair1.get(0) <= pair2.get(1))) {
                pairs++;
            }
            
            
        }
        System.out.println(pairs);
    }
}
