package packageProtected;

public class classProtectedPackage {
	
	
	
	public void method() {
		classProtected protectedVar=new classProtected();
		protectedVar.method();//can be accessed from the same package
	}

	public classProtectedPackage() {
		// TODO Auto-generated constructor stub
		
	}

}
