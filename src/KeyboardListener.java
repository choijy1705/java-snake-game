import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                if(ThreadController.directionSnake != 2){
                    ThreadController.directionSnake =1;
                }
                break;
            case KeyEvent.VK_UP:
                if(ThreadController.directionSnake != 4){
                    ThreadController.directionSnake =3;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(ThreadController.directionSnake != 1){
                    ThreadController.directionSnake =2;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(ThreadController.directionSnake != 3){
                    ThreadController.directionSnake =4;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
