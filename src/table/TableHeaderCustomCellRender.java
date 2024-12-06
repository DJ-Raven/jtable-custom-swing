package table;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableHeaderCustomCellRender extends DefaultTableCellRenderer {

    private final JTable table;
    private final TableCellRenderer oldCellRenderer;

    public TableHeaderCustomCellRender(JTable table) {
        this.table = table;
        oldCellRenderer = table.getTableHeader().getDefaultRenderer();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Component oldHeader = oldCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        JLabel oldLabel = (JLabel) oldHeader;
        JLabel label = (JLabel) com;
        label.setHorizontalTextPosition(oldLabel.getHorizontalTextPosition());
        label.setIcon(oldLabel.getIcon());
        setBorder(new EmptyBorder(8, 10, 8, 10));
        com.setFont(table.getTableHeader().getFont());
        com.setBackground(table.getTableHeader().getBackground());
        return com;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(table.getGridColor());
        g2.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight());
        g2.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
        g2.dispose();
    }
}
