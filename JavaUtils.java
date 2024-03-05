package CommonUtils;

import java.util.Random;

public class JavaUtils {

	public  int getRandonumber() {
		// TODO Auto-generated method stub
		Random r=new Random();
		int ran = r.nextInt(500);
		return ran;
		
	}

}
