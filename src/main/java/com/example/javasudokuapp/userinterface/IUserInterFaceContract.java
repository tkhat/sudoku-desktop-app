package com.example.javasudokuapp.userinterface;

import com.example.javasudokuapp.problems.SudokuGame;

public interface IUserInterFaceContract {
    interface EventListener {
        void onSudokuInput(int x, int y, int input);

        void onDialogClick();
    }

    interface View {
        void setListener(IUserInterFaceContract.EventListener listener);

        void updateSquare(int x, int y, int input);

        void updateBoard(SudokuGame game);

        void showDialog(String Message);

        void showError(String message);
    }
}
