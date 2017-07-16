package com.zfj.android.beatbox;

/**
 * Created by zfj_ on 2017/3/30.
 */

public class Sound {
    private  String mAssetPath;
    private  String mName;
    private  Integer mSoundId;

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer SoundId) {
        this.mSoundId = SoundId;
    }

    public  Sound(String assetPath){
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length-1];
        mName = filename.replace(".wav","");
    }

    public String getName() {
        return mName;
    }

    public String getAssetPath() {
        return mAssetPath;
    }


}
