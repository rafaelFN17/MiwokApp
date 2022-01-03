package com.example.android.miwok;

import android.support.constraint.motion.KeyPosition;
import android.widget.AdapterView;

public class Word {
    //Tradução da palavra em miwok
    private String mMiwokTranslation;
    //Palavra na lingua padrão (ingles)
    private String mDefaultTranslation;
    //ID da imagem referente a palavra
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    //Audio referente a palavra
    private int mAudioResourceId;

    //static referente a imagem nula
    private static final int NO_IMAGE_PROVIDED = -1;

    //construtores
    //Construtor para palavras com imagem
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    //contrutor para palavras sem imagem
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    //get que devolve a tradução em ingles
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    //Get que devolve a tradução em miwok
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getmImageResouceId(){ return mImageResourceId; }

    public boolean hasImage(){
        return mImageResourceId !=  NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() { return mAudioResourceId; }

}
