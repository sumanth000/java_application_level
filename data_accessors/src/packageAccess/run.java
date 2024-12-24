package packageAccess;

import packageDefault.*;
import packageProtected.*;
import packagePrivate.*;
import packagePublic.*;

public class run {
	
	public static void main(String []args)
	{
//=====================================================================================		
//									Implicit DEFAULT
//=====================================================================================		

		classDefault defaultVar=new classDefault();
//		defaultVar.method(); // default method only accessible within the package
		
		
		classDefaultPackage defaultVarPackage=new classDefaultPackage();
		defaultVarPackage.anotherMethod();
		
		classDefaultPackageSubClass defaultVarSubClass=new classDefaultPackageSubClass();
//		defaultVarSubClass.method(); // can't use the method() from another 
//		defaultVarSubClass.anotherMethod();// can't use any method that isn't protected or public
		
		
//=====================================================================================		
//									PROTECTED
//=====================================================================================		
		classProtected protectedVar=new classProtected();	
//		protectedVar.method(); // protected method accessed only with in the same pacakge and subclasses(extending classes)
		
		ProtectedSubclass protectedSubClass=new ProtectedSubclass();
//		protectedSubClass.method();  // can't acc
		
		
		
//=====================================================================================		
//												PRIVATE
//=====================================================================================				
		
		
		classPrivate privateVar=new classPrivate();
//		privateVar.method(); // private are only accessed with in the same class
		
//=====================================================================================		
//											PUBLIC
//=====================================================================================				
		
		classPublic publicVar=new classPublic();
		publicVar.method();
	}

}


class ProtectedSubclass extends classProtected {
	
	public void anomethod() {
		method();
	}
	
}
