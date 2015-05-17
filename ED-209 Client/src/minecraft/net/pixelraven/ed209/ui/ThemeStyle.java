package net.pixelraven.ed209.ui;

import java.awt.Color;

public class ThemeStyle {
	private float redEnabledColour = 0.0f;
	private float greenEnabledColour = 1.0f;
	private float blueEnabledColour = 1.0f;
	private float redDisabledColour = 0.2f;
	private float greenDisabledColour = 0.2f;
	private float blueDisabledColour = 0.2f;

	public Color getDisabledColour() {
		return new Color(redDisabledColour, greenDisabledColour, blueDisabledColour);
	}

	public Color getEnabledColour() {
		return new Color(redEnabledColour, greenEnabledColour, blueEnabledColour);
	}

	public void setDisabledColour(Color newColour) {
		redDisabledColour = newColour.getRed();
		greenDisabledColour = newColour.getGreen();
		blueDisabledColour = newColour.getBlue();
	}

	public void setEnabledColour(Color newColour) {
		redEnabledColour = newColour.getRed();
		greenEnabledColour = newColour.getGreen();
		blueEnabledColour = newColour.getBlue();
	}
}
