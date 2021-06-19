package com.secure;

public class MyData {
	private String name;
	private String task;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "MyData [name=" + name + ", task=" + task + "]";
	}

}
