package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi;

public class WordThread extends Thread{

    private final int x;
    private int y;
    private final String word;
    Screen screen = Screen.getInstance();

    public WordThread(int x, int y, String word) {
        this.x = x;
        this.y = y;
        this.word = word;
    }

    @Override
    public void run() {
        screen.writeStringAt(this.y, this.x, Ansi.Color.RED, this.word);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        screen.writeStringAt(this.y, this.x , Ansi.Color.BLACK, this.word);
        this.y--;
    }
}
