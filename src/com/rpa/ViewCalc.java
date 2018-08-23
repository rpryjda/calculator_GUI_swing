package com.rpa;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewCalc extends JFrame {

	JPanel panelNorth;
	JPanel panelCenter;
	JButton displayResult;
	String[] namesOfButtons = new String[] {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	
	private List<JButton> createButtons(String[] names){
		List<JButton> list = new ArrayList<>();	
		for(String item: names){				
			list.add(new JButton(item));			
		}
		return list;
	}
	
	public ViewCalc(ModelCalc model){
		super("Calc.");
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		panelNorth = new JPanel();
		panelNorth.setLayout(new BorderLayout());
		displayResult = new JButton("0");
		displayResult.setEnabled(false);
		panelNorth.add(displayResult);
		this.add(panelNorth,BorderLayout.NORTH);	
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(4,4));
		List<JButton> listOfButtons = createButtons(namesOfButtons);
		
		ActionListener listenerInsertAction = event->{	
			
			String addNumber = event.getActionCommand();
			
			if(model.isStart()){
				displayResult.setText("");
				model.setStart(false);
			}
			
			if(model.isDotInNumber() && event.getActionCommand().equals(".")){
			displayResult.setText(displayResult.getText());	
			}else{
			displayResult.setText(displayResult.getText()+addNumber);
			
				if(addNumber.equals(".")){
					model.setDotInNumber(true);
				}
			}
			
		};
		
		ActionListener listenerCommandAction = event->{	
			
			model.setResult(Double.parseDouble(displayResult.getText()),model.getLastCommand());
			model.setLastCommand(event.getActionCommand());	
			displayResult.setText(model.getResult()+"");
			model.setStart(true);
	
		};
	
		List<String> helpListOfNumbers = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","0","."));
		List<String> helpListOfCommands = new ArrayList<>(Arrays.asList("+","-","/","*","="));
		
		for(JButton item: listOfButtons){
			panelCenter.add(item);	
			
			if(helpListOfNumbers.contains(item.getText())){	
			item.addActionListener(listenerInsertAction);		
			}else if(helpListOfCommands.contains(item.getText())){			
			item.addActionListener(listenerCommandAction);
			}	
		}

		this.add(panelCenter, BorderLayout.CENTER);
		
		this.pack();
		this.setResizable(false);

	}

}
