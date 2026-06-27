/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package Server;

import DomenskiObjekat.Igra;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.NivoTezine;
import so.SORegistrujKorisnika;
import java.util.List;
import javax.jws.WebService;
import so.SOVratiRangListu;

/**
 *
 * @author Korisnik
 */
@WebService(serviceName = "GenerickiKontrolerServer")
public class GenerickiKontrolerServer {

    public int registrujKorisnika(Korisnik korisnik) throws Exception {
        SORegistrujKorisnika so = new SORegistrujKorisnika(Korisnik.class);
        so.templateExecute(korisnik);
        return so.getId();
    }

    public List<Igra> vratiRangListu(int nivoTezine) throws Exception {
        Igra igra = new Igra();
        igra.setNivoTezine(NivoTezine.fromDb(nivoTezine));
    
        SOVratiRangListu so = new SOVratiRangListu(Igra.class);
        so.templateExecute(igra);
        return so.getListaObjekata();
    }
}
