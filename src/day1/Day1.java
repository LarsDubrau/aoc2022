package day1;

import utils.FileUtils;

import java.io.IOException;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day1/input.txt");

        List<Integer> sums = new ArrayList<>();

        int currSum = 0;

        for (String line : lines){
            if(line.isEmpty()){
                sums.add(currSum);
                currSum = 0;
                continue;
            }
            currSum += Integer.valueOf(line);
        }
        Collections.sort(sums, Collections.reverseOrder());
        int result1 = sums.get(0);
        int result2 = sums.get(0) + sums.get(1) + sums.get(2);

        System.out.println("PART 1: " + result1);
        System.out.println("PART 2: " + result2);
    }
}
