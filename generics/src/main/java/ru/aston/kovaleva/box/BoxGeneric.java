package ru.aston.kovaleva.box;

public class BoxGeneric<T> {

    private T t;

    //public static T t2 = 1; //почему так нельзя?

    public BoxGeneric(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
