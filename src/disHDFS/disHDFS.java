package disHDFS;

import java.rmi.RemoteException;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import connect.client.rmiClient;
import connect.conf.loadNetConf;
import connect.server.buildRmiServer;

public class disHDFS {

	private loadNetConf confLoad;
	private buildRmiServer rs;
	private String localRmiPort;
	public disHDFS(){
		confLoad = new loadNetConf();
		localRmiPort = confLoad.getRmiPort("localRmiPort");
		System.out.println("localRmiPort:" + localRmiPort);
		rs = new buildRmiServer(localRmiPort);
	}

	
	
	
	public FileStatus getFileStatus(String remoteHdfsName,String fileName) throws Exception{
		rmiClient rc;
		String remoteHostAddress = confLoad.readRemoteAddressByName(remoteHdfsName);
		String disIp = remoteHostAddress.split(":")[0];
		String remoteRmiPort = confLoad.getRmiPort("remoteRmiPort1");
		rc = new rmiClient(disIp, remoteRmiPort);
		return rc.getFileStatus(remoteHostAddress,fileName);
	}
	
	public LocatedBlocks getFileBlocks(String remoteHdfsName, String fileName) throws Exception {
		rmiClient rc;
		String remoteHostAddress = confLoad.readRemoteAddressByName(remoteHdfsName);
		String disIp = remoteHostAddress.split(":")[0];
		String remoteRmiPort = confLoad.getRmiPort("remoteRmiPort1");
		rc = new rmiClient(disIp, remoteRmiPort);
		return rc.getFileBlocks(remoteHostAddress,fileName);
	}
	
}
