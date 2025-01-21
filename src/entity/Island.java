package entity;

public class Island extends Thread{
    private static int columnsCount;

    private static int rowsCount;

    public Island(int rowsCount, int columnsCount) {
        Island.columnsCount = columnsCount;
        Island.rowsCount = rowsCount;
    }

    public static Location[][] locations = new Location[rowsCount][columnsCount];

    @Override
    public void run() {

    }
}
