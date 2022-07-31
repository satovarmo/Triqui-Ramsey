package data;

 
import GUI.MotorInterfaz;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;

/**
 *
 * @author Tovar Mosquera
 */
public class Lógica {
    MotorInterfaz motint;   
     public Lógica(MotorInterfaz motint){
        this.motint=motint;
     }
     
    public boolean NoRepetirDatos(){
        String Nombre=motint.obj.IngNombre.getText().substring(0, 1).toUpperCase()+motint.obj.IngNombre.getText().substring(1);
        List<String> ListaNombres=new ArrayList<String>();
        List<Color> ListaColores=new ArrayList<Color>();
        for(int m=0;m<motint.i-1;m++){
            ListaNombres.add(motint.ListaJugadores.get(m).getNombre());
        }
        for(int m=0;m<motint.i-1;m++){
            ListaColores.add(motint.ListaJugadores.get(m).getColorJugador());
        }
        if(ListaNombres.contains(Nombre) || ListaColores.contains(motint.ListaJugadores.get(motint.i-1).getColorJugador())){
            return false;
        }else{
            return true;
        }
    }
    
   public void LlenadoDatos(){
       String Nombre=motint.obj.IngNombre.getText().substring(0, 1).toUpperCase()+motint.obj.IngNombre.getText().substring(1); 
       motint.ListaJugadores.get(motint.i-1).setNombre(Nombre);
                int Tamaño=(int) motint.obj.IngGraf.getSelectedItem();  
                Nodo[] Nodos=new Nodo[Tamaño];
                for(int j=0;j<Tamaño;j++){
                    Nodos[j]=new Nodo(""+j);
                }
                Arista[] Aristas=new Arista[(Tamaño*(Tamaño-1))/2];
                int j=0;
                for(int l=0;l<Tamaño;l++){
                    for(int k=l+1;k<Tamaño;k++){
                            Nodo[] NodosUnidos={Nodos[l],Nodos[k]};
                            Aristas[j]=new Arista(motint.ListaJugadores.get(motint.i-1).getColorJugador(),NodosUnidos);
                            j++;
                    }
                }
                Grafo GrafoDib=new Grafo(Tamaño,Nodos, Aristas);
                motint.ListaJugadores.get(motint.i-1).setGrafo(GrafoDib);
   }
   
   public void EleccionGrafo(JComboBox Opciones){
       for(int j=1;j<motint.obj.IngGraf.getItemCount();){
           motint.obj.IngGraf.removeItemAt(j);
       } 
       if(motint.ListaJugadores.size()==2){
           if(motint.i==1 || (motint.i==2 && motint.ListaJugadores.get(0).getGrafo().getNodos().length==3)){
               motint.obj.IngGraf.addItem(3);
               motint.obj.IngGraf.addItem(4);
               motint.obj.IngGraf.addItem(5);
               motint.obj.IngGraf.addItem(6);
            }else if(motint.i==2){
               if(motint.ListaJugadores.get(0).getGrafo().getNodos().length==4){
                motint.obj.IngGraf.addItem(3);
                motint.obj.IngGraf.addItem(4);
                motint.obj.IngGraf.addItem(5);
               }else if(motint.ListaJugadores.get(0).getGrafo().getNodos().length==5){
                motint.obj.IngGraf.addItem(3);
                motint.obj.IngGraf.addItem(4);
               }else if(motint.ListaJugadores.get(0).getGrafo().getNodos().length==6){
                motint.obj.IngGraf.addItem(3);
               }
               
           }
       }else if(motint.i==1 || (motint.i==2 && motint.ListaJugadores.get(0).getGrafo().getNodos().length==3)|| (motint.i==3 && motint.ListaJugadores.get(0).getGrafo().getNodos().length==3 && motint.ListaJugadores.get(1).getGrafo().getNodos().length==3)){
               motint.obj.IngGraf.addItem(3);
               motint.obj.IngGraf.addItem(4);
            }else if(motint.i==2 || motint.i==3){
                motint.obj.IngGraf.addItem(3);
            }
   } 
   
   public int TamañoTablero(){
   int n=motint.ListaJugadores.size();
       int[] TamGrafos=new int[n];
       int j=0;
       int m=0;
       int[] R33={3,3},R34={3,4},R35={3,5},R36={3,6},R44={4,4},R45={4,5},R333={3,3,3},R334={3,3,4};
       for(Jugador ele:motint.ListaJugadores){
           TamGrafos[j]=ele.getGrafo().getTamaño();
           j++;
       }
       for(int l=0;l<n-1;l++){
           int g=TamGrafos[l];
           if(TamGrafos[l]>=TamGrafos[l+1]){
               TamGrafos[l]=TamGrafos[l+1];
               TamGrafos[l+1]=g;
           }
       }
       if(n==2){
            if(Arrays.equals(TamGrafos,R33)){
                m=6;
            }else if(Arrays.equals(TamGrafos,R34)){
                m=9;
            }else if(Arrays.equals(TamGrafos,R35)){
                m=14;
            }else if(Arrays.equals(TamGrafos,R36)){
                m=18;
            }else if(Arrays.equals(TamGrafos,R44)){
               m=18;
            }else if(Arrays.equals(TamGrafos,R45)){
                m=25;
            }
        }else if(Arrays.equals(TamGrafos,R333)){
            m=17;  
            }else{
               m=30;
            }
    return m;   
   }
   
   public void CambioJugador(Jugador j){
       
        motint.obj.TurnoJug.setText("Es el turno de "+j.getNombre());
        motint.obj.TurnoJug.setBounds(300,100,400,100);
        motint.obj.TurnoJug.setFont(new Font("Oxanium",0,28));
        motint.obj.TurnoJug.setBorder(null);
        motint.obj.TurnoJug.setBackground(null);
        motint.obj.TurnoJug.setForeground(j.getColorJugador());
        motint.obj.TurnoJug.setVisible(true);
        
        
        if(motint.i==motint.ListaJugadores.size()-1){
            motint.i=0;
        }else{
            motint.i=motint.i+1;
        }
        for (Nodo ele:motint.GrafoTablero.getNodos()){
            ele.setSelected(false);
        }
        HabilitarNodos();
        motint.obj.JugadorActual=j;
        motint.obj.ventana.revalidate();
        motint.obj.ventana.repaint();
   }
   
   
   public void HabilitarNodos(){   
       for(Nodo ele:motint.GrafoTablero.getNodos()){
           List<Nodo> Aux=new ArrayList<>();
           motint.ListaJugadores.forEach(jug -> {
                ele.getNodosAdyacentes().get(jug.getColorJugador()).forEach(ele1 -> {
                    Aux.add(ele1);
                });
            });
            if(Aux.size()==TamañoTablero()-1){
                ele.setEnabled(false);
            }else
                ele.setEnabled(true);
        }
        motint.obj.ventana.revalidate();
        motint.obj.ventana.repaint();
   }
   
   
   public void DeshabilitarNodos(Nodo n){   
            List<Nodo> Aux=new ArrayList<>();
            motint.ListaJugadores.forEach(jug -> {
                n.getNodosAdyacentes().get(jug.getColorJugador()).forEach(ele -> {
                    Aux.add(ele);
                });
            });
            for(Nodo n2:motint.GrafoTablero.getNodos()){
                if(Aux.contains(n2)){
                    n2.setEnabled(false);
                }  
            }
   }
 
   public boolean VerificarGanador(Jugador j){
       if(j.getAristasDibujadas().size()>=j.getGrafo().getAristas().length){
           Set<Nodo> NodosC=new HashSet<Nodo>();
           for(Arista ar:j.getAristasDibujadas()){
               NodosC.add(ar.getNodosUnidos()[0]);
               NodosC.add(ar.getNodosUnidos()[1]);
            }
            if(NodosC.size()>=j.getGrafo().getNodos().length){
                Nodo[][] CombinacionesNodos=Combi(NodosC,j.getGrafo().getTamaño());
                int l;
                for(l=0;l<CombinacionesNodos.length;l++){
                    if(VerificarConexión(CombinacionesNodos[l],j)){
                        motint.Ganador(j,CombinacionesNodos[l]);
                    }
                }
                if(l==CombinacionesNodos.length){
                    return false;
                }
            }else
                return false;
        }
       return false;
   }
   
   public boolean VerificarConexión(Nodo[] NodosConc, Jugador j){ //Vamos a ver si los nodos NodosConc están conectados con el color de j
            int i=0;
            for(Nodo ele1:NodosConc){
                for(Nodo ele2:NodosConc){
                    if(ele1!=ele2 && ele1.getNodosAdyacentes().get(j.getColorJugador()).contains(ele2)){
                        i++;
                    }
                }
            }
            if(i==j.getGrafo().getTamaño()*(j.getGrafo().getTamaño()-1)){
                return true;
            }else 
                return false;
   }
   
    public Nodo[][] Combi(Set<Nodo> NodosConc, int k){
        List<Nodo> ListaAux=new ArrayList<Nodo>();
        for(Nodo ele:NodosConc){
            ListaAux.add(ele);
        }
	// get the length of the array
	// e.g. for {'A','B','C','D'} => N = 4 
	int N =NodosConc.size(); 
        int m=Comb(N,k);
        Nodo[][] Combi=new Nodo[m][k];
	// init combination index array
	int pointers[] = new int[k];
	int r = 0; // index for combination array
	int i = 0; // index for elements array	
        int j=0;
	while(r >= 0){	
		// forward step if i < (N + (r-K))
		if(i <= (N + (r - k))){
			pointers[r] = i;
			// if combination array is full print and increment i;
			if(r == k-1){
                                for(int l=0;l<k;l++){
                                    Combi[j][l]=ListaAux.get(pointers[l]);
                                }
                                j++;
				i++;				
			}
			else{
				// if combination is not full yet, select next element
				i = pointers[r]+1;
				r++;										
			}				
		}
		
		// backward step
		else{
			r--;
			if(r >= 0)
				i = pointers[r]+1;
			
		}			
	}
        return Combi;
}   

    public static int Comb(int n,int m){
        long n1=fact(n,n-m);
        long m1=fact(m,1); 
        long r=n1/m1;
        return (int)r;
    }
    
    public static long fact(int n,int lim){
        long n1=1;
        for(int i=lim+1;i<=n;i++){ 
            n1=n1*i;
        }
        return n1;
    }
    
    public void PantallaGanador(Jugador j,Nodo[] n){
       
        motint.obj.TextGanador.setText("El ganador es "+j.getNombre());
        motint.obj.TextGanador.setBounds(200,100,400,100);
        motint.obj.TextGanador.setFont(new Font("Oxanium",0,28));
        motint.obj.TextGanador.setBorder(null);
        motint.obj.TextGanador.setBackground(null);
        motint.obj.TextGanador.setForeground(j.getColorJugador());
        motint.obj.TextGanador.setVisible(true);
        
        for(Nodo ele:motint.GrafoTablero.getNodos()){
            boolean eliminarVertice=true;
            for(int i=0;i<n.length;i++){
                if(n[i]==ele){
                    eliminarVertice=false;
                }
            }
            if(eliminarVertice){
                motint.obj.PanelDibujo.remove(ele);
            }
        }
        
        
        for(int i=0;i<n.length;i++){
            for(Arista arista:n[i].getAristasAdyacentes()){
                for(int k=i+1;k<n.length;k++){
                    if(arista.getNodosUnidos()[0]==n[k] || arista.getNodosUnidos()[1]==n[k]){
                        motint.obj.PanelDibujo.add(arista);
                    }
                }
            }
        }
        
        
        motint.obj.ventana.revalidate();
        motint.obj.ventana.repaint();
   }
    
}

