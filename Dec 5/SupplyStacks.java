/*
 * https://adventofcode.com/2022/day/5
 * 
 * Requires manual pre-processing
 */

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class SupplyStacks {

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 5/input.txt");
        String values = "F H B V R Q D P\n" + 
                        "L D Z Q W V\n" +
                        "H L Z Q G R P C\n" +
                        "R D H F J V B\n" +
                        "Z W L C\n" +       // yes i typed in my stack inputs by hand what are you gonna do about it
                        "J R P N T G V M\n" +
                        "J R L V M B S\n" +
                        "D P J\n" +
                        "D C N W V";
        part1(file, values);
        part2(file, values);
    }

    public static void part1(File file, String values) throws Exception {
        Scanner in = new Scanner(file);
        Scanner stackv = new Scanner(values);
        
        Stack[] stack = new Stack[9];
        for (int i = 0; i < 9; i++) {
            stack[i] = new Stack<>();
        }
        
        for (Stack<String> s : stack) {
            Scanner line = new Scanner(stackv.nextLine());
            while (line.hasNext()) {
                s.add(line.next());
            }
        }
        
        
        for (int i = 1; i <= 10; i++) {
            in.nextLine();
        }
        
        while (in.hasNextLine()) {
            String cmd = in.nextLine();
            cmd = cmd.replaceAll("move", "");
            cmd = cmd.replaceAll("from", "");
            cmd = cmd.replaceAll("to", "");
            Scanner cmdin = new Scanner(cmd);
            int j = Integer.parseInt(cmdin.next());
            int k = Integer.parseInt(cmdin.next());
            int l = Integer.parseInt(cmdin.next());
            
            for (; j > 0; j--) {
                stack[l-1].add(stack[k-1].pop());
            }
        }
        
        for (Stack<String> s : stack) {
            System.out.print(s.pop());
        }
        System.out.println();
    }

    public static void part2(File file, String values) throws Exception {
        Scanner in = new Scanner(file);
        Scanner stackv = new Scanner(values);
        
        Stack[] stack = new Stack[9];
        for (int i = 0; i < 9; i++) {
            stack[i] = new Stack<>();
        }
        
        for (Stack<String> s : stack) {
            Scanner line = new Scanner(stackv.nextLine());
            while (line.hasNext()) {
                s.add(line.next());
            }
        }
        
        
        for (int i = 1; i <= 10; i++) {
            in.nextLine();
        }
        
        while (in.hasNextLine()) {
            String cmd = in.nextLine();
            cmd = cmd.replaceAll("move", "");
            cmd = cmd.replaceAll("from", "");
            cmd = cmd.replaceAll("to", "");
            Scanner cmdin = new Scanner(cmd);
            int j = Integer.parseInt(cmdin.next());
            int k = Integer.parseInt(cmdin.next());
            int l = Integer.parseInt(cmdin.next());
            
            Stack<String> tempStack = new Stack<>();
            for (int h = j; h > 0; h--) {
                tempStack.add((String) stack[k-1].pop());
            }
            
            for (; j > 0; j--) {
                stack[l-1].add(tempStack.pop());
            }
        }
        
        for (Stack<String> s : stack) {
            if (s.size()>0)
                System.out.print(s.pop());
        }
    }
}
