package day8;

import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day8 {
    private static List<List<Integer>> trees = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day8/input.txt");

        for (String line : lines){
            char[] chars = line.toCharArray();
            List<Integer> numbers = new ArrayList<>();
            for (char c : chars){
                numbers.add(Character.getNumericValue(c));
            }
            trees.add(numbers);
        }

        long result1 = 0;
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < trees.size(); i++){
            for(int k = 0; k < trees.get(0).size(); k++){
                scores.add(findDistance(i, k));
                if(isVisible(i, k)){
                    result1++;
                }
            }
        }

        System.out.println("PART 1: " + result1);

        Collections.sort(scores);
        System.out.println("PART 2: " + scores.get(scores.size() - 1));
    }

    private static int findDistance(int i, int k){
        int score = 1;

        //to top
        List<Integer> numbers = new ArrayList<>();
        for (int x = i; x >= 0; x--){
            numbers.add(trees.get(x).get(k));
        }
        score *= computeDistance(numbers);

        //to bottom
        numbers = new ArrayList<>();
        for (int x = i; x < trees.size(); x++){
            numbers.add(trees.get(x).get(k));
        }
        score *= computeDistance(numbers);

        //to left
        numbers = new ArrayList<>();
        for(int x = k; x >= 0; x--){
            numbers.add(trees.get(i).get(x));
        }
        score *= computeDistance(numbers);

        //to right
        numbers = new ArrayList<>();
        for (int x = k; x < trees.get(0).size(); x++){
            numbers.add(trees.get(i).get(x));
        }
        score *= computeDistance(numbers);

        return score;
    }

    private static int computeDistance(List<Integer> list){
        if (list.size() == 1){
            return 0;
        }
        int tree = list.get(0);
        int score = 0;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) < tree){
                score++;
            } else {
                score++;
                break;
            }
        }
        return score;
    }

    private static boolean isVisible(int i, int k){
        //from top
        List<Integer> numbers = new ArrayList<>();
        for (int x = i; x >= 0; x--){
            numbers.add(trees.get(x).get(k));
        }
        if (visible(numbers)){
            return true;
        }

        //from bottom
        numbers = new ArrayList<>();
        for (int x = i; x < trees.size(); x++){
            numbers.add(trees.get(x).get(k));
        }
        if (visible(numbers)){
            return true;
        }

        //from left
        numbers = new ArrayList<>();
        for(int x = k; x >= 0; x--){
            numbers.add(trees.get(i).get(x));
        }
        if (visible(numbers)){
            return true;
        }

        //from right
        numbers = new ArrayList<>();
        for (int x = k; x < trees.get(0).size(); x++){
            numbers.add(trees.get(i).get(x));
        }
        if (visible(numbers)){
            return true;
        }
        return false;
    }

    private static boolean visible(List<Integer> list){
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) >= list.get(0)){
                return false;
            }
        }
        return true;
    }
}
