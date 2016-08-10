package com.cangwang.rxobserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cangwang.rxeasy.until.IFun;
import com.cangwang.rxeasy.until.Observable;
import com.cangwang.rxeasy.until.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable.OnAttach onAttach = new Observable.OnAttach() {
//            @Override
//            public void call(Observer observer) {
//                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//                observer.update(list);
//            }
//        };
//        Observable observable = Observable.create(onAttach);
//        Observer observer = new Observer<ArrayList<Integer>>() {
//            @Override
//            public void update(ArrayList<Integer> state) {
//
//            }
//        };
//        observable.attach(observer);

        Observable.create(new Observable.OnAttach() {
            @Override
            public void call(Observer observer) {

            }
        }).map(new IFun<String,String>() {
            @Override
            public String call(String o) {
                return null;
            }
        }).map(new IFun<String,String>() {
            @Override
            public String call(String o) {
                return null;
            }
        }).attach(new Observer<String>() {
            @Override
            public void update(String state) {

            }
        });
    }

}
