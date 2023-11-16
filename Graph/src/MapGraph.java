import java.util.ArrayList;
import java.util.Arrays;

public class MapGraph {
    public static Graph getMapGraph () {
        Graph cartagoGraph = new Graph();
        for (int i = 1; i < 75; i++) {
            Node node = new Node(Integer.toString(i));
            cartagoGraph.addNode(node);
        }
        Object[][]
                relations1, relations2, relations3, relations4, relations5,
                relations6, relations7, relations8, relations9, relations10,
                relations11 , relations12, relations13, relations14, relations15,
                relations16, relations17, relations18, relations19, relations20,
                relations21 , relations22, relations23, relations24, relations25,
                relations26, relations27, relations28, relations29, relations30,
                relations31 , relations32, relations33, relations34, relations35,
                relations36, relations37, relations38, relations39, relations40,
                relations41 , relations42, relations43, relations44, relations45,
                relations46, relations47, relations48, relations49, relations50,
                relations51 , relations52, relations53, relations54, relations55,
                relations56, relations57, relations58, relations59, relations60,
                relations61 , relations62, relations63, relations64, relations65,
                relations66, relations67, relations68, relations69, relations70,
                relations71 , relations72, relations73, relations74;

        relations1 = new Object[][]{
                {"2",10},
                {"6",4}
        };
        relations2 = new Object[][]{
                {"7",4},
                {"3",2}
        };
        relations3 = new Object[][]{
                {"4",7},
                {"8",8}
        };
        relations4 = new Object[][]{
                {"3",7},
                {"5",7}
        };
        relations5 = new Object[][]{
                {"4",7},
                {"9",7}
        };
        relations6 = new Object[][]{
                {"13",6},
                {"1",4}
        };
        relations7 = new Object[][]{
                {"2",4},
                {"6",10}
        };
        relations8 = new Object[][]{
                {"3",6},
                {"15",4},
                {"9",7}
        };
        relations9 = new Object[][]{
                {"8",7},
                {"4",8},
                {"16",4},
                {"10",10}
        };
        relations10 = new Object[][]{
                {"9",10},
                {"5",6},
                {"18",5},
                {"11",3}
        };
        relations11 = new Object[][]{
                {"10",3},
                {"19",5}
        };
        relations12 = new Object[][]{
                {"13",3}
        };
        relations13 = new Object[][]{
                {"14",3},
                {"12",2}
        };
        relations14 = new Object[][]{
                {"20",2},
                {"13",3},
                {"15",10}
        };
        relations15 = new Object[][]{
                {"8",4},
                {"21",4},
                {"14",10},
                {"16", 8}
        };
        relations16 = new Object[][]{
                {"9",4},
                {"22",5},
                {"15",7},
                {"17",7}
        };
        relations17 = new Object[][]{
                {"16",7},
                {"18",5},
                {"23",3}
        };
        relations18 = new Object[][]{
                {"17",5},
                {"24",3},
                {"19",5},
                {"10",6}
        };
        relations19 = new Object[][]{
                {"25",2},
                {"11",7},
                {"18",5}
        };
        relations20 = new Object[][]{
                {"14",2},
                {"21",10},
                {"26",12}
        };
        relations21 = new Object[][]{
                {"15",4},
                {"26",4},
                {"20",10}
        };
        relations22 = new Object[][]{
                {"16",4},
                {"27",5},
                {"23",7}
        };
        relations23 = new Object[][]{
                {"22",6},
                {"29",5},
                {"24",5},
                {"17",3}
        };
        relations24 = new Object[][]{
                {"23",6},
                {"30",5},
                {"25",5},
                {"18",3}
        };
        relations25 = new Object[][]{
                {"24",5},
                {"31",5},
                {"19",2}
        };
        relations26 = new Object[][]{
                {"20",12},
                {"33",5},
                {"21",4}
        };
        relations27 = new Object[][]{
                {"33",7},
                {"28",2},
                {"22",5}
        };
        relations28 = new Object[][]{
                {"27",2},
                {"30",5},
                {"29",5}
        };
        relations29 = new Object[][]{
                {"28",5},
                {"37",5},
                {"30",5},
                {"23",5}
        };
        relations30 = new Object[][]{
                {"29",5},
                {"38",5},
                {"31",5},
                {"24",5}
        };
        relations31 = new Object[][]{
                {"30",5},
                {"39",5},
                {"25",5}
        };
        relations32 = new Object[][]{
                {"33",20}
        };
        relations33 = new Object[][]{
                {"32",20},
                {"35",3},
                {"27",7},
                {"26",5}
        };
        relations34 = new Object[][]{
                {"41",3},
                {"35",12}
        };
        relations35 = new Object[][]{
                {"34",12},
                {"42",3},
                {"36",10},
                {"33",4}
        };
        relations36 = new Object[][]{
                {"35",10},
                {"43",5},
                {"37",5},
                {"28",5}
        };
        relations37 = new Object[][]{
                {"36",5},
                {"44",5},
                {"38",5},
                {"29",5}
        };
        relations38 = new Object[][]{
                {"37",5},
                {"45",5},
                {"39",5},
                {"30",5}
        };
        relations39 = new Object[][]{
                {"38",5},
                {"46",5},
                {"31",5}
        };
        relations40 = new Object[][]{
                {"41",5}
        };
        relations41 = new Object[][]{
                {"40",5},
                {"42",12},
                {"34",3}
        };
        relations42 = new Object[][]{
                {"41",12},
                {"49",9},
                {"35",3}
        };
        relations43 = new Object[][]{
                {"52",2},
                {"44",5},
                {"36",5}
        };
        relations44 = new Object[][]{
                {"43",5},
                {"54",5},
                {"45",5},
                {"37",5}
        };
        relations45 = new Object[][]{
                {"44",5},
                {"55",5},
                {"46",5},
                {"38",5}
        };
        relations46 = new Object[][]{
                {"45",5},
                {"57",5},
                {"39",5}
        };
        relations47 = new Object[][]{
                {"48",5}
        };
        relations48 = new Object[][]{
                {"47",5},
                {"59",5},
                {"49",12}
        };
        relations49 = new Object[][]{
                {"48",12},
                {"60",5},
                {"50",2},
                {"42",9}
        };
        relations50 = new Object[][]{
                {"49",2},
                {"61",5},
                {"51",2}
        };
        relations51 = new Object[][]{
                {"50",2},
                {"62",5},
                {"52",2}
        };
        relations52 = new Object[][]{
                {"51",2},
                {"53",3},
                {"43",2}
        };
        relations53 = new Object[][]{
                {"62",2},
                {"63",5},
                {"54",5},
                {"52",3}
        };
        relations54 = new Object[][]{
                {"53",5},
                {"64",5},
                {"55",5},
                {"44",5}
        };
        relations55 = new Object[][]{
                {"54",5},
                {"65",5},
                {"56",3},
                {"45",5}
        };
        relations56 = new Object[][]{
                {"55",3},
                {"57",2}
        };
        relations57 = new Object[][]{
                {"56",2},
                {"66",5},
                {"46",5}
        };
        relations58 = new Object[][]{
                {"67",5},
                {"59",5}
        };
        relations59 = new Object[][]{
                {"58",5},
                {"68",4},
                {"60",12},
                {"48",5}
        };
        relations60 = new Object[][]{
                {"59",12},
                {"71",5},
                {"61",2},
                {"49",5}
        };
        relations61 = new Object[][]{
                {"60",2},
                {"73",5},
                {"62",2},
                {"50",5}
        };
        relations62 = new Object[][]{
                {"61",2},
                {"74",5},
                {"53",2},
                {"51",5}
        };
        relations63 = new Object[][]{
                {"74",2},
                {"53",5},
                {"64",5}
        };
        relations64 = new Object[][]{
                {"63",5},
                {"65",5},
                {"54",5}
        };
        relations65 = new Object[][]{
                {"64",5},
                {"66",5},
                {"55",5}
        };
        relations66 = new Object[][]{
                {"65",5},
                {"57",5}
        };
        relations67 = new Object[][]{
                {"58",5},
                {"68",4}
        };
        relations68 = new Object[][]{
                {"67",4},
                {"69",1},
                {"59",4}
        };
        relations69 = new Object[][]{
                {"68",1},
                {"70",4}
        };
        relations70 = new Object[][]{
                {"69",4},
                {"71",4}
        };
        relations71 = new Object[][]{
                {"70",4},
                {"73",2}
        };
        relations72 = new Object[][]{
                {"73",1},
                {"74",1}
        };
        relations73 = new Object[][]{
                {"71",2},
                {"72",1}
        };
        relations74 = new Object[][]{
                {"72",1},
                {"63",2}
        };
        Object[] relationsList = new Object[]{relations1, relations2, relations3, relations4, relations5,
                relations6, relations7, relations8, relations9, relations10,
                relations11 , relations12, relations13, relations14, relations15,
                relations16, relations17, relations18, relations19, relations20,
                relations21 , relations22, relations23, relations24, relations25,
                relations26, relations27, relations28, relations29, relations30,
                relations31 , relations32, relations33, relations34, relations35,
                relations36, relations37, relations38, relations39, relations40,
                relations41 , relations42, relations43, relations44, relations45,
                relations46, relations47, relations48, relations49, relations50,
                relations51 , relations52, relations53, relations54, relations55,
                relations56, relations57, relations58, relations59, relations60,
                relations61 , relations62, relations63, relations64, relations65,
                relations66, relations67, relations68, relations69, relations70,
                relations71 , relations72, relations73, relations74};
        for (int i = 0; i < 73; i++) {
            Node node = cartagoGraph.getNodeByName(Integer.toString(i+1));
            cartagoGraph.addRelationsToNode(node.name, (Object[][]) relationsList[i]);
        }
        return cartagoGraph;
    }
}
