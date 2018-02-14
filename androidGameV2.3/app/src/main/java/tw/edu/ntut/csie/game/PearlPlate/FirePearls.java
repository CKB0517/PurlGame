package tw.edu.ntut.csie.game.PearlPlate;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by CKB on 2018/1/19.
 */

public class FirePearls extends Pearls {
    private MovingBitmap _firePearls;

    public FirePearls() {
        _firePearls = new MovingBitmap(R.drawable.pearls_fire);
    }

    @Override
    public void move() {
        _firePearls.move();
    }

    @Override
    public void show() {
        _firePearls.show();
    }

    @Override
    public void release() {
        _firePearls.release();
    }

    @Override
    public void SetLocation(int x, int y) {
        _firePearls.setLocation(x, y);
    }
 }
