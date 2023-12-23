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

class Notebook {
    private String name;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private double diagonal;

    public Notebook(String name, int ram, int hdd, String os, String color, double diagonal) {
        this.name = name;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return String.format(
                "Название: %s \n Объем оперативной памяти: %d Гб \n Размер жесткого диска %d Гб \n ОС %s \n Цвет %s \n Диагональ %.1f \n",
                this.name, this.ram, this.hdd, this.os, this.color, this.diagonal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Notebook) {
            return this.name.equals(((Notebook) obj).name) && this.ram == ((Notebook) obj).ram
                    && this.hdd == ((Notebook) obj).hdd && this.os.equals(((Notebook) obj).os)
                    && this.color.equals(((Notebook) obj).color) && this.diagonal == ((Notebook) obj).diagonal;
        }
        return false;
    }

    public int getRam() {
        return this.ram;
    }

    public int gethdd() {
        return this.hdd;
    }

    public String getOS() {
        return this.os;
    }

    public double getDiagonal() {
        return this.diagonal;
    }
}

class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Notebook Notebook1 = new Notebook("Huawei MateBook D15", 8, 256, "Windows 11", "серый", 15.6);
        Notebook Notebook2 = new Notebook("TECNO MegaBook T1", 8, 512, "Windows 11", "серый", 15.6);
        Notebook Notebook3 = new Notebook("MSI Sword 17 ", 32, 1024, "Free DOS", "белый,", 17.3);
        Notebook Notebook4 = new Notebook("Digma EVE P5850", 8, 256, "Windows 11", "серый", 15.6);
        Notebook Notebook5 = new Notebook("Huawei MateBook D14", 8, 512, "Windows 11", "чёрный", 14);
        Notebook Notebook6 = new Notebook("MSI Stealth GS77", 32, 1024, "Windows 11", "чёрный", 17.3);
        Notebook Notebook7 = new Notebook("Apple MacBook Pro", 32, 1000, "Mac OS", "серый", 16.2);
        Set<Notebook> unicNotebook = new HashSet<Notebook>();
        unicNotebook.add(Notebook1);
        unicNotebook.add(Notebook2);
        unicNotebook.add(Notebook3);
        unicNotebook.add(Notebook4);
        unicNotebook.add(Notebook5);
        unicNotebook.add(Notebook6);
        unicNotebook.add(Notebook7);
        System.out.printf("В наличии %d ноутбуков:\n", unicNotebook.size());
        Map<Integer, String> mapCrit = new HashMap<>();
        mapCrit.put(1, "Объем оперативной памяти");
        mapCrit.put(2, "Размер жесткого диска");
        mapCrit.put(3, "ОС");
        mapCrit.put(4, "Цвет");
        mapCrit.put(5, "Диагональ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите желаемые характеристики: 1. Объем оперативной памяти: ");
        int ramUser = sc.nextInt();
        System.out.println("Размер жесткого диска: ");
        int storUser = sc.nextInt();
        System.out.println("Диагональ");
        double digUser = sc.nextDouble();
        for (Notebook lap : unicNotebook) {
            if ((lap.getRam() >= ramUser) && (lap.gethdd() >= storUser) && lap.getDiagonal() >= digUser) {
                System.out.println(lap.toString());
            }
        }
        sc.close();
    }
}
