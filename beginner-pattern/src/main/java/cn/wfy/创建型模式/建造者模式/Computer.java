package cn.wfy.创建型模式.建造者模式;


/***
 *
 * @Description Computer
 * @Author wfy
 * @Date 2021/5/24 17:01
 */
public class Computer {
    private final String cpu;
    private final String io;
    private final String keyboard;

    public Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.io = builder.io;
        this.keyboard = builder.keyboard;
    }

    public static class Builder{
        private String cpu; //must
        private String io;
        private String keyboard;

        public Builder(String cpu) {
            this.cpu = cpu;
        }


        public Builder setIo(String io) {
            this.io = io;
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public String getCpu() {
            return cpu;
        }

        public String getIo() {
            return io;
        }

        public String getKeyboard() {
            return keyboard;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
