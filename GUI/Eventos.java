
package GUI;

import data.Arista;
import data.Grafo;
import data.Jugador;
import data.Nodo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Eventos implements ActionListener, FocusListener, MouseListener{
    MotorInterfaz motint;
    public Eventos(MotorInterfaz motint){
        this.motint=motint;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==motint.obj.BotonAceptar){
            for(int i=0;i<motint.obj.NumeroJug.getSelectedIndex()+2;i++){
                motint.ListaJugadores.add(new Jugador());
            }
            motint.IngresoJugador();
        }
        else if(e.getSource()==motint.obj.BtnClr){
            motint.PantallaColor();
        }
        else if(e.getSource()==motint.obj.BtnReg){
            if(motint.obj.IngNombre.getText().equals("Nombre") || motint.obj.IngGraf.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos.");
            }else{
                if(motint.log.NoRepetirDatos()){
                    motint.log.LlenadoDatos();
                    motint.i=motint.i+1;
                    if(motint.i<=motint.ListaJugadores.size()){
                        motint.IngresoJugador();
                        motint.obj.PosibleColor=Color.white;
                    }else{
                        motint.Juego();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El nombre o color ya fueron seleccionados");
                }    
            }
        }
        else if(e.getSource()==motint.obj.IngGraf){
            motint.obj.PanelDibujo.removeAll();
            if(motint.obj.IngGraf.getSelectedIndex()!=0){
                Grafo GrafoDib=new Grafo((int) motint.obj.IngGraf.getSelectedItem());
                GrafoDib.ImprimirGrafo(motint.obj.PanelDibujo,motint.obj.PosibleColor,true);
            }
                motint.obj.ventana.revalidate();
                motint.obj.ventana.repaint();
        }else if(e.getSource()==motint.obj.Salir){
            System.exit(0);
        }else if(e.getSource()==motint.obj.Volver){
            motint.obj.PanelNumero.removeAll();
            motint.obj.ventana.repaint();
            motint.obj.ventana.revalidate();
            motint.PrimeraPantallaNumeroJug();
        }else if(e.getSource()==motint.obj.BotonInstrucciones){
            motint.Instrucciones();
        }else if(e.getSource()==motint.obj.AceptarIns){
            motint.obj.ventanaIns.dispose();
        }else if(e.getSource()==motint.obj.AceptarColor){
            motint.obj.PosibleColor=motint.ColorElegido.getBackground();
            motint.ListaJugadores.get(motint.i-1).setColorJugador(motint.obj.PosibleColor);
            motint.obj.ventanaColor.dispose();
            motint.obj.PanelDibujo.removeAll();
            if(motint.obj.IngGraf.getSelectedIndex()!=0){
                Grafo GrafoDib=new Grafo((int) motint.obj.IngGraf.getSelectedItem());
                GrafoDib.ImprimirGrafo(motint.obj.PanelDibujo,motint.obj.PosibleColor,true);
            }
                motint.obj.ventana.revalidate();
                motint.obj.ventana.repaint();
        }else{
            for(Nodo ele1:motint.GrafoTablero.getNodos()){
                if(e.getSource()==ele1){
                    if(ele1.isSelected()){
                        int j=0;
                        for(Nodo ele2:motint.GrafoTablero.getNodos()){
                            if(ele2.isSelected() && !ele2.equals(ele1)){
                                motint.DibujarArista(ele1,ele2);
                                if(!motint.log.VerificarGanador(motint.obj.JugadorActual)){
                                    motint.log.CambioJugador(motint.ListaJugadores.get(motint.i));
                                }
                            }else
                                j++;
                        }
                        if(j==motint.GrafoTablero.getTamaño()){
                            motint.log.DeshabilitarNodos(ele1);
                        }
                    }else{
                        motint.log.HabilitarNodos();                        
                    }    
                }
            }
        }    
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==motint.obj.IngNombre && motint.obj.IngNombre.getText().equals("Nombre")){
            motint.obj.IngNombre.setText("");
            motint.obj.IngNombre.setForeground(new Color(27,180,233));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
         if(e.getSource()==motint.obj.IngNombre && motint.obj.IngNombre.getText().equals("")){
            motint.obj.IngNombre.setText("Nombre");
            motint.obj.IngNombre.setForeground(Color.gray);   
         }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(JPanel ele:motint.ColoresPaleta){
            if(e.getSource()==ele){
                motint.ColorElegido.setBackground(ele.getBackground());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
