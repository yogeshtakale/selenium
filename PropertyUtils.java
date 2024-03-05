package CommonUtils;

import java.io.FileInputStream;
//import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import javax.xml.crypto.dsig.keyinfo.KeyName;


public class PropertyUtils {

	public  String getDataPropertyFile(String Keyname) throws FileNotFoundException,IOException {
		// TODO Auto-generated method stub
		//FileInputStream File= new FileInputStream("src\\test\\resources\\Book23.properties.xlsx");
		//FileInputStream File=new FileInputStream("src\\test\\resources\\fra.properties");
		FileInputStream File=new FileInputStream("src\\test\\resources\\fra.properties");
	
		
        Properties properties= new Properties();
        properties.load(File);
        String value=properties.getProperty(Keyname);
        return value;
	}

}
