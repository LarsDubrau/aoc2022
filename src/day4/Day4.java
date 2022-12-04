package day4;

import utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day4/input.txt");

        int count1 = 0;
        int count2 = 0;

        for (String line : lines) {
            String[] assignments = line.split(",");
            if(contains(assignments[0], assignments[1])){
                count1++;
            }
            if(isOverlap(assignments[0], assignments[1])){
                count2++;
            }
        }
        System.out.println("PART 1: " + count1);
        System.out.println("PART 2: " + count2);
    }

    private static boolean isOverlap(String first, String second) {
        int from1 = Integer.parseInt(first.split("-")[1]);
        int to1 = Integer.parseInt(first.split("-")[0]);
        int from2 = Integer.parseInt(second.split("-")[1]);
        int to2 = Integer.parseInt(second.split("-")[0]);
        return !(from1 < to2 && to1 < to2) || (to1 > from2 && from1 > from2);
    }

    private static boolean contains(String first, String second) {
        int from1 = Integer.parseInt(first.split("-")[1]);
        int to1 = Integer.parseInt(first.split("-")[0]);
        int from2 = Integer.parseInt(second.split("-")[1]);
        int to2 = Integer.parseInt(second.split("-")[0]);
        return (to1 <= to2 && from1 >= from2) || (to1 >= to2 && from1 <= from2);
    }
}
