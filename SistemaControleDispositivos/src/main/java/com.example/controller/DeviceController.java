package com.example.controller;

import com.example.devices.Device;
import java.util.List;
import java.util.ArrayList;

public class DeviceController {
    private static DeviceController instance;
    private final List<Device> devices = new ArrayList<>();

    private DeviceController() { }

    public static DeviceController getInstance() {
        if (instance == null) {
            instance = new DeviceController();
        }
        return instance;
    }

    public void registerDevice(Device device) {
        devices.add(device);
    }

    public void turnOnDevice(Device device) {
        device.turnOn();
    }

    public void turnOffDevice(Device device) {
        device.turnOff();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public Device getDeviceByName(String name) {
        for (Device device : devices) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }
        return null; // Dispositivo não encontrado
    }
}
