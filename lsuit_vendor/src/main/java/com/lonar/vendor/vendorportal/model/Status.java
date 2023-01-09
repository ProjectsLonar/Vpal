package com.lonar.vendor.vendorportal.model;

public class Status {

	private Integer code;
	private String message;
	private Object data;
	
	public Status() {
	
	}
	
	
	public Status(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Status [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
}
