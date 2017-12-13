
package view;

import controll.EmployeesTableModel;
import controll.TableMouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Employees;


public class EmployeesWindow extends JFrame implements ActionListener{

    //variables
    private JTable table;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private EmployeesTableModel model;
    
    
    
    //constructors
    public EmployeesWindow(){
        model = new EmployeesTableModel();
        table = new JTable(model);
        this.add(new JScrollPane(table));
        this.setTitle("Employees table");
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
        Employees employees  = new Employees(0L, "", "", "", 0, 0, 0);
        EmployeesDialogWindow dialogView = new EmployeesDialogWindow(this, employees);
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
        }//To change body of generated methods, choose Tools | Templates.
    }

}

