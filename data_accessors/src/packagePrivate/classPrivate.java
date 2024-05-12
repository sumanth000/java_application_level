package packagePrivate;

public class classPrivate {
	
	 private void method() {
		 System.out.println("method()----- "+"classDefault class");
	 }
	 
	 
	 private void anotherMethod() {
		 method();// only accessed within the same location
	 }

}


class anotherClass{
	public void method() {
		classPrivate privateVar=new classPrivate();
//		privateVar.method();// can't use private method in another class
	}
}
