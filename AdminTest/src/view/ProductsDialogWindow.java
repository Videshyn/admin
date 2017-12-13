
package view;

import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import model.DaoGenImpl;
import model.Products;


class ProductsDialogWindow extends JDialog{

    private JButton buttonCreate = new JButton("Create");
    private JButton buttonCancel = new JButton("Cancel");
    private JTextField fieldProductsName = new JTextField(25);
    private JTextField fieldCountryPrice = new JTextField(10);
    public Products products;
    
    public ProductsDialogWindow(Frame parent, Products products){
        super(parent, "Add New Product", true);
        this.products = products;
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        buttonCreate.addActionListener(event -> {
            products.setProductsName(fieldProductsName.getText());
            try {
                products.setPrice(Integer.parseInt(fieldCountryPrice.getText()));
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
            if ((products != null) && (!products.getProductsName().equals(""))) {
               new DaoGenImpl<>(Products.class).add(products);
            }
            setVisible(false);
        });

        // add event listener for the button Remove
        buttonCancel.addActionListener(event -> setVisible(false));

        add(fieldProductsName);
        add(fieldCountryPrice);
        add(buttonCreate);
        add(buttonCancel);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
}
