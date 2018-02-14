package tw.edu.ntut.csie.game.PearlPlate;

import java.util.ArrayList;

import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by CKB on 2018/1/19.
 */

public class PearlPlate  implements GameObject {
    private int _offsetX, _offsetY, _blockSize;
    private int _sizeOfVertical, _sizeOfHorizontal;
    private int _grabbedPearlNumber = 0;
    private boolean _grabbed = false;
    private MovingBitmap _pearlPlate;
    private RandomPlateGenerator _randomPlateGenerator;
    private ArrayList <Pearls> _pearlsList;

    public PearlPlate() {
        _pearlPlate = new MovingBitmap(R.drawable.pearl_plate);
        _randomPlateGenerator = new RandomPlateGenerator();
        _sizeOfVertical = _randomPlateGenerator.GetSizeOfVertical();
        _sizeOfHorizontal = _randomPlateGenerator.GetSizeOfHorizontal();
        _offsetX = _randomPlateGenerator.GetOffSetX();
        _offsetY = _randomPlateGenerator.GetOffSetY();
        _blockSize = _randomPlateGenerator.GetBlockSize();
        _pearlsList = new ArrayList <Pearls>();
    }

    public void initialize()
    {
        _pearlPlate.setLocation(_offsetX, _offsetY);
        SetPearls();
    }

    @Override
    public void move() {
        _pearlPlate.move();
        for (int i = 0; i < _sizeOfVertical * _sizeOfHorizontal; i++)
                _pearlsList.get(i).move();
    }

    @Override
    public void show() {
        _pearlPlate.show();
        for (int i = 0; i < _sizeOfVertical * _sizeOfHorizontal; i++)
            _pearlsList.get(i).show();
        if (_grabbed)
            _pearlsList.get(_grabbedPearlNumber).show();
    }

    @Override
    public void release() {
        _pearlPlate.release();
        for (int i = _sizeOfVertical * _sizeOfHorizontal - 1; i >= 0; i--)
            _pearlsList.get(i).release();
        _pearlsList.clear();
    }

    public void LockGrabbedPearl(int pressedX, int pressedY) {
        if (pressedX >= _offsetX && pressedX < _offsetX + _sizeOfVertical * _blockSize && pressedY >= _offsetY && pressedY < _sizeOfHorizontal * _blockSize)
        {
            int _pearlX = _sizeOfVertical - 1 -  (pressedX - _offsetX) / _blockSize;
            int _pearlY = _sizeOfHorizontal - 1 -  (pressedY - _offsetY) / _blockSize;
            _grabbedPearlNumber = _pearlX * _sizeOfHorizontal + _pearlY;
            _grabbed = true;
        }
    }

    public void ReleaseGrabbedPearl() {
        int _realX = _offsetX + (_sizeOfVertical - 1 - _grabbedPearlNumber / _sizeOfHorizontal) * _blockSize;
        int _realY = _offsetY + (_sizeOfHorizontal - 1 - _grabbedPearlNumber % _sizeOfHorizontal) * _blockSize;
        _pearlsList.get(_grabbedPearlNumber).SetLocation(_realX, _realY);
        _grabbed = false;
    }



    public void MovingPearl(int pressedX, int pressedY) {
        if (_grabbed && pressedX >= _offsetX && pressedX < _offsetX + _sizeOfVertical * _blockSize && pressedY >= _offsetY && pressedY < _offsetY + _sizeOfHorizontal * _blockSize)
        {
            int _pearlX = _sizeOfVertical - 1 - (pressedX - _offsetX) / _blockSize;
            int _pearlY = _sizeOfHorizontal - 1 -  (pressedY - _offsetY) / _blockSize;
            Pearls _tempPearl = _pearlsList.get(_grabbedPearlNumber);
            _pearlsList.set(_grabbedPearlNumber, _pearlsList.get(_pearlX * _sizeOfHorizontal + _pearlY));
            _pearlsList.set(_pearlX * _sizeOfHorizontal + _pearlY, _tempPearl);
            int _realX = _offsetX + (_sizeOfVertical - 1 - _grabbedPearlNumber / _sizeOfHorizontal) * _blockSize;
            int _realY = _offsetY + (_sizeOfHorizontal - 1 - _grabbedPearlNumber % _sizeOfHorizontal) * _blockSize;
            _pearlsList.get(_grabbedPearlNumber).SetLocation(_realX, _realY);
            _grabbedPearlNumber = _pearlX * _sizeOfHorizontal + _pearlY;
            _pearlsList.get(_grabbedPearlNumber).SetLocation(pressedX - _blockSize / 2, pressedY - _blockSize / 2);
        }
    }

    private void SetPearls() {
        for (int i = 0; i < _sizeOfVertical; i++)
        {
            for (int j = 0; j < _sizeOfHorizontal; j++)
            {
                if (_randomPlateGenerator.GetPlate()[i][j] == 0)
                    _pearlsList.add(new WaterPearls());
                else if (_randomPlateGenerator.GetPlate()[i][j] == 1)
                    _pearlsList.add(new FirePearls());
                else if (_randomPlateGenerator.GetPlate()[i][j] == 2)
                    _pearlsList.add(new GrassPearls());
                else
                    _pearlsList.add(new LightPearls());
                _pearlsList.get(_sizeOfHorizontal * i + j).SetLocation(_offsetX + (_sizeOfVertical - 1 - i) * _blockSize, _offsetY + (_sizeOfHorizontal - 1 - j) * _blockSize);
            }
        }
    }
}
