package day2;

import utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        part1();
        part2();
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void part1() throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day2/input.txt");
        int sum = 0;
        for (String line : lines){
            String opponent = line.split(" ")[0];
            String me = line.split(" ")[1];

            int score = 0;
            switch (me){
                case "X":
                    score = 1;
                    break;
                case "Y":
                    score = 2;
                    break;
                case "Z":
                    score = 3;
                    break;
            }

            if(me.equals("X") && opponent.equals("A") ||
                    me.equals("Y") && opponent.equals("B") ||
                    me.equals("Z") && opponent.equals("C")){
                score += 3;
            } else if(me.equals("X") && opponent.equals("C") ||
                    me.equals("Y") && opponent.equals("A") ||
                    me.equals("Z") && opponent.equals("B")){
                score += 6;
            }
            sum += score;
        }
        System.out.println("PART 1: " + sum);
    }

    private static void part2() throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day2/input.txt");
        int sum = 0;
        for (String line : lines){
            String opponent = line.split(" ")[0];
            String end = line.split(" ")[1];

           int score = 0;

           if (end.equals("X")){
               //lose
               if(opponent.equals("A")){
                   score += 3;
               } else if(opponent.equals("B")){
                   score += 1;
               } else if(opponent.equals("C")){
                   score += 2;
               }
           } else if(end.equals("Y")){
               //draw
               score += 3;
               if(opponent.equals("A")){
                   score += 1;
               } else if(opponent.equals("B")){
                   score += 2;
               } else if(opponent.equals("C")){
                   score += 3;
               }
           } else if(end.equals("Z")){
               //win
               score += 6;
               if(opponent.equals("A")){
                   score += 2;
               } else if(opponent.equals("B")){
                   score += 3;
               } else if(opponent.equals("C")){
                   score += 1;
               }
           }
           sum += score;
        }
        System.out.println("PART 2: " + sum);
    }
}
