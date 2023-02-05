module com.example.javasudokuapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javasudokuapp to javafx.fxml;
    exports com.example.javasudokuapp;
    exports com.example.javasudokuapp.problems;
    opens com.example.javasudokuapp.problems to javafx.fxml;
}