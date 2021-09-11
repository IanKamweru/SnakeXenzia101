import java.awt.*;
import static java.awt.event.KeyEvent.*;

public class Project {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        Cell[][] currentCells = new Cell[20][15];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                currentCells[i][j] = new Cell(i, j);
            }
        }



        double mouseX;
        double mouseY;
        int foodType;
        startMenu();
        boolean mousePressed;

        while(true){
            mousePressed=StdDraw.isMousePressed();

            if(mousePressed) {
                mouseX = StdDraw.mouseX();
                mouseY = StdDraw.mouseY();
                if ((mouseX > 7 && mouseX < 9) && (mouseY > 9.5 && mouseY < 11.5)) {
                    foodType = 1;
                    break;
                }
                if ((mouseX > 7 && mouseX < 9) && (mouseY > 7.5 && mouseY < 9.5)) {
                    foodType = 2;
                    break;
                }
                if ((mouseX > 7 && mouseX < 9) && (mouseY > 5.5 && mouseY < 7.5)) {
                    foodType = 3;
                    break;
                }
            }

        }


        int snakeLength=3;
        int lives = 1;
        int level = 1;
        Score newScore=new Score(0);
        int score = newScore.getScore();
        String direction = "Right";


        backgroundMap();
        Snake snake=new Snake();
        boolean isPlaying = true;
        StdDraw.pause(500);
        startGame(currentCells, snakeLength, foodType,snake);
        updateBottomMenu(lives, level, score);

        while(true){
            if((StdDraw.isKeyPressed(VK_LEFT)||StdDraw.isKeyPressed(VK_A)) && ! direction.equals("Right"))direction="Left";
            if((StdDraw.isKeyPressed(VK_RIGHT)||StdDraw.isKeyPressed(VK_D)) && ! direction.equals("Left")) direction="Right";
            if((StdDraw.isKeyPressed(VK_UP)||StdDraw.isKeyPressed(VK_W)) && ! direction.equals("Down")) direction="Up";
            if((StdDraw.isKeyPressed(VK_DOWN)||StdDraw.isKeyPressed(VK_S)) && ! direction.equals("Up")) direction="Down";
            currentCells = moveSnake(currentCells,direction,foodType,snake,newScore);
            draw(currentCells);
            updateBottomMenu(lives,level, newScore.getScore());
            isPlaying=checkCollision(snake,isPlaying);
            if(!isPlaying){
                StdAudio.close();
                gameOver();
                break;
            }
        }
    }


    //setup
    public static void startGame(Cell[][] currentCells, int snakeLength, int foodType,Snake snake) {
        //starting food
        spawnFood(currentCells, foodType,snake);

        //starting snake
        for (int i = 0; i < snakeLength; i++) {
            if(i==snakeLength-1) {
                currentCells[i][0].setState(4);
            }
            else{
                currentCells[i][0].setState(8);
            }

        }

        draw(currentCells);
    }

    //draw Cells
    public static void draw(Cell[][] newCells) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                newCells[i][j].drawCell();
            }
        }
        StdDraw.show();
        StdDraw.pause(100);
    }

    //spawn food at random
    public static void spawnFood(Cell[][] currentCells, int foodType, Snake snake) {
        int x = (int) (Math.random() * currentCells.length);
        int y = (int) (Math.random() * currentCells[1].length);
        boolean goodValues=false;
        int[][] snakeCoordinates= snake.getCoordinates();
        while(!goodValues){
            goodValues=true;
            for(int i=0;i< snakeCoordinates.length;i++){
                if(x==snakeCoordinates[i][0] && y==snakeCoordinates[i][1]){
                    goodValues=false;
                    x=(int) (Math.random() * currentCells.length);
                    y = (int) (Math.random() * currentCells[1].length);
                    break;
                }
            }
        }
        currentCells[x][y].setState(foodType);
       
    }

    //draw lives
    public static void drawLives(int lives) {
        double heartX = 2;
        for (int i = 0; i < lives; i++) {
            StdDraw.setPenColor(Color.red);
            double[] x = {heartX, heartX + .8, heartX + .4};
            double[] y = {-1, -1, -1.5};
            StdDraw.filledPolygon(x, y);
            StdDraw.filledCircle(heartX + .25, -1, 0.2);
            StdDraw.filledCircle(heartX + .55, -1, 0.2);

            heartX += 1;
        }
    }

    public static void updateBottomMenu(int lives, int level, int score) {
        //bottom menu display
        StdDraw.setPenColor(3, 150, 30); //Lives
        StdDraw.filledRectangle(2.5, -1, 2.5, 1);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(1, -1, " Lives:");

        StdDraw.setPenColor(101, 192, 39); //Level
        StdDraw.filledRectangle(7.5, -1, 2.5, 1);

        StdDraw.setPenColor(3, 150, 30); //Score
        StdDraw.filledRectangle(12.5, -1, 2.5, 1);

        StdDraw.setPenColor(11, 191, 44);
        StdDraw.filledRectangle(17.5, -1, 2.5, 1);
        StdDraw.picture(17.5,-1,"src/g.jpg",5,2);

        drawLives(lives);
        StdDraw.setPenColor(Color.white);
        //level
        StdDraw.text(6, -1, " Level: " + level);
        //score
        StdDraw.text(11, -1, " Score: " + score);
        StdDraw.show();
    }


    public static Cell[][] moveSnake(Cell[][] currentState, String direction, int foodType,Snake snake,Score newScore) {
        Cell[][] updatedState = new Cell[20][15];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                updatedState[i][j] = new Cell(i, j);
            }
        }

        //coordinates x,y of the snake
        int[] newHead=new int[2];
        int[][] snakeCoordinates=snake.getCoordinates();
        int[] last=snakeCoordinates[snakeCoordinates.length-1];

        for(int i= snakeCoordinates.length-1;i>0;i--){
            snakeCoordinates[i] = snakeCoordinates[i-1];
            updatedState[snakeCoordinates[i][0]][snakeCoordinates[i][1]].setState(8);
        }
        switch (direction) {
            case "Right" -> {
                newHead[0] = (snakeCoordinates[0][0] + 1) % updatedState.length;
                newHead[1] = snakeCoordinates[0][1];
            }
            case "Left" -> {
                newHead[0] = (((snakeCoordinates[0][0] - 1)) + updatedState.length) % updatedState.length;
                newHead[1] = snakeCoordinates[0][1];
            }
            case "Up" -> {
                newHead[0] = snakeCoordinates[0][0];
                newHead[1] = (snakeCoordinates[0][1] + 1) % updatedState[1].length;
            }
            case "Down" -> {
                newHead[0] = snakeCoordinates[0][0];
                newHead[1] = ((snakeCoordinates[0][1] - 1) + updatedState[1].length) % updatedState[1].length;
            }
        }

        snakeCoordinates[0] = newHead;

        switch (direction) {
            case "Right" -> updatedState[snakeCoordinates[0][0]][snakeCoordinates[0][1]].setState(4);
            case "Left" -> updatedState[snakeCoordinates[0][0]][snakeCoordinates[0][1]].setState(5);
            case "Up" -> updatedState[snakeCoordinates[0][0]][snakeCoordinates[0][1]].setState(6);
            case "Down" -> updatedState[snakeCoordinates[0][0]][snakeCoordinates[0][1]].setState(7);
        }


        //food
        int foodX = 0;
        int foodY = 0;
        int headState=updatedState[snakeCoordinates[0][0]][snakeCoordinates[0][1]].getState();
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < 15; j++) {
                if (currentState[i][j].getState() == foodType) {
                    updatedState[i][j].setState(foodType);
                    foodX=updatedState[i][j].getX();
                    foodY=updatedState[i][j].getY();
                }
            }
        }

        //respawn food if eaten and add score
        if(foodX==snakeCoordinates[0][0]&&foodY==snakeCoordinates[0][1]){
            StdAudio.play("src/bite.wav");
            updatedState[foodX][foodY].setState(0);
            updatedState[foodX][foodY].setState(headState);
            newScore.setScore(newScore.getScore()+1);
            spawnFood(updatedState,foodType,snake);
            int[][] newCoordinates=new int[snakeCoordinates.length+1][2];
            for(int i=0;i<snakeCoordinates.length;i++){
                newCoordinates[i]=snakeCoordinates[i];
            }
            newCoordinates[newCoordinates.length-1]=last;

            updatedState[newCoordinates[newCoordinates.length-1][0]][newCoordinates[newCoordinates.length-1][1]].setState(8);
            snake.setCoordinate(newCoordinates);
        }

        return updatedState;
    }
    //check collision
    public static boolean checkCollision(Snake snake,boolean isPlaying){
        int[][] snakeCoordinates= snake.getCoordinates();
        int headX=snakeCoordinates[0][0];
        int headY=snakeCoordinates[0][1];

        for(int i=1;i< snakeCoordinates.length;i++){
            int snakeX=snakeCoordinates[i][0];
            int snakeY=snakeCoordinates[i][1];

            if (headX == snakeX && headY == snakeY) {
                isPlaying = false;
                break;
            }
        }
        return isPlaying;
    }
    //game over
    public static void gameOver(){
        StdDraw.enableDoubleBuffering();
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
        StdDraw.setPenColor(Color.red);
        StdDraw.text(10,8.5,"GAME OVER!");
        StdDraw.picture(10,7,"src/gameover.png",3,1.5);
        StdAudio.play("src/failed.wav");
        StdDraw.show();
        StdDraw.pause(4000);
        System.exit(1);

    }
    //choosing food type in start menu
    public static void startMenu(){

        StdDraw.enableDoubleBuffering();
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
        StdAudio.play("src/game.wav");
    }
    //background
    public static void backgroundMap() {
        //setting the canvas
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0, 20);
        StdDraw.setYscale(-2, 15);
        Color lightGreen = new Color(162, 235, 52);
        StdDraw.clear(lightGreen);
    }

}
