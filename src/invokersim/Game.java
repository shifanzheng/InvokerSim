package invokersim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

public class Game extends javax.swing.JFrame implements KeyListener {

    protected char[] spells = new char[3];
    protected int num=-1;
    int counter = 0;
    int playerScore = 0;
    Timer timer;
    int timerVal;
    int combo=0;

    private AudioInputStream clipNameAIS;
    private Clip clipNameClip;

    public Game() {
        initComponents();
        addKeyListener(this);
        inGame.setVisible(false);
        setFocusable(true);
        helpPanel.setVisible(false);
        timerBar.setVisible(false);

        ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                timerVal = timerBar.getValue();
                if (timerVal <= 0) {
                    timer.stop();
                    deathSound();   
                    currentSpell.setVisible(false);
                    spellName.setVisible(false);
                    invokeLabel.setText("Press to restart");
                    timerBar.setVisible(false);
                    spells[0] = 0;
                    spells[1] = 0;
                    spells[2] = 0;
                    spell1.setVisible(false);
                    spell2.setVisible(false);
                    spell3.setVisible(false);
                    startButton.setVisible(true);
                    return;
                }
                timerBar.setValue(--timerVal);
            }
        };
        timer = new Timer(300, updateProBar);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        helpButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        menuLabel = new javax.swing.JLabel();
        helpPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        helpLabel = new javax.swing.JLabel();
        inGame = new javax.swing.JPanel();
        invokeLabel = new javax.swing.JLabel();
        timerBar = new javax.swing.JProgressBar(0,100);
        spellName = new javax.swing.JLabel();
        currentSpell = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        spell1 = new javax.swing.JLabel();
        spell2 = new javax.swing.JLabel();
        spell3 = new javax.swing.JLabel();
        quas = new javax.swing.JLabel();
        wex = new javax.swing.JLabel();
        exort = new javax.swing.JLabel();
        invoke = new javax.swing.JLabel();
        quasText = new javax.swing.JLabel();
        wexText = new javax.swing.JLabel();
        exortText = new javax.swing.JLabel();
        invokeText = new javax.swing.JLabel();
        scoreText = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        black = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        helpButton.setBackground(new java.awt.Color(255, 255, 255));
        helpButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        helpButton.setForeground(new java.awt.Color(255, 255, 255));
        helpButton.setText("How to Play");
        helpButton.setBorder(null);
        helpButton.setOpaque(false);
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        menuPanel.add(helpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, -1, -1));

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playButton.jpg"))); // NOI18N
        playButton.setBorder(null);
        playButton.setOpaque(true);
        playButton.setContentAreaFilled(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        menuPanel.add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 124, 33));

        menuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.jpg"))); // NOI18N
        menuLabel.setText("jLabel1");
        menuPanel.add(menuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        getContentPane().add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1019, 577));

        helpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button.png"))); // NOI18N
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.setOpaque(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        helpPanel.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 50));

        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.jpg"))); // NOI18N
        helpPanel.add(helpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(helpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1019, 577));

        inGame.setPreferredSize(new java.awt.Dimension(1019, 577));
        inGame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        invokeLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        invokeLabel.setForeground(new java.awt.Color(255, 255, 255));
        invokeLabel.setText("Press icon to Play");
        inGame.add(invokeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 280, 90));

        timerBar.setValue(100);
        timerBar.setForeground(new java.awt.Color(255, 0, 0));
        inGame.add(timerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 370, -1));

        spellName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spellName.setForeground(new java.awt.Color(255, 255, 255));
        inGame.add(spellName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 150, 30));
        inGame.add(currentSpell, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 128, 128));

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttonIcon.png"))); // NOI18N
        startButton.setBorder(null);
        startButton.setBorderPainted(false);
        //startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        inGame.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));
        inGame.add(spell1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 128, 128));
        inGame.add(spell2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 128, 128));
        inGame.add(spell3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 128, 128));

        quas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quas.png"))); // NOI18N
        inGame.add(quas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        wex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Wex.png"))); // NOI18N
        inGame.add(wex, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, -1));

        exort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exort.png"))); // NOI18N
        inGame.add(exort, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, -1, -1));

        invoke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoke.png"))); // NOI18N
        inGame.add(invoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, -1, -1));

        quasText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quasText.setForeground(new java.awt.Color(255, 255, 255));
        quasText.setText("Quas (Q)");
        inGame.add(quasText, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        wexText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        wexText.setForeground(new java.awt.Color(255, 255, 255));
        wexText.setText("Wex (W)");
        inGame.add(wexText, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        exortText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exortText.setForeground(new java.awt.Color(255, 255, 255));
        exortText.setText("Exort (E)");
        inGame.add(exortText, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        invokeText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invokeText.setForeground(new java.awt.Color(255, 255, 255));
        invokeText.setText("Invoke (R)");
        inGame.add(invokeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        scoreText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scoreText.setForeground(new java.awt.Color(255, 255, 255));
        scoreText.setText("Score:");
        inGame.add(scoreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, -1));

        scoreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 0, 0));
        scoreLabel.setText("0");
        inGame.add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, 20, -1));

        black.setBackground(new java.awt.Color(0, 0, 0));
        black.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/black.jpg"))); // NOI18N
        inGame.add(black, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 620));

        getContentPane().add(inGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1019, 577));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        menuPanel.setVisible(false);
        helpPanel.setVisible(true);


    }//GEN-LAST:event_helpButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        helpPanel.setVisible(false);
        menuPanel.setVisible(true);

    }//GEN-LAST:event_backButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        menuPanel.setVisible(false);
        helpPanel.setVisible(false);
        inGame.setVisible(true);

    }//GEN-LAST:event_playButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        playerScore=0;
        scoreLabel.setText("0");
        spellName.setVisible(false);
        currentSpell.setVisible(true);
        startButton.setVisible(false);
        timer.start();
        invokeLabel.setText("");
        timerBar.setVisible(true);
        timerBar.setValue(300);
        spell1.setVisible(true);
        spell2.setVisible(true);
        spell3.setVisible(true);
        
        getSpell(num);
    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }

        });

    }

    public void invokeSound() {
        try {

            clipNameAIS = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sound/Invoke.wav"));

            clipNameClip = AudioSystem.getClip();

            clipNameClip.open(clipNameAIS);

        } catch (Exception e) {
            System.out.println("Failure to load sound");
        }

        clipNameClip.setFramePosition(0);

        clipNameClip.start();
    }

    public void deathSound() {
        try {

            clipNameAIS = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sound/gameover.wav"));

            clipNameClip = AudioSystem.getClip();

            clipNameClip.open(clipNameAIS);

        } catch (Exception e) {
            System.out.println("Failure to load sound");
        }

        clipNameClip.setFramePosition(0);

        clipNameClip.start();
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public void getSpell(int currentNum) {
        num = randInt(1, 10);
        while(currentNum==num)
            num = randInt(1, 10);

        if (num == 1) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Alacrity.png")));
            spellName.setText("Alacrity");
        } else if (num == 2) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EMP.png")));
            spellName.setText("EMP");
        } else if (num == 3) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tornado.png")));
            spellName.setText("Tornado");
        } else if (num == 4) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coldsnap.png")));
            spellName.setText("Cold Snap");
        } else if (num == 5) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deafening.png")));
            spellName.setText("Deafening Blast");
        } else if (num == 6) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forged.png")));
            spellName.setText("Forged Spirit");
        } else if (num == 7) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ghostwalk.png")));
            spellName.setText("Ghost Walk");
        } else if (num == 8) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meteor.png")));
            spellName.setText("Chaos Meteor");
        } else if (num == 9) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wall.png")));
            spellName.setText("Ice Wall");
        } else if (num == 10) {
            currentSpell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sunstrike.jpg")));
            spellName.setText("Sun Strike");
        }

    }

    private int getNum() {
        return num;
    }

    private void setNum(int number) {
        num = number;
    }

    private boolean invokeSpell(int num) {
        boolean check = false;
        if (num == 1 && ((spells[0] == 'w' && spells[1] == 'w' && spells[2] == 'e') || (spells[0] == 'w' && spells[1] == 'e' && spells[2] == 'w') || (spells[0] == 'e' && spells[1] == 'w' && spells[2] == 'w'))) {
            check = true;
        }
        if (num == 2 && spells[0] == 'w' && spells[1] == 'w' && spells[2] == 'w') {
            check = true;
        }
        if (num == 3 && ((spells[0] == 'w' && spells[1] == 'w' && spells[2] == 'q') || (spells[0] == 'w' && spells[1] == 'q' && spells[2] == 'w') || (spells[0] == 'q' && spells[1] == 'w' && spells[2] == 'w'))) {
            check = true;
        }
        if (num == 4 && spells[0] == 'q' && spells[1] == 'q' && spells[2] == 'q') {
            check = true;
        }
        if (num == 5 && ((spells[0] == 'q' && spells[1] == 'w' && spells[2] == 'e') || (spells[0] == 'q' && spells[1] == 'e' && spells[2] == 'w') || (spells[0] == 'w' && spells[1] == 'e' && spells[2] == 'q') || (spells[0] == 'w' && spells[1] == 'q' && spells[2] == 'e') || (spells[0] == 'e' && spells[1] == 'q' && spells[2] == 'w') || (spells[0] == 'e' && spells[1] == 'w' && spells[2] == 'q'))) {
            check = true;
        }
        if (num == 6 && ((spells[0] == 'e' && spells[1] == 'e' && spells[2] == 'q') || (spells[0] == 'e' && spells[1] == 'q' && spells[2] == 'e') || (spells[0] == 'q' && spells[1] == 'e' && spells[2] == 'e'))) {
            check = true;
        }
        if (num == 7 && ((spells[0] == 'q' && spells[1] == 'q' && spells[2] == 'w') || (spells[0] == 'q' && spells[1] == 'w' && spells[2] == 'q') || (spells[0] == 'w' && spells[1] == 'q' && spells[2] == 'q'))) {
            check = true;
        }
        if (num == 8 && ((spells[0] == 'e' && spells[1] == 'e' && spells[2] == 'w') || (spells[0] == 'e' && spells[1] == 'w' && spells[2] == 'e') || (spells[0] == 'w' && spells[1] == 'e' && spells[2] == 'e'))) {
            check = true;
        }
        if (num == 9 && ((spells[0] == 'q' && spells[1] == 'q' && spells[2] == 'e') || (spells[0] == 'q' && spells[1] == 'e' && spells[2] == 'q') || (spells[0] == 'e' && spells[1] == 'q' && spells[2] == 'q'))) {
            check = true;
        }
        if (num == 10 && spells[0] == 'e' && spells[1] == 'e' && spells[2] == 'e') {
            check = true;
        }

        return check;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_Q) {

            spells[counter] = 'q';
            counter += 1;

            checkInputs();
            checkCounter();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {

            spells[counter] = 'w';
            counter += 1;
            checkInputs();
            checkCounter();
        } else if (e.getKeyCode() == KeyEvent.VK_E) {

            spells[counter] = 'e';
            counter += 1;
            checkInputs();
            checkCounter();
        } else if (e.getKeyCode() == KeyEvent.VK_R && timerVal>0) {
            invokeSound();

            if (invokeSpell(num) && timerVal > 0) {
               // timerVal = 600;
                //timerBar.setValue(timerVal);
                playerScore++;
                combo++;
                getSpell(num);
                scoreLabel.setText("" + playerScore);
                invokeLabel.setText(combo+"x combo");
            }else if (!invokeSpell(num) && timerVal > 0) {
                invokeLabel.setText("Wrong Input");
                timerBar.setValue(timerVal - 10);
                getSpell(num);
                combo=0;
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void checkCounter() {
        if (counter > 2) {
            counter = 0;
        }
    }

    private void checkInputs() {
        if (spells[0] == 'q') {
            spell1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quasIcon.png")));
        } else if (spells[0] == 'w') {
            spell1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wexIcon.png")));
        } else if (spells[0] == 'e') {
            spell1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exortIcon.png")));
        }
        if (spells[1] == 'q') {
            spell2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quasIcon.png")));
        } else if (spells[1] == 'w') {
            spell2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wexIcon.png")));
        } else if (spells[1] == 'e') {
            spell2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exortIcon.png")));
        }
        if (spells[2] == 'q') {
            spell3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quasIcon.png")));
        } else if (spells[2] == 'w') {
            spell3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wexIcon.png")));
        } else if (spells[2] == 'e') {
            spell3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exortIcon.png")));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel black;
    private javax.swing.JLabel currentSpell;
    private javax.swing.JLabel exort;
    private javax.swing.JLabel exortText;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JPanel inGame;
    private javax.swing.JLabel invoke;
    private javax.swing.JLabel invokeLabel;
    private javax.swing.JLabel invokeText;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel quas;
    private javax.swing.JLabel quasText;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreText;
    private javax.swing.JLabel spell1;
    private javax.swing.JLabel spell2;
    private javax.swing.JLabel spell3;
    private javax.swing.JLabel spellName;
    private javax.swing.JButton startButton;
    private javax.swing.JProgressBar timerBar;
    private javax.swing.JLabel wex;
    private javax.swing.JLabel wexText;
    // End of variables declaration//GEN-END:variables

}
