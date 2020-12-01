import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {

    public void KeyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 39:
                if(ThreadController.directionOfSnake != 2){
                    ThreadController.directionOfSnake=1;
                }
                break;
            case 38:
                if(ThreadController.directionOfSnake != 4){
                    ThreadController.directionOfSnake=3;
                }
                break;
            case 37:
                if(ThreadController.directionOfSnake != 1){
                    ThreadController.directionOfSnake=2;
                }
                break;
            case 40:
                if(ThreadController.directionOfSnake != 3){
                    ThreadController.directionOfSnake=4;
                }
                break;
            default:
                break;
        }
    }
}
