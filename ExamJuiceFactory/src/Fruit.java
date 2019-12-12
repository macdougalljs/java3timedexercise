
import java.io.Serializable;

/*
  * Fruit java bean 
 */
public class Fruit implements Serializable {

    //Field Variables
    private String name;
    private static final long serialVersionUID = 1L;
    

    //Constructor
    public Fruit() {
        super();
    }
    public Fruit(String string) {
		this.name = string;
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}