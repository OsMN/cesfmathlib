package cesf.math;

/**
 *  classe immutable per a representar fraccions enteres.
 * @author cesf
 *
 */
public class Fraction {

	private final int num;
	private final int den;
	
	/**
	 *  constructor per defecte
	 */
	public Fraction() { 
		num=0; 
		den=1;
	}
	/**
	 *  constructor amb paràmetres 
	 * @param num
	 * @param den
	 */
	public Fraction(int num, int den) { 
		if (den == 0) 
			throw new IllegalArgumentException("Denominator can not be zero!"); 
		this.num = num;
		this.den = den; 
	}

	/**
	 *  getters
	 * @return Num y Den
	 */
	public int getNum() { return this.num; }
	public int getDen() { return this.den; }
	
	/**
	 *  retorna el valor numèric de la fracció
	 * @return x
	 */
	public double valueOf() {
		double x = (double)(this.num) / this.den; 
		return x;
	}
	
	/**
	 *  retorna el valor numèric d'una fracció (versió estàtica)
	 * @param a
	 * @return x
	 */
	public static double valueOf(Fraction a) {
		double x = (double)(a.num) / a.den; 
		return x;		
	}
	
	/**
	 *  retorna una representació en cadena de text
	 */
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	/**
	 *  simplifica la fracció al màxim
	 * @return Fraction(n, d)
	 */
	public Fraction reduce() {
		int mcd = mcd(this.num, this.den);
		int n = this.num / mcd;
		int d = this.den / mcd;
		if (d < 0) { n = -n; d = -d; }
		return new Fraction(n, d);
	}
	
	/**
	 *  retorna F1 + F2
	 * @param b
	 * @return Fraction(n, d).reduce()
	 */
	public Fraction add(Fraction b) {
		int n = this.num * b.den + this.den * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 *  retorna F1 - F2
	 * @param b
	 * @return Fraction(n, d).reduce()
	 */
	public Fraction substract(Fraction b) {
		int n = this.num * b.den - this.den * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 *  retorna F1 * F2
	 * @param b
	 * @return Fraction(n, d).reduce()
	 */
	public Fraction multiply(Fraction b) {
		int n = this.num * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 *  retorna F1 * x
	 * @param x
	 * @return Fraction(n, d).reduce()
	 */
	public Fraction multiply(int x) {
		int n = this.num * x;
		int d = this.den;
		return new Fraction(n, d).reduce();
	}
	
	/**
	 *  retorna F1 / F2
	 * @param b
	 * @return this.multiply(b.reciprocal())
	 */
	public Fraction divide(Fraction b) {
		return this.multiply(b.reciprocal());
	}

	/**
	 *  retorna 1 / F
	 * @return Fraction(this.den, this.num).reduce()
	 */
	public Fraction reciprocal() {
		return new Fraction(this.den, this.num).reduce();
	}
	
	/**
	 *  troba el MCD del numerador i denominador
	 * @param a
	 * @param b
	 * @return a
	 */
	protected int mcd(int a, int b) {
		int d; 
		while (b != 0) {
			d = b;
			b = a % b;
			a = d;
		}
		return a;
	}

	/**
	 *  compara dos fraccions
	 * @param b
	 * @return true or false
	 */
	public boolean equals(Fraction b) {
		Fraction f1 = this.reduce();
		Fraction f2 = b.reduce();
		if (f1.num != f2.num) return false;
		if (f1.den != f2.den) return false; 
		return true;
	}
}
