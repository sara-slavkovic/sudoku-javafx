/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Database;

import DomenskiObjekat.AbstractDomainObject;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface AbstractBroker {

    public int insert(AbstractDomainObject ado) throws Exception;

    public List<AbstractDomainObject> selectList(AbstractDomainObject ado) throws Exception;

    public List<AbstractDomainObject> selectListByCondition(AbstractDomainObject ado) throws Exception;

    public AbstractDomainObject selectObject(AbstractDomainObject ado) throws Exception;

    public int update(AbstractDomainObject ado) throws Exception;

    public int delete(AbstractDomainObject ado) throws Exception;
}
