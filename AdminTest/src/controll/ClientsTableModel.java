
package controll;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clients;
import model.DaoGen;
import model.DaoGenImpl;


public class ClientsTableModel extends AbstractTableModel{

    private final List<Clients> clientsList;
    private final DaoGen<Clients> clientsDao;
    private final String[] columnNames = new String[]{
        "Id", "Name", "Phone", "Mail"
    };
    private final Class[] columnClass = new Class[]{
        Long.class, String.class, String.class, String.class
    };
    
    public ClientsTableModel(){
        clientsDao = new DaoGenImpl<>(Clients.class);
        this.clientsList = clientsDao.getAll();
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
        return clientsList.size();
    }

     @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex != 0) ? true : false; 
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clients row = clientsList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getClientsId();
        }
        else if(1 == columnIndex) {
            return row.getClientsName();
        }
        else if(2 == columnIndex) {
            return row.getClientsPhone();
        }
        else if(3 == columnIndex){
            return row.getClientsMail();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Clients row = clientsList.get(rowIndex);
        if(0 == columnIndex) {
            row.setClientsId((Long) aValue);
        }
        else if(1 == columnIndex) {
            row.setClientsName((String) aValue);
        }
        else if(2 == columnIndex) {
            row.setClientsPhone((String) aValue);
        }
        else if(3 == columnIndex){
            row.setClientsMail((String) aValue);
        }
        clientsDao.update(row, row.getClientsId());
    }
}

