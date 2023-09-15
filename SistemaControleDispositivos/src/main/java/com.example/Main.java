package com.example;

import com.example.controller.DeviceController;
import com.example.devices.Device;
import com.example.devices.Lamp;
import com.example.devices.Fan;
import com.example.devices.TV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DeviceController controller = DeviceController.getInstance();
        Scanner scanner = new Scanner(System.in);

        // Crie instâncias dos dispositivos e registre-os no controlador
        Device lamp = new Lamp("Lamp");
        Device fan = new Fan("Fan");
        Device tv = new TV("TV");

        controller.registerDevice(lamp);
        controller.registerDevice(fan);
        controller.registerDevice(tv);

        // Exibe a lista de dispositivos registrados
        System.out.println("Dispositivos registrados:");
        for (Device device : controller.getDevices()) {
            System.out.println("- " + device.getName());
        }

        while (true) {
            System.out.println("\nEscolha um dispositivo para ligar/desligar (ou digite 'sair' para encerrar):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break; // Encerra o programa
            }

            Device device = controller.getDeviceByName(input);
            if (device != null) {
                // Verifique o estado do dispositivo e alterne entre ligar e desligar
                if (device.isOn()) {
                    controller.turnOffDevice(device);
                } else {
                    controller.turnOnDevice(device);
                }
            } else {
                System.out.println("Dispositivo não encontrado.");
            }
        }
    }
}
