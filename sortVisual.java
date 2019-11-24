import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.math.*;

public class sortVisual extends JPanel {
    public static final int win_height = 720;
    public static final int win_width = 1280;
    public static final int width = 3;
    public static final int total_bars = win_width / width;

    private final int[] numbers;
    private final int[] colours;

    public sortVisual() {
        numbers = new int [total_bars];
        colours = new int [total_bars];
        for (int u = 0; u < total_bars; u++) {
            numbers[u] = u;
            colours[u] = 0;
        }
        shuffle();
        setBackground(Color.darkGray);
        new bubbleSort().runSort(numbers);
    }

    public int arrayLen(int[] numbers) { return numbers.length;}

    public static void sleepFor(long seconds) {
        long timeTaken;

        final long timeStart = System.nanoTime();
        do {
            timeTaken = System.nanoTime() - timeStart;
        } while(timeTaken < seconds);
    }

    public void swap(int[] numbers, long milliSecDelay, int j) {
        int temp;
        if (numbers[j] > numbers[j+1]) {
            temp = numbers[j];
            numbers[j] = numbers[j+1];
            numbers[j+1] = temp;

            //sortVisual.repaint();
            //sortVisual.sleepFor(milliSecDelay);
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int swapShuffle = random.nextInt(total_bars - 1);
            int tmp = numbers[i];
            numbers[i] = numbers[swapShuffle];
            numbers[swapShuffle] = tmp;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(g);
        this.setBackground(Color.DARK_GRAY);

        graphics.setColor(Color.white);
        for (int x = 0; x < numbers.length; x++) {
            int h = numbers[x];
            int x_pos = x + (width - 1)  * x;
            int y_pos = win_height - numbers[x];

            graphics.fillRect(x_pos,y_pos, width , h);
        }

        graphics.setColor(Color.red);
        graphics.drawRect(0, 0, win_width, win_height);
    }

    @Override
    public Dimension getPreferredSize() { return new Dimension(win_width, win_height); }
}