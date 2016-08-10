package com.cangwang.rxeasy.until;

/**
 * Created by zjl on 2016/8/8.
 */
public class OperatorMap<T,R> implements Observable.Operator<R,T> {
    private IFun<? super T,? extends R> convert;

    public OperatorMap(IFun<? super T, ? extends R> convert){
        this.convert = convert;
    }

    @Override
    public Observer<? super T> call(final Observer<? super R> observer) {
        return new Observer<T>() {
            @Override
            public void update(T state) {
                observer.update(convert.call(state));
            }
        };
    }
}
