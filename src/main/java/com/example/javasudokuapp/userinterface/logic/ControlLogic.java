package com.example.javasudokuapp.userinterface.logic;

import com.example.javasudokuapp.computation_logic.GameLogic;
import com.example.javasudokuapp.constants.GameState;
import com.example.javasudokuapp.constants.Messages;
import com.example.javasudokuapp.problems.Istorage;
import com.example.javasudokuapp.problems.SudokuGame;
import com.example.javasudokuapp.userinterface.IUserInterFaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterFaceContract.EventListener {
    private Istorage storage;
    private IUserInterFaceContract.View view;

    public ControlLogic(Istorage storage, IUserInterFaceContract.View view){
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;
            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );
            storage.updateGame(gameData);
            view.updateSquare(x,y,input);
            if (gameData.getGameState() == GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        } catch (IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try {
            storage.updateGame(
                    GameLogic.getNewGame()
            );
            view.updateBoard(storage.getGameData());
        }catch (IOException e){
            view.showError(Messages.ERROR);
        }
    }
}
