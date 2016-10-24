import java.io.*;
import sun.audio.*;

/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * @author alvin alexander, devdaily.com.
 */

public class PlaySound{
    public static void main(String[] args) throws Exception {
	// expect a sound file as args[0]
	if (args.length != 1){
		System.err.println("I need just one arg, the name of a sound file to play.");
		System.exit(1);
	    }

	InputStream in = new FileInputStream(args[0]);

	// create an audiostream from the inputstream
	AudioStream audioStream = new AudioStream(in);

	// play the audio clip with the audioplayer class
	AudioPlayer.player.start(audioStream);
    }
}
