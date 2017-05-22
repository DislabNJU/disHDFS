package testDisHDFS;

import org.apache.hadoop.hdfs.protocol.HdfsFileStatus;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import disHDFS.disHDFS;

public class testDisHdfs {
	public static void main(String args[]) throws Exception{
		disHDFS td= new disHDFS();
		String remoteHdfsName = "disHDFS1";//114.212.81.167:9000
		String fileName = "/remote/words.txt";
		HdfsFileStatus  fs = td.getFileStatus(remoteHdfsName, fileName);
		LocatedBlocks lb = td.getFileBlocks(remoteHdfsName, fileName);
		System.out.println("fs: \n"+fs.getBlockSize());
		System.out.println("lb: \n"+lb.toString());
	}
}
