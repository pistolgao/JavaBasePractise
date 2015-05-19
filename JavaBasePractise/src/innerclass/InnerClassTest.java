package innerclass;

public class InnerClassTest {
	public InnerClassTest(String outValue){
		this.outerClassField = outValue;
	}
	public void newInstanceAndPrint(){
		new InnerClass().printOuterField();
	}
	private String outerClassField;
	private class InnerClass{
		private String outerClassField ="111";
		public void printOuterField(){
			System.out.println(outerClassField);//访问自身变量，如果自身无outerClassField，则访问父类变量
			System.out.println(InnerClassTest.this.outerClassField);//访问父类变量
		}
		public InnerClass(){}
	}
	
	/**
	 * @author gaoqr
	 *InnerClass1区别InnerClass 在于不存在同名变量outerClassField
	 */
	private class InnerClass1{
		public void printOuterField(){
			System.out.println(outerClassField);//访问自身变量，如果自身无outerClassField，则访问父类变量
			System.out.println(InnerClassTest.this.outerClassField);//访问父类变量
		}
		public InnerClass1(){}
	}
	public static void main(String[] args) {
		InnerClassTest ict = new InnerClassTest("test");
//		System.out.print("newInstanceAndPrint:");ict.newInstanceAndPrint();
		System.out.println("InnerClass:");
		//一定要是ict.new 外界无法访问，无法使用new InnerClass(要想使用这种new InnerClass的方式，参考)
		ict.new InnerClass().printOuterField();
		
		System.out.println("InnerClass1:");
		ict.new InnerClass1().printOuterField();
		
	}
}
