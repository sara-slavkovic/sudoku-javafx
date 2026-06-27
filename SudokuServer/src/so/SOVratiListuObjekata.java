/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import Database.DBBroker;
import DomenskiObjekat.AbstractDomainObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Korisnik
 */
public class SOVratiListuObjekata<T extends AbstractDomainObject> extends AbstractSO {

    private List<T> listaObjekata;
    private Class<T> type;

    public SOVratiListuObjekata(Class<T> type) {
        this.type = type;
    }

    public List getListaObjekata() {
        return listaObjekata;
    }

    public void setListaObjekata(List listaObjekata) {
        this.listaObjekata = listaObjekata;
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
        List<AbstractDomainObject> lista = DBBroker.getInstance().selectListByCondition(ado);
        listaObjekata = lista.stream()
                .map(type::cast)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
