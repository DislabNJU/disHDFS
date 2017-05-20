package connect.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import fileInfo.getInfo.infoTake;

public class impleServer extends UnicastRemoteObject implements interfaceServer { 
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
    public String[] fileRemoteInfo(String[] fileName) throws RemoteException{
    	try {
			String result[] = infoTake.getInfo(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return null;
    }
}
