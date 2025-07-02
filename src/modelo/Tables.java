/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author leonv
 */
public class Tables extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(
            JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
        // Llamar al método de la clase padre para la renderización estándar
        super.getTableCellRendererComponent(jtable, o, bln, bln1, row, col);

        // Cambiar el color de fondo y el color del texto dependiendo del valor de la columna 6
        switch (jtable.getValueAt(row, 6).toString()) {
            case "PENDIENTE":
                setBackground(new Color(255, 51, 51));  // Rojo para "PENDIENTE"
                setForeground(Color.white);  // Texto blanco
                break;
            case "FINALIZADO":
                setBackground(new Color(0, 102, 102));  // Verde oscuro para "FINALIZADO"
                setForeground(Color.white);  // Texto blanco
                break;
            default:
                setBackground(Color.white);  // Fondo blanco para otros estados
                setForeground(Color.black);  // Texto negro
                break;
        }
        return this;  // Devolver el componente (celda) con los cambios aplicados
    }
}
