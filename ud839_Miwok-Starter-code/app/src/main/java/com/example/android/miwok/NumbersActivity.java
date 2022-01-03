package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    //criando audio focus change listener
    AudioManager.OnAudioFocusChangeListener mChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager. AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pausará a reprodução porque seu foco de áudio será
                        // temporariamente roubado.
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager. AUDIOFOCUS_LOSS ) {
                        // Pare a reprodução , porque você perdeu o foco de áudio.
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager. AUDIOFOCUS_GAIN ) {
                        // Retomar a reprodução, porque você mantém o Audio Focus
                        mMediaPlayer.start();
                    }
                }
            };

    //criando variavel global para utilizar o completelistener
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //criando array de palavras
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko.", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        //Criando um wordAdapter
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_numbers);

        //linkando um listview com o layout
        ListView listView = (ListView) findViewById(R.id.list);

        //setando o adapter no listView
        listView.setAdapter(adapter);

        mAudioManager = (AudioManager) getSystemService((Context.AUDIO_SERVICE));


        //setando ItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //pega a palavra perante a posição clicada
                Word word = words.get(position);

                //libera recursos do media player
                releaseMediaPlayer();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //cria o audio e starta
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId() );
                    mMediaPlayer.start();

                    //definindo listener de termino do audio
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }


            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    //metodo para liberar funcionalidade do media player
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            //Liberando o audio focus
            mAudioManager.abandonAudioFocus(mChangeListener);
        }
    }
}