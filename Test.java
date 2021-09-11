import java.awt.*;
import java.util.Scanner;
import static java.awt.event.KeyEvent.*;

public class Test {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800,600);
        StdDraw.setXscale(0,20);
        StdDraw.setYscale(-2,15);
        Color lightGreen = new Color(162, 235, 52);
        StdDraw.clear(lightGreen);
        //bottom menu display
        StdDraw.setPenColor(3, 150, 30); //Lives
        StdDraw.filledRectangle(2.5,-1,2.5,1);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(1,-1," Lives:");

        StdDraw.setPenColor(11, 191, 44); //Level
        StdDraw.filledRectangle(7.5,-1,2.5,1);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(6,-1," Level:");

        StdDraw.setPenColor(3, 150, 30); //Score
        StdDraw.filledRectangle(12.5,-1,2.5,1);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(11,-1," Score:");

        StdDraw.setPenColor(11, 191, 44); //Food Type
        StdDraw.filledRectangle(17.5,-1,2.5,1);

        StdDraw.setPenColor(0, 163, 14);
        StdDraw.filledRectangle(6,7.5,0.5,3);
        StdDraw.filledRectangle(14,7.5,0.5,3);
        StdDraw.filledRectangle(10,10,4,0.5);
        StdDraw.filledRectangle(10,5,4,0.5);
        StdDraw.setPenColor(Color.white);
        StdDraw.rectangle(6,7.5,0.5,3);
        StdDraw.rectangle(14,7.5,0.5,3);
        StdDraw.rectangle(10,10,4,0.5);
        StdDraw.rectangle(10,5,4,0.5);
        Font game= new Font("SANS_SERIF",Font.BOLD,40);
        StdDraw.setFont(game);
        StdDraw.setPenColor(255, 0, 0);
        StdDraw.text(10,8.75,"GAME OVER!");
        StdDraw.picture(10,7,"src/gameover.png",3,1.5);
        //StdAudio.play("src/failed.wav");

    }
}
