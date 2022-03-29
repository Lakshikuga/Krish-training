package com.designPatterns;

public class ModelDuck extends Duck{

    public ModelDuck() {
        flyBehaviour =  new FlyNoWay();
        quackBehaviour = new Quack();
    }

    public void display() {
        System.out.println("I am a model duck!!!");
    }
}
