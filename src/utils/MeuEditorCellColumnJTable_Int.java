package utils;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class MeuEditorCellColumnJTable_Int extends AbstractCellEditor implements TableCellEditor {

    public MeuEditorCellColumnJTable_Int(int pVlrIni, int pVlrFim) {
        this.vlrIni = pVlrIni;
        this.vlrFim = pVlrFim;
    }

    private javax.swing.JSpinner spnr0 = new javax.swing.JSpinner();
    private final int vlrIni;
    private final int vlrFim;

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        spnr0.setModel(new javax.swing.SpinnerNumberModel(1, vlrIni, vlrFim, 1));
        return spnr0;
    }

    @Override
    public Object getCellEditorValue() {
        return Integer.valueOf(String.valueOf(spnr0.getValue()));
    }
}
