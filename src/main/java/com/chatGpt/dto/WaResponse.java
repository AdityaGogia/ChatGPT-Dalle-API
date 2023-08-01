package com.chatGpt.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class WaResponse{
    public Object waResponse;


public class Img{
    public String src;
    public String alt;
    public String title;
    public int width;
    public int height;
    public String type;
    public String themes;
    public boolean colorinvertable;
    public String contenttype;
}

public class Infos{
    public ArrayList<Unit> units;
}

public class Microsources{
    public Object microsource;
}

public class Pod{
    public String title;
    public String scanner;
    public String id;
    public int position;
    public boolean error;
    public int numsubpods;
    public ArrayList<Subpod> subpods;
    public Object expressiontypes;
    public boolean primary;
    public ArrayList<State> states;
    public Infos infos;
}

public class Queryresult{
    public boolean success;
    public boolean error;
    public int numpods;
    public String datatypes;
    public String timedout;
    public String timedoutpods;
    public double timing;
    public double parsetiming;
    public boolean parsetimedout;
    public String recalculate;
    public String id;
    public String host;
    public String server;
    public String related;
    public String version;
    public String inputstring;
    public ArrayList<Pod> pods;
    public ArrayList<Source> sources;
}

public class Root{
    public Queryresult queryresult;
}

public class Source{
    public String url;
    public String text;
}

public class State{
    public String name;
    public String input;
}

public class Subpod{
    public String title;
    public Img img;
    public String plaintext;
    public Microsources microsources;
    public Datasources datasources;
}

public class Datasources{
    public Object datasource;
}

public class Unit{
    @JsonProperty("short") 
    public String myshort;
    @JsonProperty("long") 
    public String mylong;
    public String src;
    public String width;
    public String height;
}

}