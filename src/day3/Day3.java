package day3;

import utils.FileUtils;

import java.io.IOException;
import java.util.*;

public class Day3 {
    public static void main(String[] args) throws IOException {
        part2();
    }

    private static void part2() throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day3/input.txt");

        long sum = 0;

        for (int i = 0; i < lines.size() - 2; i += 3) {
            String[] items = {lines.get(i), lines.get(i + 1), lines.get(i + 2)};

            for (Character c : items[0].toCharArray()) {
                if (rucksackContains(items[1], c) && rucksackContains(items[2], c)) {
                    sum += getPrio(c);
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    private static void part1() throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day3/example.txt");

        long sum = 0;

        for (String line : lines) {
            String firstCompartment = line.substring(0, line.length() / 2);
            String secondCompartment = line.substring(line.length() / 2);

            for (Character c : firstCompartment.toCharArray()) {
                if (secondCompartment.contains(c.toString())) {
                    sum += getPrio(c);
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    private static int getPrio(Character c) {
        if (Character.isUpperCase(c)) {
            return (int) c - 38;
        } else {
            return (int) c - 96;
        }
    }

    private static boolean rucksackContains(String rucksack, Character c) {
        return rucksack.contains(c.toString());
    }
}
