package util;

public class UtilMethods {

    public static int randomChoose(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static Direction randomDirection () {

        Direction direction = Direction.UP;

        int randomDirection = UtilMethods.randomChoose(1, 4);

        direction = switch (randomDirection) {
            case (1) -> Direction.UP;
            case (2) -> Direction.DOWN;
            case (3) -> Direction.LEFT;
            case (4) -> Direction.RIGHT;
            default -> direction;
        };

        return direction;
    }
}
