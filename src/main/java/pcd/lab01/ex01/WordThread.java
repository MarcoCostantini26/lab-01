package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi;

import java.util.Random;

public class WordThread extends Thread{

    private final int x;
    private int y;
    private final String word;
    private Screen screen = Screen.getInstance();
    private Random rand = new Random();
    private int speed;

    public WordThread(int x, int y, String word) {
        this.x = x;
        this.y = y;
        this.word = word;
        speed = rand.nextInt(500);
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            screen.writeStringAt(this.y + i, this.x, Ansi.Color.RED, this.word);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if(i != 19){
                screen.writeStringAt(this.y+i, this.x, Ansi.Color.BLACK, this.word);
            }

        }

    }
}
