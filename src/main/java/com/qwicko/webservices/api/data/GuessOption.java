package com.qwicko.webservices.api.data;

import lombok.Value;

@Value(staticConstructor = "of")
public class GuessOption {
    String value;
    String id;
}
