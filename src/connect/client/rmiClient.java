package connect.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import connect.server.interfaceServer;;
public class rmiClient {
	private interfaceServer remoteHDFS;
	public rmiClient(String hostIp,String rmiPort){
		 try { 
	            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
			 String bingName = "rmi://"+hostIp+":"+rmiPort+"/remoteHDFS";
	        remoteHDFS =(interfaceServer) Naming.lookup(bingName); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        }
	}
	
	
	public FileStatus getFileStatus(String remoteHostAddress, String file) throws Exception{
		return remoteHDFS.fileRemoteInfo(remoteHostAddress,file);
	}
	public LocatedBlocks getFileBlocks(String remoteHostAddress, String fileName) throws Exception{
		return remoteHDFS.fileRemoteBlocks(remoteHostAddress, fileName);
	}
}
