package ele.element;

import java.awt.Image;
import aedt.showboard.ISquare;

public abstract class Element implements ISquare {
	private Sprite				sprite;
	private Permeability	permeability;
	private NettleWorld		nettleWorld;

	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	private void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	public NettleWorld getNettleWorld() {
		return this.nettleWorld;
	}

	public void setNettleWorld(final NettleWorld nettleWorld) {
		this.nettleWorld = nettleWorld;
	}

	@Override
	public Image getImage() {
		return this.getSprite().getImage();
	}
}
