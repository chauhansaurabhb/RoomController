package sim.deviceD3;


import iotsuite.semanticmodel.*;
import iotsuite.common.*;
import iotsuite.pubsubmiddleware.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import logic.*;
import android.content.Context;

public class Startup implements DeviceStartup {
	
	private static Context ui;
	private static String name ;
	private static String softwarePlatform;
	private static String networkAddress;
	private static Set<String> abilities = new HashSet<String>();
	private static PubSubMiddleware myPubSub;
	public static Object myContext = null;
	public static String mobileFlag;

private static void setUpNode(Device deviceInfo)	{	

	
	
	myPubSub = (PubSubMiddleware) IoTSuiteFactory.getInstance("mqtt", setUpDeviceInfo(), myContext);

	LogicRoomController logicRoomControllerImpl = new LogicRoomController(myPubSub, deviceInfo, ui); 
	new Thread(logicRoomControllerImpl).start();
	
	
}

private static Device setUpDeviceInfo() {
    
	 name = "D3";
	 softwarePlatform = "JavaSE";
	 networkAddress =  "";
	
		
 
	
	List<String> regionIDs = new ArrayList<String>();
  List<String> regionLabels = new ArrayList<String>();
  
  regionIDs.add("computerLab13") ; 
  
  regionLabels.add("Room"); 
	
	Device device = new Device(name, softwarePlatform, networkAddress, regionIDs, regionLabels , abilities, mobileFlag);
	return device;    
}

@Override
public void startDevice(Object obj, Object context) {
	ui= (Context) obj;
	myContext=context;
	setUpNode(setUpDeviceInfo());
	
}

}