package org.emall.cn.core.design.model.facade;

/**
 * @Description 外观模式 解决类与类之间的耦合度
 * 此处以计算机的启动为例，计算机启动时有硬盘的启动。cpu的启动、内存的启动
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer(CPU cpu, Memory memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }
    public void shutup(){
        System.out.println("Computer start shutup");
        cpu.shutup();
        memory.shutup();
        disk.shutup();
        System.out.println("Computer finish shutup");
    }
    public void shutdown(){
        System.out.println("Computer start shutdown");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("Computer finish shutdown");
    }

    public static void main(String[] args) {
        Computer computer=new Computer(new CPU(),new Memory(),new Disk());
        computer.shutup();
        computer.shutdown();
    }
}
