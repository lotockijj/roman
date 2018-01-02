package ss.one;

import java.io.Serializable;

public class RoadTrain extends Car implements Serializable{

	private static final long serialVersionUID = -4782761260020871875L;

	public RoadTrain(double permissibleSpeed, double turningRadius) {
		super(permissibleSpeed, turningRadius);
	}

}
