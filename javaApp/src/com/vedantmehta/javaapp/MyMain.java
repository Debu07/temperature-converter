package com.vedantmehta.javaapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {


	public static void main(String[] args) {


		launch(args);


	}

	@Override
	public void start(Stage primaryStage) throws Exception {


		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter");
		//primaryStage.setResizable(false);
		primaryStage.show();


	}

	private MenuBar createMenu() {

		Menu fileMenu = new Menu("File");
		//MenuItem newMenuItem = new MenuItem("new game");

		//newMenuItem.setOnAction(event -> System.out.println("new is pressed"));
		//SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("quit ");


		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(/*newMenuItem, separatorMenuItem, */quitMenuItem);


		Menu helpMenu = new Menu("Help");

		MenuItem aboutHelpItem = new MenuItem("How To DO");
		aboutHelpItem.setOnAction(event -> aboutApp());

		//MenuItem aboutDHelpItem = new MenuItem("Vedant Mehta");
		helpMenu.getItems().addAll(/*aboutDHelpItem,*/aboutHelpItem);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;

	}

	private void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Temperature converter tool");
		//alertDialog.setHeaderText("learning javaFX");
		alertDialog.setContentText("choose the conversion type. and then enter a valid temperature you want to conert then press convert button. it is very easy to use.");


		ButtonType yesbtn = new ButtonType("yes");


		ButtonType nobtn = new ButtonType("NO");

		alertDialog.getButtonTypes().setAll(yesbtn,nobtn);
		//alertDialog.show();
		Optional<ButtonType> clickedbtn = alertDialog.showAndWait();

		if (clickedbtn.isPresent() && clickedbtn.get() == yesbtn){

			System.out.println("yes");
		}
		if (clickedbtn.isPresent() && clickedbtn.get() == nobtn){

			System.out.println("No");
		}
	}
}
