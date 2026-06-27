/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konverter;

import DomenskiObjekat.AbstractDomainObject;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Korisnik
 */
public class KonverterGUIDK {

    public static boolean konvertujGUIUDK(Object fxcon, AbstractDomainObject gdo) {
        for (Field f : fxcon.getClass().getDeclaredFields()) {
            for (Field dk : gdo.getClass().getDeclaredFields()) {
                dk.setAccessible(true);
                if (dk.getName().equals(f.getName())) {
                    if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("int")) {
                        try {
                            Integer broj = Integer.valueOf(((javafx.scene.control.TextField) f.get(fxcon)).getText());
                            dk.set(gdo, broj);

                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }
                    if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            dk.set(gdo, ((javafx.scene.control.TextField) f.get(fxcon)).getText());
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            dk.set(gdo, ((javafx.scene.control.PasswordField) f.get(fxcon)).getText());
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.DatePicker") && dk.getType().getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        try {  // kor.setDatumRodjenja( konvertujLocalDateUSqlDate(fxcon.datumRodjenja.getValue()));
                            dk.set(gdo, konvertujLocalDateUXMLGregorianCalendar((LocalDate) ((javafx.scene.control.DatePicker) f.get(fxcon)).getValue()));
                            //dk.set(gdo,konvertujLocalDateUSqlDate((LocalDate) ((javafx.scene.control.TextField)f.get(fxcon)).getText()));
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

    public static boolean konvertujDKUGUI(AbstractDomainObject gdo, Object fxcon) {
        try {
            for (Field f : fxcon.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                for (Field dk : gdo.getClass().getDeclaredFields()) {
                    dk.setAccessible(true);
                    System.out.println("Naziv polja u fxcon" + f.getName());
                    if (dk.getName().equals(f.getName())) {

                        if (f.getType().equals(javafx.scene.control.TextField.class) && dk.getType().equals(Integer.class)) {
                            Integer broj = (Integer) dk.get(gdo);
                            ((javafx.scene.control.TextField) f.get(fxcon)).setText(String.valueOf(broj));
                            continue;
                        }

                        if (f.getType().equals(javafx.scene.control.TextField.class) && dk.getType().equals(String.class)) {
                            ((javafx.scene.control.TextField) f.get(fxcon)).setText((String) dk.get(gdo));
                            continue;
                        }

                        if (f.getType().equals(javafx.scene.control.PasswordField.class) && dk.getType().equals(String.class)) {
                            ((javafx.scene.control.PasswordField) f.get(fxcon)).setText((String) dk.get(gdo));
                            continue;
                        }

                        if (f.getType().equals(javafx.scene.control.DatePicker.class) && dk.getType().equals(javax.xml.datatype.XMLGregorianCalendar.class)) {
                            ((javafx.scene.control.DatePicker) f.get(fxcon)).setValue(((javax.xml.datatype.XMLGregorianCalendar) dk.get(gdo)).toGregorianCalendar().toZonedDateTime().toLocalDate());
                            continue;
                        }

                        if (f.getType().equals(javafx.scene.control.Label.class) && dk.getType().equals(String.class)) {
                            ((javafx.scene.control.Label) f.get(fxcon)).setText((String) dk.get(gdo));
                            continue;
                        }
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(KonverterGUIDK.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static LocalDate konvertujUtilDateULocalDate(java.util.Date input) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(sm.format(input));
        LocalDate date = sqlDate.toLocalDate();
        return date;
    }

    public static java.sql.Date konvertujLocalDateUSqlDate(LocalDate input) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = java.sql.Date.valueOf(input);
        return java.sql.Date.valueOf(sm.format(date));
    }

    public static XMLGregorianCalendar konvertujLocalDateUXMLGregorianCalendar(LocalDate date) {
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar xcal = null;
        try {
            xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException ex) {
            ex.printStackTrace();
        }
        return xcal;
    }

}
