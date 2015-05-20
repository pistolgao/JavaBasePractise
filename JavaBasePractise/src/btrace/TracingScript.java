/* BTrace Script Template */
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;
import static com.sun.btrace.BTraceUtils.jstack;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;

/*
 * 1.运行jvisualvm
 * 2.工具，插件，可用插件，安装BTrace Workbench
 * 3.运行，CaseObjectMain
 * 4.右键btrace.CaseObjectMain进程  选择trace appliaction
 * 5.讲该类代码copy到tracescript中
 * 6.点击start
 * 
 * 
 * */

@BTrace
public class TracingScript {
    /* put your code here */
/*指明要查看的方法，类*/
  @OnMethod(
     clazz="btrace.CaseObject",
     method="execute",
     location=@Location(Kind.RETURN)
  )
/*主要两个参数是对象自己的引用 和 返回值，其它参数都是方法调用时传入的参数*/
   public static void traceExecute(@Self btrace.CaseObject object,int sleepTime, @Return boolean result){
      println("调用堆栈！！");
       println(strcat("返回结果是：",str(result)));
      jstack();
      println(strcat("时间是：",str(sleepTime)));
   }

}