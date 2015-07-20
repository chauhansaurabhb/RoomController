package logic;

import iotsuite.pubsubmiddleware.PubSubMiddleware;
import android.content.Context;
import iotsuite.semanticmodel.*;
import framework.*;
	   	


public class  LogicRoomController extends RoomController  { 


	 private double avgTempValue = 0;
	 
	    public LogicRoomController(PubSubMiddleware pubSubM, Device deviceInfo,
	            Object ui) {
	        super(pubSubM, deviceInfo);
	    }
	 
	    public void onNewroomAvgTempMeasurement(TempStruct arg) {
	 
	        avgTempValue = arg.gettempValue();
	 
	        if (avgTempValue <= 25 || avgTempValue >= 20) {
	            SetTemp(new TempStruct(avgTempValue, "C"));
	            // maintain temperature between 20'C-28'C
	        }
	 
	    }
		
		
		
		
		
}