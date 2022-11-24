package com.urdelivery.urdelivery.base;


public interface IUser<T>{
    public T getRecordByEmail(String email);
    public Integer login(T entity);

}