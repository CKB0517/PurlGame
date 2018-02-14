package tw.edu.ntut.csie.game.PearlPlate;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by CKB on 2018/1/19.
 */

public class WaterPearls extends Pearls {
    private MovingBitmap _waterPearls;

    public WaterPearls() {
        _waterPearls = new MovingBitmap(R.drawable.pearls_water);
    }

    @Override
    public void move() {
        _waterPearls.move();
    }

    @Override
    public void show() {
        _waterPearls.show();
    }

    @Override
    public void release() {
        _waterPearls.release();
    }

    @Override
    public void SetLocation(int x, int y) {
        _waterPearls.setLocation(x, y);
    }
}
