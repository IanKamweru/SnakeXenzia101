public class Snake {

    private int[][] currentCoordinates;

    public Snake(){
        currentCoordinates=new int[3][2];

        for (int i = 0; i < currentCoordinates.length; i++) {

            currentCoordinates[currentCoordinates.length-1-i][0]=i;
            currentCoordinates[currentCoordinates.length-1-i][1]=0;
        }

    }

    public int[][] getCoordinates(){
        return currentCoordinates;
    }

    public void setCoordinate(int[][] coordinates){
       currentCoordinates=coordinates;
    }


}
