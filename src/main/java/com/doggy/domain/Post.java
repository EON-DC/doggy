package com.doggy.domain;

import com.doggy.share.NameValue;
import com.doggy.share.NameValueList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setValues(NameValueList nameValueList) {
        for (NameValue nameValue : nameValueList.getNameValueList()) {
            String name = nameValue.getName();
            String value = nameValue.getValue();
            switch (name) {
                case "title":
                    title = value;
                    break;
                case "body":
                    body = value;
                    break;
                default:
                    throw new RuntimeException("No such field name : " + name);
            }
        }
    }
}
