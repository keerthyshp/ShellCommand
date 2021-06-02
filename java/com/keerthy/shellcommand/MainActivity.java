package com.keerthy.shellcommand;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

/**
 * Main Activity of the application
 */
public class MainActivity extends Activity {

    //Tag to print logs
    public static final String TAG = MainActivity.class.getName();

    public static final String COMMAND = "uname -r";
    //Textview to display output
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutput = (TextView)findViewById(R.id.tvOutput);

        StringBuilder commandOutput = new StringBuilder("uname -r : ");
        try {
            commandOutput.append(CommandExecuter.executeCommand(COMMAND));
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        tvOutput.setText(commandOutput.toString());
    }
}