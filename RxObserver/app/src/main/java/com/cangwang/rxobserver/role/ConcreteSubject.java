package com.cangwang.rxobserver.role;

import com.cangwang.rxeasy.until.Subject;

/**
 * Created by zjl on 2016/8/8.
 */
public class ConcreteSubject extends Subject {
    public void change(String state){
        notifyObservers();
    }
}

