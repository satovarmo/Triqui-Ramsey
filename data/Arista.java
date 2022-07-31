package data;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Arista extends JPanel{
    private Nodo[] NodosUnidos=new Nodo[2];
    private Color ColorPintado;
    private int Casos;
    
    public Nodo[] getNodosUnidos(){
        return this.NodosUnidos;
    }
    public Color getColor(){
        return this.ColorPintado;
    }
    
    
    public void setNodosUnidos(Nodo[] N){
        this.NodosUnidos=N;
    }
    public void setColor(Color c){
        this.ColorPintado=c;
    }
    
    public void setCasos(int n){
        this.Casos=n;
    }
    
    public Arista(Color c, Nodo[] N){
        this.ColorPintado=c;
        this.NodosUnidos=N;
        this.setBackground(null);
        this.Casos=0;
    }
    
    
    public void CoordenarArista(){
        int CoordX=Math.min( this.NodosUnidos[0].getX(), this.NodosUnidos[1].getX())+10;
        int CoordY=Math.min( this.NodosUnidos[0].getY(),this.NodosUnidos[1].getY())+10;
        int Ancho=Math.abs( this.NodosUnidos[1].getX()-this.NodosUnidos[0].getX());
        int Alto=Math.abs(this.NodosUnidos[1].getY()-this.NodosUnidos[0].getY());
        if(this.NodosUnidos[0].getX()==this.NodosUnidos[1].getX() || this.NodosUnidos[0].getX()==this.NodosUnidos[1].getX()+1 || this.NodosUnidos[0].getX()==this.NodosUnidos[1].getX()-1){
            this.setCasos(2);
            CoordX=CoordX-20;
            Ancho=40;
        }else if(this.NodosUnidos[0].getY()==this.NodosUnidos[1].getY() || this.NodosUnidos[0].getY()==this.NodosUnidos[1].getY()+1  || this.NodosUnidos[0].getY()==this.NodosUnidos[1].getY()-1){
            this.setCasos(1);
            CoordY=CoordY-20;
            Alto=40;
        }else if((this.NodosUnidos[0].getX()<this.NodosUnidos[1].getX() && this.NodosUnidos[0].getY()>this.NodosUnidos[1].getY()) || (this.NodosUnidos[1].getX()<this.NodosUnidos[0].getX() && this.NodosUnidos[1].getY()>this.NodosUnidos[0].getY())){
            this.setCasos(3);
        }else {
            this.setCasos(4);
        }
        this.setBounds(CoordX,CoordY,Ancho,Alto);        
    }
    
    @Override
    public void paint(Graphics g){
        int x1=0,x2=0,y1=0,y2=0;
        
        switch(this.Casos){
                case 1: //Vertices a la misma altura
                    x1=0;
                    x2=this.getWidth();
                    y1=this.getHeight()/2;
                    y2=y1;
                    break;
                case 2: //Vertices a la misma x
                    x1=this.getWidth()/2;
                    x2=this.getWidth()/2;
                    y2=this.getHeight();
                    y1=0;
                    break;
                case 3: //Vertice 0 abajo y a la izq del vert 1
                    x1=0;
                    x2=this.getWidth();
                    y1=this.getHeight();
                    y2=0;
                    break;
                case 4: //Vertice 1 abajo y a la der del vert 0
                    x1=0;
                    x2=this.getWidth();
                    y1=0;
                    y2=this.getHeight();
                    break;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ColorPintado);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(x1,y1,x2,y2);
    }
        
}
