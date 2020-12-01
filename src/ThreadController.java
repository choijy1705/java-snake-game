import java.util.ArrayList;

public class ThreadController extends Thread{

        ArrayList<ArrayList<DataOfSquare>> squares = new ArrayList<>();
        Tuple headSnakePos;
        int sizeSnake = 3;
        long speed = 50;
        public static int directionOfSnake;

        ArrayList<Tuple> positions = new ArrayList<>();
        Tuple foodPosition;

        ThreadController(Tuple positionDepart){
            squares = Window.Grid;

            headSnakePos = new Tuple(positionDepart.x,positionDepart.y);
            directionOfSnake = 1;

            Tuple headPos = new Tuple(headSnakePos.getX(), headSnakePos.getY());
            positions.add(headPos);

            foodPosition = new Tuple(Window.height-1, Window.width-1);
            spawnFood(foodPosition);
        }

    private void spawnFood(Tuple foodPosition) {
            squares.get(foodPosition.x).get(foodPosition.y).lightMeUp(1);
    }
}
