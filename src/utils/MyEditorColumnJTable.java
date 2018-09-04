package utils;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

//public class MyEditorColumnJTable {
public class MyEditorColumnJTable extends AbstractCellEditor implements TableCellEditor {

    private com.toedter.calendar.JDateChooser datePicker;

    @Override
    public Object getCellEditorValue() {
        return datePicker.getDate();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {

        datePicker = new com.toedter.calendar.JDateChooser();
        datePicker.setDateFormatString("MM/yyyy");
//            ...
        return datePicker; //volte qualquer Component aqui!
    }

}
