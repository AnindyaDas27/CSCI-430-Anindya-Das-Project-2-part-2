package ui;

import javax.swing.*;

public abstract class UIState extends JPanel {
    protected UIContext context;

    public UIState(UIContext ctx) {
        this.context = ctx;
    }

    protected void goTo(String stateName) {
        context.showState(stateName);
    }
}
