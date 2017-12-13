
package view;

import controll.OrdersTableModel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class OrdersWindow extends JFrame {

    public OrdersWindow() {
        OrdersTableModel model = new OrdersTableModel();
        JTable tableOrders = new JTable(model);
        JScrollPane scrollpaneClients = new JScrollPane(tableOrders);
        setTitle("Orders table");
        add(scrollpaneClients, BorderLayout.EAST);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}