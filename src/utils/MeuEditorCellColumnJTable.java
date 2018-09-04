package utils;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class MeuEditorCellColumnJTable extends AbstractCellEditor implements TableCellEditor {

    public MeuEditorCellColumnJTable(FormatoData pFormatoData) {
        this.formatoData = pFormatoData;
    }

    public enum FormatoData {
        dd_MM_yyyy,
        dd_MM_yyyy_HH__mm__ss,
        MM_yyyy
    }
    private JDateChooser dateChooser = new JDateChooser();
    private FormatoData formatoData;

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        Date date = null;
        if (value instanceof Date) {
            date = (Date) value;
        }

        dateChooser.setDate(date);

        return dateChooser;
    }

    @Override
    public Object getCellEditorValue() {
        SimpleDateFormat formato = new SimpleDateFormat(this.formatoData.toString().replace("__", ":").replace("_", "/"));
        return formato.format(dateChooser.getDate());
    }
}
