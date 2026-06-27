/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public abstract class AbstractDomainObject implements Serializable {

    public String tableName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    public String alies() {
        return this.getClass().getSimpleName().substring(0, 1).toLowerCase();
    }

    public abstract String textJoin();

    public abstract String insertColumns();

    public abstract String insertValues();

    public abstract String updateValues();

    public String requiredCondition() {
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().startsWith("id")) {
                try {
                    if (field.getType().equals(Integer.class)) {
                        return field.getName() + "=" + (Integer) field.get(this);
                    }
                    if (field.getType().equals(int.class)) {
                        return field.getName() + "=" + (int) field.get(this);
                    }
                    if (field.getType().equals(long.class)) {
                        return field.getName() + "=" + (long) field.get(this);
                    }
                    if (field.getType().equals(Long.class)) {
                        return field.getName() + "=" + (Long) field.get(this);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    return "";
                }
            }
        }
        return "";
    }

    public abstract String conditionForSelect();

    public String getCondition() {
        return "WHERE " + alies() + "." + requiredCondition();
    }

    public abstract ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException;

}
