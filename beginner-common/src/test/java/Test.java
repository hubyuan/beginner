import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        int id = 2100;
        int index = 2;
        int birth = 166;
        int deathyear = 266;
        int debutyear = 182;
//        9、13
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 50; i++) {


            String str = "<people id=\"" + id + "\"surname=\"诸葛\"name=\""+id+"\"word=\"---\"namesortid=\"0\"sex=\"1\"ethnic=\"0\"character=\"0\"birth=\"160\"deathyear=\"260\"debutyear=\"176\"icon=\"1\"solores1=\"lvbu\"soundtype=\"1\"officialtype=\"2\"score=\"4\"mainweapontype=\"0\"subweapontype=\"1\"itemmainweapontype=\"12\"solotype=\"2\"identity=\"0\"career=\"0\"official=\"-1\"prestige=\"99999\"notoriety=\"0\"entryyear=\"0\"loyalty=\"100\"specialskill=\"9\">\n" + "<desc0></desc0>\n" + "<desc1></desc1>\n" + "<desc2></desc2>\n" + "       <specialattributes>377,296,290,294,289,293,286,287,376,292</specialattributes>\n" + "       <individuality>15,1,145</individuality>\n" + "       <interest>3,3,3,3,3,3,3,3,3</interest>\n" + "       <rate>0,0,0,0,0,0,0</rate>\n" + "       <achieve>0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0</achieve>\n" + "       <relation>\n" + "\t\t\t<ancestors id=\"2000\"/>\t\t\t<ancestors1 id=\"2000\"/>\t\t\t<father id=\"0\"/>\t\t\t<mother id=\"0\"/>\t\t\t<enemy id=\"0\"/>\t\t\t<wife></wife>\n" + "\t\t\t<brother></brother>\n" + "\t\t\t<child></child>\n" + "\t\t\t<friend></friend>\n" + "\t\t\t<hategeneral></hategeneral>\n" + "       </relation>\n" + "       <ability>256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256</ability>\n" + "       <skill>50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50</skill>\n" + "       <cof count=\"0\"></cof>\n" + "   </people>";
            stringBuilder.append(str);
            id += 1;
        }
        for (int i = 0; i < 50; i++) {


            String str = "<people id=\""+id+"\"surname=\"全\"name=\""+id+"\"word=\"---\"namesortid=\"0\"sex=\"0\"ethnic=\"0\"character=\"0\"birth=\"160\"deathyear=\"260\"debutyear=\"176\"icon=\"14\"solores1=\"zhurong\"soundtype=\"0\"officialtype=\"2\"score=\"4\"mainweapontype=\"1\"subweapontype=\"0\"itemmainweapontype=\"12\"solotype=\"0\"identity=\"0\"career=\"0\"official=\"-1\"prestige=\"99999\"notoriety=\"0\"entryyear=\"0\"loyalty=\"100\"specialskill=\"13\">\n" + "<desc0></desc0>\n" + "<desc1></desc1>\n" + "<desc2></desc2>\n" + "       <specialattributes>285,291,288,295,284,292,376,287,377,286</specialattributes>\n" + "       <individuality>15,1,145</individuality>\n" + "       <interest>3,3,3,3,3,3,3,0,3</interest>\n" + "       <rate>0,0,0,0,0,0,0</rate>\n" + "       <achieve>0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0</achieve>\n" + "       <relation>\n" + "\t\t\t<ancestors id=\"2001\"/>\t\t\t<ancestors1 id=\"2001\"/>\t\t\t<father id=\"0\"/>\t\t\t<mother id=\"0\"/>\t\t\t<enemy id=\"0\"/>\t\t\t<wife></wife>\n" + "\t\t\t<brother></brother>\n" + "\t\t\t<child></child>\n" + "\t\t\t<friend></friend>\n" + "\t\t\t<hategeneral></hategeneral>\n" + "       </relation>\n" + "       <ability>256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256,256</ability>\n" + "       <skill>50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50</skill>\n" + "       <cof count=\"0\"></cof>\n" + "   </people>";
            stringBuilder.append(str);
            id += 1;
        }

        System.out.println(stringBuilder.toString());
    }
}
