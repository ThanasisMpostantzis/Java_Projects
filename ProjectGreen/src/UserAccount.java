import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UserAccount implements Serializable {
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private int tokens;
	private HashMap<Material, Integer> recycled;
	//leipoun idiotites pou sxetizontai me alles leitoyrgies
	
	public UserAccount (String firstName, String lastName, String email, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.tokens = 0;
		
		recycled = new HashMap<>();
		DataBase db = new DataBase();
		for(Material material : db.getMaterials()) {
			recycled.put(material, 0);
		}
		
		//leipoun idiotites pou sxetizontai me alles leitoyrgies

	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getTokens() {
		return tokens;
	}
	
	public void signedInAccountSerialization() {
		try {
			FileOutputStream fileOut = new FileOutputStream("signedInAccount.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			System.out.println("signedInAccount.ser File Not Found (signed in account serialization)");
		} catch (IOException e) {
			System.out.println("IO Exception ?");
		}
	}
	
	public void recycleMaterial(Material m) {
		this.tokens += m.getReward();
		
		Iterator<Material> i = recycled.keySet().iterator();
		while(i.hasNext()) {
			Material key = i.next();
			if(key.getName().equals(m.getName())) {
				recycled.put(key, recycled.get(key) + 1);
			}
		}
		this.signedInAccountSerialization();
	}
	
}
