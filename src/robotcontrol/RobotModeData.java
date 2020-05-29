package robotcontrol;

import java.nio.ByteBuffer;

public class RobotModeData {
	ByteBuffer msg;
	 int packageSize;
	 int packageType;
	 long timeStamp;
	 boolean isRealRobotConnected;
	 boolean isRealRobotEnabled;
	 boolean isRobotPowerOn;
	 boolean isEmergencyStopped;
	 boolean isProtectiveStopped;
	 boolean isProgramRunning;
	 boolean isProgramPaused;
	 RobotMode robotMode;
	 ControlMode controlMode;
	 double targetSpeedFraction;
	 double speedScaling;
	 double targetSpeedFractionLimit;
	  
	  RobotModeData(ByteBuffer message) {
	    msg = message;
	    int count = 5;
	    packageSize = msg.getInt(count); count += Integer.BYTES;
	    packageType = msg.get(count); count++;
	    timeStamp = msg.getLong(count); count += Long.BYTES; 
	    isRealRobotConnected = msg.get(count) != 0; count++;
	    isRealRobotEnabled = msg.get(count) != 0; count++;
	    isRobotPowerOn = msg.get(count) != 0; count++;
	    isEmergencyStopped = msg.get(count) != 0; count++;
	    isProtectiveStopped = msg.get(count) != 0; count++;
	    isProgramRunning = msg.get(count) != 0; count++;
	    isProgramPaused = msg.get(count) != 0; count++;
	    robotMode = RobotMode.get(msg.get(count)); count++;
	    controlMode = ControlMode.get(msg.get(count)); count++;
	    targetSpeedFraction = msg.getDouble(count); count += Double.BYTES;
	    speedScaling = msg.getDouble(count); count += Double.BYTES;
	    targetSpeedFractionLimit = msg.getDouble(count); count += Double.BYTES;
	  }
	  
	  void printRobotData() {
	    System.out.println("---- ROBOT MODE DATA ----");
	    System.out.println("Package Size: " + packageSize);
	    System.out.println("Package Type: " + packageType);
	    System.out.println("timeStamp: " + timeStamp);
	    System.out.println("isRealRobotConnected: " + isRealRobotConnected);
	    System.out.println("isRealRobotEnabled: " + isRealRobotEnabled);
	    System.out.println("isRobotPowerOn: " + isRobotPowerOn);
	    System.out.println("isEmergencyStopped: " + isEmergencyStopped);
	    System.out.println("isProtectiveStopped: " + isProtectiveStopped);
	    System.out.println("isProgramRunning: " + isProgramRunning);
	    System.out.println("isProgramPaused: " + isProgramPaused);
	    System.out.println("robotMode: " + robotMode);
	    System.out.println("controlMode: " + controlMode);
	    System.out.println("targetSpeedFraction: " + targetSpeedFraction);
	    System.out.println("speedScaling: " + speedScaling);
	    System.out.println("targetSpeedFractionLimit: " + targetSpeedFractionLimit);
	    System.out.println();
	  }
}
