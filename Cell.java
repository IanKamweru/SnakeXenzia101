import java.awt.*;

public class Cell {
    private final int x;
    private final int y;
    private int cellState=0;

    public Cell(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getState(){
        return this.cellState;
    }

    public void setState(int state) {
        cellState=state;
    }

    public void drawCell(){
        int state = this.cellState;
        //food-egg
        if(state == 1){
            StdDraw.setPenColor(245, 179, 179);
            StdDraw.filledEllipse(x+.5,y+.5,0.4,0.3);
            StdDraw.setPenColor(179, 148, 148);
            StdDraw.setPenRadius(0.003);
            StdDraw.ellipse(x+.5,y+.5,0.4,0.3);
        }
        //food-watermelon
        else if(state == 2){
            StdDraw.setPenColor(Color.red);
            double[] a ={x+.1,x+.5,x+.9};
            double[] b ={y+.2,y+.9,y+.2};
            StdDraw.filledPolygon(a,b);
            StdDraw.setPenColor(0, 77, 20);
            StdDraw.filledEllipse(x+.5,y+.2,0.4,0.2);
            StdDraw.setPenColor(Color.red);
            StdDraw.filledEllipse(x+.5,y+.3,0.35,0.2);
            StdDraw.setPenColor(Color.black);
            StdDraw.filledEllipse(x+.4,y+.5,0.05,0.1);
            StdDraw.filledEllipse(x+.6,y+.5,0.05,0.1);
            StdDraw.filledEllipse(x+.3,y+.3,0.05,0.1);
            StdDraw.filledEllipse(x+.53,y+.25,0.05,0.1);
            StdDraw.filledEllipse(x+.73,y+.3,0.05,0.1);
        }
        //food-donut
        else if(state == 3){
            StdDraw.setPenColor(Color.black);
            StdDraw.circle(x+.5,y+.5,0.4);
            StdDraw.setPenColor(212, 181, 28);
            StdDraw.filledCircle(x+.5,y+.5,0.4);
            StdDraw.setPenColor(242, 241, 233);
            StdDraw.filledCircle(x+.5,y+.5,0.1);
            StdDraw.setPenColor(Color.black);
            StdDraw.circle(x+.5,y+.5,0.1);
            StdDraw.setPenColor(Color.red);
            StdDraw.setPenRadius(0.003);
            StdDraw.line(x+.2,y+.3,x+.3,y+.4);
            StdDraw.point(x+.5,y+.3);
            StdDraw.setPenColor(Color.yellow);
            StdDraw.line(x+.7,y+.4,x+.8,y+.6);
            StdDraw.point(x+.5,y+.8);
        }
        //head-RIGHT
        else if(state == 4){
            StdDraw.setPenColor(0, 107, 12);
            StdDraw.filledCircle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(252, 186, 3);
            StdDraw.circle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(Color.yellow);
            StdDraw.filledEllipse(x+.8,y+.7,0.1,0.08);
            StdDraw.filledEllipse(x+.8,y+.2,0.1,0.08);
        }
        //head-LEFT
        else if(state == 5){
            StdDraw.setPenColor(0, 107, 12);
            StdDraw.filledCircle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(252, 186, 3);
            StdDraw.circle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(Color.yellow);
            StdDraw.filledEllipse(x+.2,y+.7,0.1,0.08);
            StdDraw.filledEllipse(x+.2,y+.2,0.1,0.08);
        }
        //head-UP
        else if(state == 6){
            StdDraw.setPenColor(0, 107, 12);
            StdDraw.filledCircle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(252, 186, 3);
            StdDraw.circle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(Color.yellow);
            StdDraw.filledEllipse(x+.3,y+.8,0.07,0.12);
            StdDraw.filledEllipse(x+.7,y+.8,0.07,0.12);
        }
        //head-DOWN
        else if(state == 7){
            StdDraw.setPenColor(0, 107, 12);
            StdDraw.filledCircle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(252, 186, 3);
            StdDraw.circle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(Color.yellow);
            StdDraw.filledEllipse(x+.3,y+.2,0.07,0.12);
            StdDraw.filledEllipse(x+.7,y+.2,0.07,0.12);
        }
        //body
        else if(state == 8){
            StdDraw.setPenColor(0, 107, 12);
            StdDraw.filledCircle(x+.5,y+.5,0.5);
            StdDraw.setPenColor(Color.green);
            StdDraw.circle(x+.5,y+.5,0.5);
        }
        //nothing
        else if(state == 0){
            StdDraw.setPenColor(162, 235, 52);
            StdDraw.filledCircle(x+.5,y+.5,0.5);
            StdDraw.circle(x+.5,y+.5,0.5);
        }
    }

    public int compareTo(Cell other){
        int compare;
        if(this.x == other.x && this.y==other.y) {
            compare=0;
        }
        else compare = -1;
        return compare;
    }

}
