/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pocetna;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import login.JFXLogin;
import register.JFXRegister;
import soket_klijent_kontroler.KontrolerKlijent;

/**
 *
 * @author Korisnik
 */
public class KontrolerGUIPocetna {

    FXMLPocetnaController fxcon;

    public KontrolerGUIPocetna(FXMLPocetnaController fxcon) {
        this.fxcon = fxcon;

        try {
            Socket socket = new Socket("localhost", 9000);
            KontrolerKlijent.getInstance().initStreams(socket);

            this.fxcon.login.setOnAction(e -> login());
            this.fxcon.register.setOnAction(e -> register());
        } catch (IOException ex) {
            Logger.getLogger(KontrolerGUIPocetna.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Server nije pokrenut, pokušajte kasnije.");
        }
    }

    public void login() {
        try {
            JFXLogin loginStage;
            Stage s;
            loginStage = new JFXLogin();
            s = new Stage();

            loginStage.start(s);
            fxcon.closeStage();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerGUIPocetna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register() {
        try {
            JFXRegister registerStage;
            Stage s;
            registerStage = new JFXRegister();
            s = new Stage();

            registerStage.start(s);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerGUIPocetna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
