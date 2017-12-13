
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class MainWindow {
    private final static String[] TABLES = {"EMPLOYEES", "PRODUCTS",
        "ORDERS", "CLIENTS"};
    
    public MainWindow(){
        JComboBox comboTableList = new JComboBox(TABLES);
        comboTableList.setEditable(false);
        comboTableList.setSelectedIndex(-1);
        JLabel prompt = new JLabel("Choose table:");
        JButton btnOk = new JButton("OK");
        JFrame frame = new JFrame("Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints contraints = new GridBagConstraints();
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.weighty = 1;
        frame.add(prompt, contraints);
        contraints.gridy = 1;
        contraints.gridx = 0;
        frame.add(comboTableList, contraints);
        contraints.gridx = 1;
        frame.add(btnOk, contraints);
        frame.setVisible(true);
        
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String itemStr = (String) comboTableList.getSelectedItem();
                if(itemStr.equals(TABLES[0])){ //empl
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new EmployeesWindow();
                        }
                    });
                }else if(itemStr.equals(TABLES[1])){ //products
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new ProductsWindow();
                        }
                    });
                }else if(itemStr.equals(TABLES[2])){//orders
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new OrdersWindow();
                        }
                    });
                }else if(itemStr.equals(TABLES[3])){//clients
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new ClientsWindow();
                        }
                    });
                }
            }
        });
    }
}
