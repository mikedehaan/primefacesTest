package org.primefaces.test.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mdehaan
 * Date: 8/6/13
 */
public class DataTableRow implements Serializable {
    private List<DataTableCell> columns = new ArrayList<>();

    public void addColumn(DataTableCell column) {
        columns.add(column);
    }

    public DataTableCell get(int index) {
        return columns.get(index);
    }

    public List<DataTableCell> getColumns() {
        return columns;
    }

    public void setColumns(List<DataTableCell> columns) {
        this.columns = columns;
    }
}
