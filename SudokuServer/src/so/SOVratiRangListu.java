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
public class SOVratiRangListu extends SOVratiListuObjekata<Igra> {

    public SOVratiRangListu(Class<Igra> type) {
        super(type);
    }

    @Override
    protected void validate(Object obj) throws Exception {
        super.validate(obj);

        Igra igra = (Igra) obj;

        String uslov = "WHERE i.status=" + StatusIgre.ZAVRSENA.getDbValue();

        // ako je nivo prosledjen, filtriraj i po nivou
        if (igra.getNivoTezine() != null) {
            uslov += " AND i.nivoTezine=" + igra.getNivoTezine().getDbValue();
        }

        uslov += " ORDER BY i.vremeResavanja ASC, i.brojGresaka ASC LIMIT 10";

        igra.setWhereGetCondition(uslov);
    }
}
