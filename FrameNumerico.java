package guiConversorNumerico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JTextField;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameNumerico extends JFrame implements ActionListener{
    private JButton btnDecimal;
    private JButton btnOctal;
    private JButton btnBinario;
    private JButton btnHexa;
    private JLabel etqDecimal;
    private JLabel etqOctal;
    private JLabel etqBinario;
    private JLabel etqHexa;
    private JTextField txtDecimal;
    private JTextField txtOctal;
    private JTextField txtBinario;
    private JTextField txtHexa;

    public FrameNumerico(){
        setTitle("Calculadora de bases");
        setSize(520, 275);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        creaBotones();
        creaTextField();
        creaEtiquetas();
        setLayout(new GridLayout(4, 3));
        agregaComponentes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            //Integer fuente = new Integer(0);
            //int aux;
            if (e.getSource() == btnDecimal) {
                txtHexa.setText((Integer.toHexString(Integer.parseInt(txtDecimal.getText()))));
                txtBinario.setText((Integer.toBinaryString(Integer.parseInt(txtDecimal.getText()))));
                txtOctal.setText((Integer.toOctalString(Integer.parseInt(txtDecimal.getText()))));
            }
            else if (e.getSource() == btnBinario) {
                if(isBinary(txtBinario.getText())){
                    txtDecimal.setText(Integer.parseInt(txtBinario.getText(), 2)+"");
                    txtHexa.setText(Integer.toHexString(Integer.parseInt(txtBinario.getText(), 2)));
                    txtOctal.setText(Integer.toOctalString(Integer.parseInt(txtBinario.getText(), 2)));
                }
                else{
                    JOptionPane.showMessageDialog(this, "Se espera una combinacion de unos y ceros", "Falla de lectura", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource() == btnOctal) {
                if(isOctal(txtOctal.getText())){
                    txtDecimal.setText(Integer.parseInt(txtOctal.getText(), 8)+"");
                    txtHexa.setText(Integer.toHexString(Integer.parseInt(txtOctal.getText(), 8)));
                    txtBinario.setText(Integer.toBinaryString(Integer.parseInt(txtOctal.getText(), 8)));
                }
                else{
                    JOptionPane.showMessageDialog(this, "Se espera un numero octal", "Falla de lectura", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource() == btnHexa) {
                if(isHexa(txtHexa.getText())){
                    txtDecimal.setText(Integer.parseInt(txtHexa.getText(), 16)+"");
                    txtOctal.setText(Integer.toOctalString(Integer.parseInt(txtHexa.getText(), 16)));
                    txtBinario.setText(Integer.toBinaryString(Integer.parseInt(txtHexa.getText(), 16)));
                }
                else{
                    JOptionPane.showMessageDialog(this, "Se espera un numero hexadecimal", "Falla de lectura", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(NumberFormatException error2){
            JOptionPane.showMessageDialog(this, error2, "Error, se espera un numero", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void creaBotones(){
        this.btnDecimal = new JButton("Convertir de decimal a:");
        this.btnDecimal.addActionListener(this);
        this.btnOctal = new JButton("Convertir de octal a:");
        this.btnOctal.addActionListener(this);
        this.btnBinario = new JButton("Convertir de binario a:");
        this.btnBinario.addActionListener(this);
        this.btnHexa = new JButton("Convertir de hexa a:");
        this.btnHexa.addActionListener(this);
    }
    private void creaTextField(){
        this.txtDecimal = new   JTextField();
        this.txtOctal = new JTextField();
        this.txtBinario = new   JTextField();
        this.txtHexa = new  JTextField();
    }
    private void creaEtiquetas(){
        this.etqDecimal = new JLabel("Decimal:");
        this.etqOctal = new JLabel("Octal:");
        this.etqBinario = new JLabel("Binario:");
        this.etqHexa = new JLabel("Hexa:");
    }
    private void agregaComponentes(){
        this.add(etqDecimal);
        this.add(txtDecimal);
        this.add(btnDecimal);
        this.add(etqOctal);
        this.add(txtOctal);
        this.add(btnOctal);
        this.add(etqBinario);
        this.add(txtBinario);
        this.add(btnBinario);
        this.add(etqHexa);
        this.add(txtHexa);
        this.add(btnHexa);
    }

    public static boolean isBinary(int num) {
        String str = Integer.toString(num);
        return isBinary(str);
    }

    public static boolean isBinary(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '0' && ch != '1') {
                return false;
            }
        }
        return true;
    }

    public static boolean isOctal(int num) {
        String str = Integer.toString(num);
        return isOctal(str);
    }

    public static boolean isOctal(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch > '7' || ch < '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean isHexa(String s) {
        // Comprobar si la cadena está vacía o nula
        if (s == null || s.isEmpty()) {
            return false;
        }
        
        // Recorrer cada carácter de la cadena
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && (c < 'A' || c > 'F') && (c < 'a' || c > 'f')) {
                return false;  // No es un carácter hexadecimal
            }
        }
        return true;  // Todos los caracteres son hexadecimales
    }
}   
