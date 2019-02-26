import javafx.scene.control.Hyperlink;

import java.util.HashMap;

class Courses {
    HashMap<String, Hyperlink> getYearOneSemesterOne() {
        HashMap<String, Hyperlink> mappedObjects = new HashMap<>();
        mappedObjects.put("LFAC:", new Hyperlink("https://profs.info.uaic.ro/~otto/lfac.html?fbclid=IwAR3ZY-t52BUxdJJhr8Ua0gkvSa6ThKZYVZM6XmRle72rUMl1bJJkdhV1H-Y^"));
        mappedObjects.put("Graph Algorithms:", new Hyperlink("https://profs.info.uaic.ro/~olariu/curent/AG/AG.html?fbclid=IwAR0l9amS_ZZituJAIocLT3Vn4Z5DGP_rA5CNhSlKC7JZF5fngjWOGn-69jA^"));
        return mappedObjects;
    }

    HashMap<String, Hyperlink> getYearOneSemesterTwo() {
        HashMap<String, Hyperlink> mappedObjects = new HashMap<>();
        mappedObjects.put("Advanced Programming:", new Hyperlink("https://profs.info.uaic.ro/~acf/java/?fbclid=IwAR0Q_9it_krfVdgcYivBkDC28mDEQ3LODDvuD0E3b3rEaHaBLqU0E--jU0M^"));
        mappedObjects.put("DBMS Practice:", new Hyperlink("https://profs.info.uaic.ro/~bd/wiki/index.php/PLSQL_0?fbclid=IwAR1l0fRWYMVM9KWun2wQRFCAi_lBw0SGak2VkajHP0NyIKaWKHtBc3DsAPY^"));
        return mappedObjects;
    }
}
