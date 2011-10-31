/*
 * Copyright (C) 2011 Michael Turner <michael at turnerendlesslearning.com>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.turnerendlesslearning.audiobook;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class MainForm extends javax.swing.JFrame {


    Preferences prefs = Preferences.userRoot();
    public String discNumberStringSub = "";
    public Date startTime;
    public Date endTime;

    /** Creates new form MainForm */
    public MainForm() {
        initComponents();

        String oldAuthor = prefs.get("AUTHOR", "");
        if(oldAuthor != null) {
            this.authorTextField.setText(oldAuthor);
        }
        String oldBook = prefs.get("BOOK", "");
        if(oldBook != null) {
            this.bookTextField.setText(oldBook);
        }
        String oldDisc = prefs.get("DISC", "");
        if(oldDisc != null) {
            try {
                int oldDiscNum = Integer.parseInt(oldDisc);
                oldDiscNum++;
                this.discNumberTextField.setText(Integer.toString(oldDiscNum));
            } catch (Exception ex) {
                this.discNumberTextField.setText(oldDisc);
            }
            this.bookTextField.setText(oldBook);
        }


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	this.setTitle("TEL Audiobook Ripper 2011");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        authorTextField = new javax.swing.JTextField();
        bookTextField = new javax.swing.JTextField();
        discNumberTextField = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        disableParanoiaLabel = new javax.swing.JLabel();
        disableParanoiaCheckbox = new javax.swing.JCheckBox();
        useExternalDrive = new javax.swing.JLabel();
        useExternalDriveCheckbox = new javax.swing.JCheckBox();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Author:");

        jLabel2.setText("Book:");

        jLabel3.setText("Disc #:");
        
        disableParanoiaLabel.setText("Disable Paranoia");
        disableParanoiaCheckbox.setSelected(true);
        
        useExternalDrive.setText("Use External Drive?");
        useExternalDriveCheckbox.setSelected(true);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent winEvt) {
                // Perhaps ask user if they want to save any unsaved files first.
            	if(startButton.isEnabled()) {
            		System.exit(0);
            	} else {
            		int result = javax.swing.JOptionPane.showConfirmDialog(null, "The program is still ripping or converting.  Are you sure you want to close?", "Are you sure?", javax.swing.JOptionPane.YES_NO_OPTION);
            		if(result == javax.swing.JOptionPane.YES_OPTION) {
            			System.exit(0);
            		}
            	}
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(disableParanoiaCheckbox)
                        .addComponent(disableParanoiaLabel)
                        .addComponent(useExternalDriveCheckbox)
                        .addComponent(useExternalDrive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(startButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(authorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bookTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(discNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disableParanoiaCheckbox)
                    .addComponent(disableParanoiaLabel)
                    .addComponent(useExternalDriveCheckbox)
                    .addComponent(useExternalDrive)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        //Set start time
        startTime = new java.util.Date();

        //RIP TO WAV
        String homeDir = System.getProperty("user.home" ) + 
                "/Music";
                
        final String bookName = this.bookTextField.getText().trim();
        final String author = this.authorTextField.getText().trim();
        startButton.setEnabled(false);

        //Set Prefs
        prefs.put("AUTHOR", this.authorTextField.getText().trim());
        prefs.put("BOOK", this.bookTextField.getText().trim());
        prefs.put("DISC", this.discNumberTextField.getText().trim());

        String discNumberString = this.discNumberTextField.getText().trim();
        while(discNumberString.length() < 2) {
            discNumberString = "0" + discNumberString;
        }
        discNumberStringSub = discNumberString;


        //Build the outputDirectory
        final String outDir = homeDir + "/" + bookName + "/Disc " + discNumberString;

        RipSwingWorker rsw = new RipSwingWorker();
        rsw.setOutputDirectory(outDir);
        if(this.disableParanoiaCheckbox.isSelected()) {
        	rsw.disableParanoia = true;
        }
        if(this.useExternalDriveCheckbox.isSelected()) {
            rsw.useExternalDrive = true;
        }
        
        rsw.addOutputListener(new OutputListener() {

            @Override
            public void outputReceived(OutputEvent event) {
                textArea.append(event.getData() +"\n");
                textArea.setCaretPosition(textArea.getText().length());
                //textArea.updateUI();
            }
        });
        rsw.addRipDoneListener(new RipDoneListener() {

            @Override
            public void ripDone(RipDoneEvent event) {
            	//EJECT DISC
                try {
                    String drive = "";
                    if(useExternalDriveCheckbox.isSelected()) {
                        drive = "/dev/sr1";
                    } else {
                        drive = "/dev/sr0";
                    }
                    Runtime.getRuntime().exec("eject " + drive);
                } catch (IOException ex) {
                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Begin oggenc conversion and proper titling                
                Runtime rtt = Runtime.getRuntime();
                
                File srcFolder = new File(outDir);
                //File[] f = srcFolder.listFiles();

                String[] f = srcFolder.list();
                Arrays.sort(f);


                for(int i = 0; i < f.length; i++) {
                    
                    String filename = outDir + "/" + f[i];
                    //String withoutExtension = filename.substring(0, filename.length() - 4);
                    String ext = filename.substring(filename.length() - 4);
                    if(!ext.toLowerCase().equals(".wav")) {
                        continue;
                    }

                    String trackNumberString = Integer.toString(i + 1);
                    while(trackNumberString.length() < 2) {
                        trackNumberString = "0" + trackNumberString;
                    }


                    String outFileName = outDir + "/Disc " + discNumberStringSub + " - " + trackNumberString + ".ogg";
                    String[] encCommand = {"oggenc", "-a", author, "-l", bookName, "-N", trackNumberString, "-c", "DISCNUMBER="+discNumberStringSub,filename, "-o", outFileName};

                    textArea.append(outDir + "/" + f[i] + "\n");
                    textArea.append(outFileName + "\n");
                    textArea.setCaretPosition(textArea.getText().length());
                    Process proc = null;
                    try {
                        proc = rtt.exec(encCommand);
                        try {
                            proc.waitFor();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    File subF = new File(outDir + "/" + f[i]);
                    if(subF.exists()) {
                        if(!subF.delete()) {
                            textArea.append("Failed to delete: " + subF.getName() + "\n");
                            textArea.setCaretPosition(textArea.getText().length());
                        }
                    }

                }
                
                

                //Get the end time
                endTime = new java.util.Date();

                //Calculate the time taken (in minutes?)
                long diff = endTime.getTime() - startTime.getTime();
                int seconds = (int)Math.floor(diff / 1000);
                int minutes = (int) Math.floor(seconds / 60);
                seconds = seconds % 60;

                String durationString = "";
                if(minutes > 0) {
                    durationString = Integer.toString(minutes) + " minutes";
                }
                if(seconds > 0) {
                    if(durationString.length() > 0) {
                        durationString += " and ";
                    }

                    durationString += Integer.toString(seconds) + " seconds.";
                } else {
                    durationString += ".";
                }

                javax.swing.JOptionPane.showMessageDialog(null, "Rip Completed in \n" +
                        durationString);
                startButton.setEnabled(true);
            }
        } );
        
        Thread t = new Thread(rsw);
        t.start();


        //javax.swing.JOptionPane.showMessageDialog(this, "Finished Ripping");



        //CONVERT TO OGG
}//GEN-LAST:event_startButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorTextField;
    private javax.swing.JTextField bookTextField;
    private javax.swing.JTextField discNumberTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton startButton;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel disableParanoiaLabel;
    private javax.swing.JCheckBox disableParanoiaCheckbox;
    private javax.swing.JLabel useExternalDrive;
    private javax.swing.JCheckBox useExternalDriveCheckbox;
    // End of variables declaration//GEN-END:variables

}
