import java.io.*;
import javax.sound.sampled.*;
import java.util.Scanner;

public class Client
{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {

        String filepath = "/home/pjpaik/Desktop/softwareEngineering/RaspberryPiProject_1/vampire.wav";
        PlayMusic(filepath);


    }
    public static void PlayMusic(String location)
    {
        try
        {
            File musicPath = new File(location);
            if(musicPath.exists())
            {
                System.out.println("go time");
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                System.out.println("Press q to stop");
                String end = "n";//figure out bettter method later
                while(!end.equals("q")){//check how to detect end of song to also end
                    end = in.nextLine();
                }
                System.out.println("Stopping...");

                clip.stop();
                clip.close();

            }
            else
            {
                System.out.println("Did not work lol");
            }
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
}