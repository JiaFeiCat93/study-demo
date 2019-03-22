package com.qetch.funning.reflect.parameterizedtype;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 至Java1.7开始,java.lang.reflect 提供了Interface ParameterizedType. 
 * 通过实现这个接口, 我们可以实现泛型类的类型的参数化, 代码如下
 * @author ZCW
 *
 */
public class ParameterizedTypeImpl implements ParameterizedType {
	private final Class raw;
	private final Type[] args;
	private final Type owner;
	
	public ParameterizedTypeImpl(Class raw, Type[] args, Type owner) {
		this.raw = raw;
		this.args = args;
		this.owner = owner;
	}
	
	@Override
	public Type[] getActualTypeArguments() {
		return args;
	}

	@Override
	public Type getRawType() {
		return raw;
	}

	@Override
	public Type getOwnerType() {
		return owner;
	}
}
