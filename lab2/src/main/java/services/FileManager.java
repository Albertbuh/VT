package services;

import beans.Lot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
    public static String writeFile(String fileName, String text) throws ServiceException{
        PrintWriter writer = null;
        if(!fileName.contains(".txt"))
            fileName += ".txt";

        try {
//            fileName += "!" + java.util.UUID.randomUUID();
            writer = new PrintWriter( fileName, StandardCharsets.UTF_8);
            writer.println(text);
            System.out.println("File has been written to " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(writer != null) {
                writer.close();
            }
        }
        return new File(fileName).getName();
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

                    System.out.println("Image uploaded");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (ServletException | IOException e) {
            System.out.println(e.getMessage());
        }

        return imageFileName;
    }




}
