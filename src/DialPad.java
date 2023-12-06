import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class DialPad extends JFrame implements KeyListener {
    private JPanel mainPanel;
    private JButton[] numberButtons;
    private DialTone tones;
    private boolean entered = true;
    private boolean shiftKey = false;
    public DialPad() {
        super("DTMF Encoder");
        this.tones = new DialTone();

        mainPanel = new JPanel(new GridLayout(4,3,1,1));

        numberButtons = new JButton[12];
        //Buttons 1-9
        for (int i = 0; i < 9; i++) {
            String temp = (i+1) + "";
            numberButtons[i] = new JButton(temp);
            numberButtons[i].setFocusable(false);
            mainPanel.add(numberButtons[i]);
        }
        //Button *
        numberButtons[9] = new JButton("*");
        numberButtons[9].setFocusable(false);
        mainPanel.add(numberButtons[9]);
        //Button 0
        numberButtons[10] = new JButton("0");
        numberButtons[10].setFocusable(false);
        mainPanel.add(numberButtons[10]);
        //Button #
        numberButtons[11] = new JButton("#");
        numberButtons[11].setFocusable(false);
        mainPanel.add(numberButtons[11]);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null); //Centers the opened window
        addKeyListener(this);
        setFocusable(true); //Puts focus on keys
        setVisible(true);


    }
    public static void main(String[] args) {
        DialPad test = new DialPad();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (entered == true) {
            //*
            if (e.getKeyChar() == '*') {
                numberButtons[9].doClick();
                entered = false;
                tones.getDialTone("*");
            }
            //#
            if (e.getKeyChar() == '#') {
                numberButtons[11].doClick();
                entered = false;
                tones.getDialTone("#");
            }
            //0
            else if (e.getKeyChar() == '0') {
                entered = false;
                System.out.println("Reached Here");
                numberButtons[10].doClick();
                tones.getDialTone("0");

            }
            //1
            else if (e.getKeyChar() == '1') {
                entered = false;
                System.out.println("Reached Here");
                numberButtons[0].doClick();
                tones.getDialTone("1");
            }
            //2
            else if (e.getKeyChar() == '2') {
                numberButtons[1].doClick();
                entered = false;
                tones.getDialTone("2");
            }
            //3
            else if (e.getKeyChar() == '3') {
                numberButtons[2].doClick();
                entered = false;
                tones.getDialTone("3");
            }
            //4
            else if (e.getKeyChar() == '4') {
                numberButtons[3].doClick();
                entered = false;
                tones.getDialTone("4");
            }
            //5
            else if (e.getKeyChar() == '5') {
                numberButtons[4].doClick();
                entered = false;
                tones.getDialTone("5");
            }
            //6
            else if (e.getKeyChar() == '6') {
                numberButtons[5].doClick();
                entered = false;
                tones.getDialTone("6");
            }
            //7
            else if (e.getKeyChar() == '7') {
                numberButtons[6].doClick();
                entered = false;
                tones.getDialTone("7");
            }
            //8
            else if (e.getKeyChar() == '8') {
                numberButtons[7].doClick();
                entered = false;
                tones.getDialTone("8");
            }
            //9
            else if (e.getKeyChar() == '9') {
                numberButtons[8].doClick();
                entered = false;
                tones.getDialTone("9");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        try {
            if (entered == false){
                if (e.getKeyChar() == '0') {
                    entered = true;
                    tones.endDialTone();
                }
                else if (e.getKeyChar() == '1') {
                    entered = true;
                    tones.endDialTone();
                }
                else if (e.getKeyChar() == '2') {
                    entered = true;
                    tones.endDialTone();
                }
                else if (e.getKeyChar() == '3') {
                    entered = true;
                    tones.endDialTone();

                }
                else if (e.getKeyChar() == '4') {
                    entered = true;
                    tones.endDialTone();

                }
                else if (e.getKeyChar() == '5') {
                    entered = true;
                    tones.endDialTone();

                }
                else if (e.getKeyChar() == '6') {
                    entered = true;
                    tones.endDialTone();

                }
                else if (e.getKeyChar() == '7') {
                    entered = true;
                    tones.endDialTone();

                }
                else if (e.getKeyChar() == '8') {
                    entered = true;
                    tones.endDialTone();

                }
                else if (e.getKeyChar() == '9') {
                    entered = true;
                    tones.endDialTone();

                }
                else if (e.getKeyChar() == '*') {
                    entered = true;
                    tones.endDialTone();
                }
                else if (e.getKeyChar() == '#') {
                    entered = true;
                    tones.endDialTone();
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
