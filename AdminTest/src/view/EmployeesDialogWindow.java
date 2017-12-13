
package view;

import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import model.DaoGenImpl;
import model.Employees;

class EmployeesDialogWindow extends JDialog{
    
    //variables
    private JButton buttonCreate = new JButton("Create");
    private JButton buttonCancel = new JButton("Cancel");
    private JTextField fieldEmployeesName = new JTextField(25);
    private JTextField fieldEmployeesPhone = new JTextField(10);
    private JTextField fieldEmployeesMail = new JTextField(10);
    private JTextField fieldEmployeesSalary = new JTextField(10);
    private JTextField fieldDepartmentsId = new JTextField(10);
    private JTextField fieldPositionsId = new JTextField(10);
    public Employees employees;
    
    //constructors
    public EmployeesDialogWindow(Frame parent, Employees employees) {
        super(parent, "Add New Product", true);
        this.employees = employees;
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        buttonCreate.addActionListener(event -> {
            employees.setEmployeesName(fieldEmployeesName.getText());
            employees.setPhone(fieldEmployeesPhone.getText());
            employees.setMail(fieldEmployeesMail.getText());
            try {
                employees.setSalary(Integer.parseInt(fieldEmployeesSalary.getText()));
                employees.setDepartmentsId(Integer.parseInt(fieldDepartmentsId.getText()));
                employees.setPositionsId(Integer.parseInt(fieldPositionsId.getText()));
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
            if ((employees != null) && (!employees.getEmployeesName().equals("")) && (!employees.getMail().equals(""))) {
                new DaoGenImpl<>(Employees.class).add(employees);
            }
            setVisible(false);
        });

         // add event listener for the button Remove
        buttonCancel.addActionListener(event -> setVisible(false));

        // add components to this frame
        add(fieldEmployeesName);
        add(fieldEmployeesPhone);
        add(fieldEmployeesMail);
        add(fieldEmployeesSalary);
        add(fieldDepartmentsId);
        add(fieldPositionsId);
        add(buttonCreate);
        add(buttonCancel);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
}
