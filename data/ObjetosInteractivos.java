
package data;

import GUI.MotorInterfaz;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ObjetosInteractivos {
    MotorInterfaz motint;
      public ObjetosInteractivos(MotorInterfaz motint){
        this.motint=motint;
        TítuloRamsey.setBounds(120,20,600,120);
        TítuloRamsey.setFont(new Font("Cirquee",0,60));
        TítuloRamsey.setBorder(null);
        TítuloRamsey.setBackground(null);
        TítuloRamsey.setForeground(new Color(27,180,233));
        TítuloRamsey.setVisible(true);
        
        IngGraf.addItem("Número de vértices");
        IngGraf.setSelectedIndex(0);
        
    }
      
    //PRIMERA PANTALLA (INGRESO DEL NUMERO DE JUGADORES)   
    public JFrame ventana=new JFrame();
    public JComboBox NumeroJug=new JComboBox();
    public JButton BotonAceptar=new JButton("Ingresar");
    public JButton BotonInstrucciones=new JButton("Instrucciones");
    public JPanel PanelNumero=new JPanel();
    public JLabel TítuloRamsey=new JLabel("TRIQUI DE RAMSEY");
    
    //PANTALLA INSTRUCCIONES 
    public JFrame ventanaIns=new JFrame();
    public JTextArea TextIns=new JTextArea(),TitIns=new JTextArea();
    public JScrollPane ScrollIns=new JScrollPane(TextIns);
    public JButton AceptarIns=new JButton("Aceptar");
    public JPanel PanelIns=new JPanel();
    
    //SEGUNDA PANTALLA (INGRESO DATOS DE JUGADORES)
    public JLabel TextIngNombre=new JLabel(),TextIngColor=new JLabel(),TextIngGrafo=new JLabel();
    public JTextField IngNombre=new JTextField();
    public JColorChooser IngColor=new JColorChooser();
    public JComboBox IngGraf=new JComboBox();
    public JButton BtnReg=new JButton("Registrar"),BtnClr=new JButton("Color");
    public JPanel PanelDibujo=new JPanel();
    public Color PosibleColor;
    
    //PANTALLA COLOR 
    public JFrame ventanaColor=new JFrame();
    public JButton AceptarColor=new JButton("Aceptar");
    public JPanel PanelColor=new JPanel(),Paleta=new JPanel();
    
    
    //TERCERAPANTALLA (JUEGO)
    public JLabel TurnoJug=new JLabel();
    public Jugador JugadorActual;
    public Arista AristaADibujar;
    
    //PANTALLA GANADOR
    public JLabel TextGanador=new JLabel();
    public JButton Salir=new JButton("Salir"),Volver=new JButton("Jugar de Nuevo");
    
    
}
