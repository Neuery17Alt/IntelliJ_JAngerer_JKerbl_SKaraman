module com.example.rockpaperscissors {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.rockpaperscissors to javafx.fxml;
    exports com.example.rockpaperscissors;
}