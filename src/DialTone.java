import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DialTone {
    private HashMap<String, String> dialTones = new HashMap();
    private Clip clip;
    private File audioFile;
    private AudioInputStream audioInputStream;

    public DialTone() {
        this.dialTones.put("1", "toneOne.wav");
        this.dialTones.put("2", "toneTwo.wav");
        this.dialTones.put("3", "toneThree.wav");
        this.dialTones.put("4", "toneFour.wav");
        this.dialTones.put("5", "toneFive.wav");
        this.dialTones.put("6", "toneSix.wav");
        this.dialTones.put("7", "toneSeven.wav");
        this.dialTones.put("8", "toneEight.wav");
        this.dialTones.put("9", "toneNine.wav");
        this.dialTones.put("*", "star.wav");
        this.dialTones.put("0", "toneZero.wav");
        this.dialTones.put("#", "hashTag.wav");
    }
    public void getDialTone(String tone){
        try {
            this.audioFile = new File("/Users/shiv/Desktop/DTMF/Resources/" + dialTones.get(tone));
            this.audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            this.clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            while (!clip.isRunning()) {
                System.out.println("Loop 1");
                Thread.sleep(10);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void endDialTone() throws IOException, InterruptedException {
        System.out.println("HERE");
        this.clip.stop();
        this.clip.close();
        this.audioInputStream.close();
    }

}