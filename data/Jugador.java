package data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private Color ColorJugador;
    private List<Arista> AristasEscogidas;
    private String Nombre;
    private Grafo GrafoADibujar;
    
    public Color getColorJugador(){
        return this.ColorJugador;
    }
    public List<Arista> getAristasDibujadas(){
        return this.AristasEscogidas;
    }
    public String getNombre(){
        return this.Nombre;
    }
    
    public Grafo getGrafo(){
        return this.GrafoADibujar;
    }
    
    
    
    public void setColorJugador(Color ColorN){
        this.ColorJugador=ColorN;
    }
    public void setAristasDibujadas(List<Arista> AristasN){
        this.AristasEscogidas=AristasN;
    }
    public void setNombre(String NombreN){
        this.Nombre=NombreN;
    }
    public void AgregarArista(Arista NuevaArista){
        this.AristasEscogidas.add(NuevaArista);
    }
    public void setGrafo(Grafo GrafoN){
        this.GrafoADibujar=GrafoN;
    }
    
    public Jugador(){
        this.Nombre="No registra";
        this.ColorJugador=Color.white;
        this.AristasEscogidas=new ArrayList<Arista>();
        this.GrafoADibujar=new Grafo();
    }
    public Jugador(String NombreE, Color ColorE){
        this.Nombre=NombreE;
        this.ColorJugador=ColorE;
        this.AristasEscogidas=new ArrayList<Arista>();
    }
    @Override
    public String toString(){
        return this.Nombre+" con el color "+this.ColorJugador+" dibujara "+this.GrafoADibujar;
    }
}
