package com.zfj.android.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfj_ on 2017/3/30.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUND_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;
    private SoundPool mSoundPool;
    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<Sound>();
    public BeatBox(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0 );
        loadSound();
    }
    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if(soundId == null){
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }
    private void loadSound(){
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUND_FOLDER);
            Log.i(TAG,"Found"+soundNames.length+" sounds!");

        } catch (IOException e) {
           Log.e(TAG,"COUND NOT LIST ASSETS",e);
            return ;
        }
        for(String filename : soundNames){
            try {
                String assetPath = SOUND_FOLDER+"/"+filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException e) {
                Log.e(TAG,"Could Not Load Sound"+filename,e);
            }

        }

    }
    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public void release(){
        mSoundPool.release();
    }
    public List<Sound> getSounds() {
        return mSounds;
    }
}
