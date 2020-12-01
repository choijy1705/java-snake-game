import java.util.ArrayList;

public class ThreadController extends Thread{

    ArrayList<ArrayList<DataOfSquare>> squares = new ArrayList<>();
    Tuple headSnakePos;
    int sizeSnake = 3;
    long speed = 100;
    public static int directionSnake;

    private static final int MOVE_UP = 3;
    private static final int MOVE_DOWN = 4;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_LEFT = 2;
    private static final int NOT_MOVE = 0;

    ArrayList<Tuple> positions = new ArrayList<>();
    Tuple foodPosition;

    ThreadController(Tuple positionDepart){
        squares = Window.Grid;

        headSnakePos = new Tuple(positionDepart.x,positionDepart.y);
        directionSnake = NOT_MOVE;

        Tuple headPos = new Tuple(headSnakePos.getX(), headSnakePos.getY());
        positions.add(headPos);

        foodPosition = new Tuple(Window.height-1, Window.width-1);
        spawnFood(foodPosition);
    }

    private void spawnFood(Tuple foodPosition) {
            squares.get(foodPosition.x).get(foodPosition.y).lightMeUp(1);
    }

    public void run() {
        while(true){
            moveInterne(directionSnake);
            checkCollision();
            moveExterne();
            deleteTail();
            pause();

        }
    }

    private void pause() {
        try{
            sleep(speed);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private void deleteTail() {
        int cmpt = sizeSnake;
        for(int i=positions.size()-1;i>=0;i--){
            if(cmpt == 0){
                Tuple t = positions.get(i);
                squares.get(t.y).get(t.x).lightMeUp(2);
            }else{
                cmpt--;
            }
        }
        cmpt = sizeSnake;
        for(int i=positions.size()-1;i>=0;i--){
            if(cmpt==0){
                positions.remove(i);
            }else{
                cmpt--;
            }
        }
    }

    private void moveExterne() {
        for(Tuple t : positions){
            int y = t.getX();
            int x = t.getY();
            squares.get(x).get(y).lightMeUp(0);
        }
    }

    private void checkCollision() {
        Tuple posCritique = positions.get(positions.size()-1);
        for(int i=0;i<=positions.size()-2;i++){
            boolean biteItself = posCritique.getX()==positions.get(i).getX() && posCritique.getY()==positions.get(i).getY();
            if(biteItself){
                stopTheGame();
            }
        }

        boolean eatingFood = posCritique.getX() == foodPosition.y && posCritique.getY() == foodPosition.x;
        if(eatingFood){
            System.out.println("Yummy!");
            sizeSnake=sizeSnake+1;
            foodPosition = getValAreaNotInSnake();
            spawnFood(foodPosition);
        }



    }

    private Tuple getValAreaNotInSnake() {
        Tuple p;
        int ranX = 0 + (int)(Math.random()*19);
        int ranY = 0 + (int)(Math.random()*19);
        p = new Tuple(ranX, ranY);

        for(int i=0;i<=positions.size()-1;i++){
            if(p.getY()==positions.get(i).getX() && p.getX() == positions.get(i).getY()){
                ranX = 0 + (int)(Math.random()*19);
                ranY = 0 + (int)(Math.random()*19);
                p = new Tuple(ranX,ranY);
                i=0;
            }
        }
        return p;

    }

    private void stopTheGame() {
        System.out.println("Collision! \n");
        while(true){
            pause();
        }
    }

    private void moveInterne(int dir){

        switch(dir){
            case MOVE_DOWN:
                headSnakePos.ChangeData(headSnakePos.x, (headSnakePos.y+1)%20);
                positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
                break;
            case MOVE_UP:
                if(headSnakePos.y -1 <0){
                    headSnakePos.ChangeData(headSnakePos.x, 19);
                }else{
                    headSnakePos.ChangeData(headSnakePos.x, Math.abs(headSnakePos.y-1)%20);
                }
                positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
                break;
            case MOVE_LEFT:
                if(headSnakePos.x -1 <0){
                    headSnakePos.ChangeData(19, headSnakePos.y);
                }else{
                    headSnakePos.ChangeData(Math.abs(headSnakePos.x-1)%20, headSnakePos.y );
                }
                positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
                break;
            case MOVE_RIGHT:
                headSnakePos.ChangeData(Math.abs(headSnakePos.x+1)%20, headSnakePos.y);
                positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
                break;
            case NOT_MOVE:
                break;
        }
    }
}
