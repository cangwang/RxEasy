package com.cangwang.rxeasy.until;

/**
 * Created by zjl on 2016/8/8.
 */
public class Observable<T> {
    protected OnAttach onAttach;

    public Observable(OnAttach onAttach){
        this.onAttach = onAttach;
    }

    public static <T> Observable<T> create(OnAttach<T> onAttach){
        return new Observable(onAttach);
    }

    public void attach(Observer<T> observer){
        onAttach.call(observer);
    }

    public interface OnAttach<T> {
        void call(Observer<? super T> observer);
    }

    public <R> Observable<R> map(IFun<? super T, ? extends R> fun){
        OperatorMap operatorMap = new OperatorMap(fun);
        Observable observable = lift(operatorMap);
        return observable;
    }

    public <R> Observable<R> lift(final Operator<? extends R, ? super T> operator){
        return new Observable<>(new OnAttach() {
            @Override
            public void call(Observer observer) {
                Observer<? super T> call = operator.call(observer);
                Observable.this.onAttach.call(call);
            }
        });
    }

    public interface Operator<R,T> extends IFun<Observer<? super R> ,Observer<? super T>>{}
}
