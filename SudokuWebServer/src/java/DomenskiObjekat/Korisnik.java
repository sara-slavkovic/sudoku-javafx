/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Korisnik extends AbstractDomainObject {

    private static final long serialVersionUID = 1L;

    private int id;
    private String korisnickoIme;
    private String lozinka;

    private String whereGetCondition;

    public Korisnik() {
    }

    public Korisnik(int id, String korisnickoIme, String lozinka) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

    @Override
    public String toString() {
        return korisnickoIme;
    }

    @Override
    public String textJoin() {
        return "";
    }

    @Override
    public String insertColumns() {
        return "(korisnickoIme, lozinka)";
    }

    @Override
    public String insertValues() {
        return "'" + korisnickoIme + "', '" + lozinka + "'";
    }

    @Override
    public String updateValues() {
        return "korisnickoIme='" + korisnickoIme + "', lozinka='" + lozinka + "'";
    }

    @Override
    public String conditionForSelect() {
        return "";
    }

    public void setWhereGetCondition(String whereGetCondition) {
        this.whereGetCondition = whereGetCondition;
    }

    @Override
    public String getCondition() {
        return whereGetCondition == null ? "" : whereGetCondition;
        //return whereGetCondition;
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("k.id");
            String korisnickoIme = rs.getString("k.korisnickoIme");
            String lozinka = rs.getString("k.lozinka");
            Korisnik korisnik = new Korisnik(id, korisnickoIme, lozinka);
            lista.add(korisnik);
        }
        rs.close();
        return lista;
    }
}
