
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	public Monom(String s) {
		/*
		 * default constractors
		 */
		this._power = 0;
		this._coefficient =0;
	}
	public Monom(double a, int b){//constructr
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom mi) {
		/*
		 * copy constractor
		 */
		this._power = mi.get_power();
		this._coefficient =mi._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/*my code*/
	public void add(Monom m1) {
		if (this.get_power()==m1.get_power()) {
			this.set_coefficient(this.get_coefficient()+m1.get_coefficient());
			/*
			 * summing the coefficients if the powers are equals
			 */
		}
	}
	public void nigzeret() {
		double result=this.get_coefficient()*this.get_power();
		this.set_coefficient(result);
		this.set_power((this.get_power())-1);
	}
	@Override
	public String toString() {
		return  _coefficient + "x^" + _power ;
	}
	public void multiply(Monom m)
	{
		this.set_coefficient(this.get_coefficient()*m.get_coefficient());
		this.set_power(this.get_power()+m.get_power());
	}

	public double f(double x) {
		return this.get_coefficient()*Math.pow(x,this.get_power());
	} 
	//****************** Private Methods and Data *****************	
	public double get_coefficient() {//v
		// TODO Auto-generated method stub
		return this._coefficient;
	}
	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		this._power = p;
	}
	public void add_coefficient(double a){//v
		this.set_coefficient(this.get_coefficient()+a);
	}	
	public void substract_coefficient(double a){
		this.set_coefficient(this.get_coefficient()-a);
	}
	private double _coefficient; // 
	private int _power;
}

