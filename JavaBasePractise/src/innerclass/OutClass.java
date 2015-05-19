package innerclass;

/**
 * @author gaoqr
 * 测试通过  内部类直接获取外部类成员变量
 * 原理：java编译器，在编译内部类时会为内部类构造器添加一个外部类对象的参数
 * 注：此内部类指一般内部类，不指static的内部类
 */
public class OutClass {
	int i ;
	public OutClass(int i){
		this.i = i;
	}
	protected class InnerClass{
		public int getOutIVal(){
			return i;
		}
	}
	public int getIByInner(){
		return new InnerClass().getOutIVal();
	}
	public static void main(String[] args) {
		OutClass out = new OutClass(8);
		System.out.println(out.getIByInner());
	}

}
