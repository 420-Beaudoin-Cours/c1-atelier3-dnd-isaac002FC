package sample;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;

import javax.swing.text.html.ImageView;

public class Controller {

    public void initialize(){



    }

    public void txfSourceDragDetected(MouseEvent mouseEvent) {



        TextField ref = (TextField) mouseEvent.getSource();

        if(!ref.getText().equals("")){

            Dragboard db = ref.startDragAndDrop(TransferMode.ANY);

            ClipboardContent content = new ClipboardContent();
            content.putString((ref.getText()));
            db.setContent(content);
        }


    }


    public void imgTargetDragDropped(DragEvent dragEvent) {

        TextField refSource = (TextField) dragEvent.getGestureSource();
        
        refSource.clear();

    }

    public void imgTargetDragOver(DragEvent dragEvent) {

        dragEvent.acceptTransferModes(TransferMode.ANY);

    }

    public void cmbTargetDragDropped(DragEvent dragEvent) {

        TextField refSource = (TextField) dragEvent.getGestureSource();
        ComboBox refTarget = (ComboBox) dragEvent.getGestureTarget();

        refTarget.getItems().addAll(refSource.getText());

    }

    public void cmbTargetDragOver(DragEvent dragEvent) {

        dragEvent.acceptTransferModes(TransferMode.ANY);

    }
}
