/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
public class Billing extends javax.swing.JFrame
{

    /**
     * Creates new form Billing
     */
    
    DefaultTableModel dtm;
    int searchOptionCheck;
    int SumTotalBill=0;

    public DefaultTableModel getDtm()
    {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm)
    {
        this.dtm = dtm;
    }

    public int getSearchOptionCheck()
    {
        return searchOptionCheck;
    }

    public void setSearchOptionCheck(int searchOptionCheck)
    {
        this.searchOptionCheck = searchOptionCheck;
    }

    public int getSumTotalBill()
    {
        return SumTotalBill;
    }

    public void setSumTotalBill(int SumTotalBill)
    {
        this.SumTotalBill = SumTotalBill;
    }

    public JButton getjButton3()
    {
        return jButton3;
    }

    public void setjButton3(JButton jButton3)
    {
        this.jButton3 = jButton3;
    }

    public JButton getjButton4()
    {
        return jButton4;
    }

    public void setjButton4(JButton jButton4)
    {
        this.jButton4 = jButton4;
    }

    public JButton getjButton5()
    {
        return jButton5;
    }

    public void setjButton5(JButton jButton5)
    {
        this.jButton5 = jButton5;
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

    public JLabel getjLabelPassword3()
    {
        return jLabelPassword3;
    }

    public void setjLabelPassword3(JLabel jLabelPassword3)
    {
        this.jLabelPassword3 = jLabelPassword3;
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

    public JScrollPane getjScrollPane2()
    {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2)
    {
        this.jScrollPane2 = jScrollPane2;
    }

    public JTable getjTable1()
    {
        return jTable1;
    }

    public void setjTable1(JTable jTable1)
    {
        this.jTable1 = jTable1;
    }

    public JTextArea getjTextArea1()
    {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1)
    {
        this.jTextArea1 = jTextArea1;
    }

    public JTextField getjTextFieldFoodCategory()
    {
        return jTextFieldFoodCategory;
    }

    public void setjTextFieldFoodCategory(JTextField jTextFieldFoodCategory)
    {
        this.jTextFieldFoodCategory = jTextFieldFoodCategory;
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
    
    public Billing()
    {
        initComponents();
          DisplayTableData();
        SumTotalBill=0;
        jTextArea1.setText("=======================GUI======================\n*			                       *\n================================================\nID            PRODUCT              PRICE            QTY            TOTAL\n");
    
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

        jPanel2 = new jpanelGradient()
        ;
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabelProductName = new javax.swing.JLabel();
        jTextFieldFoodName = new javax.swing.JTextField();
        jLabelPassword2 = new javax.swing.JLabel();
        jTextFieldFoodPrice = new javax.swing.JTextField();
        jLabelPassword3 = new javax.swing.JLabel();
        jTextFieldFoodCategory = new javax.swing.JTextField();
        jLabelPassword1 = new javax.swing.JLabel();
        jTextFieldFoodQTY = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setForeground(new java.awt.Color(51, 0, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
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
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton4.setBackground(new java.awt.Color(235, 231, 231));
        jButton4.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton4.setText("Print Invoice");
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(238, 232, 232));
        jButton5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });

        jLabelProductName.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
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

        jLabelPassword2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabelPassword2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword2.setText("Price");

        jLabelPassword3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabelPassword3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword3.setText("Category");

        jLabelPassword1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabelPassword1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword1.setText("Qty");

        jTextFieldFoodQTY.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldFoodQTYActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(249, 243, 243));
        jButton3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton3.setText("ADD to Bill");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Billing System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(324, 324, 324)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(jLabelPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPassword3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldFoodCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(jTextFieldFoodName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldFoodPrice, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldFoodQTY, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldFoodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFoodCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabelPassword3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabelPassword1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldFoodQTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
       // new Login().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldFoodNameMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTextFieldFoodNameMouseClicked
    {//GEN-HEADEREND:event_jTextFieldFoodNameMouseClicked

        getjTable1().clearSelection();
    }//GEN-LAST:event_jTextFieldFoodNameMouseClicked

    private void jTextFieldFoodNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldFoodNameActionPerformed
    {//GEN-HEADEREND:event_jTextFieldFoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFoodNameActionPerformed

    private void jTextFieldFoodQTYActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFieldFoodQTYActionPerformed
    {//GEN-HEADEREND:event_jTextFieldFoodQTYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFoodQTYActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //        Management c=new Cashier();
        //        c.CreateInvoice(this, dtm, TextArea, TotalBill);
        int selected_Row=jTable1.getSelectedRow();
        String qty="";
        if (selected_Row!=-1)
        {
            qty = getjTable1().getValueAt(selected_Row, 3).toString();
        }

        int Qty=Integer.parseInt(qty);

        int invoice_Price=0;
        int UserQTY=0;
        int TextAreaQTY=0;

        int SelectedRow=this.getjTable1().getSelectedRow();

        if (SelectedRow==-1)
        {
            JOptionPane.showMessageDialog(this, "Please Select a Row");
            return;
        }
        //         for (int i = 0; i < Array_List.FoodList.size(); i++)
        //
        {
            //            if (Product_Bill.getjTextFieldFoodName().getText().compareTo(Array_List.FoodList.get(i).getName())==0)
            //
            {
                //                SelectedRow=i;
                //            }
            //
            //        }
        if (this.getjTextFieldFoodQTY().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter a QTY of an item to Add to Bill");
            return;
        }

        try
        {
            UserQTY=Integer.parseInt(this.getjTextFieldFoodQTY().getText());
            if (UserQTY<=0)
            {
                JOptionPane.showMessageDialog(this, "QTY must be Greater than Zero");
                return;
            }

            if (UserQTY>Qty)
            {
                JOptionPane.showMessageDialog(this, "Not Enough item in Stock");
                return;
            }

        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please Enter an Integer Number");
        }

        int NewQty=Qty-UserQTY;

        selected_Row=jTable1.getSelectedRow();

        if (selected_Row!=-1)
        {
            String price = getjTable1().getValueAt(selected_Row, 2).toString();
            int Price=Integer.parseInt(price);

            String id = getjTable1().getValueAt(selected_Row, 0).toString();
            String productName = getjTable1().getValueAt(selected_Row, 1).toString();

            invoice_Price=UserQTY*Price;

            SumTotalBill=SumTotalBill+(UserQTY*Price);
            System.out.println("Sum of totalBill "+SumTotalBill);
            String prevText=jTextArea1.getText();
            jTextArea1.setText(prevText+id+"               "+productName+"                         "+Price+"                 "+UserQTY+"                 "+invoice_Price+"\n");

            DatabaseConnector dbConnector = new DatabaseConnector();

            // Establish connection
            dbConnector.connect();

            // Use the connection as needed
            Connection connection = dbConnector.getConnection();

            // Now you can perform database operations using 'connection'
            try
            {

                Statement statement=connection.createStatement();

                String query="UPDATE Inventory SET  Qty='"+NewQty+"'  WHERE ID = '"+id+"'";
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

            getjTextFieldFoodName().setText("");
            getjTextFieldFoodPrice().setText("");
            getjTextFieldFoodQTY().setText("");
            getjTextFieldFoodCategory().setText("");

            System.out.println("Sum of toatl"+SumTotalBill);
            DisplayTableData();

        }

    }//GEN-LAST:event_jButton3ActionPerformed
    }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
        // TODO add your handling code here:

        int selected_Row=jTable1.getSelectedRow();

        if (selected_Row != -1)
        {
            // Get data from the selected row
            String id = getjTable1().getValueAt(selected_Row, 0).toString();
            String productName = getjTable1().getValueAt(selected_Row, 1).toString();
            String price = getjTable1().getValueAt(selected_Row, 2).toString();
            String qty = getjTable1().getValueAt(selected_Row, 3).toString();
            String category = getjTable1().getValueAt(selected_Row, 4).toString();

            // Update the text fields with the selected row data
            jTextFieldFoodName.setText(productName);
            jTextFieldFoodPrice.setText(price);
            jTextFieldFoodCategory.setText(category);
        }

        //        jTextFieldFoodName.setText(dtm.getValueAt(selected_Row, 1).toString());
        //        jTextFieldFoodPrice.setText(dtm.getValueAt(selected_Row, 2).toString());
        //        jTextFieldFoodCategory.setText(dtm.getValueAt(selected_Row, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //        Management c=new Cashier();
        //        c.PrintInvoice(this, TotalBill,TextArea);
        JOptionPane.showMessageDialog(this, "Total is: "+SumTotalBill);
        SumTotalBill=0;
        jTextArea1.setText("=======================GUI======================\n*			                       *\n================================================\nID            PRODUCT              PRICE            QTY            TOTAL\n");
    
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelPassword2;
    private javax.swing.JLabel jLabelPassword3;
    private javax.swing.JLabel jLabelProductName;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldFoodCategory;
    private javax.swing.JTextField jTextFieldFoodName;
    private javax.swing.JTextField jTextFieldFoodPrice;
    private javax.swing.JTextField jTextFieldFoodQTY;
    // End of variables declaration//GEN-END:variables
}
