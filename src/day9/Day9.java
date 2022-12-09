package day9;

import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day9 {
    private static List<String> visitedPositions = new ArrayList<>();

    private static List<Knot> rope = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLinesFromFile("src/day9/input.txt");

        for (int i = 0; i <= 9; i++){
            rope.add(new Knot(i));
        }

        Knot head = rope.get(0);

        addCurrentTailPosition();

        for (String line : lines) {
            //System.out.println("Current line: " + line);
            String dir = line.split(" ")[0];
            int steps = Integer.valueOf(line.split(" ")[1]);

            for (int i = 0; i < steps; i++) {
                switch (dir) {
                    case "R":
                        head.increaseX();
                        break;
                    case "L":
                        head.decreaseX();
                        break;
                    case "U":
                        head.increaseY();
                        break;
                    case "D":
                        head.decreaseY();
                        break;
                }
                //System.out.println("New head postion: " + currentXH + "|" + currentYH);
                for (int k = 1; k < rope.size(); k++){
                    if (!knotsCloseEnough(rope.get(k - 1), rope.get(k))){
                        moveKnot(rope.get(k), rope.get(k-1));
                    }
                }
                //System.out.println("New tail postion: " + currentXT + "|" + currentYT);
            }
        }
        //System.out.println(visitedPositions);
        System.out.println(visitedPositions.size());
    }

    private static void moveKnot(Knot knot, Knot knotToMoveTo) {
        if (knotToMoveTo.getX() == knot.getX()){
            //same column
            if (knotToMoveTo.getY() < knot.getY()){
                knot.decreaseY();
            } else {
                knot.increaseY();
            }
        } else if(knotToMoveTo.getY() == knot.getY()){
            //same row
            if (knotToMoveTo.getX() < knot.getX()){
                knot.decreaseX();
            } else {
                knot.increaseX();
            }
        } else {
            //move diagonal
            if (knotToMoveTo.getY() > knot.getY()){
                knot.increaseY();
            } else if (knotToMoveTo.getY() < knot.getY()){
                knot.decreaseY();
            }
            if(knotToMoveTo.getX() > knot.getX()){
                knot.increaseX();
            } else if(knotToMoveTo.getX() < knot.getX()){
                knot.decreaseX();
            }
        }

        addCurrentTailPosition();
    }

    private static boolean knotsCloseEnough(Knot knot1, Knot knot2) {
        int diffX = Math.abs(knot1.getX() - knot2.getX());
        int diffY = Math.abs(knot1.getY() - knot2.getY());
        return diffY <= 1 && diffX <= 1;
    }

    private static void addCurrentTailPosition() {
        String pos = rope.get(rope.size() - 1).getPositionString();
        if (!visitedPositions.contains(pos)) {
            visitedPositions.add(pos);
        }
    }
}
