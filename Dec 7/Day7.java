/*
 * https://adventofcode.com/2022/day/7
 */

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 7/input.txt");
        part1(file);
        part2(file);
    }
    
    static long sum1 = 0;
    public static void part1(File file) throws Exception {
        Scanner in = new Scanner(file);
        
        Tree dir = new Tree("/", null, "root");
        
        boolean defined = false;
        String temp = "";
        while (in.hasNextLine()) {
            String l = temp;
            if (!defined) {
                l = in.nextLine();
            } defined = false;
            Scanner line = new Scanner(l);
            String cmd = line.next();
            
            do {
                
                if (cmd.equals("$")) {
                    cmd = line.next();
                    
                    if (cmd.equals("cd")) {
                        cmd = line.next();
                        
                        if (cmd.equals("/")) {
                            while (dir.hasParent()) {
                                dir = (Tree) dir.parent;
                            }
                        } else if (cmd.equals("..")) {
                            dir = (Tree) dir.parent;
                        } else {
                            Iterator<Object> i = dir.children.iterator();
                            while (i.hasNext()) {
                                Tree o = (Tree) i.next();
                                if (o.name.equals(cmd)) 
                                    dir = o;
                            }
                        }
                    } 
                    else if (cmd.equals("ls")) {
                        cmd = in.nextLine();
                        while (!cmd.contains("$")) {
                            if (cmd.contains("dir")) {
                                dir.add(new Tree(cmd.substring(cmd.indexOf(" ")+1), 0, dir, "dir"));
                            }
                            else {
                                int size = Integer.parseInt(cmd.substring(0, cmd.indexOf(" ")));
                                dir.add(new Tree(cmd.substring(cmd.indexOf(" ")+1), size, dir, "file"));
                            }
                            if (in.hasNextLine())
                                cmd = in.nextLine();
                            else break;
                        }
                        defined = true;
                        temp = cmd;
                    }
                }
            }
            while(line.hasNext());
        }
        
        while (dir.hasParent()) {
            dir = (Tree) dir.parent;
        }
        
        help1(dir);
        System.out.println(sum1);
        
    }
    
    private static void help1(Tree dir) { 
        for (Object o : dir.children) {
            Tree t = (Tree) o;
            if (t.type.equals("dir")) {
                help1(t);
                if ((int)t.val <= 100000) {
                    sum1 += (int)t.val;
                } 
            }
            
        }
        
    }
    
    
    static long sum2 = 70000000;
    public static void part2(File file) throws Exception {
        Scanner in = new Scanner(file);
        
        Tree dir = new Tree("/", null, "root");
        
        boolean defined = false;
        String temp = "";
        while (in.hasNextLine()) {
            String l = temp;
            if (!defined) {
                l = in.nextLine();
            } defined = false;
            Scanner line = new Scanner(l);
            String cmd = line.next();
            
            do {
                
                if (cmd.equals("$")) {
                    cmd = line.next();
                    
                    if (cmd.equals("cd")) {
                        cmd = line.next();
                        
                        if (cmd.equals("/")) {
                            while (dir.hasParent()) {
                                dir = (Tree) dir.parent;
                            }
                        } else if (cmd.equals("..")) {
                            dir = (Tree) dir.parent;
                        } else {
                            Iterator<Object> i = dir.children.iterator();
                            while (i.hasNext()) {
                                Tree o = (Tree) i.next();
                                if (o.name.equals(cmd)) 
                                    dir = o;
                            }
                        }
                    } 
                    else if (cmd.equals("ls")) {
                        cmd = in.nextLine();
                        while (!cmd.contains("$")) {
                            if (cmd.contains("dir")) {
                                dir.add(new Tree(cmd.substring(cmd.indexOf(" ")+1), 0, dir, "dir"));
                            }
                            else {
                                int size = Integer.parseInt(cmd.substring(0, cmd.indexOf(" ")));
                                dir.add(new Tree(cmd.substring(cmd.indexOf(" ")+1), size, dir, "file"));
                            }
                            if (in.hasNextLine())
                                cmd = in.nextLine();
                            else break;
                        }
                        defined = true;
                        temp = cmd;
                    }
                }
            }
            while(line.hasNext());
        }
        
        while (dir.hasParent()) {
            dir = (Tree) dir.parent;
        }
        
        help2(dir);
        System.out.println(sum2);
        
    }
    
    private static void help2(Tree dir) { 
        for (Object o : dir.children) {
            Tree t = (Tree) o;
            if (t.type.equals("dir")) {
                help2(t);
                if ((int)t.val >= 1035571) {
                    
                    if ((int)t.val < sum2) sum2 = (int)t.val;
                } 
            }
            
        }
    }
}
