
public class TestBuilderPattern {
    public static void main(String[] args) {
        // ..... Creating different configurations of Computer using the Builder
        // pattern.........
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("ASUS ROG")
                .setPowerSupply("750W")
                .setCoolingSystem("Liquid Cooling")
                .setCaseType("Tower")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setMotherboard("Gigabyte B450")
                .setPowerSupply("500W")
                .setCaseType("Mini Tower")
                .build();

        // ..........Printing the configurations.........
        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
