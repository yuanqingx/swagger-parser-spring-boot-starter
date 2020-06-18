package com.qing.swagger;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yuanqing
 * @since 2020/6/18
 */

public class ParserTest {
    private String path;
    private String content;

    @BeforeEach
    void setUp() throws IOException {
        path = getClass().getResource("/api-docs.json").getFile();
        content = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8.name());

    }

    @Test
    void parserRef() {
        JSONArray ref = JsonPath.read(content, "$..$ref");
        List<String> objs = new HashSet<>(ref).stream().map(o -> ((String) o).replace("#/definitions/", "")).collect(Collectors.toList());
        System.out.println("objects = " + objs);
    }

    @Test
    void listApi() {
        Map<String, Map> read = JsonPath.read(content, "$.paths");
        String api = "/swagger/scripts";
        Map list = read.get(api);

        String jsonPath = "$.." + api + ".post";
        Object post = JsonPath.read(content, jsonPath);
        System.out.println("post = " + post);
        if (Objects.nonNull(post)) {
            String tags = jsonPath + ".tags[0]";
            JSONArray t = JsonPath.read(content, tags);
            System.out.println("t = " + t.get(0));
        }
    }
}
