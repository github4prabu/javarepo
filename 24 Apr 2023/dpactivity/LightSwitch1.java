package dedalus.dpactivity;

public class LightSwitch1 {
	private State state;
    
    public LightSwitch1() {
        state = new RedState();
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public void redSwitch() {
        state.switchOnRed(this);
    }
    
    public void yellowSwitch() {
        state.switchOnYellow(this);
    }
    
    public void greenSwitch() {
        state.switchOnGreen(this);
    }
}
