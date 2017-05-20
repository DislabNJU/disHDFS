package connect.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceServer extends Remote {
	public String helloWorld() throws RemoteException;
	public String sayHelloToSomeBody(String someBodyName)
			throws RemoteException;

	//this function return infomation about the file from remote hdfs 
	public String[] fileRemoteInfo(String[] fileName) throws RemoteException;
}