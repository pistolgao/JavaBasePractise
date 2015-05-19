package innerclass;

/**
 * @author gaoqr
 * ����ͨ��  �ڲ���ֱ�ӻ�ȡ�ⲿ���Ա����
 * ԭ��java���������ڱ����ڲ���ʱ��Ϊ�ڲ��๹�������һ���ⲿ�����Ĳ���
 * ע�����ڲ���ָһ���ڲ��࣬��ָstatic���ڲ���
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
