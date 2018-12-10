package myMath;
//import myMath.Polynom;

import javmos.JavmosGUI;

public class Tester {

	public static void main(String[]args)
	{
//		Polynom p1=new Polynom();
//		Polynom p2=new Polynom();
//		
//		p1.Init("-13x^5+2x^6-7x^3-28x^2+19x^1-0.5x^0");
//		p2.Init("1x^1+26x^4+0.5x^0");
//		
//		Polynom p3=new Polynom();
//		 p3 = (Polynom)p1.copy();
//		p3.add(p2);
//				
//		System.out.println("p3 String : " + p3.toString());
//		System.out.println("f(0.5) : " + p3.f(0.5));
//		System.out.println("f(1.5) : " + p3.f(1.5));
//		System.out.println("root(0.5, 1.5, 0.001) : " + p3.root(0.5, 1.5, 0.001));
//		System.out.println("Derivative : " + p3.derivative().toString());
//		System.out.println("area(0, 1, 0.001) : " + p3.area(0, 1, 0.001));
		Polynom p1=new Polynom("0.2x^4 -1.5x^3 +3.0x^2 -1x^1 -5x^0");
		p1.derivative();
		double d=p1.root(2, 6, 0.001);
		System.out.println(d);
//		JavmosGUI polynomialGUI = new JavmosGUI();
//		polynomialGUI.printout("2x^3+0.5x^2-10x+11");
      
	
	}

	}
