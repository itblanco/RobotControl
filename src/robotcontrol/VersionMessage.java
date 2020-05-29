package robotcontrol;

import java.nio.ByteBuffer;

public class VersionMessage {
	  ByteBuffer msg;
	  int messageSize;
	  MessageType messageType;
	  long timeStamp;
	  MessageSource source;
	  int robotMessageType;
	  int projectNameSize;
	  String projectName;     
	  int majorVersion;
	  int minorVersion;
	  int bugFixVersion;
	  int buildNumber;
	  String buildDate;

	  public VersionMessage(ByteBuffer message) { 
	    msg = message;
	    int count = 0;
	    messageSize = msg.getInt(count); count += Integer.BYTES;
	    messageType = MessageType.get(msg.get(count)); count ++;
	    timeStamp = msg.getLong(count); count += Long.BYTES;
	    source = MessageSource.get(msg.get(count)); count++;
	    robotMessageType = msg.get(count); count ++;
	    projectNameSize = msg.get(count); count ++;
	    projectName = ""; 
	    for (int i = 0; i < projectNameSize; i++, count++) {
	      projectName += (char)msg.get(count);
	    }
	    majorVersion = msg.get(count); count ++;
	    minorVersion = msg.get(count); count ++;
	    bugFixVersion = msg.getInt(count); count += Integer.BYTES;   
	    buildNumber = msg.getInt(count); count += Integer.BYTES;
	    buildDate = "";
	    for (int i = 0, j = messageSize - count; i < j; i++, count++) {
	      buildDate += (char)msg.get(count);
	    }
	  }
	  
	  public void printVersionInfo() {
	    System.out.println("---- VERSION MESSAGE ----");
	    System.out.println("Message Size: " + messageSize);
	    System.out.println("Message Type: " + messageType);
	    System.out.println("timeStamp: " + timeStamp);
	    System.out.println("source: " + source);
	    System.out.println("robotMessageType: " + robotMessageType);
	    System.out.println("projectNameSize: " + projectNameSize);
	    System.out.println("projectName: " + projectName);
	    System.out.println("majorVersion: " + majorVersion);
	    System.out.println("minorVersion: " + minorVersion);
	    System.out.println("bugFixVersion: " + bugFixVersion);
	    System.out.println("buildNumber: " + buildNumber);
	    System.out.println("buildDate: " + buildDate);
	    System.out.println();
	  }
}
