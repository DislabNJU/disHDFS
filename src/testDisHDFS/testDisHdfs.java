package testDisHDFS;

import java.rmi.RemoteException;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import disHDFS.disHDFS;

public class testDisHdfs {
	public static void main(String args[]) throws Exception{
		disHDFS td= new disHDFS();
		String remoteHdfsName = "disHDFS1";
		String fileName = "/input/word.txt";
		//LocatedBlocks lb = td.getFileBlocks(remoteHdfsName, fileName);
		FileStatus  fs = td.getFileStatus(remoteHdfsName, fileName);
	}
}
