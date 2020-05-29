package robotcontrol;

public enum RobotMode {
	NO_CONTROLLER(-1), DISCONNECTED(0), CONFIRM_SAFETY(1), BOOTING(2), POWER_OFF(3), POWER_ON(4), IDLE(5), BACKDRIVE(6),
	RUNNING(7), UPDATING_FIRMWARE(8);

	private int mode;

	private RobotMode(int _mode) {
		mode = _mode;
	}

	public int getValue() {
		return mode;
	}

	static public RobotMode get(int i) {
		switch (i) {
		case -1:
			return NO_CONTROLLER;
		case 0:
			return DISCONNECTED;
		case 1:
			return CONFIRM_SAFETY;
		case 2:
			return BOOTING;
		case 3:
			return POWER_OFF;
		case 4:
			return POWER_ON;
		case 5:
			return IDLE;
		case 7:
			return RUNNING;
		case 8:
			return UPDATING_FIRMWARE;
		default:
			return NO_CONTROLLER;
		}
	}
}
