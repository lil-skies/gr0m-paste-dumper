import java.util.Scanner;

public class main 
{	
	public static void main(String args[])
	{
		func p = new func();
		Scanner scn = new Scanner(System.in);
		
		p.log("[?] Enter URL:");
		p.url = scn.next();
		
		p.log("\n", "[ gr0m dumper ]", "\n");

		p.scrape(p.url);
		
	}

}
