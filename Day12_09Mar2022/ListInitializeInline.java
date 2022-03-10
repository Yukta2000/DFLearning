import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ListInitializeInline
{
	public static void main(String[] args) {
		List<Integer> listInt = new ArrayList<>(){{
		    add(1);
		    add(2);
		    add(3);
		}};
		
		System.out.println(listInt);
		
		List<String> listStr = new ArrayList(Arrays.asList("Hello","Hi","How are you ?"));
		System.out.println(listStr);
	}
}

//https://www.geeksforgeeks.org/initializing-a-list-in-java/
