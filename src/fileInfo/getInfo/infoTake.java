package fileInfo.getInfo;

import java.net.URI; 
import java.sql.Timestamp; 
import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.fs.FileStatus; 
import org.apache.hadoop.fs.FileSystem; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;
 
/** 
 * 
 * Description:这个类通过FileSystem的getFileStatus()方法来获得FileStatus对象 
 * 进而查询文件或者目录的元信息 
 *
 * 
 */ 
public class infoTake { 
 
    /** 
     * @param args 
     */ 
    public static void main(String[] args) throws Exception { 
        // TODO Auto-generated method stub 
        //读取hadoop文件系统的配置 
        Configuration conf = new Configuration(); 
        conf.set("hadoop.job.ugi", "hadoop-user,hadoop-user"); 
         
        //实验1:查看HDFS中某文件的元信息 
        System.out.println("实验1:查看HDFS中某文件的元信息"); 
        String fileUri = args[0]; 
        FileSystem fileFS = FileSystem.get(URI.create(fileUri) ,conf); 
        FileStatus fileStatus = fileFS.getFileStatus(new Path(fileUri)); 
        //获取这个文件的基本信息       
        if(fileStatus.isDir()==false){ 
            System.out.println("这是个文件"); 
        } 
        System.out.println("文件路径: "+fileStatus.getPath()); 
        System.out.println("文件长度: "+fileStatus.getLen()); 
        System.out.println("文件修改日期： "+new Timestamp (fileStatus.getModificationTime()).toString()); 
        System.out.println("文件上次访问日期： "+new Timestamp(fileStatus.getAccessTime()).toString()); 
        System.out.println("文件备份数： "+fileStatus.getReplication()); 
        System.out.println("文件的块大小： "+fileStatus.getBlockSize()); 
        System.out.println("文件所有者：  "+fileStatus.getOwner()); 
        System.out.println("文件所在的分组： "+fileStatus.getGroup()); 
        System.out.println("文件的 权限： "+fileStatus.getPermission().toString()); 
        System.out.println(); 
        DFSClient dfsClient = new DFSClient(new URI("hdfs://114.212.87.91:9000"),conf);
        LocatedBlocks locatedBlocks = dfsClient.getLocatedBlocks("/input/word.txt", 0);
        System.out.println("blockinfo:\n" +locatedBlocks.toString());
        
        
    } 
 
}
