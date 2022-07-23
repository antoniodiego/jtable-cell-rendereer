/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.antoniodiego.jtablecellrenderer;

import br.com.antoniodiego.jtablecellrenderer.FrameTabela.Rotulo;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author anton
 */
public class CellRendererRotulos implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JPanel jpanel = new JPanel();

        System.out.println("Value: " + value);

        JLabel labRot;

        labRot = new JLabel((String) value);
        labRot.setOpaque(true);
        labRot.setBackground(Color.red);
        jpanel.add(labRot);

        return jpanel;
    }

}
