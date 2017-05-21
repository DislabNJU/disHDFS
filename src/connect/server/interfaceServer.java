package connect.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

public interface interfaceServer extends Remote {
	public String helloWorld() throws RemoteException;
	public String sayHelloToSomeBody(String someBodyName)
			throws RemoteException;

	//this function return infomation about the file from remote hdfs 
	public FileStatus fileRemoteInfo(String remoteHostAddress,  String fileName) throws RemoteException, Exception;
	public LocatedBlocks fileRemoteBlocks(String remoteHostAddress, String fileName) throws RemoteException, Exception;
}