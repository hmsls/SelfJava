package TestKettle1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

/*
 * 测试传递参数给kettle的转换和job
 */
public class Test1 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		String dateTime = sdf.format(new Date());
		String[] params = {"707", dateTime};
		String path = "D:\\kettle\\kettle_practice\\kettle_java_job1.kjb";
//		String path1 = "D:\\kettle\\kettle_practice\\java_kettle1.ktr";
		String path1 = "C:\\Users\\LISHUAI\\Desktop\\test2.ktr";
		
		runTransfer(params, path1);
//		runJob(params, path);
//		jbResource(); 
	}
	 /**  
     * 运行转换文件方法 
     * @param params 多个参数变量值 
     * @param ktrPath 转换文件的路径，后缀ktr 
     */  
    public static void runTransfer(String[] params, String ktrPath) {  
        Trans trans = null;  
        try {  
            // // 初始化  
            // 转换元对象  
            KettleEnvironment.init();// 初始化  
            EnvUtil.environmentInit();  
            TransMeta transMeta = new TransMeta(ktrPath);  
            // 转换  
            trans = new Trans(transMeta);  
            trans.setVariable("out", "{\"batchNo\":\"000150111703071727130530019552\",\"decisionResult\":\"0\",\"erorcd\":\"0001\",\"erortx\":\"Source must not be null\"}");
//            trans.setVariable("v2", "values2");
//            trans.setVariable("v3", "values3");
              
            // 执行转换  
            trans.execute(params);  
            // 等待转换执行结束  
            trans.waitUntilFinished();  
            // 抛出异常  
            if (trans.getErrors() > 0) {  
                throw new Exception(  
                        "There are errors during transformation exception!(传输过程中发生异常)");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * java 调用 kettle 的job 
     *  
     * @param jobname 
     *            如： String fName= "D:\\kettle\\informix_to_am_4.ktr"; 
     */  
    public static void runJob(String[] params, String jobPath) {  
        try {  
            KettleEnvironment.init();  
            // jobname 是Job脚本的路径及名称  
            JobMeta jobMeta = new JobMeta(jobPath, null);  
            Job job = new Job(null, jobMeta);  
            // 向Job 脚本传递参数，脚本中获取参数值：${参数名}  
            // job.setVariable(paraname, paravalue);  
            job.setVariable("id", params[0]);  
            job.setVariable("dt", params[1]);  
            job.start();  
            job.waitUntilFinished();  
            if (job.getErrors() > 0) {  
                throw new Exception(  
                        "There are errors during job exception!(执行job发生异常)");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
