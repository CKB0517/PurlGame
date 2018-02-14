package tw.edu.ntut.csie.game.PearlPlate;

/**
 * Created by CKB on 2018/1/22.
 */

public class RandomPlateGenerator {
    private int _sizeOfVertical = 5, _sizeOfHorizontal = 6;
    private int _offsetX = 340, _offsetY = 8, _blockSize = 60;
    public RandomPlateGenerator() {}

    public int[][] GetPlate() {
        TestGenerator();
        return _initialPlate;
    }

    public int GetOffSetX() { return _offsetX;}

    public int GetOffSetY() { return _offsetY;}

    public int GetBlockSize() { return _blockSize;}

    public int GetSizeOfVertical() { return _sizeOfVertical;}

    public int GetSizeOfHorizontal() { return _sizeOfHorizontal;}

    private int[][] _initialPlate = new int[_sizeOfVertical][_sizeOfHorizontal];

    private int[][] TestGenerator()
    {
        for (int i = 0; i <_sizeOfVertical; i++)
            for (int j = 0 ; j < _sizeOfHorizontal; j++)
                _initialPlate[i][j] = (i + j) % 3;
        return _initialPlate;
    }
}
