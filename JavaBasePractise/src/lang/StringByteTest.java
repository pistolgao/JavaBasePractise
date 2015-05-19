package lang;

import java.io.UnsupportedEncodingException;

public class StringByteTest {

	public static void main(String[] args) {
		byte[] bytes = {50, 0, -1, 28, -24};
		try {
			String str = new String(bytes, "UTF-8");
			System.out.println(str);
			byte[] sendBytes = str.getBytes("UTF-8");
			for(byte b:sendBytes){
				System.out.print(b+" ");
			}
			System.out.println();
			String recStr = new String(sendBytes,"UTF-8");
			System.out.println(recStr);
			byte[] recBytes = recStr.getBytes("UTF-8");
			for(byte b:recBytes){//�����byte���鲻��ԭ���������ֵ��
				System.out.print(b+" ");
			}
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
	}

}
