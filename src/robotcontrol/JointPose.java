package robotcontrol;

public class JointPose {
	String pose;
	  float x, y, z, rx, ry, rz;

	  public JointPose(float _x, float _y, float _z, float _rx, float _ry, float _rz) {
	    x = _x; y = _y; z = _z;
	    rx = _rx; ry = _ry; rz = _rz;
	  }
	  
	  public String toString() {
	    return String.format("[%.9s, %.9s, %.9s, %.9s, %.9s, %.9s]", x, y, z, rx, ry, rz);
	  }
}
