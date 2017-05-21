package connect.server;

import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.hdfs.protocol.LocatedBlocks;

import remoteFileInfo.getRemoteBlock.remoteBlockTake;
import remoteFileInfo.getRemoteInfo.remoteInfoTake;

public  class impleServer extends UnicastRemoteObject implements interfaceServer { 
    /** 
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，
     * 必须声明抛出RemoteException异常 
     * 
     * @throws RemoteException 
     */ 
    public impleServer() throws RemoteException { 
    } 
    public String helloWorld() throws RemoteException { 
        return "Hello World!"; 
    } 
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException { 
        return "你好，" + someBodyName + "!"; 
    } 
    public FileStatus fileRemoteInfo(String remoteHostAddress, String fileName) throws Exception{
    	FileStatus result = null;
    	
    		result = remoteInfoTake.getInfo(remoteHostAddress,fileName);
		
    	return result;
    }
    public LocatedBlocks fileRemoteBlocks(String remoteHostAddress, String fileName) throws Exception{
    	LocatedBlocks blocks = null;
    	blocks = remoteBlockTake.getBlocks(remoteHostAddress, fileName);
    	return blocks;
    }
}
