package com.keerthy.shellcommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Util class to execute commands
 */
public class CommandExecuter {

    /**
     * Method to execute a command are gets the result
     * @param command - command to be executed
     * @return Output String
     * @throws IOException
     * @throws InterruptedException
     */
    public static String executeCommand(String command) throws IOException, InterruptedException
    {
            // Executes the command
            Process process = Runtime.getRuntime().exec(command);
            // Reads stdout of the process
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuilder output = new StringBuilder();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            // Waits for the command to finish.
            process.waitFor();
            return output.toString();
    }
}
