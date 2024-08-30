package com.atm.entities;

public class Check {
	private String check;

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Check [check=" + check + "]";
	}

	public Check(String check) {
		super();
		this.check = check;
	}

	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
