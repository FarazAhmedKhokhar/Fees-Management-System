/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.DetailsBean;
import BeanClasses.ListBean;
import databaseManager.DBManagerschool;
import databaseManager.Decoder;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Haji Khokar
 */
public class DetailFrame extends javax.swing.JFrame {

    /**
     * Creates new form DetailFrame
     */
    public DetailFrame() {
        initComponents();
        Section();
        getCLass();
    }
  //      getFaculty();
    private void getCLass(){
    
        
        try{
             java.util.Vector v=DBManagerschool.getCLass();
        classComboBox2.removeAllItems();
        for(int i=0;i<v.size(); i++)
        {
            ListBean bean=(ListBean)v.elementAt(i);
            classComboBox2.addItem(bean);
        }
                
		        }catch(Exception e){
            e.printStackTrace();
        }     
    }
    private void getDetail(){
        try{
            
               
               ListBean bean=(ListBean)classComboBox2.getSelectedItem();
                if(bean==null)return;
               
		 
                Vector v=databaseManager.DBManagerschool.getDetail(bean.getCLass());
                STUDENTLISTList.setListData(v);
//             
//      java.util.Vector v=databaseManager.DBManagerschool.getCLass(); 
//                 for(int i=0;i<v.size(); i++)
//                 {
//                 ListBean progbean=(ListBean)v.elementAt(i);
//                    classComboBox2.addItem(progbean);
//                    java.util.Vector z=databaseManager.DBManagerschool.getDetail(progbean.getCLass()); 
//                    STUDENTLISTList.setListData(z);
          
                        
                }catch(Exception e){
                e.printStackTrace();
       
            JOptionPane.showMessageDialog(null,e.getMessage());
    }
        
    }
          private void clear()
             {
            jidTextField.setText("");	
	studentnameTextField.setText("");	
	fathernameTextField.setText("");
        feesTextField.setText("");
        casteTextField.setText("");
        tareekhTextField.setText("");
         classComboBox2.addItem("");
        sectionTextField.setText("");
        phonenumberTextField12.setText("");
        balanceTextField13.setText("");
        
           }   
private void updateDetails()
           {
//             private int id;
//    private String studentName;
//    private String fatherName;
//    private String caste;
//    private int Class;
//    private String section;
//    private int fees;
//    private Date dateandmonthofpayment; 
               DetailsBean bean=(DetailsBean)STUDENTLISTList.getSelectedValue();
            if(bean==null)return;
             int id=Integer.parseInt(jidTextField.getText());
             String studentName=studentnameTextField.getText();
//           String Class=(String)(classComboBox1.getSelectedItem());
             String fatherName=fathernameTextField.getText();
             String caste=casteTextField.getText();
             String section=sectionTextField.getText(); 
             //String fees=feesTextField.getText();
            
              int fees = Integer.parseInt(feesTextField.getText());
//               String dateandmonthofpayment1=feesTextField.getText();
          String dateandmonthofpayment=Decoder.DateFormate(dateandmonthstartDateChooser2.getDate());   
 //         String balance= balanceTextField13.getText();
        
          String PhoneNumber=phonenumberTextField12.getText();
              int balance = Integer.parseInt( balanceTextField13.getText());
            
             try{
             //int rows=DBManagerschool.updateDetail(bean.getCLass(),id, studentName, fatherName, caste, section, fees, dateandmonthofpayment,balance,PhoneNumber);
             int rows=DBManagerschool.updateDetail(bean.getCLass(), id, studentName, fatherName, caste, section, fees, dateandmonthofpayment, balance, PhoneNumber);
               
             if(rows>=1)
                {
                   JOptionPane.showMessageDialog(null,rows+"Records Updated");
                    clear();
                    getDetail();
                }

              }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,e.getMessage());


                      }
        
        }

 private void deleteDetails()
    {
        DetailsBean bean=(DetailsBean)STUDENTLISTList.getSelectedValue();
            if(bean==null)return;
             
            String studentName=studentnameTextField.getText();
//            String Class=(String)(classComboBox1.getSelectedItem());
            String fatherName=fathernameTextField.getText();
             String caste=casteTextField.getText();
              String section=sectionTextField.getText();
            //   String fees=feesTextField.getText();
              int fees = Integer.parseInt(feesTextField.getText());  
            Date dateandmonthofpayment=dateandmonthstartDateChooser2.getDate();             
            // String Balance= balanceTextField13.getText();
              int balance = Integer.parseInt( balanceTextField13.getText());
             
            String PhoneNumber=phonenumberTextField12.getText();
        
//     String dateandmonthofpayment=Decoder.DateFormate(dateandmonthstartDateChooser2.getDate());      
             try{
             int rows=DBManagerschool.deleteDetail(bean.getId());
              
                 if(rows>=1)
                {
                   JOptionPane.showMessageDialog(null,rows+"Records Deleted");
                    clear();
                    getDetail();
                }

              }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,e.getMessage());
            
                      }
        
        }
    
//        private void addDetail()
//        {
//          ListBean bean=(ListBean)classComboBox2.getSelectedItem();
//           if(bean==null)return;
//            
//           String studentName=studentnameTextField.getText();
////            String Class=(String)(classComboBox1.getSelectedItem());
//            String fatherName=fathernameTextField.getText();
//             String caste=casteTextField.getText();
//              String section=sectionTextField.getText();
//             // int fees=Integer.parseInt(feesTextField.getText());
//              String fees=feesTextField.getText();
//         String Balance= balanceTextField13.getText();
//            
//              String PhoneNumber=phonenumberTextField12.getText();
//        
//        
//// String dateandmonthofpayment=TextField.getText();
//                               // Date dateandmonthofpayment=dateandmonthstartDateChooser2.getDate();
//    String Dateandmonthofpayment=Decoder.DateFormate(dateandmonthstartDateChooser2.getDate());
//
//             try{
//             int rows=DBManagerschool.addDetail(bean.getCLass(), studentName, fatherName, caste, section, fees, Dateandmonthofpayment,Balance,PhoneNumber);
//
//
//                 if(rows>=1)
//            {
//               JOptionPane.showMessageDialog(null,rows+"Records Added");
//                
//                getDetail();
//            }
//                
//          }catch(Exception e){
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,e.getMessage());
//              
//                      
//                      }
//        
//        
//             }      
//                
           
        private void addDetail()
        {
          ListBean bean=(ListBean)classComboBox2.getSelectedItem();
           if(bean==null)return;
            
           String studentName=studentnameTextField.getText();
//            String Class=(String)(classComboBox1.getSelectedItem());
            String fatherName=fathernameTextField.getText();
             String caste=casteTextField.getText();
              String section=sectionTextField.getText();
             // int fees=Integer.parseInt(feesTextField.getText());
           //   String fees=feesTextField.getText();
                int fees = Integer.parseInt(feesTextField.getText());  
        
           int Balance = Integer.parseInt( balanceTextField13.getText());
                
              String PhoneNumber=phonenumberTextField12.getText();
        
        
// String dateandmonthofpayment=TextField.getText();
                               // Date dateandmonthofpayment=dateandmonthstartDateChooser2.getDate();
    String dateandmonthofpayment=Decoder.DateFormate(dateandmonthstartDateChooser2.getDate());

             try{
             int rows=DBManagerschool.addDetail(bean.getCLass(), studentName, fatherName, caste, section, fees, dateandmonthofpayment,Balance,PhoneNumber);


                 if(rows>=1)
            {
               JOptionPane.showMessageDialog(null,rows+"Records Added");
                
                getDetail();
            }
                
          }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
              
                      
                      }
        
        
             }      
           
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        studentnameTextField = new javax.swing.JTextField();
        feesTextField = new javax.swing.JTextField();
        jidTextField = new javax.swing.JTextField();
        sectionTextField = new javax.swing.JTextField();
        fathernameTextField = new javax.swing.JTextField();
        casteTextField = new javax.swing.JTextField();
        tareekhTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        STUDENTLISTList = new javax.swing.JList();
        jTextField10 = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        classComboBox2 = new javax.swing.JComboBox();
        jTextField11 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        phonenumberTextField12 = new javax.swing.JTextField();
        balanceTextField13 = new javax.swing.JTextField();
        BACKButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 121, 206));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 20));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(0, 121, 206));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("DETAILS");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 280, 60));

        jTextField2.setBackground(new java.awt.Color(0, 121, 206));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("ID");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jTextField3.setBackground(new java.awt.Color(0, 121, 206));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("STUDENT NAME");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, -1, -1));

        jTextField4.setBackground(new java.awt.Color(0, 121, 206));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("FATHER NAME");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jTextField5.setBackground(new java.awt.Color(0, 121, 206));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setText("CLASS");
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 121, 206));
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText("CASTE");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 150, 50));

        jTextField7.setBackground(new java.awt.Color(0, 121, 206));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("SECTION");
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jTextField8.setBackground(new java.awt.Color(0, 121, 206));
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setText("FEES");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, -1, -1));

        jTextField9.setBackground(new java.awt.Color(0, 121, 206));
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setText("SELECT PAYMENT DATE");
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, -1, -1));

        studentnameTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        studentnameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel1.add(studentnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 320, 50));

        feesTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        feesTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel1.add(feesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 200, 50));

        jidTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jidTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jidTextField.setEnabled(false);
        jidTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(jidTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 60, 40));

        sectionTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sectionTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel1.add(sectionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 110, 50));

        fathernameTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fathernameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 8));
        jPanel1.add(fathernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 320, 50));

        casteTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        casteTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel1.add(casteTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 320, 50));

        tareekhTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tareekhTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        tareekhTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tareekhTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(tareekhTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 190, 50));

        STUDENTLISTList.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        STUDENTLISTList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                STUDENTLISTListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(STUDENTLISTList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 130, 270, 620));

        jTextField10.setBackground(new java.awt.Color(0, 121, 206));
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setText("STUDENT LIST");
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, -170, -1, -1));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.setToolTipText("");
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 10));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, 140, 60));

        deleteButton.setBackground(new java.awt.Color(255, 51, 51));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 10));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 720, -1, 60));

        clearButton.setBackground(new java.awt.Color(255, 255, 255));
        clearButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 10, true));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel1.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 720, 130, 60));

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 10));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 720, 150, 60));

        classComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        classComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        classComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(classComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 140, 50));

        jTextField11.setBackground(new java.awt.Color(0, 121, 206));
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));
        jTextField11.setText("DATE AND MONTH OF PAYMENT");
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PHONE NUMBER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UNPAID AMOUNT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STUDENTS LIST");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 90, 220, -1));

        phonenumberTextField12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        phonenumberTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel1.add(phonenumberTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 280, 50));

        balanceTextField13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        balanceTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 5));
        jPanel1.add(balanceTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 270, 50));

        BACKButton1.setBackground(new java.awt.Color(255, 255, 255));
        BACKButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BACKButton1.setText("BACK");
        BACKButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 10));
        BACKButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(BACKButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 720, 120, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void STUDENTLISTListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_STUDENTLISTListValueChanged
//getDetail();      
        DetailsBean bean=(DetailsBean)STUDENTLISTList.getSelectedValue();
	if(bean==null)return;
	jidTextField.setText(""+bean.getId());	
	studentnameTextField.setText(""+bean.getStudentName());	
	fathernameTextField.setText(""+bean.getFaherName());
        feesTextField.setText(""+bean.getFees());
        casteTextField.setText(""+bean.getCaste());
        tareekhTextField.setText(""+bean.getDateandmonthofpayment());
        /// classComboBox1.addItem(""+bean.getCLass());
        sectionTextField.setText(""+bean.getSection());
        phonenumberTextField12.setText(""+bean.getNumber());
        balanceTextField13.setText(""+bean.getBalance());
                                              

// TODO add your handling code here:
    }//GEN-LAST:event_STUDENTLISTListValueChanged

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
     updateDetails();
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
     deleteDetails();
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
   addDetail();
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void classComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboBox2ActionPerformed
getDetail();        
// TODO add your handling code here:
    }//GEN-LAST:event_classComboBox2ActionPerformed

    private void jidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jidTextFieldActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void BACKButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKButton1ActionPerformed
      this.toBack();
      setVisible(false);
      new HOME().toFront();
      new HOME().setState(java.awt.Frame.NORMAL);
        // TODO add your handling code here:
    }//GEN-LAST:event_BACKButton1ActionPerformed

    private void tareekhTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tareekhTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tareekhTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACKButton1;
    private javax.swing.JList STUDENTLISTList;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField balanceTextField13;
    private javax.swing.JTextField casteTextField;
    private javax.swing.JComboBox classComboBox2;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField fathernameTextField;
    private javax.swing.JTextField feesTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jidTextField;
    private javax.swing.JTextField phonenumberTextField12;
    private javax.swing.JTextField sectionTextField;
    private javax.swing.JTextField studentnameTextField;
    private javax.swing.JTextField tareekhTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
private void Section()
{
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images.png")));
}

}
