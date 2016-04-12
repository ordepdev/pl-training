package com.ordepdev.state;

import java.util.Comparator;

public class Fan {

    State fanOffState;
    State fanLowState;
    State fanMedState;

    private State state;

    public Fan() {
        fanOffState = new FanOffState(this);
        fanLowState = new FanLowState(this);
        fanMedState = new FanMedState(this);
    }

    public void pullChain() {
        state.handleRequest();
    }

    @Override
    public String toString() {
        return state.toString();
    }

    public State getFanLowState() {
        return fanOffState;
    }

    public State getFanMedState() {
        return fanMedState;
    }

    public State getFanOffState() {
        return fanOffState;
    }

    public void setState(State state) {
        this.state = state;
    }
}
