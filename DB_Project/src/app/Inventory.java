/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hp
 */
public class Inventory extends javax.swing.JFrame
{

    /**
     * Creates new form Inventory
     */
    int searchOptionCheck;
    int rowcount=-2;
    DefaultTableModel dtm;
    public Inventory()
    {
        initComponents();
        String[] Header={"PRODID","Product Name","Price","Qty","Category"};
                
                dtm =new DefaultTableModel(Header,0);
            getjTable1().setModel(dtm);
            this.setLocationRelativeTo(null);
jTextField1.setEnabled(false);
jTextField1.setText("");
        System.out.println(jTextField1.getText());
            DatabaseConnector dbConnector = new DatabaseConnector();

            // Establish connection
            dbConnector.connect();
            boolean status=false;

            // Use the connection as needed
            Connection connection = dbConnector.getConnection();
            System.out.println("Here");
            try {
        // Query to fetch data from the employees table
            String query = "SELECT * FROM Inventory";

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and display data to console
            while (resultSet.next()) {
                // Retrieve data from the current row
                //int id = resultSet.getInt("id");
                String Name = resultSet.getString("Product_name");
                String id=resultSet.getString("ID");
                String Product_category = resultSet.getString("Product_category");
                String Qty=resultSet.getString("Qty");
                String Price = resultSet.getString("Price");
                Object obj[]={id,Name,Price,Qty,Product_category};
                dtm.addRow(obj);
                // Display data to console


        }
            rowcount=dtm.getRowCount();
    } catch (SQLException e) {
        System.out.println("Failed to fetch data from the employees table.");
        
        e.printStackTrace();
    } finally {
        // Close the connection
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }

    public JButton getjButton1()
    {
        return jButton1;
    }

    public void setjButton1(JButton jButton1)
    {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2()
    {
        return jButton2;
    }

    public void setjButton2(JButton jButton2)
    {
        this.jButton2 = jButton2;
    }

    public JButton getjButton3()
    {
        return jButton3;
    }

    public void setjButton3(JButton jButton3)
    {
        this.jButton3 = jButton3;
    }

    public JButton getjButton7()
    {
        return jButton7;
    }

    public void setjButton7(JButton jButton7)
    {
        this.jButton7 = jButton7;
    }

    public JComboBox<String> getjComboBoxCategory()
    {
        return jComboBoxCategory;
    }

    public void setjComboBoxCategory(JComboBox<String> jComboBoxCategory)
    {
        this.jComboBoxCategory = jComboBoxCategory;
    }

    public JLabel getjLabel1()
    {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1)
    {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabelPassword()
    {
        return jLabelPassword;
    }

    public void setjLabelPassword(JLabel jLabelPassword)
    {
        this.jLabelPassword = jLabelPassword;
    }

    public JLabel getjLabelPassword1()
    {
        return jLabelPassword1;
    }

    public void setjLabelPassword1(JLabel jLabelPassword1)
    {
        this.jLabelPassword1 = jLabelPassword1;
    }

    public JLabel getjLabelPassword2()
    {
        return jLabelPassword2;
    }

    public void setjLabelPassword2(JLabel jLabelPassword2)
    {
        this.jLabelPassword2 = jLabelPassword2;
    }

    public JLabel getjLabelProductName()
    {
        return jLabelProductName;
    }

    public void setjLabelProductName(JLabel jLabelProductName)
    {
        this.jLabelProductName = jLabelProductName;
    }

    public JScrollPane getjScrollPane1()
    {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1)
    {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable1()
    {
        return jTable1;
    }

    public void setjTable1(JTable jTable1)
    {
        this.jTable1 = jTable1;
    }

    public JTextField getjTextField1()
    {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1)
    {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextFieldFoodName()
    {
        return jTextFieldFoodName;
    }

    public void setjTextFieldFoodName(JTextField jTextFieldFoodName)
    {
        this.jTextFieldFoodName = jTextFieldFoodName;
    }

    public JTextField getjTextFieldFoodPrice()
    {
        return jTextFieldFoodPrice;
    }

    public void setjTextFieldFoodPrice(JTextField jTextFieldFoodPrice)
    {
        this.jTextFieldFoodPrice = jTextFieldFoodPrice;
    }

    public JTextField getjTextFieldFoodQTY()
    {
        return jTextFieldFoodQTY;
    }

    public void setjTextFieldFoodQTY(JTextField jTextFieldFoodQTY)
    {
        this.jTextFieldFoodQTY = jTextFieldFoodQTY;
    }

    
    class jpanelGradient extends JPanel
    {
        protected void paintComponent(Graphics g)
        {
            Graphics2D g2d=(Graphics2D) g; 
            int width=getWidth();
            int height=getHeight();
            Color color1=new Color(110,250,130);
            Color color2=new Color(100,231,212);
             
             //Color color3=Color.CYAN;
             GradientPaint gp=new GradientPaint(0,0, color1, 180,height ,color2);
             g2d.setPaint(gp);
             g2d.fillRect(0, 0, width, height);
        }
    }
    
    public String GetIDTable()
    {
        String id="";
        DatabaseConnector dbConnector = new DatabaseConnector();
        
        
            // Establish connection
            dbConnector.connect();
            Connection connection = dbConnector.getConnection();
            
//            try {
//            Statement statement=connection.createStatement();
//            String query="Select * from Inventory";
//            ResultSet resultSet = statement.executeQuery(query);
//            
//            String prd_name="Product_name";
//            String prd_category="Product_category";
//            String zero="0";
//            System.out.println("Inside Empty table query");
//            if (!resultSet.next()) {
//                query="insert into Inventory values('"+zero+"','"+prd_name+"','"+prd_category+"','"+zero+"','"+zero+"')";
//                resultSet = statement.executeQuery(query);
//                System.out.println("Inside condition of Empty table");
//            }
//            
//        } catch (Exception e) {
//        }
            
        try {
            
        // Query to fetch data from the employees table
            String query = "SELECT * FROM Inventory ORDER BY ID DESC LIMIT 1";

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and display data to console
            while (resultSet.next()) {
                // Retrieve data from the current row
                //int id = resultSet.getInt("id");
                
                 id=resultSet.getString("ID");
                
                
                // Display data to console


        }
    } catch (SQLException e) {
        System.out.println("Failed to fetch data from the employees table.");
        
        e.printStackTrace();
    } finally {
        // Close the connection
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        System.out.println("ID Fetched from Last "+id);
        return id;
    }
    
    public void DisplayTableData()
    {
        String[] Header={"PRODID","Product Name","Price","Qty","Category"};
                
         DefaultTableModel       dtm =new DefaultTableModel(Header,0);
         dtm.setRowCount(0);
            getjTable1().setModel(dtm);
            this.setLocationRelativeTo(null);
            
            DatabaseConnector dbConnector = new DatabaseConnector();

            // Establish connection
            dbConnector.connect();
            boolean status=false;

            // Use the connection as needed
            Connection connection = dbConnector.getConnection();
            System.out.println("Here");
            try {
        // Query to fetch data from the employees table
            String query = "SELECT * FROM Inventory";

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and display data to console
            while (resultSet.next()) {
                // Retrieve data from the current row
                //int id = resultSet.getInt("id");
                String Name = resultSet.getString("Product_name");
                String id=resultSet.getString("ID");
                String Product_category = resultSet.getString("Product_category");
                String Qty=resultSet.getString("Qty");
                String Price = resultSet.getString("Price");
                Object obj[]={id,Name,Price,Qty,Product_category};
                dtm.addRow(obj);
                
                // Display data to console


        }
            
           // rowcount=dtm.getRowCount();
                
            
    } catch (SQLException e) {
        System.out.println("Failed to fetch data from the Inventory table.");
        
        e.printStackTrace();
    } finally {
        // Close the connection
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//            
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new jpanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabelProductName = new javax.swing.JLabel();
        jTextFieldFoodName = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldFoodPrice = new javax.swing.JTextField();
        jLabelPassword1 = new javax.swing.JLabel();
        jTextFieldFoodQTY = new javax.swing.JTextField();
        jLabelPassword2 = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(236, 236, 236));
        jButton2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(246, 243, 243));
        jButton1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelProductName.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabelProductName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductName.setText("Item Name");

        jTextFieldFoodName.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTextFieldFoodNameMouseClicked(evt);
            }
        });
        jTextFieldFoodName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldFoodNameActionPerformed(evt);
            }
        });

        jLabelPassword.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Item Price");

        jLabelPassword1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabelPassword1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword1.setText("Quantity");

        jLabelPassword2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabelPassword2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword2.setText("Category");

        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "....Select....", "Drinks", "Cosmetics", "Crockery", "Whole Grain", "Dairy", "Pulses", "Others", " " }));

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("      Inventory Management");

        jButton7.setBackground(new java.awt.Color(247, 242, 242));
        jButton7.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(jLabelPassword1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldFoodQTY)
                            .addComponent(jTextFieldFoodName)
                            .addComponent(jTextFieldFoodPrice)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCategory, 0, 318, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFoodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFoodQTY)
                    .addComponent(jLabelPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jComboBoxCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
    {//GEN-HEADEREND:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //new Login().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextFieldFoodNameMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextFieldFoodNameMouseClicked
    {//GEN-HEADEREND:event_jTextFieldFoodNameMouseClicked
        // TODO add your handling code here:
        getjTable1().clearSelection();
    }//GEN-LAST:event_jTextFieldFoodNameMouseClicked

    private void jTextFieldFoodNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldFoodNameActionPerformed
    {//GEN-HEADEREND:event_jTextFieldFoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFoodNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //        Management s=new InventoryManagement(null, 0, null, 0, 0);
        //        s.add(this, dtm, row);

        int Price;
        int Qty;

        if (getjTextFieldFoodName().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter a Food Name");
            getjTextFieldFoodName().grabFocus();
            return;
        }
        if (getjTextFieldFoodPrice().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter a Food Price");
            getjTextFieldFoodName().grabFocus();
            return;
        }
        //.......................Try Catch...........................
        try
        {
            Price=Integer.parseInt(getjTextFieldFoodPrice().getText().trim());
            if (Price<=0)
            {
                JOptionPane.showMessageDialog(this, "Please Enter a Price which is Greater than Zero");
                getjTextFieldFoodPrice().grabFocus();
                return;
            }

        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please Enter an Integer Number");
            this.getjTextFieldFoodPrice().grabFocus();
            return;
        }
        //................................................................
        if (getjTextFieldFoodQTY().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter a Qty");
            getjTextFieldFoodQTY().grabFocus();
            return;
        }
        //.......................Try Catch...........................
        try
        {

            Qty=Integer.parseInt(getjTextFieldFoodQTY().getText().trim());
            if (Qty<=0)
            {
                JOptionPane.showMessageDialog(this, "Please Enter a Qty which is Greater than Zero");
                getjTextFieldFoodQTY().grabFocus();
                return;
            }

        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please Enter an Integer Number");
            getjTextFieldFoodQTY().grabFocus();
            return;
        }
        //................................................................
        if (getjComboBoxCategory().getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(this, "Please Select a Food Category");
            getjTextFieldFoodName().grabFocus();
            return;
        }

        System.out.println("FoodQty"+Qty);
        System.out.println("FoodPrice"+Price);

        String ProductName=getjTextFieldFoodName().getText().trim();
        ProductName=ProductName.toUpperCase();
        String Category=getjComboBoxCategory().getSelectedItem().toString();
        System.out.println("FoodName"+ProductName);
        System.out.println("Category"+Category);
        String strID=GetIDTable();

        if (strID.isEmpty())
        {
            strID = "0"; // Set some initial ID value when the table is empty
        }

        int intID = Integer.parseInt(strID);
        intID=intID+1;

        String ID = Integer.toString(intID);
        DatabaseConnector dbConnector = new DatabaseConnector();

        // Establish connection
        dbConnector.connect();

        // Use the connection as needed
        Connection connection = dbConnector.getConnection();

        // Now you can perform database operations using 'connection'

        try
        {

            Statement statement=connection.createStatement();
            String query="insert into Inventory values('"+ID+"','"+ProductName+"','"+Category+"','"+Qty+"','"+Price+"')";
            statement.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Failed Query");
            JOptionPane.showMessageDialog(this, "Same Product Name is Not Allowed");
        }
        // Don't forget to close the connection when done
        try
        {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        DisplayTableData();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int Price;
        int Qty;

        if (getjTextFieldFoodName().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter a Food Name");
            getjTextFieldFoodName().grabFocus();
            return;
        }
        if (getjTextFieldFoodPrice().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter a Food Price");
            getjTextFieldFoodName().grabFocus();
            return;
        }
        //.......................Try Catch...........................
        try
        {
            Price=Integer.parseInt(getjTextFieldFoodPrice().getText().trim());
            if (Price<=0)
            {
                JOptionPane.showMessageDialog(this, "Please Enter a Price which is Greater than Zero");
                getjTextFieldFoodPrice().grabFocus();
                return;
            }

        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please Enter an Integer Number");
            this.getjTextFieldFoodPrice().grabFocus();
            return;
        }
        //................................................................
        if (getjTextFieldFoodQTY().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter a Qty");
            getjTextFieldFoodQTY().grabFocus();
            return;
        }
        //.......................Try Catch...........................
        try
        {

            Qty=Integer.parseInt(getjTextFieldFoodQTY().getText().trim());
            if (Qty<=0)
            {
                JOptionPane.showMessageDialog(this, "Please Enter a Qty which is Greater than Zero");
                getjTextFieldFoodQTY().grabFocus();
                return;
            }

        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please Enter an Integer Number");
            getjTextFieldFoodQTY().grabFocus();
            return;
        }
        //................................................................
        if (getjComboBoxCategory().getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(this, "Please Select a Food Category");
            getjTextFieldFoodName().grabFocus();
            return;
        }

        System.out.println("FoodQty"+Qty);
        System.out.println("FoodPrice"+Price);

        String ProductName=getjTextFieldFoodName().getText().trim();
        ProductName=ProductName.toUpperCase();
        String Category=getjComboBoxCategory().getSelectedItem().toString();
        String Id=jTextField1.getText().toString();
        System.out.println("ID"+Id);

        DatabaseConnector dbConnector = new DatabaseConnector();

        // Establish connection
        dbConnector.connect();

        // Use the connection as needed
        Connection connection = dbConnector.getConnection();

        // Now you can perform database operations using 'connection'
        try
        {

            Statement statement=connection.createStatement();

            String query="UPDATE Inventory SET Product_name = '"+ProductName+"', Product_category='"+Category+"', Qty='"+Qty+"',Price='"+Price+"'  WHERE ID = '"+Id+"'";
            statement.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Failed Query");
            JOptionPane.showMessageDialog(this, "Same Product Name is Not Allowed");
        }
        // Don't forget to close the connection when done
        try
        {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        jTextField1.setText("");
        getjTextFieldFoodName().setText("");
        getjTextFieldFoodPrice().setText("");
        getjTextFieldFoodQTY().setText("");
        
        getjComboBoxCategory().setSelectedItem("");


        DisplayTableData();

        //        int SelectedRow=this.getjTable1().getSelectedRow();
        //        Management m=new InventoryManagement(null, 0, null, 0, 0);
        //        m.update(this,dtm,SelectedRow);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';

        String Id=jTextField1.getText().toString();

        DatabaseConnector dbConnector = new DatabaseConnector();

        // Establish connection
        dbConnector.connect();

        // Use the connection as needed
        Connection connection = dbConnector.getConnection();

        // Now you can perform database operations using 'connection'
        try
        {

            Statement statement=connection.createStatement();

            String query="DELETE FROM Inventory WHERE ID='"+Id+"'";
            statement.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Failed Query");
            JOptionPane.showMessageDialog(this, "Same Product Name is Not Allowed");
        }
        // Don't forget to close the connection when done
        try
        {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        DisplayTableData();
        jTextField1.setText("");
        getjTextFieldFoodName().setText("");
        getjTextFieldFoodPrice().setText("");
        getjTextFieldFoodQTY().setText("");
        getjComboBoxCategory().setSelectedItem("");

        //        int SelectedRow=this.getjTable1().getSelectedRow();
        //        Management m=new InventoryManagement(null, 0, null, 0, 0);
        //        m.delete(this,dtm,SelectedRow);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
        // TODO add your handling code here:
        //        String[] ComboArray={"","Drinks","Cosmetics","Crockery","Whole Grain","Dairy","Pulses","Others"};
        //
        //        int selected_Row=getjTable1().getSelectedRow();
        //        System.out.println("Selected row Index "+selected_Row);
        //        //System.out.println("Table Click "+selected_Row);
        //        jTextField1.setText(dtm.getValueAt(selected_Row, 0).toString());
        //        getjTextFieldFoodName().setText(dtm.getValueAt(selected_Row, 1).toString());
        //        getjTextFieldFoodPrice().setText(dtm.getValueAt(selected_Row, 2).toString());
        //        getjTextFieldFoodQTY().setText(dtm.getValueAt(selected_Row, 3).toString());
        //        String ComboBoxValue=dtm.getValueAt(selected_Row, 4).toString();
        //
        //        for (int i = 0; i < ComboArray.length; i++)
        //
        {
            //            if (ComboBoxValue.compareTo(ComboArray[i])==0)
            //
            {
                //                getjComboBoxCategory().setSelectedIndex(i);
                //                break;
                //            }
            //        }
        //
        //getjComboBoxCategory().getSelectedObjects();

        int selectedRow = getjTable1().getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1)
        {
            // Get data from the selected row
            String id = getjTable1().getValueAt(selectedRow, 0).toString();
            String productName = getjTable1().getValueAt(selectedRow, 1).toString();
            String price = getjTable1().getValueAt(selectedRow, 2).toString();
            String qty = getjTable1().getValueAt(selectedRow, 3).toString();
            String category = getjTable1().getValueAt(selectedRow, 4).toString();

            // Update the text fields with the selected row data
            jTextField1.setText(id);
            getjTextFieldFoodName().setText(productName);
            getjTextFieldFoodPrice().setText(price);
            getjTextFieldFoodQTY().setText(qty);
            getjComboBoxCategory().setSelectedItem(category);
        }
        else
        {
            jTextField1.setText("");
            getjTextFieldFoodName().setText("");
            getjTextFieldFoodPrice().setText("");
            getjTextFieldFoodQTY().setText("");
            getjComboBoxCategory().setSelectedItem("");
        }

    }//GEN-LAST:event_jTable1MouseClicked
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelPassword2;
    private javax.swing.JLabel jLabelProductName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldFoodName;
    private javax.swing.JTextField jTextFieldFoodPrice;
    private javax.swing.JTextField jTextFieldFoodQTY;
    // End of variables declaration//GEN-END:variables
}
