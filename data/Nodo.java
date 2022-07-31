package data;


import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JRadioButton;

public class Nodo extends JRadioButton{
    private String Nombre;
    private Map<Color,List<Nodo>> NodosAdy;
    private List<Arista> AristasAdy;
    

    
    public Map<Color,List<Nodo>> getNodosAdyacentes(){
        return this.NodosAdy;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public List<Arista> getAristasAdyacentes(){
        return this.AristasAdy;
    }
    
    
    public void setNodosAdyacentes(Map<Color,List<Nodo>> NNodos){
        this.NodosAdy=NNodos;
    }
    public void setNombre(String NNombre){
        this.Nombre=NNombre;
    }
    public void setAristasAdyacentes(List<Arista> NAristas){
        this.AristasAdy=NAristas;
    }
    
    
    public void AgregarNodoAdy(Nodo n, Color color){
        
            this.NodosAdy.get(color).add(n);
        
    }
    
    
    public void AgregarAristaAdy(Arista n){
        this.AristasAdy.add(n);
    }
    
    
    public Nodo(){
        this.Nombre="NodoVacio";
        this.NodosAdy=new  HashMap<Color,List<Nodo>>();
        this.AristasAdy=new ArrayList<Arista>();
    }
    
    public Nodo(String nombre){
        this.Nombre=nombre;
        this.NodosAdy=new  HashMap<Color,List<Nodo>>();
        this.AristasAdy=new ArrayList<Arista>();
        
    }
    
     @Override
    public String toString(){
        return this.Nombre;
    }
}
