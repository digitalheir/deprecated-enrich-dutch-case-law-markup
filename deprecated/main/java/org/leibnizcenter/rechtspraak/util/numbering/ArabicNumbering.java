package org.leibnizcenter.rechtspraak.util.numbering;

import java.security.InvalidParameterException;

/**
 * Created by maarten on 16-2-16.
 */
public class ArabicNumbering extends Number implements FullSectionNumber {
    private int num;
    private String terminal;

    public ArabicNumbering(int num) {
        this.num = num;
        this.terminal = null;
    }

    public ArabicNumbering(String num, String terminal) {
        this.num = Integer.parseInt(num);

        if (terminal != null) {
            terminal = terminal.trim();
            if (terminal.length() <= 0) terminal = null;
        }
        this.terminal = terminal;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Override
    public String toString() {
        return num + "";
    }

    @Override
    public boolean isSuccedentOf(NumberingNumber precedent) {
        if (precedent.mainNum() + 1 == num) {
            //noinspection Duplicates
            if (precedent instanceof SubSectionNumber || precedent instanceof ArabicNumbering) {
                return true;
            } else if (precedent instanceof RomanNumeral || precedent instanceof AlphabeticNumbering || precedent instanceof NonNumericNumbering) {
                return false; // We can't mix Arabics and Romans
            } else {
                throw new InvalidParameterException(precedent.getClass().getSimpleName());
            }
        } else {
            return false;
        }
    }

    @Override
    public int mainNum() {
        return num;
    }

    @Override
    public boolean isFirstNumbering() {
        return num == 1 || num == 0;
    }

    @Override
    public String getTerminal() {
        return terminal;
    }

    /**
     * @return this number as a string without terminal
     */
    @Override
    public String canonicalRepresentation() {
        return String.valueOf(num);
    }

    @Override
    public int intValue() {
        return num;
    }

    @Override
    public long longValue() {
        return num;
    }

    @Override
    public float floatValue() {
        return num;
    }

    @Override
    public double doubleValue() {
        return num;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO check if terminal is the same?
        return obj instanceof ArabicNumbering && ((ArabicNumbering) obj).mainNum() == this.mainNum();
    }

    @Override
    public FullSectionNumber succ() {
        return new ArabicNumbering(num + 1);
    }
}
