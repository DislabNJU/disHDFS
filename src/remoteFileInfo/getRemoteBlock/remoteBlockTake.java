package remoteFileInfo.getRemoteBlock;

import java.io.IOException;
import java.net.URI; 
import java.net.URISyntaxException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;



public class remoteBlockTake  {

	
	public static  LocatedBlocks getBlocks(String remoteHostAddress,String fileName) throws IOException, URISyntaxException{
		Configuration conf = new Configuration(); 
        conf.set("hadoop.job.ugi", "hadoop-user,hadoop-user"); 
		@SuppressWarnings("resource")
		DFSClient dfsClient = new DFSClient(new URI("hdfs://"+remoteHostAddress),conf);
		LocatedBlocks locatedBlocks = dfsClient.getLocatedBlocks(fileName, 0);//getBlockStorageLocations(file)
		//System.out.println("blockinfo:\n" +locatedBlocks.toString());
        return locatedBlocks;
	}
}
