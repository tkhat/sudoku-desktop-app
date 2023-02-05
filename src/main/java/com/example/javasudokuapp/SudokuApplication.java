package com.example.javasudokuapp;

import com.example.javasudokuapp.buildLogic.SudokuBuildLogic;
import com.example.javasudokuapp.userinterface.IUserInterFaceContract;
import com.example.javasudokuapp.userinterface.UserInterfaceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterFaceContract.View uiImpl;
    @Override
    public void start(Stage stage) throws IOException {
        uiImpl = new UserInterfaceImpl(stage);
        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}