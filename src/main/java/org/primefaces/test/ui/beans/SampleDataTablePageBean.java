package org.primefaces.test.ui.beans;

import org.primefaces.component.api.UIColumn;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.test.ui.util.ComponentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * User: mdehaan
 * Date: 7/26/13
 */
@Named
@Scope("view")
public class SampleDataTablePageBean implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleDataTablePageBean.class);

    private DataTableModel dataTableModel = new DataTableModel();

    @PostConstruct
    private void initialize() {
        dataTableModel.addHeader("Column1");
        dataTableModel.addHeader("Column2");
        dataTableModel.addHeader("Column3");

        DataTableRow dataTableRow;

        dataTableRow = new DataTableRow();
        dataTableRow.addColumn(new DataTableCell("Row A Column 1"));
        dataTableRow.addColumn(new DataTableCell("Row A Column 2"));
        dataTableRow.addColumn(new DataTableCell("Row A Column 3"));
        dataTableModel.addRow(dataTableRow);

        dataTableRow = new DataTableRow();
        dataTableRow.addColumn(new DataTableCell("Row B Column 1"));
        dataTableRow.addColumn(new DataTableCell("Row B Column 2"));
        dataTableRow.addColumn(new DataTableCell("Row B Column 3"));
        dataTableModel.addRow(dataTableRow);
    }

    public void submit() {
        // Read the model for the new values
        for (DataTableRow row : dataTableModel.getRows()) {
            for (DataTableCell column : row.getColumns()) {
                System.out.print("\t" + column.getValue());
            }

            System.out.println("\n");
        }
    }

    public void validate(ComponentSystemEvent event) {
        DataTable dataTable = (DataTable)event.getComponent();

        LOGGER.debug("debug: inside validate");
        LOGGER.info("debug: inside validate");


        for (int r = 0; r < dataTable.getRowCount(); r++) {
            dataTable.setRowIndex(r);

            for (int c = 0; c < dataTable.getColumns().size(); c++) {
                UIColumn column = dataTable.getColumns().get(c);

                for (UIComponent columnChild : column.getChildren()) {
                    List<UIInput> inputs = ComponentUtils.findComponentsOfType(columnChild, UIInput.class);

                    for (UIInput input : inputs) {
                        LOGGER.debug("Local: [{}]", input.getLocalValue());
                        LOGGER.debug("Submitted: [{}]", input.getSubmittedValue());

                        try {
                            if (input.getValue() == null) {
                                LOGGER.debug("Value: [{}]", "null");
                            } else {
                                LOGGER.debug("Value: [{}]", input.getValue());
                            }
                        } catch (Exception ex) {
                            LOGGER.debug("Reading Value threw an exception", ex);
                        }
                    }
                }
            }
        }

    }

    public DataTableModel getDataTableModel() {
        return dataTableModel;
    }

    public void setDataTableModel(DataTableModel dataTableModel) {
        this.dataTableModel = dataTableModel;
    }
}
