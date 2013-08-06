package org.primefaces.test.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mdehaan
 * Date: 8/6/13
 */
public class DataTableModel implements Serializable {
    private List<String> headers = new ArrayList<>();
    private List<DataTableRow> rows = new ArrayList<>();

    public void addHeader(String header) {
        headers.add(header);
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<DataTableRow> getRows() {
        return rows;
    }

    public void setRows(List<DataTableRow> rows) {
        this.rows = rows;
    }

    public void addRow(DataTableRow row) {
        this.rows.add(row);
    }
}
