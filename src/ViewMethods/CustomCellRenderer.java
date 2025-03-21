package ViewMethods;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    private Color foregroundColor;

    public CustomCellRenderer(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cellComponent.setForeground(foregroundColor); // Đổi màu chữ
        return cellComponent;
    }
}
