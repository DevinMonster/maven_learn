package com.devin.servlet;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        request.rq_str = "req-->";
        response.rp_str = "rsp-->";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response);

        System.out.println(request.rq_str);
        System.out.println(response.rp_str);
    }
}

interface Filter {
    void doFilter(Request request, Response response,FilterChain filterChain);
}

class Request {
    String rq_str = "";
}

class Response {
    String rp_str = "";
}

class FilterChain{
    List<Filter> filters = new ArrayList<Filter>();
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index >= filters.size()) return;
        Filter filter = filters.get(index++);
        filter.doFilter(request, response,this);
    }
}

class HTMLFilter implements Filter{

    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.rq_str += "_htmlrq->";
        filterChain.doFilter(request, response);
        response.rp_str += "_htmlrp->";
    }
}

class SensitiveFilter implements Filter{

    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.rq_str += "_senrq->";
        filterChain.doFilter(request, response);
        response.rp_str += "_senrp->";
    }
}