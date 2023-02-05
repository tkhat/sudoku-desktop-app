package com.example.javasudokuapp.buildLogic;

import com.example.javasudokuapp.computation_logic.GameLogic;
import com.example.javasudokuapp.persistance.LocalStorageImpl;
import com.example.javasudokuapp.problems.Istorage;
import com.example.javasudokuapp.problems.SudokuGame;
import com.example.javasudokuapp.userinterface.IUserInterFaceContract;
import com.example.javasudokuapp.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterFaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        Istorage storage = new LocalStorageImpl();
        try {
            initialState = storage.getGameData();
        } catch (IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGame(initialState);
        }
        IUserInterFaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);

    }
}
