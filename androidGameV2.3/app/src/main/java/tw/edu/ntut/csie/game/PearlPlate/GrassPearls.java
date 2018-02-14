package tw.edu.ntut.csie.game.PearlPlate;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by CKB on 2018/1/19.
 */

public class GrassPearls extends Pearls {
    private MovingBitmap _grassPearls;

    public GrassPearls() {
        _grassPearls = new MovingBitmap(R.drawable.pearls_grass);
    }

    @Override
    public void move() {
        _grassPearls.move();
    }

    @Override
    public void show() {
        _grassPearls.show();
    }

    @Override
    public void release() {
        _grassPearls.release();
    }

    @Override
    public void SetLocation(int x, int y) {
        _grassPearls.setLocation(x, y);
    }
}
