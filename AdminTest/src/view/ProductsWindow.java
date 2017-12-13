
package view;

import controll.ProductsTableModel;
import controll.TableMouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Products;


public class ProductsWindow extends JFrame implements ActionListener{
    
    private JTable table;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private ProductsTableModel model;

    public ProductsWindow() {
        model = new ProductsTableModel();
        table = new JTable(model);
        this.add(new JScrollPane(table));
        this.setTitle("Products table");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        
        JPopupMenu popupMenu = new JPopupMenu();
        menuItemAdd = new JMenuItem("Add New Row");
        menuItemRemove = new JMenuItem("Remove Current Row");
        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        menuItemAdd.addActionListener(this);
        menuItemRemove.addActionListener(this);
        table.setComponentPopupMenu(popupMenu);
        table.addMouseListener(new TableMouseListener(table));
    }
    
    private void addNewRow() {
        Products products = new Products(0L, "", 0);
        ProductsDialogWindow dialogView = new ProductsDialogWindow(this, products);
        dialogView.setVisible(true);
    }

    private void removeCurrentRow() {
        int selectedRow = table.getSelectedRow();
        model.removeRow(selectedRow);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
            JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemAdd) {
            addNewRow();
        } else if (menu == menuItemRemove) {
            removeCurrentRow();
        }
    }
}

