package remoteFileInfo.getRemoteInfo;

import java.net.URI; 
import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.hdfs.protocol.HdfsFileStatus;

 
/** 
 * 
 * Description:这个类通过FileSystem的getFileStatus()方法来获得FileStatus对象 
 * 进而查询文件或者目录的元信息 
 *
 * 
 */ 
public class remoteInfoTake  { 
 
    /** 
     * @param args 
     */ 
	public remoteInfoTake(){
		
	}

	public static HdfsFileStatus getInfo(String remoteHostAddress,
			String fileName) throws Exception {
		// TODO Auto-generated method stub
		// 读取hadoop文件系统的配置
		// 查看HDFS中某文件的元信息
		Configuration conf = new Configuration();
		conf.set("hadoop.job.ugi", "hadoop-user,hadoop-user");
		@SuppressWarnings("resource")
		DFSClient dfsClient = new DFSClient(new URI("hdfs://"
				+ remoteHostAddress), conf);
		HdfsFileStatus fileStatus = dfsClient.getFileInfo(fileName);

		// 获取这个文件的基本信息
		if (fileStatus.isDir() == false) {
			System.out.println("这是个文件");
		}
		//System.out.println(fileStatus.toString());
		return fileStatus;

	} 
 
}
