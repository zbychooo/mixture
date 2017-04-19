package com.company.nongeneric;

public class NonGenericApp {

    public static void main(String[] args) {

        NonGenericSingleLinkable list = new NonGenericSinglyLinked();
        list.add("Hello String");
        list.add(40);
        list.add(3.14);
        list.add(new Tramway());


        for (int i = 0; i < list.size(); i++) {
                Object o = list.get(i);

                if(o instanceof String) {
                    String s = (String) list.get(i);
                } else if(o instanceof Integer) {
                    Integer number = (Integer) list.get(i);
                } else if(o instanceof Tramway) {
                    Tramway t = (Tramway) list.get(i);
                }



        }

    }
}

class Tramway{}
