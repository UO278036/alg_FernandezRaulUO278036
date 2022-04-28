package algUO278036p7;

import java.util.ArrayList;

import algUO278036p6.Imagen;

public class EstadoPromediador extends Node {
	private Imagen[] dataSet;
	private int[] solucion;
	private int[] numEle;
	
	public EstadoPromediador(int totalImagenes) {
		dataSet = new Imagen[totalImagenes];
		solucion = new int[totalImagenes];
		for (int i=0;i<totalImagenes;i++) {
			solucion[i] = -1;
			
		}
		numEle = new int[3];
	}
	
	public EstadoPromediador(EstadoPromediador padre, int j) {
		super();
	}
	
	@Override
	public void calculateHeuristicValue() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> listaHijos = new ArrayList<Node>();
		for(int i=0; i<3;i++) {
			EstadoPromediador hijo = new EstadoPromediador(i);
		}
		return null;
	}

	@Override
	public boolean isSolution() {
			if(depth == dataSet.length) {
				return true;
			}else {
				return false;		
		}
	}

}
