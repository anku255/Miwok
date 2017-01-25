package com.example.android.miwok;

/**
 * Created by Anku on 1/6/2017.
 */
public class Word {

    //Default translation for the word
    private String mDefaultTranslation;

    //Miwok translation for the word
    private String mMiwokTranslation;

    //Audio resource ID for word
    private int mAudioResourceId;

    //Image Resource ID for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // A constant integer value that represents no image was provided
    private static final int NO_IMAGE_PROVIDED = -1;

    /*
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     * @param mAudioResourceId is the id for audio of  pronounciation for word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        this(defaultTranslation,miwokTranslation,audioResourceId);
        mImageResourceId = imageResourceId;
    }

    /*
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param mAudioResourceId is the id for audio of  pronounciation for word
     */

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }


    //Get the default translation of the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //Get the miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //Get the image resource id of the word
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // Method returns true if word object has an image i.e. an image ID was provided
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    // Get audio resource id of the word
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
