/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rang_lista;

import Server_client.Igra;
import java.net.URL;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Korisnik
 */
public class JFXRangLista extends Application {

    FXMLRangListaController con;
    private List<Igra> listaIgara;
    private String nivo;

    public JFXRangLista(List<Igra> listaIgara, String nivo) {
        this.listaIgara = listaIgara;
        this.nivo = nivo;
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL location = getClass().getResource("/rang_lista/FXMLRangLista.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLRangListaController) fxmlLoader.getController();
        con.setData(listaIgara, nivo);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/rang_lista.css");
        stage.setScene(scene);
        stage.setTitle("Rang lista");
        stage.show();
    }

}
