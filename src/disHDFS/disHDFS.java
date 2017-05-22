package disHDFS;


import org.apache.hadoop.hdfs.protocol.HdfsFileStatus;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import remoteFileInfo.getRemoteBlock.remoteBlockTake;
import remoteFileInfo.getRemoteInfo.remoteInfoTake;

import connect.conf.loadNetConf;

public class disHDFS  {

	private loadNetConf confLoad;
	public disHDFS(){
		confLoad = new loadNetConf();
		
	}
	
	
	
	
	public HdfsFileStatus getFileStatus(String remoteHdfsName,String fileName) throws Exception{
		String remoteHostAddress = confLoad.readRemoteAddressByName(remoteHdfsName);
		return remoteInfoTake.getInfo(remoteHostAddress, fileName);
	}
	
	public LocatedBlocks getFileBlocks(String remoteHdfsName, String fileName) throws Exception {
		String remoteHostAddress = confLoad.readRemoteAddressByName(remoteHdfsName);
		return remoteBlockTake.getBlocks(remoteHostAddress, fileName);
	}
	
}
