/*
 * https://adventofcode.com/2022/day/9
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RopeBridge {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 9/input.txt");
        part1(file);
        part2(file);
    }
    
    public static void part1(File file) throws Exception {
        Scanner in = new Scanner(file);
        
        class knot {
            public int x;
            public int y;
            knot() {
                x = 0;
                y = 0;
            }
            
            public String position() {
                return x + " " + y;
            }
            
            public boolean nearBy(knot head) {
                if ((x == head.x || x+1 == head.x || x-1 == head.x)
                     && (y == head.y || y+1 == head.y || y-1 == head.y)) {
                    return true;
                }
                return false;
            }
        }
        
        ArrayList<String> pos = new ArrayList<>();
        pos.add("0 0");
        
        knot head = new knot();
        knot tail = new knot();
        
        while (in.hasNext()) {
            String direction = in.next();
            String move;
            if (direction.equals("U")) {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    head.y++;
                    if (!tail.nearBy(head)) {
                        
                        if (head.x == tail.x) {
                                tail.y++;
                        }
                        else if (head.x > tail.x) {
                            tail.y++;
                            tail.x++;
                        }
                        else if (head.x < tail.x) {
                            tail.y++;
                            tail.x--;
                        }
                        
                        if (!pos.contains(tail.position()))
                            pos.add(tail.position());
                    }
                }
            }
            else if (direction.equals("D")) {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    head.y--;
                    if (!tail.nearBy(head)) {
                        
                        if (head.x == tail.x) {
                            tail.y--;
                        }
                        else if (head.x > tail.x) {
                            tail.y--;
                            tail.x++;
                        }
                        else if (head.x < tail.x) {
                            tail.y--;
                            tail.x--;
                        }
                        
                        if (!pos.contains(tail.position()))
                            pos.add(tail.position());
                    }
                }
            }
            else if (direction.equals("L")) {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    head.x--;
                    if (!tail.nearBy(head)) {
                        
                        if (head.y == tail.y) {
                            tail.x--;
                        }
                        else if (head.y > tail.y) {
                            tail.x--;
                            tail.y++;
                        }
                        else if (head.y < tail.y) {
                            tail.x--;
                            tail.y--;
                        }
                        
                        if (!pos.contains(tail.position()))
                            pos.add(tail.position());
                    }
                }
            }
            else {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    head.x++;
                    if (!tail.nearBy(head)) {
                        
                        if (head.y == tail.y) {
                            tail.x++;
                        }
                        else if (head.y > tail.y) {
                            tail.x++;
                            tail.y++;
                        }
                        else if (head.y < tail.y) {
                            tail.x++;
                            tail.y--;
                        }
                        
                        if (!pos.contains(tail.position()))
                            pos.add(tail.position());
                    }
                }
            }
        }
        
        System.out.println(pos.size());
    }

    public static void part2(File file) throws Exception {
        Scanner in = new Scanner(file);
        
        class knot {
            public int x;
            public int y;
            public knot following;
            knot(knot k) {
                x = 0;
                y = 0;
                following = k;
            }
            
            public String position() {
                return x + ", " + y;
            }
            
            public boolean nearBy(knot head) {
                if(following == null) return true;
                if ((x == head.x || x+1 == head.x || x-1 == head.x)
                     && (y == head.y || y+1 == head.y || y-1 == head.y)) {
                    return true;
                }
                return false;
            }
            
            public void move() {
                if (following.y - y == 2) {
                    if (following.x == x)
                        y++;
                    else if (following.x > x)
                    {
                        x++; y++;
                    }
                    else if (following.x < x) {
                        x--; y++;
                    }
                }
                
                else if (following.y - y == -2) {
                    if (following.x == x)
                        y--;
                    else if (following.x > x)
                    {
                        x++; y--;
                    }
                    else if (following.x < x) {
                        x--; y--;
                    }
                }
                else if (following.x - x == 2) {
                    if (following.y == y)
                        x++;
                    else if (following.y > y) {
                        y++; x++;
                    }
                    else if (following.y < y) {
                        y--; x++;
                    }
                }
                else if (following.x - x == -2) {
                    if (following.y == y)
                        x--;
                    else if (following.y > y) {
                        y++; x--;
                    }
                    else if (following.y < y) {
                        y--; x--;
                    }
                }
                
                
            }
        }
        
        ArrayList<String> pos = new ArrayList<>();
        pos.add("0, 0");
        
        knot head = new knot(null);
        knot k2 = new knot(head);
        knot k3 = new knot(k2);
        knot k4 = new knot(k3);
        knot k5 = new knot(k4);
        knot k6 = new knot(k5);
        knot k7 = new knot(k6);
        knot k8 = new knot(k7);
        knot k9 = new knot(k8);
        knot tail = new knot(k9);
        knot[] knots = {head, k2, k3, k4, k5, k6, k7, k8, k9, tail};
        
        
        while (in.hasNext()) {
            int l = pos.size();
            
            
            String direction = in.next();
            String move;
            if (direction.equals("U")) {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    for (int k = 0; k < knots.length; k++) {
                        if (knots[k] == head)
                            knots[k].y++;
                        
                        if (!knots[k].nearBy(knots[k].following)) {
                            
                            knots[k].move();
                            
                            if (knots[k] == tail) {
                                if (!pos.contains(knots[k].position()))
                                    pos.add(knots[k].position());
                            }
                        }
                    }
                }
            }
            else if (direction.equals("D")) {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    for (int k = 0; k < knots.length; k++) {
                        if (knots[k] == head)
                            knots[k].y--;
                        
                        if (!knots[k].nearBy(knots[k].following)) {
                            
                            knots[k].move();
                            
                            if (knots[k] == tail) {
                                if (!pos.contains(knots[k].position()))
                                    pos.add(knots[k].position());
                            }
                        }
                    }
                }
            }
            else if (direction.equals("L")) {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    for (int k = 0; k < knots.length; k++) {
                        if (knots[k] == head)
                            knots[k].x--;
                        if (!knots[k].nearBy(knots[k].following)) {
                            
                            knots[k].move();
                            
                            if (knots[k] == tail) {
                                if (!pos.contains(knots[k].position()))
                                    pos.add(knots[k].position());
                            }
                        }
                    }
                }
            }
            else {
                move = in.next();
                for (int i = 0; i < Integer.parseInt(move); i++) {
                    for (int k = 0; k < knots.length; k++) {
                        if (knots[k] == head)
                            knots[k].x++;
                        
                        if (!knots[k].nearBy(knots[k].following)) {
                            
                            knots[k].move();
                            
                            if (knots[k] == tail) {
                                if (!pos.contains(knots[k].position()))
                                    pos.add(knots[k].position());
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(pos.size());
    }
}
