package com.rpa;

public class ModelCalc {
	
	private boolean start = true;
	private double result = 0;
	private String lastCommand = "=";
	private boolean dotInNumber = false;
	
	public boolean isDotInNumber() {
		return dotInNumber;
	}

	public void setDotInNumber(boolean dotInNumber) {
		this.dotInNumber = dotInNumber;
	}

	public String getLastCommand() {
		return lastCommand;
	}

	public void setLastCommand(String lastCommand) {
		this.lastCommand = lastCommand;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}
	
	public void setResult(double number, String action){			
		if(action.equals("+")){
			result = result+number;
		}else if(action.equals("-")){
			result = result-number;
		}else if(action.equals("/")){
			result = result/number;
		}else if(action.equals("*")){
			result = result*number;
		}else{
			result=number;		
		}	
	}
	
	public void setResult(double result) {
		this.result = result;
	}
	
	public double getResult() {
		return result;
	}

	

}
