package cn.wfy.abstractClass;

public class RealMotor extends BatteryPoweredMotor {
    @Override
    public int getTimeToRecharge() {
        return 0;
    }

    @Override
    public int getHorsepower() {
        return 0;
    }
}
