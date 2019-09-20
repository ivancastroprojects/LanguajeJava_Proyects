package es.unileon.prg.tema6;

import java.util.*;

public class Ecuacion2Grado{
	
	private int a,b,c;

	public Ecuacion2Grado(int a, int b, int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public int getA(){
		return this.a;
	}
	
	public int getB(){
		return this.b;
	}
	
	public int getC(){
		return this.c;
	}
	
	public int numeroDeSoluciones(){
		double x1=0,x2=0;
		int aux=0;
		
		x1=((b*b)-(4*a*c));
		x2=((b*b)+(4*a*c));
		
		if(x1<0 && x2<0){
			aux=0;
		}
		if(x1>0 || x2>0){
			aux=1;
		}
		if(x1>0 && x2>0){
			aux=2;
		}
		return aux;
	}
	
	public String toString(){
		StringBuffer msg=new StringBuffer();
		int numeroSoluciones=this.numeroDeSoluciones();
		double x1=0,x2=0;
		
		x1=((-b + Math.sqrt(Math.pow(b,2) - (4*a*c)))/(2*a));
		x2=((-b - Math.sqrt(Math.pow(b,2) - (4*a*c)))/(2*a));
		
		msg.append("La ecuacion tiene ");
		msg.append(numeroSoluciones);
		msg.append(" solucion/es");
		if(numeroSoluciones==2){
			msg.append(" x1= ");
			msg.append(x1);
			msg.append(" x2= ");
			msg.append(x2);
		}
		
		
		return msg.toString();
	}
}
