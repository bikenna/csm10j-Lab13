/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianobioha
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Program extends JFrame{
    //mouseClick mml = new mouseClick();
    public JButton clickMe = new JButton("Click Me!");
    public void CreateText(){
        Container content = this.getContentPane();
        content.add(clickMe);
        clickMe.addActionListener(new ClickMeButtonClicked());
        //clickMe.addMouseListener(mml);
    }
    private class ClickMeButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            boolean set = false;
            if(e.getSource() == clickMe){
                clickMe.setVisible(set);
                menu p = new menu();
                Graphics oval = getGraphics();
                //clickMe.setVisible(set);
                p.paint(oval);
            }
        }
    }
//    private class mouseClick implements MouseListener{
//        @Override
//        public void mouseClicked(MouseEvent e){
//            if(e.getSource() == clickMe){
//                clickMe.setVisible(false);
//                menu p = new menu();
//                Graphics oval = getGraphics();
//                p.paint(oval);
//                clickMe.setVisible(true);
//            }
//        }
//        
//        @Override
//        public void mouseEntered(MouseEvent arg0) {}
//
//        @Override
//        public void mouseExited(MouseEvent arg0) {}
//
//        @Override
//        public void mousePressed(MouseEvent arg0) {}
//
//        @Override
//        public void mouseReleased(MouseEvent arg0) {}
//    }
//    
    private class menu extends JFrame{
        String input = JOptionPane.showInputDialog("Enter number of Ovals");
        int ovalNum = Integer.parseInt(input);
        
        public void createOvals(Graphics g){
            if(ovalNum == 0){
                this.setVisible(false);
                clickMe.setVisible(true);
            }
            g.setColor(Color.red);
            if(ovalNum < 1){
                g.drawOval(0, 0, 0, 0);
            }
            else if(ovalNum <= 20){
                for(int i = 0; i < ovalNum; i++)
                    g.drawOval(i*3 + 20, i*3 + 20, i*5, i*3);
            }
            else{ 
                for(int i = 0; i < 20; i++)
                  g.drawOval(i*3 + 20, i*3 + 20, i*5, i*3);
            }
        }
        @Override
        public void paint(Graphics g){
            super.paint(g);
            createOvals(g);
            System.out.println("Painting Random Shapes");


        }
  }
      
      
      
      public static void main(String [] args){
    
          Program p = new Program();
          //p.clickMe.setBounds(0, 0, 0, 0);
          p.setSize(400, 400);
          p.CreateText();
          p.setVisible(true);
      }
}
