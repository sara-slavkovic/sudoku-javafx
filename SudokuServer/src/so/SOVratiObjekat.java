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
public class SOVratiObjekat<T extends AbstractDomainObject> extends AbstractSO {

    private T objekat;
    private Class<T> type;

    public SOVratiObjekat(Class<T> type) {
        this.type = type;
    }

    public T getObjekat() {
        return objekat;
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
        AbstractDomainObject object;
        object = DBBroker.getInstance().selectObject(ado);
        objekat = type.cast(object);
    }

}
