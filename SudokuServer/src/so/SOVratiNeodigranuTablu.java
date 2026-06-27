/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import Database.DBBroker;
import DomenskiObjekat.AbstractDomainObject;
import DomenskiObjekat.Igra;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.SudokuTabla;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class SOVratiNeodigranuTablu extends AbstractSO {

    private SudokuTabla neodigrana;
    private Korisnik korisnik;

    public SOVratiNeodigranuTablu(Class<SudokuTabla> type, Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public SudokuTabla getNeodigrana() {
        return neodigrana;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        if (obj == null || !(obj instanceof SudokuTabla)) {
            throw new Exception("Prosledjeni objekat nije SudokuTabla.");
        }
        if (((SudokuTabla) obj).getNivoTezine() == null) {
            throw new Exception("Nivo tezine nije prosledjen.");
        }
        if (korisnik == null || korisnik.getId() == 0) {
            throw new Exception("Korisnik nije prosledjen.");
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        SudokuTabla param = (SudokuTabla) obj;

        //uzmi sve table tog nivoa
        param.setWhereGetCondition("WHERE s.nivoTezine = " + param.getNivoTezine().getDbValue());
        List<AbstractDomainObject> rezultatTabli = DBBroker.getInstance().selectListByCondition(param);

        if (rezultatTabli == null || rezultatTabli.isEmpty()) {
            neodigrana = null;
            return;
        }

        //uzmi id-jeve odigranih tabli ovog korisnika
        Igra igraParam = new Igra();
        igraParam.setKorisnik(korisnik);
        igraParam.setWhereGetCondition("WHERE i.korisnik_id = " + korisnik.getId());

        List<AbstractDomainObject> rezultatIgara = DBBroker.getInstance().selectListByCondition(igraParam);
        List<Integer> idOdigranihTabli = new ArrayList<>();
        if (rezultatIgara != null) {
            for (AbstractDomainObject ado : rezultatIgara) {
                idOdigranihTabli.add(((Igra) ado).getSudokuTabla().getId());
            }
        }

        //nadji prvu tablu koja nije odigrana
        for (AbstractDomainObject ado : rezultatTabli) {
            SudokuTabla t = (SudokuTabla) ado;
            if (!idOdigranihTabli.contains(t.getId())) {
                neodigrana = t;
                break;
            }
        }
    }

}
