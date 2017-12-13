
package controll;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DaoGen;
import model.DaoGenImpl;
import model.Employees;

public class EmployeesTableModel extends AbstractTableModel{  

    private final List<Employees> employeesList;
    private final DaoGen<Employees> employeesDao;
    private final String[] columnNames = new String[]{
        "Id", "Name", "Phone", "Mail", "Salary", "DepartmentsId", "PositionsId"
    };
    private final Class[] columnClass = new Class[]{
        Long.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class
    };
    
    public EmployeesTableModel() {
        employeesDao = new DaoGenImpl<>(Employees.class);
        this.employeesList = employeesDao.getAll();
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
        return employeesList.size();
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
        Employees row = employeesList.get(rowIndex);
         if (0 == columnIndex) {
            return row.getEmployeesId();
        } else if (1 == columnIndex) {
           return row.getEmployeesName();
        } else if (2 == columnIndex) {
            return row.getPhone();
        } else if (3 == columnIndex) {
            return row.getMail();
        } else if (4 == columnIndex) {
            return row.getSalary();
        } else if (5 == columnIndex) {
            return row.getDepartmentsId();
        } else if (6 == columnIndex) {
            return row.getPositionsId();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Employees row = employeesList.get(rowIndex);
        if (0 == columnIndex) {
            row.setEmployeesId((Long) aValue);
        } else if (1 == columnIndex) {
            row.setEmployeesName((String) aValue);
        } else if (2 == columnIndex) {
            row.setPhone((String) aValue);
        } else if (3 == columnIndex) {
            row.setMail((String) aValue);
        } else if (4 == columnIndex) {
            row.setSalary((int) aValue);
        } else if (5 == columnIndex) {
            row.setDepartmentsId((int) aValue);
        } else if (6 == columnIndex) {
            row.setPositionsId((int) aValue);
        }
        employeesDao.update(row, row.getEmployeesId());
    }
    public void addRow(Employees employees) {
        employeesDao.add(employees);
    }

    public void removeRow(int selectedRow) {
        Employees products = employeesList.get(selectedRow);
        employeesDao.delete(products);
    }

}