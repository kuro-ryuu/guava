

import java.util.Random;

public class johnname {
    public static void main(String[] args) {
        String[] Fname = {
            "Alphard","Ampiroy","Arnalio","Adachi","Aquioy","Ankuyw",
            "Berdoy","Bezuli","Boure","Bafloy","Bicao","Bendale","Brown",
            "Conroy","Caoman","Cleimain","Charduy","Clark","Cineilou","Cpolui",
            "Davy","Droi"
        };

        String[] Lname = {
            "Alerandoy","Alcetroz","Adams","Asemouily","Arthur","Ankevozich",
            "Borlak","Bernouli","Bourne","Bufula","Benjamin","Brund","Boujei"
        };
    
        System.out.println(Fname[new Random().nextInt(Fname.length)] + " " + Lname[new Random().nextInt(Lname.length)]);
    }
}
