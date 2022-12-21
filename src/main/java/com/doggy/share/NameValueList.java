package com.doggy.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NameValueList {

    private List<NameValue> nameValueList = new ArrayList<>();

    public void add(NameValue nameValue) {
        nameValueList.add(nameValue);
    }


}
