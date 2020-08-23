package com.sapient.pjp2.io;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.sapient.pjp2.session.SessionObject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONReaderWriter {
    private final File file;

    public JSONReaderWriter(String path) {
        this.file = new File(path);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(SessionObject sessionObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            append(mapper, sessionObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SessionObject> read() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(this.file, SessionObject[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void append(ObjectMapper mapper, SessionObject sessionObject) throws IOException {
        JsonNode root = mapper.readTree(this.file);
        if (root == null || root.isMissingNode()) {
//            root = mapper.createObjectNode();
            root = mapper.createArrayNode();
        }
//        JsonNode session_history = root.path("session_history");
//        if (session_history == null || session_history.isMissingNode()) {
//            session_history = mapper.createArrayNode();
//            ((ObjectNode) root).set("session_history", session_history);
//        }
        ((ArrayNode) root).addPOJO(sessionObject);
        mapper.writerWithDefaultPrettyPrinter().writeValue(this.file, root);
    }
}
