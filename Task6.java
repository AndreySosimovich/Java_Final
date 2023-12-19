/*Подумать над структурой класса Ноутбук для магазина техники-выделить поля и методы.Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.*/

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Laptop {

    private String name;
    private int ram;
    private int storageCap;
    private String os;
    private String color;
    private double diagonal;

    public Laptop(String name, int ram, int storageCap, String os, String color, double diagonal) {
        this.name = name;
        this.ram = ram;
        this.storageCap = storageCap;
        this.os = os;
        this.color = color;
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return String.format(
                "Название: %s \n объем оперативной памяти: %d Гб \n объем накопителя %d Гб \n ОС %s \n Цвет %s \n Диагональ %.1f \n",
                this.name, this.ram, this.storageCap, this.os, this.color, this.diagonal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Laptop) {
            return this.name.equals(((Laptop) obj).name) && this.ram == ((Laptop) obj).ram
                    && this.storageCap == ((Laptop) obj).storageCap && this.os.equals(((Laptop) obj).os)
                    && this.color.equals(((Laptop) obj).color) && this.diagonal == ((Laptop) obj).diagonal;
        }
        return false;
    }

    public int getRam() {
        return this.ram;
    }

    public int getStorageCap() {
        return this.storageCap;
    }

    public String getOS() {
        return this.os;
    }

    public double getDiagonal() {
        return this.diagonal;
    }
}

class App {
    public static void main(String[] args) throws Exception {
        Laptop laptop1 = new Laptop("Lenovo IdealPad 5", 8, 256, "Windows 11", "синий", 15.6);
        Laptop laptop2 = new Laptop("Honor MagicBook 16", 16, 512, "без ОС", "серый", 16.1);
        Laptop laptop3 = new Laptop("Apple MacBook Air 13", 8, 256, "MacOs", "золотистый", 13.3);
        Laptop laptop4 = new Laptop("HP 250 G7", 4, 1024, "без ОС", "черный", 15.6);
        Laptop laptop5 = new Laptop("MSI GF76 Katana 17", 8, 256, "без ОС", "чёрный", 17.3);
        Laptop laptop6 = new Laptop("IRBIS NB290", 4, 128, "Windows 10", "чёрный", 15.6);
        Laptop laptop7 = new Laptop("ASUS Laptop 15", 4, 1000, "Windows 10", "чёрный", 15.6);
        Laptop laptop8 = new Laptop("Acer Extensa 15", 4, 256, "Windows 11", "чёрный", 15.6);
        Laptop laptop9 = new Laptop("ASUS Vivobook Go 15", 8, 512, "Windows 11", "серый", 15.6);
        Laptop laptop10 = laptop1;
        Set<Laptop> unicLaptop = new HashSet<Laptop>();
        unicLaptop.add(laptop1);
        unicLaptop.add(laptop2);
        unicLaptop.add(laptop3);
        unicLaptop.add(laptop4);
        unicLaptop.add(laptop5);
        unicLaptop.add(laptop6);
        unicLaptop.add(laptop7);
        unicLaptop.add(laptop8);
        unicLaptop.add(laptop9);
        unicLaptop.add(laptop10);
        System.out.printf("Первый ноутбук идентичен десятому: %b \n", laptop1.equals(laptop6));
        System.out.printf("Всего уникалных ноутбуков: %d \n", unicLaptop.size());
        Map<Integer, String> mapCrit = new HashMap<>();
        mapCrit.put(1, "объем оперативной памяти");
        mapCrit.put(2, "объем накопителя");
        mapCrit.put(3, "ОС");
        mapCrit.put(4, "цвет");
        mapCrit.put(5, "диагональ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите желаемые характеристики: 1. объем оперативной памяти: ");
        int ramUser = sc.nextInt();
        System.out.println("объем накопителя: ");
        int storUser = sc.nextInt();
        System.out.println("диагональ");
        double digUser = sc.nextDouble();
        for (Laptop lap : unicLaptop) {
            if ((lap.getRam() >= ramUser) && (lap.getStorageCap() >= storUser) && lap.getDiagonal() >= digUser) {
                System.out.println(lap.toString());
            }
        }
        sc.close();
    }
}