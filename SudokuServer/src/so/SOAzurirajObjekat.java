/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import Database.DBBroker;
import DomenskiObjekat.AbstractDomainObject;

/**
 *
 * @author Korisnik
 */
public class SOAzurirajObjekat<T extends AbstractDomainObject> extends AbstractSO {

    private Class<T> type;

    public SOAzurirajObjekat(Class<T> type) {
        this.type = type;
    }

    @Override
    protected void validate(Object obj) throws Exception {
        AbstractDomainObject ado = (AbstractDomainObject) obj;

        if (ado == null || !type.isInstance(obj)) {
            throw new Exception("Prosledjeni objekat nije instanca klase " + type.getSimpleName());
        }
    }

    @Override
    protected void execute(Object obj) throws Exception {
        T ado = type.cast(obj);
        DBBroker.getInstance().update(ado);
    }

}
