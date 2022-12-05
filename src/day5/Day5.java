package day5;

import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day5/input.txt");

        List<List<String>> stacks = new ArrayList<>();

        int a = 0;

        for (String line : lines){
            if(a == 8) break;
            line = line.replace("]", " ").replace("[", " ");
            for (int i = 0; i <= line.length() - 3; i += 4){
                int stackIndex = i / 4;
                String item = line.substring(i, i+3).trim();
                if (stacks.size() <= stackIndex){
                    stacks.add(new ArrayList<>());
                }
                if(item.isBlank()) continue;
                stacks.get(stackIndex).add(item);
            }
            a++;
        }
        System.out.println(stacks);
        for (int i = a + 2; i < lines.size(); i++){
            int countMoves = Integer.valueOf(lines.get(i).split("move ")[1].split(" from")[0]);
            int from = Integer.valueOf(lines.get(i).split("from ")[1].split(" to")[0]);
            int to = Integer.valueOf(lines.get(i).split("to ")[1]);
            List<String> crates = stacks.get(from - 1).subList(0, countMoves);
            System.out.println("Move " + crates + " from " + from + " to " + to);
            for (int z = countMoves - 1; z >= 0; z--){
                stacks.get(to - 1).add(0, crates.get(z));
            }
            stacks.get(from - 1).removeAll(crates);
            System.out.println(stacks);
        }
        String solution = "";
        for (List<String> stack : stacks){
            solution += stack.get(0);
        }
        System.out.println(solution);
    }
}
