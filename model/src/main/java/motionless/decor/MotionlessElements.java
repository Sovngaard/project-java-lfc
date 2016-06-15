package motionless.decor;

public abstract class MotionlessElements {
	public static final MotionlessElement	HBONE								= new Hbone(null, null, 0);
	public static final MotionlessElement	VBONE								= new Vbone(null, null, 0);
	public static final MotionlessElement	GATEO								= new Gateo(null, null, 0);
	public static final MotionlessElement	GATEC								= new Gatec(null, null, 0);
	public static final MotionlessElement	BACKGROUND							= new Background(null, null, 0);
	//public static final MotionlessElement	TOWN								= new Town();
	//public static final MotionlessElement	WATER								= new Water();

	private static MotionlessElement			motionlessElements[]	= { HBONE, VBONE, GATEO, GATEC,BACKGROUND};

	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getFileSymbol() == fileSymbol) {
				return motionlessElement;
			}
		}
		return BACKGROUND;
	}
}//