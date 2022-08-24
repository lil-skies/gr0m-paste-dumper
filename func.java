import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.util.List;
import java.io.FileWriter;

public class func 
{
	public String url;
	public String format;
	
	public <T> void log(T...args)
	{
		for(int i = 0; i < args.length; i++)
		{
			if(args[i].equals("\n")) System.out.println();
			else System.out.print(args[i] + " ");
			
		}
		
	}
	
	public void scrape(String url)
	{
		try(WebClient client = new WebClient(BrowserVersion.CHROME))
		{
			HtmlPage webpage = client.getPage(url);
			client.getCurrentWindow().getJobManager().removeAllJobs();
			client.getOptions().setCssEnabled(false);
			client.getOptions().setJavaScriptEnabled(false);
			
			log(webpage.getTitleText(), "\n");
			
			List<?>anchors = webpage.getByXPath(".//div[@class='de1']");
			
			FileWriter dumper = new FileWriter("dump.csv", true);
			
			for(int i = 0; i < anchors.size(); i++)
			{
				HtmlElement fnd = (HtmlElement)anchors.get(i);

				log(fnd.asNormalizedText(), "\n");
				dumper.write(fnd.asNormalizedText() + "\n");
				
			}
			
			log("[+] dump completed!", "\n");
			dumper.close();
			client.close();
			
		} 
		catch (IOException e) 
		{
			this.log("Error caught!", "\n");
			
		} 

		
	}

}
