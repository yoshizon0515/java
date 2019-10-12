package com.example.sample;

@FunctionalInterface
public interface LvlTransFunction<F , E>
{
	public Integer apply(F f, E e);

}
