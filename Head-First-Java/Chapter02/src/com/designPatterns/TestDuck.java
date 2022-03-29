package com.designPatterns;

public class TestDuck {

    public static void main(String args[]) {

        Duck mallard = new MallardDuck();

        mallard.performQuack();
        mallard.performFly();


        Duck modelDuck = new ModelDuck();
        modelDuck.performQuack();
        modelDuck.performFly();

        modelDuck.setFlyBehaviour(new FlyRocketPowered());
        modelDuck.performFly();
    }
}
