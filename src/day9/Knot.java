package day9;

public class Knot {
    private int index;
    private int x;
    private int y;

    public Knot(int index) {
        this.index = index;
        this.x = 0;
        this.y  = 0;
    }

    public String getPositionString(){
        return this.x + "|" + this.y;
    }

    public void increaseX(){
        this.x++;
    }

    public void decreaseX(){
        this.x--;
    }

    public void increaseY(){
        this.y++;
    }

    public void decreaseY(){
        this.y--;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
