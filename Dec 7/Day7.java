/*
 * i did not clean this up yet
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
        String test = "$ cd /\n"
                + "$ ls\n"
                + "dir a\n"
                + "14848514 b.txt\n"
                + "8504156 c.dat\n"
                + "dir d\n"
                + "$ cd a\n"
                + "$ ls\n"
                + "dir e\n"
                + "29116 f\n"
                + "2557 g\n"
                + "62596 h.lst\n"
                + "$ cd e\n"
                + "$ ls\n"
                + "584 i\n"
                + "$ cd ..\n"
                + "$ cd ..\n"
                + "$ cd d\n"
                + "$ ls\n"
                + "4060174 j\n"
                + "8033020 d.log\n"
                + "5626152 d.ext\n"
                + "7214296 k";
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
                //System.out.println(dir.name + ": " + dir.val);
            }
            while(line.hasNext());
        }
        
        while (dir.hasParent()) {
            dir = (Tree) dir.parent;
        }
        
        long sum = 0;
        help1(dir, sum);
        System.out.println(sum1);
        
    }
    
    private static long help1(Tree dir, long sum) { // there are directories smaller than the first ones, but you cant get to them because the big ones are bigger than 100k
        boolean foundDirs = false;
        for (Object o : dir.children) {
            Tree t = (Tree) o;
            if (t.type.equals("dir")) {
                long pre = help1(t, sum);
                if (pre > 0) {
                    sum += pre;
                }
                if ((int)t.val <= 100000) {
                    sum += (int)t.val;
                    sum1 += (int)t.val;
                } foundDirs = true;
            }
            
        }
        if (foundDirs)
            return sum;
        return 0;
    }
    static long sum2 = 70000000;
    public static void part2(File file) throws Exception {
        String test = "$ cd /\n"
                + "$ ls\n"
                + "dir a\n"
                + "14848514 b.txt\n"
                + "8504156 c.dat\n"
                + "dir d\n"
                + "$ cd a\n"
                + "$ ls\n"
                + "dir e\n"
                + "29116 f\n"
                + "2557 g\n"
                + "62596 h.lst\n"
                + "$ cd e\n"
                + "$ ls\n"
                + "584 i\n"
                + "$ cd ..\n"
                + "$ cd ..\n"
                + "$ cd d\n"
                + "$ ls\n"
                + "4060174 j\n"
                + "8033020 d.log\n"
                + "5626152 d.ext\n"
                + "7214296 k";
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
                //System.out.println(dir.name + ": " + dir.val);
            }
            while(line.hasNext());
        }
        
        while (dir.hasParent()) {
            dir = (Tree) dir.parent;
        }
        
        long sum = 0;
        System.out.println(dir.val);
        help2(dir, sum);
        System.out.println(sum2);
        
    }
    
    // 1035571
    private static long help2(Tree dir, long sum) { // there are directories smaller than the first ones, but you cant get to them because the big ones are bigger than 100k
        boolean foundDirs = false;
        for (Object o : dir.children) {
            Tree t = (Tree) o;
            if (t.type.equals("dir")) {
                long pre = help2(t, sum);
                if (pre > 0) {
                    sum += pre;
                }
                if ((int)t.val >= 1035571) {
                    sum += (int)t.val;
                    
                    if ((int)t.val < sum2) sum2 = (int)t.val;
                } foundDirs = true;
            }
            
        }
        if (foundDirs)
            return sum;
        return 0;
    }
}
