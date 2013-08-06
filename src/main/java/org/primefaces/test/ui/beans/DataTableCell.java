package org.primefaces.test.ui.beans;

import java.io.Serializable;

/**
 * User: mdehaan
 * Date: 8/6/13
 */
public class DataTableCell implements Serializable {
    private String value;

    public DataTableCell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
