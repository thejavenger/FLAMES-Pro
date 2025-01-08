
package flames.pro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Javenger
 */
public class FLAMESInterface extends javax.swing.JFrame {

    int matched = 0;
    String result = "";
    
    String boyfullname = "";
    String girlfullname = "";
        
    Graphics2D g;
    
    ArrayList matchedletters = new ArrayList();
    
    public FLAMESInterface() {
        initComponents();
        extraComponents();
    }
    
    private void CalculateFlames(){
        
        String boyname = "";
        String girlname = "";
        
        boyfullname = txtBoyFirstname.getText() + " " + txtBoyLastname.getText();
        girlfullname = txtGirlFirstname.getText() + " " + txtGirlLastname.getText();
        
        boyname = boyfullname;
        girlname = girlfullname;

        int counter = 0;
        int breakIt, signal;

        boyname = boyname.replace(" ", "");
        girlname = girlname.replace(" ", "");
        boyname = boyname.toUpperCase();
        girlname = girlname.toUpperCase();

        for (int charCrush=0;charCrush<boyname.length();charCrush++){
            breakIt = 0;
            signal = 0;
            for(int charMe=0;charMe<girlname.length();charMe++){
                if(boyname.charAt(charCrush)==girlname.charAt(charMe)){
                    counter++;
                    for (int charCrush1=0;charCrush1<charCrush;charCrush1++){
                        if(boyname.charAt(charCrush1)==boyname.charAt(charCrush)){
                            counter--;
                            breakIt=1;
                            break;
                        }
                    }
                    if(breakIt==1){
                            break;
                    }
                    if (signal==0){
                        for(int charCrush1=0;charCrush1<boyname.length();charCrush1++){
                            if(boyname.charAt(charCrush1)==boyname.charAt(charCrush)){
                                counter++;
                            }
                        }
                        signal=1;
                    }
                    
                    matchedletters.add(boyname.charAt(charCrush) + "");
                }
                
                matched = counter;
            }

        }

        while(counter>6){
            counter = counter - 6;
        }

        if (counter==1)
            result = "friends";
        else if (counter==2)
            result = "lovers";
        else if (counter==3)
            result = "angry";
        else if (counter==4)
            result = "marriage";
        else if (counter==5)
            result = "enemy";
        else
            result = "sweethearts";
        
        result = result.toUpperCase();
            
        
        
        lblMatched.setText("" + matched);
        lblResult.setText(result);
        
        //JOptionPane.showMessageDialog(null, result, "Flames", JOptionPane.PLAIN_MESSAGE);
					

    }
    
    private void SketchFlames(){
        
        g = (Graphics2D) pnlSketchBoard.getGraphics();
        
        g.setColor(Color.BLACK);
        g.setFont(new java.awt.Font("Verdana", 0, 19));
        g.setStroke(new BasicStroke(1));
        
        
        int nameheight = g.getFontMetrics().getHeight();
        int namewidth = g.getFontMetrics().stringWidth(boyfullname);
        
        int marginx = 25;
        int marginy = 25;
        
        int lettergap = 10;
        
        int letterx = marginx;
        int lettery = marginy;
        
        //g.drawString(boyfullname.toUpperCase(), 50, 50);
        
        for(int i=0; i<boyfullname.length(); i++){
            
            g.setStroke(new BasicStroke(1));
            
            String currentletter = boyfullname.toUpperCase().charAt(i) + "";
            
            namewidth = g.getFontMetrics().stringWidth(currentletter);
            
            g.drawString(currentletter, letterx, lettery + (nameheight/2));
            
            
            if(matchedletters.contains(currentletter)){
                
                int linexfrom = letterx + namewidth + 5;
                int lineyfrom = lettery - 5;
                int linexto = letterx - 5;
                //int linexto = letterx - (namewidth/2) - 5;
                int lineyto = lettery + (nameheight/2) + 5;
                
                g.setStroke(new BasicStroke(1));
            
                g.drawLine(linexfrom, lineyfrom, linexto, lineyto);
                g.drawLine(linexfrom + 2, lineyfrom, linexto + 2, lineyto);

                //g.drawLine(letterx+4, lettery+4, letterx + namewidth +4, lettery +4 + (nameheight/2));
                //g.drawLine(letterx, lettery, letterx + nameheight, lettery);
                
            }
            
            
            
            
            letterx += namewidth + lettergap;
            
        }
        
        letterx = marginx;
        lettery += nameheight * 2;
        
        for(int i=0; i<girlfullname.length(); i++){
            
            String currentletter = girlfullname.toUpperCase().charAt(i) + "";
            
            namewidth = g.getFontMetrics().stringWidth(currentletter);
            
            g.drawString(currentletter, letterx, lettery + (nameheight/2));
            
            if(matchedletters.contains(currentletter)){
                
                int linexfrom = letterx + namewidth + 5;
                int lineyfrom = lettery - 5;
                int linexto = letterx - 5;
                int lineyto = lettery + (nameheight/2) + 5;
                
                g.setStroke(new BasicStroke(1));
            
                g.drawLine(linexfrom, lineyfrom, linexto, lineyto);
                g.drawLine(linexfrom + 2, lineyfrom, linexto + 2, lineyto);
                
            }
            
            letterx += namewidth + lettergap;
            
        }
        
        String flamesword = "FLAMES";
        String flamesletter = "";
        int counter = matched;
        
        while(counter>6){
            counter = counter - 6;
        }

        if (counter==1)
            flamesletter = "F";
        else if (counter==2)
            flamesletter = "L";
        else if (counter==3)
            flamesletter = "A";
        else if (counter==4)
            flamesletter = "M";
        else if (counter==5)
            flamesletter = "E";
        else
            flamesletter = "S";
        
        letterx = marginx + 10;
        lettery += nameheight * 3;
        lettergap = 25;
        
        g.setColor(Color.BLACK);
        g.setFont(new java.awt.Font("Segoe Script", 0, 48));
        g.setStroke(new BasicStroke(1));
        
        int[] flamesletterwidth = new int[flamesword.length()];
        int flameslettergap = lettergap;
        
        
        for(int i=0; i<flamesword.length(); i++){
            
            String currentletter = flamesword.toUpperCase().charAt(i) + "";
            
            namewidth = g.getFontMetrics().stringWidth(currentletter);
            
            if(currentletter.equals(flamesletter)){
                
                int centerx = letterx;
                int centery = lettery - nameheight;
                
                g.drawOval(centerx, centery, namewidth + 5, nameheight + 20);
                
                //g.draw
                
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.BLACK);
            }
            
            g.drawString(currentletter, letterx, lettery + (nameheight/2));
            
            letterx += namewidth + lettergap;
            flamesletterwidth[i] = namewidth;
            
        }
        
        
        g.setColor(Color.BLACK);
        g.setFont(new java.awt.Font("Courier New", 0, 10));
        g.setStroke(new BasicStroke(1));
        
        
        nameheight = g.getFontMetrics().getHeight();
        //namewidth = g.getFontMetrics().stringWidth(boyfullname);
        
        letterx = marginx + 10;
        lettery += nameheight * 3;
        lettergap = 10;
        
        
        for(int i=0; i<matched;i++){
            
            int flamescount = i+1;
            int flamescharcount;
            String countword = flamescount + "";
            
            String currentletter = countword;
            
            namewidth = g.getFontMetrics().stringWidth(currentletter);
            
            if(flamescount<=6){
                
                flamescharcount = flamescount;
                
                if(flamescharcount==1)
                    letterx = marginx + 10;
            }else{
                
                if(flamescount%6==0){
                    flamescharcount = 6;
                }else{
                    flamescharcount = flamescount%6;
                }
                
                if(flamescharcount==1)
                    letterx = marginx + 10;
                
            }
            
            
            letterx += ((flamesletterwidth[flamescharcount-1]));
            lettery = lettery + (nameheight * (flamescharcount/6));
            
            if(i==matched-1)
                g.setColor(Color.RED);
            
            if(flamescharcount==6)
                g.drawString(currentletter, letterx - (flamesletterwidth[flamescharcount-1]/2), (lettery + (nameheight/2))-nameheight);
            else
                g.drawString(currentletter, letterx - (flamesletterwidth[flamescharcount-1]/2), lettery + (nameheight/2));
            
            write("flamescount: " + flamescount + " flamescharcount: " + flamescharcount + " flamesletterwidth: " + flamesletterwidth + " letterx: " + letterx + " lettery: " + lettery);
            
            
            letterx += flameslettergap;
            
            
        }
        
        
        
        
        
        
    }
    

    private void prompt(String p){
        JOptionPane.showMessageDialog(null, p);
    }
    
    private void prompt(int p){
        JOptionPane.showMessageDialog(null, p);
    }
    
    private void prompt(int p[]){
        JOptionPane.showMessageDialog(null, p);
    }
    
    private void write(String p){
        System.out.println(p);
    }
    
    private void write(int p){
        System.out.println(p);
    }
    
    
   private void extraComponents(){
        this.setLocationRelativeTo(null);
        //setIconImage(new ImageIcon("favicon.png").getImage());
    }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBoy = new javax.swing.JPanel();
        txtBoyFirstname = new javax.swing.JTextField();
        txtBoyLastname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlGirl = new javax.swing.JPanel();
        txtGirlFirstname = new javax.swing.JTextField();
        txtGirlLastname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblMatched = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnFlames = new javax.swing.JButton();
        pnlSketchBoard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBoy.setBorder(javax.swing.BorderFactory.createTitledBorder("Boy"));

        txtBoyFirstname.setText("Charles Cyril");

        txtBoyLastname.setText("Russell");
        txtBoyLastname.setNextFocusableComponent(txtGirlFirstname);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Firstname");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Lastname");

        javax.swing.GroupLayout pnlBoyLayout = new javax.swing.GroupLayout(pnlBoy);
        pnlBoy.setLayout(pnlBoyLayout);
        pnlBoyLayout.setHorizontalGroup(
            pnlBoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlBoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBoyFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBoyLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlBoyLayout.setVerticalGroup(
            pnlBoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBoyFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoyLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGirl.setBorder(javax.swing.BorderFactory.createTitledBorder("Girl"));

        txtGirlFirstname.setText("Divina Ursula Bokbokova");

        txtGirlLastname.setText("Smash");
        txtGirlLastname.setNextFocusableComponent(btnFlames);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Firstname");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setText("Lastname");

        javax.swing.GroupLayout pnlGirlLayout = new javax.swing.GroupLayout(pnlGirl);
        pnlGirl.setLayout(pnlGirlLayout);
        pnlGirlLayout.setHorizontalGroup(
            pnlGirlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGirlLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlGirlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGirlFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGirlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGirlLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlGirlLayout.setVerticalGroup(
            pnlGirlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGirlLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlGirlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGirlFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGirlLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGirlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Result"));

        lblMatched.setBackground(new java.awt.Color(255, 255, 255));
        lblMatched.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblMatched.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatched.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Matched Letters");

        lblResult.setBackground(new java.awt.Color(255, 255, 255));
        lblResult.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResult.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Result");

        btnFlames.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFlames.setText("FLAMES");
        btnFlames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlamesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFlames, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMatched, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMatched, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFlames)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSketchBoard.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlSketchBoardLayout = new javax.swing.GroupLayout(pnlSketchBoard);
        pnlSketchBoard.setLayout(pnlSketchBoardLayout);
        pnlSketchBoardLayout.setHorizontalGroup(
            pnlSketchBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSketchBoardLayout.setVerticalGroup(
            pnlSketchBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSketchBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlGirl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlBoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlBoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlGirl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSketchBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFlamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlamesActionPerformed
        CalculateFlames();
        SketchFlames();
    }//GEN-LAST:event_btnFlamesActionPerformed

    
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
            java.util.logging.Logger.getLogger(FLAMESInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLAMESInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLAMESInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLAMESInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLAMESInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFlames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMatched;
    private javax.swing.JLabel lblResult;
    private javax.swing.JPanel pnlBoy;
    private javax.swing.JPanel pnlGirl;
    private javax.swing.JPanel pnlSketchBoard;
    private javax.swing.JTextField txtBoyFirstname;
    private javax.swing.JTextField txtBoyLastname;
    private javax.swing.JTextField txtGirlFirstname;
    private javax.swing.JTextField txtGirlLastname;
    // End of variables declaration//GEN-END:variables
}
