package com.example.devices;

public class Fan implements Device {
    private String name;
    private boolean isOn = false; // Adicione um campo de controle de estado

    public Fan(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void turnOn() {
        if (!isOn) { // Verifica se o dispositivo já está ligado
            isOn = true;
            System.out.println(name + " ligado.");
        } else {
            System.out.println(name + " já está ligado.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) { // Verifica se o dispositivo já está desligado
            isOn = false;
            System.out.println(name + " desligado.");
        } else {
            System.out.println(name + " já está desligado.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}
