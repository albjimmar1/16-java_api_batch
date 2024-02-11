package com.example.batch.builders;

import java.util.List;

public class MarvelResponse {

    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private Data data;

    public MarvelResponse() {
    }

    public MarvelResponse(int code, String status, String copyright, String attributionText, String attributionHTML, Data data) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {

        private int offset;
        private int limit;
        private int total;
        private int count;
        private List<MarvelCharacter> results;

        public Data() {
        }

        public Data(int offset, int limit, int total, int count, List<MarvelCharacter> results) {
            this.offset = offset;
            this.limit = limit;
            this.total = total;
            this.count = count;
            this.results = results;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<MarvelCharacter> getResults() {
            return results;
        }

        public void setResults(List<MarvelCharacter> results) {
            this.results = results;
        }
    }
}
