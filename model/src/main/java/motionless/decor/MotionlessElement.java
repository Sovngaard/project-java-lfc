package motionless.decor;

import ele.element.Element;
import ele.element.Sprite;
import ele.element.Permeability;


abstract class MotionlessElement extends Element {
	private final char fileSymbol;

	public MotionlessElement(final Sprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}
}