public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(40,40);
        grid.init();
        Player startingPos = new Player(0,0,grid);
    }
}