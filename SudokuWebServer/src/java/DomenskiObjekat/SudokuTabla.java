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
public class SudokuTabla extends AbstractDomainObject {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String pocetnaTabla;
    private String resenjeTabla;
    private NivoTezine nivoTezine;

    private String whereGetCondition;

    public SudokuTabla() {
    }

    public SudokuTabla(Integer id, String pocetnaTabla, String resenjeTabla, NivoTezine nivoTezine) {
        this.id = id;
        this.pocetnaTabla = pocetnaTabla;
        this.resenjeTabla = resenjeTabla;
        this.nivoTezine = nivoTezine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPocetnaTabla() {
        return pocetnaTabla;
    }

    public void setPocetnaTabla(String pocetnaTabla) {
        this.pocetnaTabla = pocetnaTabla;
    }

    public String getResenjeTabla() {
        return resenjeTabla;
    }

    public void setResenjeTabla(String resenjeTabla) {
        this.resenjeTabla = resenjeTabla;
    }

    public NivoTezine getNivoTezine() {
        return nivoTezine;
    }

    public void setNivoTezine(NivoTezine nivoTezine) {
        this.nivoTezine = nivoTezine;
    }

    public void setWhereGetCondition(String whereGetCondition) {
        this.whereGetCondition = whereGetCondition;
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
        final SudokuTabla other = (SudokuTabla) obj;
        if (!Objects.equals(this.pocetnaTabla, other.pocetnaTabla)) {
            return false;
        }
        if (!Objects.equals(this.resenjeTabla, other.resenjeTabla)) {
            return false;
        }
        if (!Objects.equals(this.nivoTezine, other.nivoTezine)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "SudokuTabla{" + "id=" + id + ", pocetnaTabla=" + pocetnaTabla + ", resenjeTabla=" + resenjeTabla + ", nivoTezine=" + nivoTezine + '}';
    }

    @Override
    public String textJoin() {
        return "";
    }

    @Override
    public String insertColumns() {
        return "(pocetnaTabla, resenjeTabla, nivoTezine)";
    }

    @Override
    public String insertValues() {
        return "'" + pocetnaTabla + "', '" + resenjeTabla + "', " + nivoTezine.getDbValue();
    }

    @Override
    public String updateValues() {
        return "pocetnaTabla='" + pocetnaTabla + "', " + "resenjeTabla='" + resenjeTabla + "', " + "nivoTezine=" + nivoTezine.getDbValue();
    }

    @Override
    public String conditionForSelect() {
        return "";
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
            int id = rs.getInt("s.id");
            String pocetnaTabla = rs.getString("s.pocetnaTabla");
            String resenjeTabla = rs.getString("s.resenjeTabla");
            NivoTezine nivoTezine = NivoTezine.fromDb(rs.getInt("s.nivoTezine"));

            SudokuTabla tabla = new SudokuTabla(id, pocetnaTabla, resenjeTabla, nivoTezine);
            lista.add(tabla);
        }
        rs.close();
        return lista;
    }

}
