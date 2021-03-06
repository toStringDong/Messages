import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class BackEnd {
	
		    public Map<String, List<String>> data = new TreeMap<String, List<String>>();

		  public List<String> getMessage(String username){
		    return data.get(username);

		//    Returns a list of every message under the username
		  }

		  public void addMessage(String username, String msg){
		    if(data.containsKey(username)){
		    	data.get(username).add(msg);
		    }
		    else{
		    	data.put(username, new ArrayList<String>());
		    }
		  }

		  public List<Object> getUsers(){
		    return Arrays.asList(data.keySet().toArray());
	//	    Returns a list of every username ALPHABETICALLY ORDERED
		  

		}
}