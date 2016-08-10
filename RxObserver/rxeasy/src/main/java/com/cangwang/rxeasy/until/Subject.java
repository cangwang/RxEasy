package com.cangwang.rxeasy.until;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjl on 2016/8/8.
 */
public abstract class Subject {
    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer){
        list.add(observer);
    }

    public void detach(Observer observer){
        list.remove(observer);
    }

    public void notifyObservers(){
        for(Observer ob:list){
            ob.update(this);
        }
    }

    public void clear(){
        list.clear();
    }
}
