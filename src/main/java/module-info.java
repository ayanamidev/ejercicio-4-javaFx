module net.liceo.bar.exercicioexame {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.liceo.bar.exercicioexame to javafx.fxml;
    exports net.liceo.bar.exercicioexame;
}