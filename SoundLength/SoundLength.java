import java.io.File;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

public class SoundLength {

    public static void main(String[] args) {
        File file = new File("E:\\新建文件夹\\TDDOWNLOAD\\【37人大合唱】跳蛋的幸福理论.mp3");
        try {
            MP3File f = (MP3File)AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            System.out.println(audioHeader.getTrackLength());    
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}