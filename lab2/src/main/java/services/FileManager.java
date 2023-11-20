package services;

import beans.Lot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
    private static final Logger logger = LoggerFactory.getLogger("FileManager");
    public static String writeFile(String fileName, String text) throws ServiceException{
        PrintWriter writer = null;
        if(!fileName.contains(".txt"))
            fileName += ".txt";

        try {
//          fileName += "!" + java.util.UUID.randomUUID();
            writer = new PrintWriter( fileName, StandardCharsets.UTF_8);
            writer.println(text);
            System.out.println("File has been written to " + fileName);
        } catch (IOException e) {
            logger.error("writeFile: {}", e.getMessage());
        }
        finally {
            if(writer != null) {
                writer.close();
            }
        }
        return new File(fileName).getName();
    }

   private static String readFile(String path) {
        var sb = new StringBuilder();
       try (BufferedReader br = new BufferedReader(new FileReader(path))) {
           String line;
           while ((line = br.readLine()) != null) {
               sb.append(line);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return sb.toString();
   }

   public static String readLotDescription(String fileName) {
        return readFile(Lot.defaultDescDir + fileName);
   }
    public static String writeLotDescriptionToFile(String fileName, String text) throws ServiceException{
        return writeFile(Lot.defaultDescDir + fileName, text);
    }


    public static String uploadLotImageFromRequest(HttpServletRequest request, String partName) {
        String imageFileName = "";
        try {
            Part filePart = request.getPart(partName);
            imageFileName = filePart.getSubmittedFileName();
            InputStream imageInputStream = filePart.getInputStream();

            if(!imageFileName.isEmpty()) {
//                 imageFileName = imageFileName + '!' + java.util.UUID.randomUUID();

                try (FileOutputStream fos = new FileOutputStream(Lot.defaultImgDir + imageFileName)) {
                    byte[] bytes = new byte[1024];
                    while ((imageInputStream.read(bytes)) != -1) {
                        fos.write(bytes);
                    }

                    logger.info("Image uploaded");
                } catch (IOException e) {
                    logger.error("uploadLotImageFromRequest: {}", e.getMessage());
                }
            }
        } catch (ServletException | IOException e) {
            logger.error("uploadLotImageFromRequest: {}", e.getMessage());
        }

        return imageFileName;
    }

}
