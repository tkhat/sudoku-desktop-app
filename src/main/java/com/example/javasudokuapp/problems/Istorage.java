package com.example.javasudokuapp.problems;

import java.io.IOException;

public interface Istorage {
    void updateGame(SudokuGame game) throws IOException;
    SudokuGame getGameData() throws  IOException;

}
