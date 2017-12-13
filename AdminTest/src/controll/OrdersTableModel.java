
package controll;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clients;
import model.DaoGen;
import model.DaoGenImpl;
import model.Orders;


public class OrdersTableModel extends AbstractTableModel{
     //variables
    private final List<Orders> ordersList;
    private final DaoGen<Orders> ordersDao;
    private final String[] columnNames = new String[]{
        "Id", "Description", "Orders Date", "Total Costs", "Clients Id"
    };
    private final Class[] columnClass = new Class[]{
        Long.class, String.class, String.class, Integer.class, Clients.class
    };
    
    public OrdersTableModel() {
        ordersDao = new DaoGenImpl<>(Orders.class);
        this.ordersList = ordersDao.getAll();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getRowCount() {
        return ordersList.size();
    }

     @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex == 1) ? true : false; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Orders row = ordersList.get(rowIndex);
         if (0 == columnIndex) {
            return row.getOrdersId();
        } else if (1 == columnIndex) {
           return row.getDescription();
        } else if (2 == columnIndex) {
            return row.getOrdersDate();
        } else if (3 == columnIndex) {
            return row.getTotalCosts();
        } else if (4 == columnIndex) {
            return row.getClients();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Orders row = ordersList.get(rowIndex);
        if (0 == columnIndex) {
            row.setOrdersId((Long) aValue);
        } else if (1 == columnIndex) {
            row.setDescription((String) aValue);
        } else if (2 == columnIndex) {
            row.setOrdersDate((String) aValue);
        } else if (3 == columnIndex) {
            row.setTotalCosts((int) aValue);
        } else if (4 == columnIndex) {
            row.setClients((Clients) aValue);
        }
        ordersDao.update(row, row.getOrdersId());
    }
    
}

