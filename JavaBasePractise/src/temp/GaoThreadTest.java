package temp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GaoThreadTest {
	static class SlFundIntent{
		private BigDecimal money;
		SlFundIntent(BigDecimal money){
			this.money = money;
		}
		public BigDecimal getMoney(){
			return this.money;
		}
		public BigDecimal wasteTimeMethod(){
			try {
				Thread.sleep(100);//new Random().nextInt(10)*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this.money.add(new BigDecimal(1));
		}
		public String toString(){
			return "SlFundIntent"+money;
		}
		
	}
	static class GaoCallableThread implements Callable<BigDecimal>{
		SlFundIntent sfi;
		GaoCallableThread(SlFundIntent sfi){
			this.sfi = sfi;
		}
		@Override
		public BigDecimal call() throws Exception {
			// TODO Auto-generated method stub
			return sfi.wasteTimeMethod();
		}
		
	}

	public static void main(String[] args) {
		List<SlFundIntent> SlFundIntents = new ArrayList<SlFundIntent>();
		for(int i = 0 ;i <100;i++){
			SlFundIntents.add(new SlFundIntent(new BigDecimal(i)));
		}
		long time = System.currentTimeMillis();
		 BigDecimal result = BigDecimal.ZERO;
		 List<Future> futureLIst = new ArrayList<Future>();
		ExecutorService exec = Executors.newFixedThreadPool(10);
//        ArrayList<Future<BigDecimal>> results =new ArrayList<Future<BigDecimal>>();
       
        try {
        	for(SlFundIntent sfi:SlFundIntents){
        		futureLIst.add(exec.submit(new GaoCallableThread(sfi)));
        	}
        	for(Future future:futureLIst){
        		BigDecimal temp = (BigDecimal)future.get();
        		System.out.println(temp);
        		result = result.add(temp);
        	}
        	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*for(SlFundIntent sfi:SlFundIntents){
			result =result.add(sfi.wasteTimeMethod());
		}*/
        time = System.currentTimeMillis() - time;
//            results.add(exec.submit(new GaoCallableThread(sfi)));
        System.out.println(result+"ºÄÊ±£º"+time);
	}

}
