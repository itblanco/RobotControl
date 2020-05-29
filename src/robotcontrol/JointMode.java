package robotcontrol;

public enum JointMode {
	RESET(235), SHUTTING_DOWN(236), PART_D_CALIBRATION(237), BACKDRIVE(238), POWER_OFF(239), NOT_RESPONDING(245),
	MOTOR_INITIALISATION(246), BOOTING(247), PART_D_CALIBRATION_ERROR(248), BOOTLOADER(249), CALIBRATION(250),
	VIOLATION(251), FAULT(252), RUNNING(253), IDLE(255);

	private int mode;

	private JointMode(int _mode) {
		mode = _mode;
	}

	public int getValue() {
		return mode;
	}
}
