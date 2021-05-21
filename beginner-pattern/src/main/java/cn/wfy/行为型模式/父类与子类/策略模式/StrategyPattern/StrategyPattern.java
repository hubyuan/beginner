package cn.wfy.行为型模式.父类与子类.策略模式.StrategyPattern;

public class StrategyPattern {
    public static void main(String[] args) {

        ContextStra contextStra = new ContextStra(new OnePoint());
        contextStra.excuteStrategy(1);
        ContextStra contextStra2 = new ContextStra(new TwoPoint());
        contextStra2.excuteStrategy(2);


        StrategyPattern strategyPattern = new StrategyPattern() {
            void sayMessage1(String message) {
                System.out.println("32423");
            }
        };
//        Greeting greeting = message -> System.out.println("say:"+message);
        Greeting greeting = new Greeting() {
            @Override
            public void sayMessage(String message) {
                System.out.println(333333333);
            }
        };
    }

    void sayMessage1(String message) {
        System.out.println("123123");
    }
}
