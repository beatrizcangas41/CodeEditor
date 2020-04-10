package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import util.DialogCreator;
import util.SceneChange;

public class LanguagePickerController {

    public Button backButton;
    public Button C_PlusPlus_Button, Java_Button, JavaScript_Button, SQL_Button,
                    Swift_Button, ObjectiveC_Button, Ruby_Button, Python_Button;

    public void C_PlusPlus(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/ModulePickerUI.fxml",C_PlusPlus_Button);
    }

    public void Java(ActionEvent actionEvent) {
        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void JavaScript(ActionEvent actionEvent) {
        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void SQL(ActionEvent actionEvent) {
        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void Swift(ActionEvent actionEvent) {
        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void ObjectiveC(ActionEvent actionEvent) {
        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void Ruby(ActionEvent actionEvent) {
        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void Python(ActionEvent actionEvent) {
        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }
}
