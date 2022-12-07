package day7;

import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7 {
    private static List<Long> dirSizes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day7/input.txt");
        lines.remove(0);
        lines.remove(0);

        Node tree = new Node("/", 0, null);
        Node activeNode = tree;

        for (int i = 0; i < lines.size(); i++){
            String line = lines.get(i);

            if(!line.startsWith("$") && !line.startsWith("dir")){
                long size = Long.parseLong(line.split(" ")[0]);
                String name = line.split(" ")[1];

                activeNode.addChild(name, size);
            }

            if (line.startsWith("$ cd")){
                String arg = line.split("cd ")[1];

                if(arg.equals("..")){
                    activeNode = activeNode.getParent();
                } else {
                    activeNode.addChild(arg, 0);
                    activeNode = activeNode.getChildByName(arg);
                }
            }
        }

        //part 1
        findDirSizes(tree);
        long result1 = 0;
        for (Long l : dirSizes){
            if (l <= 100000){
                result1 += l;
            }
        }
        System.out.println("PART 2: " + result1);

        //part2
        long neededSpace = Math.abs(70000000 - tree.getTotalSize() - 30000000);

        Collections.sort(dirSizes);
        for (Long l : dirSizes){
            if (l >= neededSpace){
                System.out.println("PART 1: " + l);
                break;
            }
        }
    }

    private static void findDirSizes(Node parent){
        if (parent.getSize() == 0){
            dirSizes.add(parent.getTotalSize());
        }
        for (Node n : parent.getChildren()){
            if (n.getSize() == 0){
                findDirSizes(n);
            }
        }
    }
}
