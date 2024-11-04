module com.academia {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;


    opens com.academia to javafx.fxml;
    exports com.academia;
}