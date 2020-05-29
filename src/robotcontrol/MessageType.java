package robotcontrol;

public enum MessageType {
	DISCONNECT(-1), ROBOT_STATE(16), ROBOT_MESSAGE(20), HMC_MESSAGE(22), MODBUS_INFO_MESSAGE(5),
	SAFETY_SETUP_BROADCAST_MESSAGE(23), SAFETY_COMPLIANCE_TOLERANCES_MESSAGE(24), PROGRAM_STATE_MESSAGE(25);

	private int val;

	private MessageType(int _val) {
		val = _val;
	}

	public int getValue() {
		return val;
	}

	static public MessageType get(int i) {
		switch (i) {
		case -1:
			return DISCONNECT;
		case 16:
			return ROBOT_STATE;
		case 20:
			return ROBOT_MESSAGE;
		case 22:
			return HMC_MESSAGE;
		case 5:
			return MODBUS_INFO_MESSAGE;
		case 23:
			return SAFETY_SETUP_BROADCAST_MESSAGE;
		case 24:
			return SAFETY_COMPLIANCE_TOLERANCES_MESSAGE;
		case 25:
			return PROGRAM_STATE_MESSAGE;
		default:
			return DISCONNECT;
		}
	}
}
