package remoteFileInfo.getRemoteBlock;

import java.io.IOException;
import java.net.URI; 
import java.net.URISyntaxException;
import java.sql.Timestamp; 
import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.fs.FileStatus; 
import org.apache.hadoop.fs.FileSystem; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;


public class remoteBlockTake {

	
	public static LocatedBlocks getBlocks(String remoteHostAddress,String file) throws IOException, URISyntaxException{
		Configuration conf = new Configuration(); 
        conf.set("hadoop.job.ugi", "hadoop-user,hadoop-user"); 
		DFSClient dfsClient = new DFSClient(new URI("hdfs://"+remoteHostAddress),conf);
		LocatedBlocks locatedBlocks = dfsClient.getLocatedBlocks(file, 0);
        System.out.println("blockinfo:\n" +locatedBlocks.toString());
        return locatedBlocks;
	}
}
