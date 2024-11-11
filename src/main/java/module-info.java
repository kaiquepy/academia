module com.academia {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires com.google.gson;


    opens com.academia to javafx.fxml;
    opens com.academia.funcionario.model to com.google.gson;
    opens com.academia.cliente.model to com.google.gson;
    opens com.academia.sala.model to com.google.gson;
    opens com.academia.loja.model to com.google.gson;
    opens com.academia.produto.model to com.google.gson;
    opens com.academia.estoque.model to com.google.gson;
    opens com.academia.usuario.model to com.google.gson;
    exports com.academia;
}