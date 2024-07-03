package com.gui.performance;
import com.bus.monitor.PerformanceMonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bus.monitor.PerformanceMonitor;
import com.gui.MainFrame;
import com.gui.client.ClientPanel;
import com.gui.common.CommonLabel;
import com.gui.common.CommonPanel;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerformancePanel extends JPanel {
    public final static String BACKGROUND = "0x00A571";
    public final static String FOREGROUND = "0x003927";
    private CommonPanel main_panel;
    private CommonLabel connect_label;
    private ButtonGroup button_group;
    private JRadioButton low_radio;
    private JRadioButton high_radio;
    private JLabel loader_label;
    private PerformanceMonitor performanceMonitor;
    private JLabel cpuLabel;
    private JLabel memoryLabel;
    private Timer timer;

    public PerformancePanel() {
        performanceMonitor = new PerformanceMonitor();
        cpuLabel = new JLabel();
        memoryLabel = new JLabel();

        this.setLocation(0, MainFrame.HEIGHT_TASKBAR);
        this.setSize(MainFrame.WIDTH_FRAME, MainFrame.HEIGHT_FRAME - MainFrame.HEIGHT_TASKBAR);
        this.setBackground(Color.decode(ClientPanel.BACKGROUND));
        this.setLayout(new GridLayout(2, 1));

        add(cpuLabel);
        add(memoryLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePerformanceMetrics();
            }
        });
        timer.start();

    }

    private void updatePerformanceMetrics() {
        double cpuLoad = performanceMonitor.getSystemCpuLoad();
        long freeMemory = performanceMonitor.getFreePhysicalMemorySize();
        long totalMemory = performanceMonitor.getTotalPhysicalMemorySize();

        cpuLabel.setText(String.format("CPU Load: %.2f%%", cpuLoad));
        memoryLabel.setText(String.format("Memory: %d/%d MB", (totalMemory - freeMemory) / (1024 * 1024), totalMemory / (1024 * 1024)));
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
//    }
}
