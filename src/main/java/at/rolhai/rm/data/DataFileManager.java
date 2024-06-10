package at.rolhai.rm.data;

import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DataFileManager {

    @Inject
    Jsonb jsonb;

    public <T> List<T> loadFromFiles(File[] files, Class<T> type) throws IOException {
        if (files == null || files.length < 1) {
            return null;
        }
        List<T> resultList = new ArrayList<>();
        for (File file : files) {
            byte[] data =  Files.readAllBytes(Paths.get(file.toURI()));
            T result = jsonb.fromJson(new String(data, StandardCharsets.UTF_8), type);
            resultList.add(result);
        }
        return resultList;
    }

    public <T> T loadFromFile(String filepath, Class<T> type) throws IOException {
        if (StringUtil.isNullOrEmpty(filepath) || type == null) {
            return null;
        }
        byte[] data = Files.readAllBytes(Paths.get(filepath));
        return jsonb.fromJson(new String(data, StandardCharsets.UTF_8), type);
    }

    public void saveToFile(String filepath, Object data) throws IOException {
        if (StringUtil.isNullOrEmpty(filepath) || data == null) {
            return;
        }
        String json = jsonb.toJson(data);
        Files.write(Paths.get(filepath), json.getBytes(StandardCharsets.UTF_8));
    }
}
