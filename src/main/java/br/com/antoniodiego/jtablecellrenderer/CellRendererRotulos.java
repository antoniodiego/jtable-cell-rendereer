/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.antoniodiego.jtablecellrenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author anton
 */
public class CellRendererRotulos implements TableCellRenderer {

    // We need a place to store the color the JLabel should be returned
    // to after its foreground and background colors have been set
    // to the selection background color.
    // These ivars will be made protected when their names are finalized.
    private Color unselectedForeground;
    private Color unselectedBackground;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JPanel jpanel = new JPanel();

        jpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

        // jpanel.setOpaque(false);

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
        Color fg = null;
        Color bg = null;

        JTable.DropLocation dropLocation = table.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsertRow()
                && !dropLocation.isInsertColumn()
                && dropLocation.getRow() == row
                && dropLocation.getColumn() == column) {

            fg = (Color) UIManager.get("Table.dropCellForeground");
            bg = (Color) UIManager.get("Table.dropCellBackground");

            isSelected = true;
        }

        if (isSelected) {
            jpanel.setForeground(fg == null ? table.getSelectionForeground()
                    : fg);
            jpanel.setBackground(bg == null ? table.getSelectionBackground()
                    : bg);
        } else {
            Color background = unselectedBackground != null
                    ? unselectedBackground
                    : table.getBackground();

            System.out.println("Back: " + background);

            if (background == null || background instanceof javax.swing.plaf.UIResource) {
                Color alternateColor = (Color) UIManager.get("Table.alternateRowColor");
                System.out.println("Alt: " + alternateColor);
                if (alternateColor != null && row % 2 != 0) {
                    System.out.println("Alt: " + (row % 2));
                    background = alternateColor;
                }
            }

            if (row % 2 == 0) {
                System.out.println("Alt: " + (row % 2));
                jpanel.setOpaque(false);
            }

            jpanel.setForeground(unselectedForeground != null
                    ? unselectedForeground
                    : table.getForeground());
            jpanel.setBackground(background);
        }

        return jpanel;
    }

}
