package com.exempel.martin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;

import apple.laf.JRSUIConstants.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class ExempelProjekt implements EntryPoint {
	private VerticalPanel mainPanel = new VerticalPanel();
	private HorizontalPanel addPanelOperand1 = new HorizontalPanel();
	private HorizontalPanel addPanelOp = new HorizontalPanel();
	private HorizontalPanel addPanelOp1 = new HorizontalPanel();
	private HorizontalPanel addPanelOperand2 = new HorizontalPanel();
	private HorizontalPanel addPanelCalcButton = new HorizontalPanel();
	private HorizontalPanel addPanelResult = new HorizontalPanel();
	private TextBox operand1TextBox = new TextBox();
	private TextBox operand2TextBox = new TextBox();
	private MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	private Button multiply = new Button("*");
	private Button modulo = new Button("%");
	private Button division = new Button("/");
	private Button subtraction = new Button("-");
	private Button addition = new Button("+");
	private Button calculateButton = new Button("Calculate");
	private TextBox resultTextBox = new TextBox();

	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {
		//Suggests the valid operators
		oracle.add("*");
		oracle.add("%");
		oracle.add("/");
		oracle.add("-");
		oracle.add("+");
		
		addPanelOperand1.add(operand1TextBox);
		addPanelOp.add(multiply);
		addPanelOp.add(modulo);
		addPanelOp.add(division);
		addPanelOp.add(subtraction);
		addPanelOp.add(addition);
		addPanelOperand2.add(operand2TextBox);
		addPanelCalcButton.add(calculateButton);
		addPanelResult.add(resultTextBox);

		// TODO Assemble Main panel.	
		mainPanel.add(addPanelOperand1);
		mainPanel.add(addPanelOp);
		mainPanel.add(addPanelOperand2);
		mainPanel.add(addPanelCalcButton);
		mainPanel.add(addPanelResult);
		
		// TODO Associate the Main panel with the HTML host page.
		RootPanel.get("calc").add(mainPanel);
		
		operand1TextBox.setFocus(true);
		
		multiply.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcMulti();
						resultTextBox.setFocus(true);
					}});
			}});
		
		modulo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcModulo();
						resultTextBox.setFocus(true);
					}});
			}});
		
		division.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcDiv();
						resultTextBox.setFocus(true);
					}});
			}});
		
		subtraction.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcSub();
						resultTextBox.setFocus(true);
					}});
			}});
		
		addition.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcAdd();
						resultTextBox.setFocus(true);
					}});
			}});
		
		
		
	 
		operand1TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					calcMulti();
					calcModulo();
					calcDiv();
					calcSub();
					calcAdd();
				}

			}
		});
		

		operand2TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					calcMulti();
					calcModulo();
					calcDiv();
					calcSub();
					calcAdd();
				}

			}
		});
		
		
	
		/*operand2TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				//final String operator = operatorTextBox.getText().trim();
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					switch(operator) {
					case ("*"):
						calcMulti();
					break;
					case ("%"):
						calcModulo();
					break;
					case ("/"):
						calcDiv();
					break;
					case ("-"):
						calcSub();
					break;
					case ("+"):
						calcAdd();
					break;
					}
				}

			}
		}); */
	} 
	
	
	private void calcMulti() {
		 calculateButton.setFocus(true);
		 if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
			return;
		}
	
		double operandMulti1 = Double.parseDouble(operand1TextBox.getText());
		double operandMulti2 = Double.parseDouble(operand2TextBox.getText());
		double multiAnswer;
		
		if(multiply.getText().equals("*")) {
			multiAnswer= operandMulti1 * operandMulti2;
			String stringAnswer = Double.toString(multiAnswer);
			resultTextBox.setText(stringAnswer);
		}
	
	} 
	
	private void calcModulo() {
		calculateButton.setFocus(true);
		if (!isInteger(operand1TextBox.getText().trim())|| !isInteger(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
			return;
		}
	
		int operatorModulo1 = Integer.parseInt(operand1TextBox.getText());
		int operatorModulo2 = Integer.parseInt(operand2TextBox.getText());
		int moduloAnswer;
		if(modulo.getText().equals("%")) {
			moduloAnswer= operatorModulo1 % operatorModulo2;
			String stringAnswer = Double.toString(moduloAnswer);
			resultTextBox.setText(stringAnswer);
		}
		
	}
	
	private void calcDiv() {
		 calculateButton.setFocus(true);
		 if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
			return;
		}
	
		double operandDiv1 = Double.parseDouble(operand1TextBox.getText());
		double operandDiv2 = Double.parseDouble(operand2TextBox.getText());
		double divAnswer;
		
		if(division.getText().equals("/")) {
			divAnswer= operandDiv1 / operandDiv2;
			String stringAnswer = Double.toString(divAnswer);
			resultTextBox.setText(stringAnswer);
		}
	
	} 
	
	private void calcSub() {
		 calculateButton.setFocus(true);
		 if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
			return;
		}
	
		double operandSub1 = Double.parseDouble(operand1TextBox.getText());
		double operandSub2 = Double.parseDouble(operand2TextBox.getText());
		double subAnswer;
		
		if(subtraction.getText().equals("-")) {
			subAnswer= operandSub1 - operandSub2;
			String stringAnswer = Double.toString(subAnswer);
			resultTextBox.setText(stringAnswer);
		}
	
	} 
	
	private void calcAdd() {
		 calculateButton.setFocus(true);
		 if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
			return;
		}
	
		double operandAdd1 = Double.parseDouble(operand1TextBox.getText());
		double operandAdd2 = Double.parseDouble(operand2TextBox.getText());
		double addAnswer;
		
		if(addition.getText().equals("+")) {
			addAnswer= operandAdd1 + operandAdd2;
			String stringAnswer = Double.toString(addAnswer);
			resultTextBox.setText(stringAnswer);
		}
	
	} 
	
	//Checks if a String could be seen as an integer
	public boolean isInteger( String input )
	{
		try
		{
			Integer.parseInt( input );
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}

	//Checks if a String could be seen as double
	public boolean isDouble( String input )
	{
		try
		{
			Double.parseDouble( input );
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}