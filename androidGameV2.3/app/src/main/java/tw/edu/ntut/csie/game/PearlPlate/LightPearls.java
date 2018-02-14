package tw.edu.ntut.csie.game.PearlPlate;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by CKB on 2018/1/19.
 */

public class LightPearls extends Pearls {
    private MovingBitmap _lightPearls;

    public LightPearls() {
        _lightPearls = new MovingBitmap(R.drawable.pearls_light);
    }

    @Override
    public void move() {
        _lightPearls.move();
    }

    @Override
    public void show() {
        _lightPearls.show();
    }

    @Override
    public void release() {
        _lightPearls.release();
    }

    @Override
    public void SetLocation(int x, int y) {
        _lightPearls.setLocation(x, y);
    }
}
