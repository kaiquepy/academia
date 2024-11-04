module com.academia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.academia to javafx.fxml;
    exports com.academia;
}