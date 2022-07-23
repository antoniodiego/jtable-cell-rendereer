/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.antoniodiego.jtablecellrenderer;

import br.com.antoniodiego.jtablecellrenderer.FrameTabela.Rotulo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author anton
 */
public class CellRendererRotulos implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JPanel jpanel = new JPanel();

        jpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

        jpanel.setBackground(Color.orange);

        System.out.println("Value: " + value);

        JLabel rotulo;

        rotulo = new JLabel((String) value);
        rotulo.setOpaque(true);
        rotulo.setBackground(Color.red);
        jpanel.add(rotulo);

        rotulo.setBorder(new EmptyBorder(2, 2, 2, 2));

        JLabel segundoRotulo = new JLabel((String) value);

        segundoRotulo.setOpaque(true);
        segundoRotulo.setBackground(Color.blue);
        segundoRotulo.setForeground(Color.white);

        segundoRotulo.setBorder(new EmptyBorder(2, 2, 2, 2));

        jpanel.add(segundoRotulo);

        return jpanel;
    }

}
