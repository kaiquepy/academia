module br.com.milhoverde.academia.academia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.academia to javafx.fxml;
    exports com.academia;
}