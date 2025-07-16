package modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Tables extends DefaultTableCellRenderer {

    private int statusColumnIndex; 

    // Constructor para especificar el índice de la columna de estado
    public Tables(int statusColumnIndex) {
        this.statusColumnIndex = statusColumnIndex;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
        // Llamar al método de la clase padre para la renderización estándar
        super.getTableCellRendererComponent(jtable, o, bln, bln1, row, col);

        // Obtener el valor de la columna de estado especificada
        Object statusValue = jtable.getValueAt(row, statusColumnIndex);

        // Asegurarse de que statusValue no sea null antes de llamar a toString()
        String status = (statusValue != null) ? statusValue.toString() : "";

        // Cambiar el color de fondo y el color del texto dependiendo del valor del estado
        switch (status) {
            case "PENDIENTE":
                setBackground(new Color(255, 51, 51));  // Rojo para "PENDIENTE"
                setForeground(Color.white);  // Texto blanco
                break;
            case "FINALIZADO":
                setBackground(new Color(0, 102, 102));  // Verde oscuro para "FINALIZADO"
                setForeground(Color.white);  // Texto blanco
                break;
            case "EN PROCESO": // Añadido para el estado "EN PROCESO"
                setBackground(new Color(255, 204, 0)); // Amarillo
                setForeground(Color.black); // Texto negro
                break;
            default:
                setBackground(Color.white);  // Fondo blanco para otros estados
                setForeground(Color.black);  // Texto negro
                break;
        }
        return this;  // Devolver el componente (celda) con los cambios aplicados
    }
}