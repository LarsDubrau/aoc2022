package day10;

import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Day10 {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day10/input.txt");

        List<Integer> register = new ArrayList<>();
        int currentRegisterValue = 1;

        List<Character> crt = new ArrayList<>();

        for (String line : lines) {

            if (line.equals("noop")) {
                register.add(currentRegisterValue);
                crt.add(getDisplayValue(register.size() - 1, currentRegisterValue));
            } else {
                int x = Integer.parseInt(line.split("addx ")[1]);

                register.add(currentRegisterValue);
                crt.add(getDisplayValue(register.size() - 1, currentRegisterValue));

                register.add(currentRegisterValue);
                crt.add(getDisplayValue(register.size() - 1, currentRegisterValue));

                currentRegisterValue += x;
            }
        }


        int result1 = 0;
        for (int i = 20; i <= register.size(); i += 40) {
            result1 += (i * register.get(i - 1));
        }
        System.out.println(result1);

        for (int i = 0; i < 6; i++) {
            for (int k = i * 40; k < i * 40 + 40 && k < crt.size(); k++) {
                System.out.print(crt.get(k));
            }
            System.out.println();
        }
    }

    private static Character getDisplayValue(int cycle, int registerValue) {
        cycle = cycle % 40;
        if (registerValue == cycle || registerValue - 1 == cycle || registerValue + 1 == cycle) {
            return '#';
        } else {
            return '.';
        }
    }
}