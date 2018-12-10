package myMath;

import java.util.Comparator;
public class Monom_Comperator implements Comparator<Monom> 
{
	// ******** add your code below *********
 public int compare(Monom arg0, Monom arg1) {
		
	//Describing every possible condition between two Monoms
		Boolean b1=(arg0.get_power()==arg1.get_power());
		Boolean b2=(arg0.get_power()>arg1.get_power());
		Boolean b3=(arg0.get_power()<arg1.get_power());
		Boolean b4=(arg0.get_coefficient()==arg1.get_coefficient());
		Boolean b5=(arg0.get_coefficient()>arg1.get_coefficient());
		Boolean b6=(arg0.get_coefficient()<arg1.get_coefficient());
		if(b1==true)//if powers of two monoms are equal there are 3 possible scenarios
		{
			if(b4==true)//both monoms are the same
				return 0;
			else if(b5==true)// arg0 is bigger than arg1
				return 1;
			else if(b6==true)// arg1 is bigger than arg0
				return -1;
		}
		if(b2==true)//arg0 is exponitially bigger
			return 1;
		else //(b3==true) //arg1 is exponitially bigger
			return -1;				
	}
}
