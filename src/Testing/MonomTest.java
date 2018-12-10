package Testing;

import org.junit.jupiter.api.Test;

import myMath.Monom;

import static org.junit.jupiter.api.Assertions.*;



class MonomTest {

	@Test
	void test_add_equal() {

		Monom m1=new Monom(3,5);
		Monom m2=new Monom(5,5);
		m2.add(m1);
		assertEquals("8.0x^5", m2.toString());
 	}
	@Test
	void test_add_not_equal() {
		Monom m1=new Monom(3,5);
		Monom m2=new Monom(5,5);
		m2.add(m1);
		assertNotEquals("8.0x^8", m2.toString());
 	}
	@Test
	void test_derivative_equal() {
		Monom m1=new Monom(3,5);
		m1.nigzeret();
		assertEquals("15.0x^4", m1.toString());
	}
	void test_Not_derivative_equal() {
		Monom m1=new Monom(3,5);
		m1.nigzeret();
		assertNotEquals("40.0x^4", m1.toString());
	}
	@Test
	void test_multiply_equal() {
		Monom m1=new Monom(3,5);
		Monom m2=new Monom(5,5);
		m2.multiply(m1);
		assertEquals("15.0x^10", m2.toString());
 	}
	@Test
	void test_multiply_Not_equal() {
		Monom m1=new Monom(3,5);
		Monom m2=new Monom(5,5);
		m2.multiply(m1);
		assertNotEquals("8.0x^5", m2.toString());
 	}
	@Test
	void test_f_equal(){
		Monom m1=new Monom(3,5);
		m1.f(5);
		assertNotEquals("15.0x^5", m1.toString());
	}
	@Test
	void test_f_Not_equal(){
		Monom m1=new Monom(3,5);
		m1.f(5);
		assertNotEquals("40.0x^4", m1.toString());
	}
}

