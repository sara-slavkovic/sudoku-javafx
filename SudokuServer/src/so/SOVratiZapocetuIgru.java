/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import DomenskiObjekat.Igra;
import DomenskiObjekat.StatusIgre;

/**
 *
 * @author Korisnik
 */
public class SOVratiZapocetuIgru extends SOVratiObjekat<Igra> {

    public SOVratiZapocetuIgru(Class<Igra> type) {
        super(type);
    }

    @Override
    protected void validate(Object obj) throws Exception {
        super.validate(obj);

        Igra igra = (Igra) obj;

        if (igra.getKorisnik() == null || igra.getKorisnik().getId() == 0) {
            throw new Exception("Korisnik nije prosledjen.");
        }

        igra.setWhereGetCondition(
                "WHERE i.korisnik_id=" + igra.getKorisnik().getId()
                + " AND i.status=" + StatusIgre.U_TOKU.getDbValue()
                + " ORDER BY i.id DESC LIMIT 1"
        );
    }
}
