package day6;

import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static void main(String[] args) throws IOException {
        String input = FileUtils.readLinesFromFile("src/day6/input.txt").get(0);

        for (int i = 13; i < input.length(); i++){
           if (stringContainsDistinctChars(input.substring(i - 13, i + 1))){
               System.out.println(i  + 1);
               break;
           }
        }
    }

    private static boolean stringContainsDistinctChars(String s){
        List<Character> chars = new ArrayList<>();
        for (Character c : s.toCharArray()){
            if (chars.contains(c)){
                return false;
            } else {
                chars.add(c);
            }
        }
        return true;
    }
}
