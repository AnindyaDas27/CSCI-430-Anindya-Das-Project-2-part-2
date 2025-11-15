package ui;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends UIState {
    public LoginPanel(UIContext ctx) {
        super(ctx);
        setLayout(new GridLayout(4,1,10,10));

        JLabel title = new JLabel("Warehouse System Login", SwingConstants.CENTER);
        JButton clientBtn = new JButton("Login as Client");
        JButton clerkBtn = new JButton("Login as Clerk");
        JButton managerBtn = new JButton("Login as Manager");

        clientBtn.addActionListener(e -> goTo("CLIENT"));
        clerkBtn.addActionListener(e -> goTo("CLERK"));
        managerBtn.addActionListener(e -> goTo("MANAGER"));

        add(title); add(clientBtn); add(clerkBtn); add(managerBtn);
    }
}
