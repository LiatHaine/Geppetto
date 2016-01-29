package com.geppettosoftware.lh.findthedifferent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SoundPool appSounds;
    int rightAnswerSoundId;
    int wrongAnswerSoundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appSounds = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        rightAnswerSoundId = appSounds.load(this, R.raw.right, 1);
        wrongAnswerSoundId = appSounds.load(this, R.raw.wrong, 1);
    }

    public void rightAnswer(View view) {
        display(true);
        playSound(true);
    }
    public void wrongAnswer(View view){
        display(false);
        playSound(false);
    }

    private void playSound(boolean rightAnswerClicked ) {
        if (rightAnswerClicked)
            appSounds.play(rightAnswerSoundId,1,1,1,0,1);
        else
            appSounds.play(wrongAnswerSoundId,1,1,1,0,1 );
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(boolean rightAnswerClicked) {
        TextView quantityTextView = (TextView) findViewById( R.id.topLineText);
        if (rightAnswerClicked)
            quantityTextView.setText("Very Good :)");
        else
            quantityTextView.setText("Wrong :( ");
    }
}
