package com.intellect.jobportal.model.common;

import java.util.List;

public class CommonResponse<T> extends BaseResponse{
	private T data;
	private List<T> list;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
