package robotcontrol;

import java.nio.ByteBuffer;

import processing.core.*;
import processing.net.*;

public class URobot {
	Client client;
	String robotIP;
	int robotPort;
	JointPose homePosition;
	Pose currentPose;
	ByteBuffer msg;
	VersionMessage versionMessage;
	RobotModeData robotModeData;

	URobot(PApplet parent, String _robotIP) {
		robotIP = _robotIP;
		robotPort = 30002;
		client = new Client(parent, robotIP, robotPort);
		homePosition = new JointPose(0, -PConstants.PI / 2, 0, -PConstants.PI / 2, 0, 0);
		msg = ByteBuffer.allocate(79);
		// currentPose = client.available() > 0? getCurrentPose() : new Pose();
	}

	public void moveHome() {
		client.write("movej(" + homePosition.toString() + ")\n");
	}

	public void movec(Pose p1, Pose p2) {
		client.write("movec(" + p1.toString() + ", " + p2.toString() + ")\n");
	}

	public void movej(Pose p, float speed) {
		client.write("movej(" + p.toString() + ", v=" + speed + ")\n");
	}

	public void movej(JointPose p, float speed) {
		client.write("movej(" + p.pose + ", v=" + speed + ")\n");
	}

	public void movel(Pose p) {
		client.write("safetyCheck = is_within_safety_limits(" + p.toString() + ")\n");
		client.write("if safetyCheck:\n");
		client.write("    movel(" + p.toString() + ")\n");
		client.write("else:\n");

	}

	public void movel(JointPose p) {
		client.write("movel(" + p.pose + ")\n");
	}

	public void movep(Pose p) {
		client.write("movep(" + p.toString() + ")\n");
	}

	public void movep(JointPose p) {
		client.write("movep(" + p.pose + ")\n");
	}

	public void set_tcp(Pose p) {
		client.write("set_tcp(" + p.toString() + ")\n");
	}

	public Pose getCurrentPose() {
		int offset = 308;
		float x = (float) msg.getDouble(offset) * 1000;
		offset += Double.BYTES;
		float y = (float) msg.getDouble(offset) * 1000;
		offset += Double.BYTES;
		float z = (float) msg.getDouble(offset) * 1000;
		offset += Double.BYTES;
		float rx = (float) msg.getDouble(offset);
		offset += Double.BYTES;
		float ry = (float) msg.getDouble(offset);
		offset += Double.BYTES;
		float rz = (float) msg.getDouble(offset);
		offset += Double.BYTES;

		Pose p = new Pose(x, y, z, rx, ry, rz);
		currentPose = p;

		return currentPose;
	}

	int packageCount = 0;

	public void test() {
		if (client.available() > 0) {
			// System.out.println(client.readBytes().length, count);
			switch (packageCount) {
			case 0:
				updateBuffer();
				getVersionMessage();
				break;
			case 2:
				updateBuffer();
				getLoopMessage();
				packageCount = 1;
				break;
			default:
				break;
			}
			packageCount++;
		}
	}

	public void getVersionMessage() {
		versionMessage = new VersionMessage(msg);
		versionMessage.printVersionInfo();
	}

	public void getLoopMessage() {
		robotModeData = new RobotModeData(msg);
		robotModeData.printRobotData();

		/*
		 * System.out.println("---- ROBOT DATA ----"); getCurrentPose();
		 * 
		 * System.out.println("//// SUB_PACKAGE"); System.out.println("X: " +
		 * currentPose.x); System.out.println("Y: " + currentPose.y);
		 * System.out.println("Z: " + currentPose.z); System.out.println("RX: " +
		 * currentPose.rx); System.out.println("RY: " + currentPose.ry);
		 * System.out.println("RZ: " + currentPose.rz);
		 */

		/*
		 * while (count < 682) { int packageSize = msg.getInt(count); count +=
		 * Integer.BYTES; int packageType = msg.get(count); count ++; count +=
		 * packageSize - Integer.BYTES - 1; }
		 */
	}

	public void updateBuffer() {
		if (client.available() > 0) {
			msg = ByteBuffer.allocate(682);
			msg.put(client.readBytes(682));
		}
	}
}
