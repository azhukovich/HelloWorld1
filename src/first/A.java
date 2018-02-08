package first;

import java.math.BigDecimal;

public class A {
	public void doSmth(Action a) {
		a.doAction();			
	}
	
	public int sum (int ... num) {
		int summa=0;
		for (int i: num) {
			summa +=i;
		}
		return summa; 
	}
	
	public BigDecimal divide (float a,float b) {
		BigDecimal b1 = new BigDecimal(a);
		BigDecimal b2 = new BigDecimal(b);
		BigDecimal b3 = b1.divide(b2);
		
		//return b1.divide(b2,100,BigDecimal.ROUND_HALF_UP); 
		return b3.setScale(50, BigDecimal.ROUND_HALF_UP);
	}
}
