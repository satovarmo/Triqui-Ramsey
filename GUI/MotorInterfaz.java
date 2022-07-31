package GUI;

import data.Arista;
import data.Grafo;
import data.Jugador;
import data.Lógica;
import data.Nodo;
import data.ObjetosInteractivos;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MotorInterfaz {
    // RELACION ENTRE CLASES 
    Eventos evt=new Eventos(this);
    public ObjetosInteractivos obj=new ObjetosInteractivos(this);
    Lógica log=new Lógica(this);
    
    //OBJETOS DE DATOS
    public List<Jugador> ListaJugadores;
    public int i;
    public Grafo GrafoTablero;
    public Color[] Colores={new Color(16,237,30),new Color(252,30,30),new Color(255,127,255),new Color(255,206,98),new Color(255,255,255),new Color(145,61,249),new Color(252,97,3),new Color(36,169,153),new Color(30,38,233)};
    public JPanel[] ColoresPaleta=new JPanel[9];
    public JPanel ColorElegido=new JPanel();
    
    
    public static void main(String args[]){
        MotorInterfaz mi=new MotorInterfaz();
    }

    public MotorInterfaz(){
        PrimeraPantallaNumeroJug();
        CreacionVentana();
    }
    
    public void CreacionVentana(){
        obj.ventana.setSize(800, 600);
        obj.ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        obj.ventana.getContentPane().setBackground(null);
        obj.ventana.setResizable(false);
        obj.ventana.setLayout(null);
        obj.ventana.setVisible(true);
        obj.ventana.setLocationRelativeTo(null);
        obj.ventana.setTitle("TRIQUI DE RAMSEY");
    }
    
   public void PrimeraPantallaNumeroJug(){
        i=1;
        ListaJugadores=new ArrayList<Jugador>();
        obj.PanelNumero.setBounds(0,0,800,600);
        obj.PanelNumero.setLayout(null);
        obj.PanelNumero.setBackground(new Color(0,0,0));
        obj.ventana.add(obj.PanelNumero);
        
        obj.PanelNumero.add(obj.TítuloRamsey);
        
        JLabel TextoNum=new JLabel();
        TextoNum.setBounds(180,180,450,30);
        TextoNum.setFont(new Font("Oxanium",0,28));
        TextoNum.setText("Selecciona el número de jugadores");
        TextoNum.setBorder(null);
        TextoNum.setBackground(null);
        TextoNum.setForeground(new Color(27,180,233));
        TextoNum.setVisible(true);
        obj.PanelNumero.add(TextoNum);
        
        obj.NumeroJug.setBounds(350,250,100,50);
        obj.NumeroJug.setFont(new Font("Oxanium",0,20));
        obj.NumeroJug.setBorder(null);
        obj.NumeroJug.setForeground(new Color(39, 40, 80));
        obj.NumeroJug.removeAllItems();
        obj.NumeroJug.addItem(2);
        obj.NumeroJug.addItem(3);
        obj.NumeroJug.setVisible(true);
        obj.PanelNumero.add(obj.NumeroJug);
        
        
        
        obj.BotonInstrucciones.setFont(new Font("Oxanium",3,30));
        obj.BotonInstrucciones.setBounds(225,450,350,60);
        obj.BotonInstrucciones.setBackground(new Color(27,180,233));
        obj.BotonInstrucciones.setForeground(new Color(0,0,0));
        obj.BotonInstrucciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.BotonInstrucciones.setFocusPainted(false);
        obj.BotonInstrucciones.removeActionListener(evt);
        obj.BotonInstrucciones.addActionListener(evt);
        obj.PanelNumero.add(obj.BotonInstrucciones);
            
         
        obj.BotonAceptar.setFont(new Font("Oxanium",3,30));
        obj.BotonAceptar.setBounds(225,360,350,60);
        obj.BotonAceptar.setBackground(new Color(27,180,233));
        obj.BotonAceptar.setForeground(new Color(0,0,0));
        obj.BotonAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.BotonAceptar.setFocusPainted(false);
        obj.BotonAceptar.removeActionListener(evt);
        obj.BotonAceptar.addActionListener(evt);
        obj.PanelNumero.add(obj.BotonAceptar);
        
        obj.PosibleColor=Color.white;
    } 
    
   public void IngresoJugador(){
        obj.PanelNumero.removeAll();
        obj.TextIngNombre.setBounds(215,140,390,30);
        obj.TextIngNombre.setFont(new Font("Oxanium",0,28));
        obj.TextIngNombre.setText("Ingresa los datos del jugador "+i);
        obj.TextIngNombre.setBorder(null);
        obj.TextIngNombre.setBackground(null);
        obj.TextIngNombre.setForeground(new Color(27,180,233));
        obj.TextIngNombre.setVisible(true);
        obj.PanelNumero.add(obj.TextIngNombre);
        
        obj.PanelNumero.add(obj.TítuloRamsey);
        
        obj.IngNombre.setBounds(50,250,250,30);
        obj.IngNombre.setText("Nombre");
        obj.IngNombre.setFont(new Font("Oxanium",0,20));
        obj.IngNombre.setBorder(null);
        obj.IngNombre.setBackground(null);
        obj.IngNombre.setForeground(Color.gray);
        obj.IngNombre.removeFocusListener(evt);
        obj.IngNombre.addFocusListener(evt);
        obj.IngNombre.setVisible(true);
        obj.PanelNumero.add(obj.IngNombre);
        
        
        JSeparator SeparadorN=new JSeparator();
        SeparadorN.setBounds(50,290,250,10);
        SeparadorN.setVisible(true);
        obj.PanelNumero.add(SeparadorN);
            
        obj.BtnClr.setFont(new Font("Oxanium",3,30));
        obj.BtnClr.setBounds(50,300,250,60);
        obj.BtnClr.setBackground(new Color(27,180,233));
        obj.BtnClr.setForeground(new Color(0,0,0));
        obj.BtnClr.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.BtnClr.setFocusPainted(false);
        obj.BtnClr.removeActionListener(evt);
        obj.BtnClr.addActionListener(evt);
        obj.PanelNumero.add(obj.BtnClr);
        
     
        obj.IngGraf.setBounds(50,370, 250,30);
        obj.IngGraf.setFont(new Font("Oxanium",1,17));
        obj.IngGraf.setForeground(new Color(0,0,0));
        obj.IngGraf.setVisible(true);
        log.EleccionGrafo(obj.IngGraf);
        obj.IngGraf.removeActionListener(evt);
        obj.IngGraf.addActionListener(evt);
        obj.PanelNumero.add(obj.IngGraf);
        
        obj.PanelDibujo.setBounds(430,190,250,250);
        obj.PanelDibujo.setLayout(null);
        obj.PanelDibujo.setBackground(null);
        obj.PanelNumero.add(obj.PanelDibujo);
        
        obj.BtnReg.setFont(new Font("Oxanium",3,30));
        obj.BtnReg.setBounds(225,450,350,60);
        obj.BtnReg.setBackground(new Color(27,180,233));
        obj.BtnReg.setForeground(new Color(0,0,0));
        obj.BtnReg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.BtnReg.setFocusPainted(false);
        obj.BtnReg.removeActionListener(evt);
        obj.BtnReg.addActionListener(evt);
        obj.PanelNumero.add(obj.BtnReg);
        
        
        obj.ventana.revalidate();
        obj.ventana.repaint();
    }
    
   public void Juego(){
        obj.PanelNumero.removeAll();
        i=0;
        obj.PanelNumero.add(obj.TítuloRamsey);
        int TamG=log.TamañoTablero();
        GrafoTablero=new Grafo(TamG);
        obj.PanelNumero.add(obj.TurnoJug);
        
        obj.PanelDibujo.removeAll();
        obj.PanelDibujo.setBounds(220,170,360,360);
        obj.PanelDibujo.setLayout(null);
        obj.PanelDibujo.setBackground(null);
        obj.PanelNumero.add(obj.PanelDibujo);
        
        GrafoTablero.ImprimirGrafo(obj.PanelDibujo, Color.yellow, false);
        for (Nodo ele:GrafoTablero.getNodos()){
            ele.setEnabled(true);
            ele.addActionListener(evt);
            for(Jugador jug: ListaJugadores){
               ele.getNodosAdyacentes().put(jug.getColorJugador(),new ArrayList<Nodo>());
            }    
        }
       
        log.CambioJugador(ListaJugadores.get(i));
       
       
        obj.ventana.revalidate();
        obj.ventana.repaint();
       
   }
   
   public void DibujarArista(Nodo n1,Nodo n2){
        Nodo[] NodosUnidos={n1,n2};
        Arista a=new Arista(obj.JugadorActual.getColorJugador(),NodosUnidos);
        a.CoordenarArista();
        n1.AgregarNodoAdy(n2,obj.JugadorActual.getColorJugador());
        n2.AgregarNodoAdy(n1,obj.JugadorActual.getColorJugador());
        n1.AgregarAristaAdy(a);
        n2.AgregarAristaAdy(a);
        obj.JugadorActual.AgregarArista(a);
        obj.PanelDibujo.add(a);
   }
   
   public void Ganador(Jugador j,Nodo[] n){
        obj.PanelNumero.removeAll();
        obj.PanelNumero.add(obj.TítuloRamsey);
        obj.PanelNumero.add(obj.TextGanador);
        
        obj.PanelDibujo.removeAll();
        obj.PanelDibujo.setBounds(220,170,360,360);
        obj.PanelDibujo.setLayout(null);
        obj.PanelDibujo.setBackground(null);
        obj.PanelNumero.add(obj.PanelDibujo);
        
        GrafoTablero.ImprimirGrafo(obj.PanelDibujo, Color.yellow, false);
       
        log.PantallaGanador(j,n);
        
        
        obj.Salir.setFont(new Font("Oxanium",3,30));
        obj.Salir.setBounds(20,320,180,60);
        obj.Salir.setBackground(new Color(27,180,233));
        obj.Salir.setForeground(new Color(0,0,0));
        obj.Salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.Salir.setFocusPainted(false);
        obj.Salir.removeActionListener(evt);
        obj.Salir.addActionListener(evt);
        obj.PanelNumero.add(obj.Salir);
        
        
        obj.Volver.setFont(new Font("Oxanium",3,15));
        obj.Volver.setBounds(600,320,180,60);
        obj.Volver.setBackground(new Color(27,180,233));
        obj.Volver.setForeground(new Color(0,0,0));
        obj.Volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.Volver.setFocusPainted(false);
        obj.Volver.removeActionListener(evt);
        obj.Volver.addActionListener(evt);
        obj.PanelNumero.add(obj.Volver);
        
        
        obj.ventana.revalidate();
        obj.ventana.repaint();
       
   }
   
   public void Instrucciones(){
        obj.ventanaIns.setSize(500, 500);
        obj.ventanaIns.getContentPane().setBackground(null);
        obj.ventanaIns.setResizable(false);
        obj.ventanaIns.setLayout(null);
        obj.ventanaIns.setVisible(true);
        obj.ventanaIns.setLocationRelativeTo(null);
        obj.ventanaIns.setTitle("TRIQUI DE RAMSEY-INSTRUCCIONES");
        
        obj.PanelIns.setBounds(0,0,500,500);
        obj.PanelIns.setLayout(null);
        obj.PanelIns.setBackground(new Color(27,180,233));
        
        
        obj.TitIns.setText("   ¡Bienvenido a un juego de\n"
                + "         triqui donde jamás\n"
                + "         podrás empatar!\n");
        obj.TitIns.setBackground(new Color(27,180,233));
        obj.TitIns.setForeground(new Color(0,0,0));
        obj.TitIns.setEditable(false);
        obj.TitIns.setBounds(95,45,305,90);
        obj.TitIns.setFont(new Font("Oxanium",1,23));
        
        
        obj.ScrollIns.setBounds(100,150,302,200);
        obj.ScrollIns.setBorder(null);
        obj.PanelIns.add(obj.ScrollIns); 
        obj.TextIns.setBackground(new Color(27,180,233));
        obj.TextIns.setEditable(false);
        obj.TextIns.setFont(new Font("Oxanium",1,20));
        obj.TextIns.setText("1. En la primera pantalla \n"
                + " escoge la cantidad\n"
                + "  de jugadores que\n"
                + " disputarán esta partida;\n"
                + " puedes elegir entre 2 y 3.\n\n\n"
                + "2.   A continuación cada\n"
                + " jugador ingresa su\n"
                + " nombre, el color con el\n"
                + " que dibujará y la cantidad\n"
                + " de puntos que desea que\n"
                + " tenga el grafo que deberá\n"
                + " dibujar. Al lado derecho\n"
                + " aparecerá la figura\n"
                + " que cada uno \n"
                + " tiene que completar\n"
                + " para ganar la partida.\n\n\n"
                + "3.   Cuando se ejecute el\n"
                + " juego, cada jugador debe\n"
                + " unir los puntos de la\n"
                + " pantalla, por turnos.\n"
                + " Si por ejemplo, Juan eligió\n"
                + " 5 vértices, Juan deberá\n"
                + " unir 5 puntos completamen-\n"
                + " te; es decir dibujar todas\n"
                + " las lineas posibles entre los\n"
                + " 5 puntos, para completar la\n"
                + " figura que apareció en\n"
                + " la pantalla anterior,\n"
                + " y así ganar el juego.\n\n"
                + "Si te preguntas ¿Por qué \n"
                + "nunca hay un empate en\n"
                + "este triqui? ¡Es muy sencillo!\n"
                + "Este triqui se basa en\n"
                + "la teoría de Ramsey para\n"
                + "grafos. En resumidas\n"
                + "cuentas esta dice que en\n"
                + "una estructura grande,\n"
                + "aparentemente\n"
                + "desordenada\n"
                + "existen subestructuras que\n"
                + "preservan un orden.\n"
                + "Esto puede aplicarse\n"
                + "a los grafos de la siguiente\n"
                + "forma:\n"
                + "Tomemos 6 puntos,\n"
                + "y dibujemos todas las\n"
                + "líneas que los unen\n"
                + "(15 en total), pintemos\n"
                + "cada una de rojo o azul\n"
                + "de manera aleatoria.\n"
                + "con la teoría de Ramsey\n"
                + "garantizamos que existe\n"
                + "un triángulo completamente\n"
                + "rojo o uno completamente\n"
                + "azul cuyos vértices son\n"
                + "3 de los puntos iniciales.\n"
                + "Este ejemplo se define\n"
                + "como el número de Ramsey\n"
                + "de 3 y 3. R(3,3)=6\n"
                + "Por que 6 es el mínimo\n"
                + "número de puntos\n"
                + "necesarios para encontrar\n"
                + "los triángulos.\n"
                + "Es por eso que  en la versión\n"
                + "para dos jugadores,si ambos\n"
                + "eligen dibujar un triángulo,\n"
                + "el tablero tendrá 6 puntos.");
        
        

        
        obj.AceptarIns.setBounds(200,375,100,60);
        obj.AceptarIns.setFont(new Font("Oxanium",3,12));
        obj.AceptarIns.setBackground(new Color(0,0,0));
        obj.AceptarIns.setForeground(new Color(27,180,233));
        obj.AceptarIns.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.AceptarIns.setFocusPainted(false);
        obj.AceptarIns.removeActionListener(evt);
        obj.AceptarIns.addActionListener(evt);
        
        obj.PanelIns.add(obj.TitIns);
        obj.PanelIns.add(obj.AceptarIns);
        obj.ventanaIns.add(obj.PanelIns);
        
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                obj.ScrollIns.getViewport().setViewPosition(new Point(0,0));
            }
        });
   
   }
   
   
   public void PantallaColor(){
        obj.ventanaColor.setSize(500, 500);
        obj.ventanaColor.getContentPane().setBackground(null);
        obj.ventanaColor.setResizable(false);
        obj.ventanaColor.setLayout(null);
        obj.ventanaColor.setVisible(true);
        obj.ventanaColor.setLocationRelativeTo(null);
        obj.ventanaColor.setTitle("TRIQUI DE RAMSEY-ELECCIÓN COLOR");
        
        obj.PanelColor.setBounds(0,0,500,500);
        obj.PanelColor.setLayout(null);
        obj.PanelColor.setBackground(new Color(27,180,233));
        
        obj.Paleta.removeAll();
        obj.Paleta.setBounds(150,50,200,200);
        obj.Paleta.setBackground(null);
        obj.Paleta.setLayout(new GridLayout(3,3));
        for(int p=0;p<Colores.length;p++){
            ColoresPaleta[p]=new JPanel();
            ColoresPaleta[p].setSize(20,20);
            ColoresPaleta[p].setBackground(Colores[p]);
            ColoresPaleta[p].addMouseListener(evt);
            ColoresPaleta[p].setCursor(new Cursor(Cursor.HAND_CURSOR));
            obj.Paleta.add(ColoresPaleta[p]);
        }
        
        
        
        ColorElegido.setBackground(Color.white);
        ColorElegido.setBounds(210,280,70,70);
        
                
        obj.AceptarColor.setBounds(200,375,100,60);
        obj.AceptarColor.setFont(new Font("Oxanium",3,12));
        obj.AceptarColor.setBackground(new Color(0,0,0));
        obj.AceptarColor.setForeground(new Color(27,180,233));
        obj.AceptarColor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        obj.AceptarColor.setFocusPainted(false);
        obj.AceptarColor.removeActionListener(evt);
        obj.AceptarColor.addActionListener(evt);
        
        obj.PanelColor.add(ColorElegido);
        obj.PanelColor.add(obj.AceptarColor);
        obj.PanelColor.add(obj.Paleta);
        obj.ventanaColor.add(obj.PanelColor);
   
   }
}
