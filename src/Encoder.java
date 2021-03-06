import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Encoder{

  private File file;
  private List<String> messages;

  
   public Encoder(String filename) 
  {
	  file = new File (filename+".txt");
  }
  
  public void write (String plaintext)
  {
	  int shiftValue = 1;

	  String bar = "";

	  for (char c : plaintext.toCharArray()) {
	     bar += Character.toString((char) (((c - 'a' + shiftValue) % 26) + 'a'));
	  }

	  try{
		   
			FileWriter fout = new FileWriter(file, true);
			fout.write(bar+ "\n");
			fout.close();
			
				 
		  	}catch(Exception ex){}
	  
	  System.out.println("Encoder wrote:"+bar);
  }
  
  public List<String> read()
  {
	messages = new ArrayList<String>();
	 
	 try{

         FileReader inputFile = new FileReader(file);
         BufferedReader bufferReader = new BufferedReader(inputFile);
         String line;
         while ((line = bufferReader.readLine()) != null)   {
           messages.add(line);
         }
         bufferReader.close();
      }catch(Exception e){
         System.out.println("Error while reading file line by line:" + e.getMessage());  
         e.printStackTrace();
      }
	 
	 for (int i = 0; i < messages.size(); i ++)
	 {
		 String n = "";
		 String name = messages.get(i);
		 System.out.println(i);
		 for (char c : name.toCharArray()){
			 n += Character.toString((char) (((c - 'a' - 1) % 26) + 'a')) ;
		 }
		 messages.set(i, n); 
		 System.out.println(messages.get(i));
	 }
	 
	 return messages;
  }
}