/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package DomenskiObjekat;

/**
 *
 * @author Korisnik
 */
public enum StatusIgre {

    U_TOKU(0),
    ZAVRSENA(1);

    private final int dbValue;

    StatusIgre(int dbValue) {
        this.dbValue = dbValue;
    }

    public int getDbValue() {
        return dbValue;
    }

    public static StatusIgre fromDb(int value) {
        for (StatusIgre s : values()) {
            if (s.dbValue == value) {
                return s;
            }
        }
        throw new IllegalArgumentException("Nepoznat status: " + value);
    }
}
