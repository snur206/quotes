/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;



import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args)  throws IOException {
//        Gson gson = new Gson();
        // Get URL
        URL ronSwansonUrl = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");

        // Making a connection
        HttpURLConnection ronSwansonUrlConnection = (HttpURLConnection) ronSwansonUrl.openConnection();

        // Specifying GET method
        ronSwansonUrlConnection.setRequestMethod("GET");
        ronSwansonUrlConnection.connect();

        // Verify connection
        int code = ronSwansonUrlConnection.getResponseCode();
        System.out.println("Response code " + code);
        if(code == 200) {
            System.out.println("Working");
        } else {
            System.out.println("Broken");
        }


        // Reading from connection
        InputStreamReader ronSwansonInputStreamReader = new InputStreamReader(ronSwansonUrlConnection.getInputStream());
        BufferedReader ronSwansonBufferedReader = new BufferedReader(ronSwansonInputStreamReader);
        String ronSwansonQuote = ronSwansonBufferedReader.readLine();
        System.out.println(ronSwansonQuote);
        Gson gson = null;

        //GSON from JSON conversion
        gson = new GsonBuilder().setPrettyPrinting().create();

        String[] quotes = gson.fromJson(ronSwansonQuote, String[].class);
        RSAPI quote = new RSAPI(quotes[0]);

        // Writing to file
        File file = new File("app/src/main/resources/recentquotes.json");
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            gson.toJson(quote, fileWriter);
        }
    }

    public static void GrabQuote() throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File("app/src/main/resources/recentquotes.json");
        FileReader fileReader = new FileReader(file);
        Type collectionType = new TypeToken<Collection<Quotes>>(){}.getType();
        ArrayList<Quotes> quotesArrayList = gson.fromJson(fileReader, collectionType);
        int index =  new Random().nextInt(quotesArrayList.size());
        System.out.println(quotesArrayList.get(index).getAuthor());
        System.out.println(quotesArrayList.get(index).getText());
    }
//    if (GrabQuote();)
}