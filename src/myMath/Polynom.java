package myMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{

	private ArrayList<Monom> pol=new ArrayList<Monom>();
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		Iterator<Monom> mi=this.iteretor();
		double res=0;
		while (mi.hasNext()) {
			Monom temp=mi.next();
			res=res+temp.f(x);
			/*
			 * jumping with the iterator and summing the result in each monom
			 */
		}
		return res;
	}

	
	@Override
	public void add(Polynom_able p1) {
		// TODO Auto-generated method stub
		ArrayList<Monom> res=new ArrayList<Monom>();
		Iterator<Monom> mi_p=p1.iteretor();
		Iterator<Monom> mi_t=this.iteretor();
		while(mi_p.hasNext()) {
			Monom temp_p=mi_p.next();
			while(mi_t.hasNext()) {
				Monom temp_t=mi_t.next();
				Monom copy=new Monom(temp_t);
				copy.add(temp_p);
				res.add(copy);
			}
			mi_t=this.iteretor();
			/*
			 * this for re initial the inner loop
			 */
		}
		this.pol.clear();
		for(Monom it:res) {
			this.add(it);
		}
	}

	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> mi=p1.iteretor();
		while(mi.hasNext()) {
			Monom temp=mi.next();
			temp.set_coefficient(temp.get_coefficient()*-1);
			this.add(temp);
		}
	}

	@Override
	public void multiply(Polynom_able p1) { 
		// TODO Auto-generated method stub
		ArrayList<Monom> res=new ArrayList<Monom>();
		Iterator<Monom> mi_p=p1.iteretor();
		Iterator<Monom> mi_t=this.iteretor();
		while(mi_p.hasNext()) {
			Monom temp_p=mi_p.next();
			while(mi_t.hasNext()) {
				Monom temp_t=mi_t.next();
				Monom copy=new Monom(temp_t);
				copy.multiply(temp_p);
				res.add(copy);
			}
			 mi_t=this.iteretor();
		}
		this.pol.clear();
		for (Monom it:res) {
			this.add(it);
		}
	}

	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		boolean flage = false;
		boolean comp = true;
		Iterator<Monom> mi_p=p1.iteretor();
		Iterator<Monom> mi_t=this.iteretor();
		while(mi_p.hasNext()) {
			Monom temp_p=mi_p.next();
			while(mi_t.hasNext()&&flage==false) {
				Monom temp_t=mi_t.next();
				if(temp_t.get_coefficient()==temp_p.get_coefficient()&&temp_t.get_power()==temp_p.get_power()) {
					flage=true;
				}
			}
			comp=comp&&flage;
			flage=false;
			mi_t=this.iteretor();
		}
		return comp;
	}

	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		boolean flage=true;
		Iterator<Monom> mi=this.iteretor();
		while(mi.hasNext()) {
			Monom temp=mi.next();
			if(temp.get_coefficient()!=0)
				flage=false;
		}
		return flage;

	}
	public double root(double x0, double x1, double eps) {
		double x_0=this.f(x0);
		double x_1=this.f(x1);
		if(x_0*x_1>=0)
		{
			System.out.println("Assertion of x0 and x1 is not correct");
		}
		double temp=x0;
		while((x1-x0)>=eps)
		{
			temp=(x1+x0)/2;
			if(this.f(temp)==0.0)
			break;
			else if(this.f(temp)*this.f(x0)<0)
			x1=temp;
			else
				x0=temp;
		}
		return temp;
	}
	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub
		Polynom_able copied = new Polynom() ;
		Iterator<Monom> mi=this.iteretor();
		while(mi.hasNext()) {

			Monom temp=mi.next();

			copied.add(new Monom(temp));												
		}
		return copied;
	}

	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		Polynom_able copied = new Polynom() ;
		Iterator<Monom> mi=this.iteretor();
		while(mi.hasNext()) {
			Monom temp=mi.next();
			Monom temp2=new Monom(temp);
			temp2.nigzeret();
			copied.add(temp2);												
		}												
		return copied;	
	}

//	@Override
//	public double area(double x0, double x1, double eps) {
//		double count= 0;	
//		int t=(int)Math.abs((x1-x0)/eps);
//		for (int i = 0; i < t; i++) {
//			double temp=this.f(x0);
//			if(temp>0)
//				count=count+this.f(x0) * eps;
//			x0=x0+eps;
//		}
//		return count;
//	}
	@Override
	public double area(double x0, double x1, double eps) {
		double Delta_X=(x1-x0)/eps;
		double sum=0;
		for(int i=1;i<=eps;i++)
		{
			double xi=x0+Delta_X*i;
			sum=sum+this.f(xi);
		}
		return sum*Delta_X;
	}

public Polynom (String str) {//full description in accumulated doc.
		str=str.replaceAll("-", "+-");//same sign
		String[]S=str.split(" +");
		for(String s:S)
		{									
			try {
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='x'&&s.charAt(1)!='-')
				{
					String s1=s.substring(0, i);
					String s2=s.substring(i+2, s.length());
					double co=Double.parseDouble(s1);//coefficent
					int po=Integer.parseInt(s2);//power
					Monom m=new Monom(co,po);
					this.pol.add(m);
				}				
				if(s.charAt(i)=='x'&&s.charAt(1)=='-')
				{
					String s1=s.substring(1, i);
					String s2=s.substring(i+2, s.length());
					double co=Double.parseDouble(s1);//coefficent
					int po=Integer.parseInt(s2);//power
					Monom m=new Monom(co,po);
					this.pol.add(m);
				}				
			}					
		}catch(Exception e) {System.err.println("please use space char("+" "+") betwen each monom");
		}
		}
		Collections.sort(pol, new Monom_Comperator());
	}
@Override
public void add(Monom m1) {
	Iterator<Monom> mi=this.iteretor();
	boolean flage=false;
	/*
	 * this flage is for preventing double adding 
	 */
	while(mi.hasNext()){
		Monom temp=mi.next(); 
		if(temp.get_coefficient()==0) 
			return;
		if (temp.get_power()==m1.get_power()) {
			flage=true;
			temp.add(m1);
		}
	}
	if(flage==false)
	this.pol.add(m1);
}

	ArrayList<Monom> monom_list=new ArrayList<Monom>();

	public Polynom() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Iterator<Monom> iteretor() {
		return this.pol.iterator();
	}
	@Override
	public String toString() {
		Iterator<Monom> mi=this.iteretor();
		String []res=new String[this.pol.size()];
		int jump=0;
		while(mi.hasNext()) {
			Monom temp=mi.next();
			res[jump]="+"+temp.get_coefficient()+"x^"+temp.get_power();
			System.out.print(res[jump]+" ");
			jump++;
		}
		return "";
	}
	// ********** add your code below ***********

}
