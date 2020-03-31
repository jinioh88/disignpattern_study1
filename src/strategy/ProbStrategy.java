package strategy;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currenthandValue = 0;
    private int[][] history = {
            {1,1,1}, {1,1,1}, {1,1,1},
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }


    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currenthandValue));
        int handVal = 0;
        if(bet < history[currenthandValue][0]) {
            handVal = 0;
        } else if(bet < history[currenthandValue][0] + history[currenthandValue][1]) {
            handVal = 1;
        } else {
            handVal = 2;
        }
        prevHandValue = currenthandValue;
        currenthandValue = handVal;
        return Hand.getHand(handVal);
    }


    private int getSum(int hv) {
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            sum += history[hv][i];
        }
        return sum;
    }


    @Override
    public void study(boolean win) {
        if(win) {
            history[prevHandValue][currenthandValue]++;
        } else {
            history[prevHandValue][(currenthandValue + 1) % 3]++;
            history[prevHandValue][(currenthandValue + 2) % 3]++;
        }
    }
}
