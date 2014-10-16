# CesfMathLib

### Projecte per tenir una llibreria de **funcions matematiques**. 

Conte les clases:

   * [Complex](http://en.wikipedia.org/wiki/Complex_number)
   * [Fraction](http://en.wikipedia.org/wiki/Fraction_(mathematics))
   * [Matrix](http://en.wikipedia.org/wiki/Matrix_(mathematics))



Classes  | Descripcio
-------- | -------------
Complex  | Classe per disposar de nombres complexos.
Fraction | Classe immutable per a representar fraccions enteres.
Matrix   | Classe immutable per a la representació i manipulació de matrius de nombres reals.


Un funcio en `java` de la classe Fraction com a exemple:
```java
	public Fraction multiply(int x) {
		int n = this.num * x;
		int d = this.den;
		return new Fraction(n, d).reduce();
	}
```


