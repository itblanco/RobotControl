package robotcontrol;

public enum MessageSource {
	UNDEFINED(-1), JOINT_0(0), JOINT_1(1), JOINT_2(2), JOINT_3(3), JOINT_4(4), JOINT_5(5), TOOL(6), EUROMAP_2(68),
	EUROMAP_1(67), TEACH_PENDANT_2(66), TEACH_PENDANT_1(65), SAFETY_PROCESSOR_UA(20), SAFETY_PROCESSOR_UB(30),
	ROBOTINTERFACE(-2), RTMACHINE(-3), SIMULATED_ROBOT(-4), GUI(-5), CONTROLLER(7), RTDE(8);

	private int val;

	private MessageSource(int _val) {
		val = _val;
	}

	public int getValue() {
		return val;
	}

	static public MessageSource get(int i) {
		switch (i) {
		case -1:
			return UNDEFINED;
		case 0:
			return JOINT_0;
		case 1:
			return JOINT_1;
		case 2:
			return JOINT_2;
		case 3:
			return JOINT_3;
		case 4:
			return JOINT_4;
		case 5:
			return JOINT_5;
		case 6:
			return TOOL;
		case 68:
			return EUROMAP_2;
		case 67:
			return EUROMAP_1;
		case 66:
			return TEACH_PENDANT_2;
		case 65:
			return TEACH_PENDANT_1;
		case 20:
			return SAFETY_PROCESSOR_UA;
		case 30:
			return SAFETY_PROCESSOR_UB;
		case -2:
			return ROBOTINTERFACE;
		case -3:
			return RTMACHINE;
		case -4:
			return SIMULATED_ROBOT;
		case -5:
			return GUI;
		case 7:
			return CONTROLLER;
		case 8:
			return RTDE;
		default:
			return UNDEFINED;
		}
	}
}
