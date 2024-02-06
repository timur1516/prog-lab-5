package ru.timur.Controllers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ru.timur.Collection.Worker;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.JSON.LocalDateTimeDeserializer;
import ru.timur.JSON.LocalDateTimeSerializer;
import ru.timur.JSON.ZonedDateTimeDeserializer;
import ru.timur.JSON.ZonedDateTimeSerializer;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FileController {
    private final String fileName;
    private final Gson gson;
    public FileController(String fileName) throws FileNotFoundException {
        if(!isValidPath(fileName)){
            throw new FileNotFoundException();
        }
        this.fileName = fileName;

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        gsonBuilder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer());

        this.gson = gsonBuilder.setPrettyPrinting().create();
    }
    private  boolean isValidPath(String path){
        File f = new File(path);
        return f.exists() && !f.isDirectory();
    }
    public void writeToJSON(PriorityQueue<Worker> data) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName));
        Type dataType = new TypeToken<PriorityQueue<Worker>>(){}.getType();
        String output = this.gson.toJson(data, dataType);
        outputStreamWriter.write(output);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
    public PriorityQueue<Worker> readJSON() throws IOException, JsonParseException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
        Type dataType = new TypeToken<PriorityQueue<Worker>>(){}.getType();
        return this.gson.fromJson(new JsonReader(inputStreamReader), dataType);
    }
}
