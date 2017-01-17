package forBigFields;

/**
 * Created by Dasha on 13.01.2017.
 */
public class ForBigFields {
    //static final int HORIZONTAL = 1;
    //static final int VERTICAL = 2;
    //static final int DIAGONAL_ONE = 3;
    //static final int DIAGONAL_TWO = 4;

    static int sizeOfField = 6; // Например, если поле 4х4, переменная = 4

    private int field[] = new int[sizeOfField * sizeOfField];
    private int neighbours[];

    Neighbours n = new Neighbours();

    public void determineNeighbours(int i){
        if (i == 0){                                    // 0
            neighbours = new int[3];
            neighbours[0] = n.horizontalPlus(i);
            neighbours[1] = n.diagonalOnePlus(i);
            neighbours[2] = n.verticalPlus(i);
        }

        else if (i == sizeOfField - 1){                 //5
            neighbours = new int[3];
            neighbours[0] = n.horizontalMinus(i);
            neighbours[1] = n.diagonalTwoPlus(i);
            neighbours[2] = n.verticalPlus(i);
        }

        else if (i == field.length - sizeOfField)       //30
        {
            neighbours = new int[3];
        }
        else if (i == field.length - 1){                //35
            neighbours = new int[3];
        }
        else if (i > 0 && i < sizeOfField - 1){         //from 0 to 5
            neighbours = new int[5];
        }
        else if (i > field.length - sizeOfField &&      //from 30 to 35
                i < field.length - 1){
            neighbours = new int[5];
        }
        else if (i % sizeOfField == 0){                  //6, 12, 18, 24
            neighbours = new int[5];
        }
        else if (i % sizeOfField == sizeOfField - 1){   //11, 17, 23, 29, 35
            neighbours = new int[5];
        }
        else {
            neighbours = new int[8];
        }
    }


}
