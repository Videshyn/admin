
package controll;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DaoGen;
import model.DaoGenImpl;
import model.Products;


public class ProductsTableModel extends AbstractTableModel{
    
    private final List<Products> productsList;
    private final DaoGen<Products> productsDao;
    private final String[] columnNames = new String[]{
        "Id", "Name", "Price"
    };
    private final Class[] columnClass = new Class[]{
        Long.class, String.class, Integer.class
    };
    
    public ProductsTableModel(){
        productsDao = new DaoGenImpl<>(Products.class);
        this.productsList = productsDao.getAll();
    }

  @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return productsList.size();
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
        Products row = productsList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getProductsId();
        } else if(1 == columnIndex) {
            return row.getProductsName();
        } else if(2 == columnIndex) {
            return row.getPrice();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Products row = productsList.get(rowIndex);
        if(0 == columnIndex) {
            row.setProductsId((Long) aValue);
        }
        else if(1 == columnIndex) {
            row.setProductsName((String) aValue);
        }
        else if(2 == columnIndex) {
            try{
                row.setPrice(Integer.parseInt((String) aValue));
            }
            catch(NumberFormatException e){
                System.out.println("not a number");
            }
        }
        productsDao.update(row, row.getProductsId());
    }

    public void addRow(Products products) {
        productsDao.add(products);
    }

    public void removeRow(int selectedRow) {
        Products products = productsList.get(selectedRow);
        productsDao.delete(products);
    }

}

