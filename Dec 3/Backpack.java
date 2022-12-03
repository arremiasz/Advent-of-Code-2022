import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Backpack {

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/aremiasz/Documents/GitHub/Advent of Code 2022/Dec 3/input.txt");
        part1(file);
        part2(file);
    }

    public static void part1(File file) throws Exception {
        Scanner in = new Scanner(file);
        int sum = 0;
        while (in.hasNextLine()) {
            ArrayList<String> shared = new ArrayList<>();
            String line = in.nextLine();
            String comp1 = line.substring(0, (line.length()) /2);
            String comp2 = line.substring(line.length()/2);
            for (int i = 0; i < comp1.length(); i++) {
                boolean found = false;
                for (int k = 0; k < comp2.length(); k++) {

                    if (comp1.charAt(i) == comp2.charAt(k)) {
                        shared.add(comp1.substring(i, i+1));
                        found = true;
                        break;
                    }

                }
                if(found) break;
            }

            for (int i = 0; i < shared.size(); i++) {
                char let = shared.get(i).charAt(0);
                if (let>96) {
                    int priority = 0;
                    int c = 96;
                    while (let != c) {
                        priority++;
                        c++;
                    }
                    sum += priority;
                }
                else {
                    int priority = 27;
                    int c = 65;
                    while (let != c) {
                        priority++;
                        c++;
                    }
                    sum += priority;
                }
            }

        }
        System.out.println(sum);
    }

    public static void part2(File file) throws Exception {
        Scanner in = new Scanner(file);
        int sum = 0;
        while (in.hasNextLine()) {
            ArrayList<String> shared = new ArrayList<>();
            String elf1 = in.nextLine();
            String elf2 = in.nextLine();
            String elf3 = in.nextLine();
            for (int i = 0; i < elf1.length(); i++) {
                boolean found = false;
                for (int k = 0; k < elf2.length(); k++) {

                    if (elf1.charAt(i) == elf2.charAt(k)) {
                        for (int j = 0; j < elf3.length(); j++) {
                            if (elf1.charAt(i) == elf3.charAt(j)) {
                                shared.add(elf1.substring(i, i+1));
                                found = true;
                                break;
                            }
                        }
                    }
                    if(found) break;
                }
                if(found) break;
            }

            for (int i = 0; i < shared.size(); i++) {
                char let = shared.get(i).charAt(0);
                if (let>96) {
                    int priority = 0;
                    int c = 96;
                    while (let != c) {
                        priority++;
                        c++;
                    }
                    sum += priority;
                }
                else {
                    int priority = 27;
                    int c = 65;
                    while (let != c) {
                        priority++;
                        c++;
                    }
                    sum += priority;
                }
            }

        }
        System.out.print(sum);
    }
}
