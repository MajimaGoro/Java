import java.io.File;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

public class SoundLength {

    //获取mp3时长
    public static int getTrackLength(File file) {
        try {
            MP3File f = (MP3File)AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
            return audioHeader.getTrackLength();    
        } catch(Exception e) {
            System.out.println(file.getName());
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean isMP3(String fileName) {
        int index = fileName.indexOf(".mp3");
        if (index == -1)
            return false;
        return true;
    }

    //遍历文件夹
    public static void traversalDir(String dirPath, String subPath, StringBuilder s) {
        try {
            File file = new File(dirPath);
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory())
                    traversalDir(f.getAbsolutePath(), subPath, s);
                else {
                    if (isMP3(f.getName())) {
                        // String key = new String(f.getAbsolutePath().getBytes("gbk"), "utf-8");
                        String key = f.getAbsolutePath().replace(subPath, "").replace("\\", "/");
                        s.append("\t[\"");
                        s.append(key);
                        s.append("\"] = ");
                        s.append(getTrackLength(f));
                        s.append(",\n");
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // String[] a = new String[3];
            // //目录
            // a[0] = "E:\\新建文件夹\\TDDOWNLOAD\\";
            // //导出文件路径
            // a[1] = "E:\\Code\\Java\\SoundLength\\SoundLength.lua";
            // //忽略路径
            // a[2] = "E:\\新建文件夹\\";
            StringBuilder s = new StringBuilder();
            s.append("SoundLength = {\n");
            traversalDir(args[0], args[2], s);
            s.append("}");
            //写文件
            File file = new File(args[1]);
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            out.write(s.toString());
            out.flush();
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}