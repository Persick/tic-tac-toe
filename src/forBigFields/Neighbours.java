package forBigFields;

/**
 * Created by Dasha on 13.01.2017.
 */
public class Neighbours {
    int s = ForBigFields.sizeOfField;

    int direction = 0;

    public int horizontalPlus(int i){
        return i++;
    }

    public int horizontalMinus(int i){
        return i--;
    }

    public int verticalPlus(int i){
        return i + s;
    }

    public int verticalMinus(int i){
        return i - s;
    }

    public int diagonalOnePlus(int i){
        return i + (s++);
    }

    public int diagonalOneMinus(int i){
        return i - (s++);
    }

    public int diagonalTwoPlus(int i){
        return i + (s--);
    }

    public int diagonalTwoMinus(int i){
        return i - (s--);
    }

    public void checkNeighbours(){
    }
}
