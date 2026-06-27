/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package DomenskiObjekat;

/**
 *
 * @author Korisnik
 */
public enum NivoTezine {
    LAK(0),
    SREDNJI(1),
    TEZAK(2);

    private final int dbValue;

    NivoTezine(int dbValue) {
        this.dbValue = dbValue;
    }

    public int getDbValue() {
        return dbValue;
    }

    public static NivoTezine fromDb(int value) {
        for (NivoTezine n : values()) {
            if (n.dbValue == value) {
                return n;
            }
        }
        throw new IllegalArgumentException("Nepoznat nivo tezine: " + value);
    }
}
