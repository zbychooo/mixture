package com.company;

import java.util.Comparator;


public class Runner {

    public static void main(String[] args){
        Mappable<Term, Definition> m = new Dictionary<>(new TermComparator());
        m.put(new Term("zzz"), new Definition("dfdsfsfddgdf"));
        m.put(new Term("aaa"), new Definition("ff"));
        m.put(new Term("1111"), new Definition("ddd"));
    }

}

class Term{
    String term;

    public Term(String term) {
        this.term = term;
    }
}
class Definition{String value;

    public Definition(String value) {
        this.value = value;
    }
}

class TermComparator implements Comparator<Term> {

    @Override
    public int compare(Term o1, Term o2) {
        return o1.term.compareTo(o2.term);
    }
}

