module br.com.milhoverde.academia.academia {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.milhoverde.academia.academia to javafx.fxml;
    exports br.com.milhoverde.academia.academia;
}