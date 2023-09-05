package task9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Basket {
    private ArrayList<Ball> ballsList;

    private int getBallsAmount() {
        return ballsList.size();
    }
    public Basket() {
        ballsList = new ArrayList<Ball>();
    }

    public Basket(Collection<Ball> collection) {
        ballsList = new ArrayList<Ball>(collection);
    }

    public Basket(Ball[] array) {
        ballsList = new ArrayList<Ball>();
        ballsList.addAll(Arrays.asList(array));
    }

    public void addBall(Ball ball) {
        ballsList.add(ball);
    }

    public double GetBallsWeight() {
        if(ballsList == null)
            throw new NullPointerException("list of balls is null");

        double totalWeight = 0;
        for(var ball: ballsList) {
            totalWeight += ball.weight;
        }
        return totalWeight / getBallsAmount();
    }

    public int GetBallsAmountByColor(String color) {
        int amount = 0;
        for(var ball: ballsList) {
            if(ball.color.equals(color))
                amount++;
        }
        return amount;
    }
    public int GetBallsAmountByColor() {
        int amount = 0;
        for(var ball: ballsList) {
            if(ball.color.equals(Ball.defaultColor))
                amount++;
        }
        return amount;
    }
}
