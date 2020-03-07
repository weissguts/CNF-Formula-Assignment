/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel Hernandez
 */
public class AssignmentView extends JDialog 
        implements ActionListener, WindowListener {
    
    /**
     * The Assignment model displayed in this view
     */
    private Assignment model;
    
    /**
     * Assignment variables and their values are displayed in this table
     */
    private JTable table;
    private MyTableModel tableModel;
    
    private JButton okBut;
    
    public AssignmentView() {
        super((JFrame) null, "Select an Assignment", true);
        
        setModal(true);
        
        initComponents();
        initLayout();
        
        addWindowListener(this);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        
        pack();
    }
    
    /**
     * Return the Assignment model displayed in this view
     * 
     * @return an Assignment (only updated if Ok was previously selected) 
     */
    public Assignment getModel() {
        // updateModel
        return model;
    }
    
    /**
     * Display the given model in this view
     * 
     * @param model an Assignment 
     */
    public void setModel(Assignment model){
        this.model = model;
//        System.out.println("Test 6 Model!!!");
        updateDisplay();
    }
    
    /**
     * Create the primary child components used in this view
     */
    private void initComponents() {       
        Object[][] data = {{"x1", new Boolean(false)}};
        
        tableModel = new MyTableModel(data);
        
        table = new JTable(tableModel);
        
        okBut = new JButton("OK");
        okBut.addActionListener(this);
    }
    
    /**
     * Layout the child components used in this view
     */
    private void initLayout() {
        GPanel panel = new GPanel();
       
        JScrollPane scroller = new JScrollPane(table);
        
        JLabel label = new JLabel("Please select values for the variables");
       
         panel.addc(label, 0, 0, 1, 1, 0.0, 0.0,
                   GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                   5,10,0,10);
        
        panel.addc(scroller, 0, 1, 1, 1, 1.0, 1.0,
                   GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                   5,10,0,10);
        
        panel.addc(okBut, 0, 2, 1, 1, 0.0, 0.0,
                   GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                   5,10,0,10);
        
        getContentPane().add(panel);
    }
    
    /**
     * Update the view to display the current model
     */
    private void updateDisplay() {
//        System.out.println("Test 7!!!");        
        String[] variables = Assignment.literalsA();
//        System.out.println("Test 8!!!"); 
        Object[][] data = new Object[variables.length][2];
        
        for (int i = 0; i < variables.length; i++) {
            Object[] row = new Object[2];
            row[0] = variables[i];
            row[1] = new Boolean(false);
            
            data[i] = row;
            
        }
        
        tableModel = new MyTableModel(data);
        
        table.setModel(tableModel);
    }
    
    /**
     * Update the current model with the values displayed in this view.
     */
    private void updateModel() {
        MyTableModel tableModel = (MyTableModel) table.getModel();
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String var = (String) tableModel.getValueAt(i, 0);
            boolean val = (boolean) tableModel.getValueAt(i, 1);
            
            model.setValue(var, val);
        }
    }
    
    /**
     * Handle the user's clik on the OK button
     * 
     * @param evt 
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == okBut) {
            updateModel();
            setVisible(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    /**
     * Update the model, if the user exits via the window close icon.
     * 
     * @param e 
     */
    @Override
    public void windowClosing(WindowEvent e) {
        updateModel();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
    /**
     * Table model for the JTable displaying the assignments.
     * (Typical approach for displaying a checkbox for the Boolean values.)
     */
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Variable", "Value (select for true)"};
        
        /**
         * {{String-variable-name, Boolean-variable-value} ... }
         */
        private Object[][] data;
        
        public MyTableModel(Object[][] data) {
            super();
            
            this.data = data;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            if (col < 1) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}

