
package view;

import controll.ClientsTableModel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ClientsWindow extends JFrame{
    public ClientsWindow(){
        ClientsTableModel modelClients = new ClientsTableModel();
        JTable tableClients = new JTable(modelClients);
        JScrollPane scrollpaneClients = new JScrollPane(tableClients);
        setTitle("Clients table");
        add(scrollpaneClients, BorderLayout.EAST);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}