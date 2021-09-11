import java.awt.*;

public class Startscreen {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0,20);
        StdDraw.setYscale(0,15);
        System.out.println("Instructions:\nTo start the game, choose one of the food-types by clicking the corresponding box.\nUse arrow keys to move the snake.\nGOOD LUCK!");
        StdDraw.picture(10,7.5,"src/startmenu.jpg",20,15);
        StdDraw.setPenColor(37, 245, 0);
        Font game= new Font("SANS_SERIF",Font.BOLD,30);
        StdDraw.setFont(game);
        StdDraw.text(7,13,"TO START, CHOOSE A FOOD-TYPE: \n");
        //A-egg
        StdDraw.text(3,10.5,"A: Protein?\n");
        //B-watermelon
        StdDraw.text(3.1,8.5,"B: Veggies?\n");
        //C-donut
        StdDraw.text(2.7,6.5,"C: Snack?\n");

        StdDraw.text(3,1,"GO GET EM'...!\n");
        //squares
        StdDraw.setPenColor(Color.white);
        StdDraw.setPenRadius(0.005);
        StdDraw.square(8,10.5,1);
        StdDraw.square(8,8.5,1);
        StdDraw.square(8,6.5,1);

        //options
        //A
        StdDraw.setPenColor(245, 179, 179);
        StdDraw.filledEllipse(8,10.5,0.7,0.5);
        StdDraw.setPenColor(179, 148, 148);
        StdDraw.setPenRadius(0.003);
        StdDraw.ellipse(8,10.5,0.7,0.5);
        //B
        StdDraw.setPenColor(Color.red);
        double x=7.5;
        int y=8;
        double[] a ={x-.3,x+.5,x+1.3};
        double[] b ={y+.15,y+1,y+.15};
        StdDraw.filledPolygon(a,b);
        StdDraw.setPenColor(0, 77, 20);
        StdDraw.filledEllipse(x+.5,y+.2,0.77,0.2);
        StdDraw.setPenColor(Color.red);
        StdDraw.filledEllipse(x+.5,y+.3,0.70,0.15);
        StdDraw.setPenColor(Color.black);
        StdDraw.filledEllipse(x+.4,y+.5,0.05,0.1);
        StdDraw.filledEllipse(x+.2,y+.5,0.05,0.1);
        StdDraw.filledEllipse(x+.8,y+.5,0.05,0.1);
        StdDraw.filledEllipse(x+.6,y+.5,0.05,0.1);
        StdDraw.filledEllipse(x+.3,y+.3,0.05,0.1);
        StdDraw.filledEllipse(x+.53,y+.25,0.05,0.1);
        StdDraw.filledEllipse(x+.73,y+.3,0.05,0.1);
        StdDraw.filledEllipse(x+.93,y+.3,0.05,0.1);
        StdDraw.filledEllipse(x+.1,y+.3,0.05,0.1);
        StdDraw.filledEllipse(x+.54,y+.75,0.05,0.1);
        //C
        StdDraw.setPenColor(Color.black);
        StdDraw.circle(8,6.5,0.7);
        StdDraw.setPenColor(212, 181, 28);
        StdDraw.filledCircle(8,6.5,0.7);
        StdDraw.setPenColor(235, 232, 176);
        StdDraw.filledCircle(8,6.5,0.2);
        StdDraw.setPenColor(Color.black);
        StdDraw.circle(8,6.5,0.2);
        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(7.8,6.1,8.0,6.2);
        StdDraw.point(8.3,6.1);
        StdDraw.setPenColor(Color.yellow);
        StdDraw.line(8.3,6.4,8.4,6.6);
        StdDraw.point(8,7);
        StdDraw.show();

        //starting sound effect
        StdAudio.play("src/game.wav");


    }
}
