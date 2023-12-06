package Project_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class chks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String x ="StopArea:OCE71793150,Portbou,,42.4247010,3.15803400,,,1,,";
		//String x ="StopPoint:OCETrain TER-87613323,Lalbenque - Fontanes,,44.3336560,1.51157800,,,0,StopArea:OCE87613323,";
		//String x ="StopPoint:OCETrain TER-87611152,StopPoint:OCETrain TER-87611152,2,300,,";
		//String x ="OCESN105330F600360:2021-12-08T20:44:38Z,07:27:00,07:27:00,StopPoint:OCENavette-87571240,0,,0,1,";
		//String x ="OCESN-180694,OCESN,R 09,Bus 4726 4724 1240 4723 4727 1260 4728 Toulouse -LNN SSTL- Luchon Pau,,3,,,";
		/*int comma=x.indexOf(',');
		String f = x.substring(0,comma);
		System.out.println(f);
		int comma2=x.indexOf(',', comma);
		if(x.subSequence(comma, comma2).equals("")) 
		{
			System.out.println("tm");
		}*/
		/*ArrayList <String> r = kk(x);
		for(int i=0;i<r.size();i++) 
		{
			System.out.println(r.get(i));
		}*/
		//ArrayList <String> Strings = ff(",Portbou,,42.4247010,3.15803400,,,1,,f");
		//Strings.add("");
		//Strings.add("");
		//Strings.add("");
		//Strings.add("a");
		//System.out.println("fun");
		//for(int i=0;i<Strings.size();i++) 
		//{
			//System.out.println(Strings.get(i));
		//}
		
		
		/*ArrayList <ArrayList <String>> l =new ArrayList ();
		BufferedReader objReader = new BufferedReader(new FileReader("cities.txt"));
		String strCurrentLine;
		while ((strCurrentLine = objReader.readLine()) != null) {
		    System.out.println(strCurrentLine);
		}*/
		String x1="http://dbpedia.org/resource/Pointe-à-Pitre";
		ArrayList <String> l =new ArrayList ();
		l.add(x1);
		String x=l.get(0);
		x=x.substring(x.lastIndexOf("/")+1);
		l.set(0, x);
		System.out.println(l.get(0));
	}
	public static ArrayList <String> kk (String x)
	{
		ArrayList <String> Strings = new ArrayList();
		int comma=x.indexOf(',');
		String f = x.substring(0,comma);
		Strings.add(f);
		x=x.substring(comma);
		//Strings.add(x);
		Strings=ff(x,Strings);
		return Strings;
	}
	public static ArrayList <String> ff (String x,ArrayList <String> Strings)
	{
		if(x.charAt(0) == ',') 
		{
			x=x.substring(1);
			int comma=x.indexOf(',');
			if(comma!=-1) 
			{
				String f = x.substring(0,comma);
				//System.out.println(f);
				Strings.add(f);
				x=x.substring(comma);
				//System.out.println(x);
				ff(x,Strings);
				//Strings.add(f);
			}
			else
			{
				//System.out.println("x: "+x);
				Strings.add(x);
			}
		}
		return Strings;
	}
}
