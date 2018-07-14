package com.vedantmehta.javaapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
@FXML
public Label welcome;

@FXML
public ChoiceBox<String> choose;

@FXML
public TextField temp;

@FXML
public javafx.scene.control.Button convert;


private  boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choose.getItems().add("Celsius to Fahrenheit");
		choose.getItems().add("Fahrenheit to Celsius");
		choose.setValue("Celsius to Fahrenheit");

		choose.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

				if(newValue.equals("Celsius to Fahrenheit")){

					isC_TO_F = true;
				}
				else {

					isC_TO_F = false;
				}

		});

		convert.setOnAction(event -> convertIt());

	}
	private void convertIt(){

			String input =	temp.getText();

			float user = 0.0f;
			try
			{
				 user = Float.parseFloat(input);

			}catch (Exception exe){

				warning();
				return;
				// no code is executed after this

			}



			float newtemp = 0.0f;

			if (isC_TO_F)
			{
				newtemp = (user*9/5) + 32;
			}
			else
			{
				newtemp = (user-32)*5/9;
			}
			 
			display(newtemp);


	}

	private void warning() {

		Alert ale = new Alert(Alert.AlertType.ERROR);
		ale.setTitle("ERROR OCCURED");
		ale.setContentText("please enter the valid temperature");
		ale.show();
	}

	private void display(float newtemp) {

		String unit = isC_TO_F? "F" : "C"; // ternary operator

	//System.out.println("the new temperature is " + newtemp + unit);

		Alert al = new Alert(Alert.AlertType.INFORMATION);
		al.setTitle("RESULT");
		al.setContentText("The new temperature is " + newtemp + unit);
		al.show();

	}

}
