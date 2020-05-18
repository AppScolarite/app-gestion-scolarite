package com.javafx.ourproject.Controllers;

import com.javafx.ourproject.Services.BranchServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    public MenuItem deleteUsers;

    @FXML
    private AnchorPane anchorPane;
    Stage stage;

    @FXML
    private Pane panelNotes;

    @FXML
    private Button btnAccueil;

    @FXML
    private Button btnListes;

    @FXML
    private Button btnStatistiques;

    @FXML
    private Button btnGestion;

    @FXML
    private Button btnNotes;

    @FXML
    private TableView tblView;

    @FXML
    private BorderPane panelGestion;

//    @Autowired
//    private BrancheRepository brancheRepository;

//    @Autowired
//    BranchServiceImpl brancheService;

    @FXML
    private void btnClose_Click(ActionEvent e) {
//        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
//        stage.close();

//        System.out.println("just testing hibernate");
////        System.out.println(brancheRepository.findById(1).orElseThrow(()-> new RuntimeException("Exception rejeter !")));
//        System.out.println(brancheService.listAll().size());

    }

    @FXML
    private void btnMinimize_Click(ActionEvent e) {
        stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void btnNotes_click(ActionEvent e) {
        //todo
        //regler TAB design

        btnNotes.setStyle("-fx-background-color : #02030A");
        btnNotes.setStyle("-fx-background-radius :  30 0 0 30;");

//        tblView.getItems().add(0, "Doe");
        panelNotes.toFront();
    }

    @FXML
    private void btnGestion_click(ActionEvent e) {
        panelGestion.toFront();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        Node[] nodes = new Node[10];
//        for (int i = 0; i < nodes.length; i++) {
//            try {
//
//                final int j = i;
//                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));
//
//                //give the items some effect
//
//                nodes[i].setOnMouseEntered(event -> {
//                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
//                });
//                nodes[i].setOnMouseExited(event -> {
//                    nodes[j].setStyle("-fx-background-color : #02030A");
//                });
//                pnItems.getChildren().add(nodes[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


//    public void handleClicks(ActionEvent actionEvent) {
//        if (actionEvent.getSource() == btnCustomers) {
//            pnlCustomer.setStyle("-fx-background-color : #1620A1");
//            pnlCustomer.toFront();
//        }
//        if (actionEvent.getSource() == btnMenus) {
//            pnlMenus.setStyle("-fx-background-color : #53639F");
//            pnlMenus.toFront();
//        }
//        if (actionEvent.getSource() == btnOverview) {
//            pnlOverview.setStyle("-fx-background-color : #02030A");
//            pnlOverview.toFront();
//        }
//        if(actionEvent.getSource()==btnOrders)
//        {
//            pnlOrders.setStyle("-fx-background-color : #464F67");
//            pnlOrders.toFront();
//        }
//    }
}
