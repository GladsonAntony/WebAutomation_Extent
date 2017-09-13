/**
 * 
 */
package tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

/**
 * @author ${Gladson Antony}
 * @date 22-Oct-2016
 * 
 */
public class Test2 {

	@Test
	public  void testme(String[] Command) throws Exception 
	{
		Process proc = Runtime.getRuntime().exec(Command);

		// Read the output

		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.print(line + "\n");
		}
		proc.waitFor();
	}

	@Test(enabled=false)
	public void test123() throws Exception 
	{
		String command="mvn -version";

		Process process = Runtime.getRuntime().exec(command);
		System.out.println("the output stream is "+process.getOutputStream());
		BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
		String s; 
		while ((s = reader.readLine()) != null)
		{
			System.out.println("The inout stream is " + s);
		}

	}
}
