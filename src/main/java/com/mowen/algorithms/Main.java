package com.mowen.algorithms;

import java.util.Random;

/**
 * Created by mowen on 15-11-7.
 *  比重胜出算法
 */
public class Main {
    private static final int LOOPS = 10000;
    private static final int DEVIACTION = 100;
    public static void main(String[] args) {
        int[] winner_numbers = new int[3];
        for(int i =0; i < LOOPS; i++) {
            winner_numbers[weightedChoice(1, 3, 6)] += 1;
        }

        assert (winner_numbers[0] > LOOPS * 1/10 - DEVIACTION) && (winner_numbers[0] < LOOPS * 1/10 + DEVIACTION);
        assert (winner_numbers[1] > LOOPS * 3/10 - DEVIACTION) && (winner_numbers[1] < LOOPS * 3/10 + DEVIACTION);
        assert (winner_numbers[2] > LOOPS * 6/10 - DEVIACTION) && (winner_numbers[2] <  LOOPS * 6/10 + DEVIACTION);
    }

    private static int weightedChoice(int ... weights) {
        int winner = -1;
        double sum = 0;
        Random random = new Random();
        for(int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if(sum * random.nextDouble() < weights[i]) {
                winner = i;
            }
        }
        return winner;
    }
}
