package packageProtected;

public class classProtectedPackageSubClas extends classProtected {
	
	
	
	public void method() {
		
		method();
		
		classProtected protectedVar=new classProtected();
		protectedVar.method();//can be accessed from the same package
	}

	public classProtectedPackageSubClas() {
		// TODO Auto-generated constructor stub
		
	}

}
