package com.zfj.android.beatbox;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeatBoxActivity extends SimpleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return BeatBoxFragment.newInstance();
    }
}
