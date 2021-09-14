package com.simple.spring.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class DemoModel {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("id")
    private int id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;

    public static DemoModel singletonDemoModel() {
        return DefaultDemoModel.getDefaultModel();
    }
    public static DemoModel prototypeDemoModel() {
        return DefaultDemoModel.get();
    }

    private static class DefaultDemoModel {

        static int id = 0;
        static int userId = 0;

        @Getter
        static final DemoModel defaultModel = get();

        public static DemoModel get() {
            return new DemoModel(id++, userId++, "some title " + id,
                    String.format("{'id':'%s';'userId':'%s'}", id, userId));
        }
    }
}
