package packageAccess;

import packageDefault.*;
import packageProtected.*;
import packagePrivate.*;
import packagePublic.*;

public class run {
	
	public static void main(String []args)
	{
		
		
		classDefault defaultVar=new classDefault();
//		defaultVar.method(); // default method only accessible within the package
		
		classProtected protectedVar=new classProtected();	
//		protectedVar.method(); // protected method accessed only with in the same pacakge and subclasses(extending classes)
		
		
		classPrivate privateVar=new classPrivate();
//		privateVar.method(); // private are only accessed with in the same class
		
		
		classPublic publicVar=new classPublic();
		publicVar.method();
	}

}


class ProtectedSubclass extends classProtected {
	
	public void anomethod() {
		method();
	}
	
}
