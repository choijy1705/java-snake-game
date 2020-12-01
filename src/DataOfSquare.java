import java.awt.*;
import java.util.ArrayList;

public class DataOfSquare {

    ArrayList<Color> C = new ArrayList<>();
    int color;
    SquarePanel square;

    public DataOfSquare(int col){
        C.add(Color.darkGray);
        C.add(Color.blue);
        C.add(Color.white);
        color=col;
        square = new SquarePanel();
    }
}
