package cn.wfy.行为型模式.父类与子类.策略模式.StrategyPattern;

public class ContextStra {
    private StrategyInf strategyInf;

    public ContextStra() {
    }

    public ContextStra(StrategyInf strategyInf) {
        this.strategyInf = strategyInf;
    }

    public void excuteStrategy(int point) {
        strategyInf.getPoint(point);
    }

}
