package robotcontrol;

import processing.core.PVector;

public class Pose {
	float x, y, z, rx, ry, rz;

	  public Pose(float _x, float _y, float _z, float _rx, float _ry, float _rz) {
	    x = _x; y = _y; z = _z;
	    rx = _rx; ry = _ry; rz = _rz;
	  }

	  public Pose(PVector p1, PVector p2) {
	    x = p1.x; y = p1.y; z = p1.z;
	    rx = p2.x; ry = p2.y; rz = p2.z;
	  }
	  
	  public Pose() {
	    
	  }

	  public String interpolate_pose(Pose p, float alpha) {
	    return "interpolate_pose(" + toString() + ", " + p.toString() + ", " + alpha + ")\n";
	  }
	  
	  public String toString() {
	    return String.format("p[%.9s, %.9s, %.9s, %.9s, %.9s, %.9s]", x, y, z, rx, ry, rz);
	  }
}
