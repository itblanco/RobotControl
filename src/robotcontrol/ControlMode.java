package robotcontrol;

public enum ControlMode {
	POSITION(0), TEACH(1), FORCE(2), TORQUE(3), UNDEFINED(4);

	private int mode;

	private ControlMode(int _mode) {
		mode = _mode;
	}

	public int getValue() {
		return mode;
	}

	static public ControlMode get(int i) {
		switch (i) {
		case 0:
			return POSITION;
		case 1:
			return TEACH;
		case 2:
			return FORCE;
		case 3:
			return TORQUE;
		default:
			return UNDEFINED;
		}
	}
}
