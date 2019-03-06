package ec.edu.espe.as.solange;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 * @author jhona
 */
public class File {

    public void start() {
        java.io.File file = new java.io.File("c:\\tmp\\hotel.txt");
        List<String> readLines = null;
        try {
            readLines = verificateFiles(file);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        if (readLines != null) {
            convertData(readLines);
        }
    }

    private List<String> verificateFiles(java.io.File file) throws IOException {
        List<String> readLines;
        if (file.exists()) {
            readLines = FileUtils.readLines(file, "UTF-8");
        } else {

            readLines = null;
        }
        return readLines;
    }

    private void convertData(List<String> readSource) {
        Iterator iter = readSource.iterator();
        String[] values;
        StringBuilder sb = new StringBuilder();
        String type;
        String[] days = {};
        Hotel hotel = new Hotel();
        int cont = 0;
        while (iter.hasNext()) {
            values = iter.next().toString().split("\n");
            for (String val : values) {
                type = val.split(":")[0];
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(val);
                System.out.println(val);
                String aux="";
                while (m.find()) {
                    aux = aux+ m.group(1) + " ";
                }
                days = aux.split(" ");                
                System.out.println(hotel.findHotel(days,type));   
                aux="";
            }
        }
    }
}
//darasme qcredito o recomendaciones con el jefe jaja :'v
