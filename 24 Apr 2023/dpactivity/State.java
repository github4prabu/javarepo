package dedalus.dpactivity;

public interface State {
	void switchOnRed(LightSwitch1 lightSwitch);
	void switchOnYellow(LightSwitch1 lightSwitch);
	void switchOnGreen(LightSwitch1 lightSwitch);
}
