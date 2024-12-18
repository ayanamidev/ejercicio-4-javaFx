package net.liceo.bar.exercicioexame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberController {
    @FXML
    public TextField numberField;
    @FXML
    public HBox hbox;
    @FXML
    public Label numbersLabel;
    @FXML
    public Button ordenar;

    private List<TextField> numbersFields;
    private boolean flagReverse = true;

    public void onEnviarNumeroButtonClick(ActionEvent actionEvent) {
        int totalNumbers = 0;
        try {
            totalNumbers = Integer.parseInt(numberField.getText().trim());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        borrarHBox(hbox);
        numbersFields = new ArrayList<>();
        for (int i=0; i<totalNumbers; i++) {
            Label label = new Label("Number " + i);
            TextField number = new TextField();
            VBox numbersBox = new VBox(label, number);
            //Se guarda el campo de texto (TextField) en la lista numbersFields.
            //Esto permite guardar todos los valores que el usuario introduzca en esos campos más tarde.
            numbersFields.add(number);//numberField es el array con todos los textfield

            hbox.getChildren().add(numbersBox);
            //El VBox (que contiene la etiqueta y el campo de texto) se añade como hijo del HBox.
            //Esto hace que los componentes se muestren en fila horizontal dentro del HBox.
        }
        hbox.setDisable(false);
        ordenar.setDisable(false);
    }

    private void borrarHBox(HBox numbersHBox) {
        //Los elementos en el HBox (botones, etiquetas, etc.) no podrán interactuar con el usuario.
        //Visualmente, suele verse como atenuado (grisado).
        numbersHBox.setDisable(true);
        //getChildren() devuelve la lista de nodos hijos (Node) que están dentro del HBox.
        //clear() elimina todos esos elementos hijos, dejando el HBox vacío.
        numbersHBox.getChildren().clear();
    }

    public void onOrdenarButtonClick(ActionEvent actionEvent) {
        List<Integer> numbers = new ArrayList<>();
        //lista de textfields
        numbersFields.stream().forEach(n->{
            //Añade a la lista el valor de cada textfield
            try {
                numbers.add(Integer.parseInt(n.getText().trim()));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        });
        if (flagReverse){
            Collections.sort(numbers);
            flagReverse=false;
        }else {
            Collections.sort(numbers, Collections.reverseOrder());
            flagReverse = true;
        }
        String numberString = new String("");
        //4 5 6 7 (añade cada numero ordenado de la lista de numbers)
        for (Integer number : numbers ){
            numberString += number + " ";
        }
        numbersLabel.setText(numberString);
        numbersLabel.setDisable(false);

    }
}
