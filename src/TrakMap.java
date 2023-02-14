import java.util.List;

public class TrakMap {

    public static void pintrace(List<Double> list1, List<Double> list2, String name1 , String name2) {
        StringBuilder racer1 = new StringBuilder();
        StringBuilder racer2 = new StringBuilder();

        for (Double d : list1
        ) {
            if (d < 10) {
                racer1.append("=");
            }
            if (d > 10 & d < 20) {
                racer1.append("==");
            }
            if (d > 20 & d < 30) {
                racer1.append("===");
            }
            if (d > 30) {
                racer1.append("===");

            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (Double d : list2
        ) {
            if (d < 10) {
                racer2.append("=");
            }
            if (d > 10 & d < 20) {
                racer2.append("==");
            }
            if (d > 20 & d < 30) {
                racer2.append("===");
            }
            if (d > 30) {
                racer2.append("===");

            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print(racer1 +" " +  name1 + "\n\t" + racer2 + " " + name2 + "\n\t");



    }
}