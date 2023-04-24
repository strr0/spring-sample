package com.strr.rabbit.model;

import java.io.Serializable;

public class Foo implements Serializable {
    private String foo;

    public Foo() {
    }

    public Foo(String foo) {
        this.foo = foo;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Foo [foo=" + this.foo + "]";
    }
}
