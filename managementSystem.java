/*Created by Taha Atakan İpekçi on 22.2.2017*/
/*an interface for the management system of a library*/
import java.lang.*;


interface managementSystem{

	public String getLibraryName();
	public String getUserFileName();
	public String getBooksFileName();
	public String getStaffFileName();
	public void setLibraryName(String name);
	public void setUserFileName(String name);
	public void setBooksFileName(String name);
	public void setStaffFileName(String name);
	public int loginStaff(String name, String password);
	public int loginUser(String name, String password);


}
