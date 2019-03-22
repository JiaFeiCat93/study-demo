package com.qetch.funning.reflect.parameterizedtype;

public class ResponseDTO<T> {
	private int code;
	private String message;
	private T data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseDTO [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
}
