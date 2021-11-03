package Tools;

public class SDCalculator {

    public static void printInfo(double DAU, String type, String operation, int size, double ratio) {
        double dau = 0;
        if (type == "M") {
            dau = DAU * 1000000;
        } else if (type == "B") {
            dau = DAU * 1000000000;
        }
        //Assume size is Byte
        double perSecond = dau / 86400;
        System.out.println(operation + ":  " + perSecond + "/s");

        //Assume peak time is 50% higher
        System.out.println("Peak time " + operation + ":  " + perSecond * 1.5 + "/s");

        //Bandwidth estimates
        double perSecBandWidth = perSecond * size;
        //System.out.println("Peak time band width" + operation + ":  " + perSecBandWidth * 1.5 / 1024 + "KB/s");

        if (size <= 0)  //Read operation
            return;
        //Daily storage  write
        int ByteToKB = 1024;
        int KBToMB = 1024;
        int MBToGB = 1024;
        int GBToTB = 1000;
        double storagePerDay = ratio * dau * size / (ByteToKB* KBToMB * MBToGB);
        System.out.println("storage per day: " + storagePerDay + " GB/day");
        double storage5Year = storagePerDay * 365 * 5;
        if (storage5Year < 1000) {
            System.out.println("storage 5 year: " + storage5Year + " GB/5 years");
        } else
            System.out.println("storage 5 year: " + storage5Year / GBToTB + " TB/5 years");

    }

    public static void main(String[] args) {
        //printInfo(2, "M", "Read", 0, 1.0);
        printInfo(2, "M", "Write", 200000, 1);
    }
}
