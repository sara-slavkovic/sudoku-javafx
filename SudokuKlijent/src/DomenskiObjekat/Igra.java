/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class Igra extends AbstractDomainObject {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private int vremeResavanja;
    private int brojGresaka;
    private NivoTezine nivoTezine;
    private StatusIgre status;
    private String trenutnoStanje; //81 karaktera popunjenosti sudoku table 0-9
    private Date datumIgre;
    private Korisnik korisnik;
    private SudokuTabla sudokuTabla;

    public Igra() {
    }

    public Igra(int id, int vremeResavanja, int brojGresaka, NivoTezine nivoTezine,
            StatusIgre status, String trenutnoStanje, Date datumIgre,
            Korisnik korisnik, SudokuTabla sudokuTabla) {
        this.id = id;
        this.vremeResavanja = vremeResavanja;
        this.brojGresaka = brojGresaka;
        this.nivoTezine = nivoTezine;
        this.status = status;
        this.trenutnoStanje = trenutnoStanje;
        this.datumIgre = datumIgre;
        this.korisnik = korisnik;
        this.sudokuTabla = sudokuTabla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVremeResavanja() {
        return vremeResavanja;
    }

    public void setVremeResavanja(int vremeResavanja) {
        this.vremeResavanja = vremeResavanja;
    }

    public int getBrojGresaka() {
        return brojGresaka;
    }

    public void setBrojGresaka(int brojGresaka) {
        this.brojGresaka = brojGresaka;
    }

    public NivoTezine getNivoTezine() {
        return nivoTezine;
    }

    public void setNivoTezine(NivoTezine nivoTezine) {
        this.nivoTezine = nivoTezine;
    }

    public StatusIgre getStatus() {
        return status;
    }

    public void setStatus(StatusIgre status) {
        this.status = status;
    }

    public String getTrenutnoStanje() {
        return trenutnoStanje;
    }

    public void setTrenutnoStanje(String trenutnoStanje) {
        this.trenutnoStanje = trenutnoStanje;
    }

    public Date getDatumIgre() {
        return datumIgre;
    }

    public void setDatumIgre(Date datumIgre) {
        this.datumIgre = datumIgre;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public SudokuTabla getSudokuTabla() {
        return sudokuTabla;
    }

    public void setSudokuTabla(SudokuTabla sudokuTabla) {
        this.sudokuTabla = sudokuTabla;
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
        final Igra other = (Igra) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Igra{" + "id=" + id + ", vremeResavanja=" + vremeResavanja
                + ", brojGresaka=" + brojGresaka + ", nivoTezine=" + nivoTezine
                + ", status=" + status + ", trenutnoStanje=" + trenutnoStanje
                + ", datumIgre=" + datumIgre + ", korisnik=" + korisnik
                + ", sudokuTabla=" + sudokuTabla + '}';
    }

    @Override
    public String textJoin() {
        return "JOIN korisnik k ON k.id = i.korisnik_id "
                + "JOIN sudokutabla s ON s.id = i.sudokutabla_id";
    }

    @Override
    public String insertColumns() {
        return "(vremeResavanja, brojGresaka, nivoTezine, status, trenutnoStanje, datumIgre, korisnik_id, sudokutabla_id)";
    }

    @Override
    public String insertValues() {
        return vremeResavanja + ", " + brojGresaka + ", " + nivoTezine.getDbValue() + ", " + status.getDbValue() + ", '" + trenutnoStanje + "', '" + datumIgre + "', " + korisnik.getId() + ", " + sudokuTabla.getId();
    }

    @Override
    public String updateValues() {
        return "vremeResavanja=" + vremeResavanja + ", brojGresaka=" + brojGresaka + ", nivoTezine=" + nivoTezine.getDbValue() + ", status=" + status.getDbValue() + ", trenutnoStanje='" + trenutnoStanje + "'" + ", datumIgre='" + datumIgre + "'" + ", korisnik_id=" + korisnik.getId() + ", sudokutabla_id=" + sudokuTabla.getId();
    }

    //rang lista
    @Override
    public String conditionForSelect() {
        return " WHERE i.status = 1 ORDER BY i.vremeResavanja ASC, i.brojGresaka ASC LIMIT 10";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("i.id");
            int vremeResavanja = rs.getInt("i.vremeResavanja");
            int brojGresaka = rs.getInt("i.brojGresaka");
            NivoTezine nivoTezine = NivoTezine.fromDb(rs.getInt("i.nivoTezine"));
            StatusIgre status = StatusIgre.fromDb(rs.getInt("i.status"));
            String trenutnoStanje = rs.getString("i.trenutnoStanje");
            Date datumIgre = rs.getDate("i.datumIgre");

            Korisnik korisnik = new Korisnik(
                    rs.getInt("k.id"),
                    rs.getString("k.korisnickoIme"),
                    rs.getString("k.lozinka")
            );

            SudokuTabla tabla = new SudokuTabla(
                    rs.getInt("s.id"),
                    rs.getString("s.pocetnaTabla"),
                    rs.getString("s.resenjeTabla"),
                    NivoTezine.fromDb(rs.getInt("s.nivoTezine"))
            );

            Igra igra = new Igra(id, vremeResavanja, brojGresaka, nivoTezine, status, trenutnoStanje, datumIgre, korisnik, tabla);
            lista.add(igra);
        }

        rs.close();
        return lista;
    }
}
