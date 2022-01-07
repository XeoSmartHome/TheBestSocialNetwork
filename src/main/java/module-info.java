module com.example.thebestsocialnetwork {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.thebestsocialnetwork to javafx.fxml;
    exports com.example.thebestsocialnetwork;
}