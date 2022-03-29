package com.designPatterns;

public class MuteQuack implements QuackBehaviour{

    public void quack() {
        System.out.print("<<Silence>>");
    }
}
