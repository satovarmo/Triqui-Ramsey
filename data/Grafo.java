package data;

import java.awt.Color;
import javax.swing.JPanel;

public class Grafo {
    private int tamaño;
    private Nodo[] Nodos;
    private Arista[] Aristas;
    
    public int getTamaño(){
        return this.tamaño;
    }
    public Nodo[] getNodos(){
        return this.Nodos;
    }
    public Arista[] getAristas(){
        return this.Aristas;
    }
    
    public void setTamaño(int NTamaño){
        this.tamaño=NTamaño;
    }
    public void setNodos(Nodo[] NNodos){
        this.Nodos=NNodos;
    }
    public void setAristas(Arista[] NAristas){
        this.Aristas=NAristas;
    }
    
    
    public Grafo(){
        this.tamaño=10;
        this.Nodos=new Nodo[10];
        this.Aristas=new Arista[10];
    }
    
    public Grafo(int n){
        this.tamaño=n;
        this.Nodos=new Nodo[n];
        for(int j=0;j<n;j++){
            this.Nodos[j]=new Nodo(""+j);
        }
        this.Aristas=new Arista[n*(n-1)/2];
    }
    
    public Grafo(int n, Nodo[] NNodos, Arista[] NAristas){
       this.tamaño=n;
       this.Nodos=NNodos;
       this.Aristas=NAristas;
   }
    
     @Override
    public String toString(){
        return "El grafo de tamaño "+this.tamaño;
    }
    
    public void AñadirArista(Arista a,int index){
        this.Aristas[index]=a;
    }
   
   public void ImprimirGrafo(JPanel PanelDibujo, Color color,Boolean Completo){
        int n=this.getTamaño();
        double ang=(360/n)*3.14159265358979323846/180;
        int x=PanelDibujo.getWidth()/2;
        int y=PanelDibujo.getHeight()/2;
        int r=x-30;
        for(int m=0;m<n;m++){
            this.getNodos()[m].setBounds(CoordX(r,x,ang*m),CoordY(r,y,ang*m),20,20);
            this.getNodos()[m].setBackground(null);
            this.getNodos()[m].setEnabled(false);
            this.getNodos()[m].setSelected(false);
            PanelDibujo.add(this.getNodos()[m]);
       }
       if(Completo){
            int j=0;
            for(int l=0;l<n;l++){
                for(int k=l+1;k<n;k++){
                    Nodo[] NodosUnidos={this.getNodos()[l],this.getNodos()[k]};
                    this.getAristas()[j]=new Arista(color,NodosUnidos);
                    this.getAristas()[j].CoordenarArista();
                    PanelDibujo.add(this.getAristas()[j]);
                    j++;
                }
            }
       }
   }
   
   
   public int CoordX(int r,int x1, double angulo){
       return (int) (x1+r*Math.cos(angulo));
   }
   public int CoordY(int r, int x1, double angulo){
       return (int) (x1-r*Math.sin(angulo));
   }
}
