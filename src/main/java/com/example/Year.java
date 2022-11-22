/* ----------------------------------------------------------------------------
 *     (c) by data experts gmbh
 *            Woldegker Str. 12
 *            17033 Neubrandenburg
 * ----------------------------------------------------------------------------
 *     Dieses Dokument und die hierin enthaltenen Informationen unterliegen
 *     dem Urheberrecht und duerfen ohne die schriftliche Genehmigung des
 *     Herausgebers weder als ganzes noch in Teilen dupliziert, reproduziert
 *     oder manipuliert werden.
 * ----------------------------------------------------------------------------
 */
package com.example;

import java.io.Serializable;
import java.util.Objects;

public class Year implements Serializable {

    private final int year;

    private static final int MIN_VALID_YEAR = 1990;

    private static final int MAX_VALID_YEAR = 2100;

    private Year(int year) {
        this.year = year;
    }

    public static Year from(int year) {
        if (year < MIN_VALID_YEAR || year > MAX_VALID_YEAR) {
            throw new RuntimeException("" + year);
        }
        return new Year(year);
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Year that = (Year) o;
        return year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }

    @Override
    public String toString() {
        return String.valueOf(year);
    }
}
