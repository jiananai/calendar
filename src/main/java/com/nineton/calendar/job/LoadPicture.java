package com.nineton.calendar.job;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.nineton.calendar.pojo.Theme;
import com.nineton.calendar.service.ThemeService;
import javassist.ClassPath;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoadPicture {
    private Logger log = LoggerFactory.getLogger(LoadPicture.class);

    @Autowired
    private ThemeService themeService;

    @Scheduled(initialDelay = 1000*10,fixedDelay = 1000*60*60*24)
    public void work() {
        List<Theme> themes=themeService.findAllTheme();
        List<String> list=new ArrayList<>();
        for(Theme theme:themes){
            list.add(theme.getFileName());
        }
        String url = "http://vinwapgames.com/3dparallaxcool/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String linkHref = link.attr("abs:href");
                String linkName = link.text();
                if(list.contains("img/"+linkName)){
                    continue;
                }
                //System.out.println(linkName);
                Document document = Jsoup.connect(linkHref).get();
                Elements pngs = document.select("a[href~=(?i)\\.(png|jpg)]");
                int count=0;
                for (Element png : pngs) {
                    count++;
                    String imgHref = png.attr("abs:href");
                    // System.out.println(imgHref);
                    String imgName = png.text();
                    File file = new File("img/" + linkName);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    downloadPicture(imgHref, "img/" + linkName + imgName);
                }
                if(count!=0){
                    Theme theme=new Theme();
                    theme.setThemeId(Integer.parseInt(linkName.substring(0,linkName.length()-1)));
                    theme.setFileName("img/" + linkName);
                    themeService.insertTheme(theme);
                }
            }
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    private void downloadPicture(String urlList, String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            log.error(e.toString());
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

}
