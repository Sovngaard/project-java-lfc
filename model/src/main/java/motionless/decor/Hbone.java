package motionless.decor;

import ele.element.Element;
import ele.element.Sprite;
import ele.element.Permeability;


class Hbone extends MotionlessElement {

	public Forest() {
		super(new Sprite("horizontal_bone.jpg"), Permeability.BLOCKING, '!');
	}

}
