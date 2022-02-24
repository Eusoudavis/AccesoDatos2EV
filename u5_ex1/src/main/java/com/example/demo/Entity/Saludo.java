package com.example.demo.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Saludo implements Serializable {
    private static final long serialVersionUID = -786428861269832443L;
    private final long id;
    private final String contido;
}
