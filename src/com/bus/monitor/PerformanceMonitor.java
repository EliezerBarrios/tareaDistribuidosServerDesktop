package com.bus.monitor;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class PerformanceMonitor {
    private OperatingSystemMXBean osBean;

    public PerformanceMonitor() {
        this.osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    public double getSystemCpuLoad() {
        return osBean.getSystemCpuLoad() * 100;
    }

    public double getProcessCpuLoad() {
        return osBean.getProcessCpuLoad() * 100;
    }

    public long getFreePhysicalMemorySize() {
        return osBean.getFreePhysicalMemorySize();
    }

    public long getTotalPhysicalMemorySize() {
        return osBean.getTotalPhysicalMemorySize();
    }

    public long getFreeSwapSpaceSize() {
        return osBean.getFreeSwapSpaceSize();
    }

    public long getTotalSwapSpaceSize() {
        return osBean.getTotalSwapSpaceSize();
    }
}
