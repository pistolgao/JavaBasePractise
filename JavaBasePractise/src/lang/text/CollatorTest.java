package lang.text;

import java.text.Collator;

public class CollatorTest {

	public static void main(String[] args) {
		// The Collator class performs locale-sensitive String comparison. You use this class to build searching and sorting routines for natural language text. 
		 Collator collator = Collator.getInstance();
		 System.out.println(collator.compare("高","张"));//高（gao）<张(zhang)
		 System.out.println(collator.compare("镇","张"));//镇（zhen）>张(zhang)
		 
	}

}
