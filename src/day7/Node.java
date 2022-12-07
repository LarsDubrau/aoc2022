package day7;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private long size;
    private List<Node> children;
    private Node parent;

    public Node(String name, long size, Node parent) {
        this.name = name;
        this.size = size;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public void addChild(String name, long size){
        this.children.add(new Node(name, size, this));
    }

    public Node getChildByName(String name){
        for (Node n : children){
            if (n.getName().equals(name)){
                return n;
            }
        }
        throw new IllegalArgumentException("No child with given name found");
    }

    public long getTotalSize(){
        long sum = 0;
        for (Node n : children){
            if (n.getSize() == 0){
                sum += n.getTotalSize();
            } else {
                sum += n.getSize();
            }
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Node{" + "name='" + name + '\'' + ", size=" + size + '}';
    }
}
