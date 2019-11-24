import java.awt.*;

import

public class bubbleSort implements sortAlgorithms {
    @Override
    public void runSort(sortVisual numbers) {
        int i = numbers.arrayLen();

        for (int q = 0; q < i - 1; q++) {
            for (int j = 0; j < i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    //swap(numbers, 2, j);
                    int temp;
                    if (numbers[j] > numbers[j + 1]) {
                        temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
            }
        }
    }
}