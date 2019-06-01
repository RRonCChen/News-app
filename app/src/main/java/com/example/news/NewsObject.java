package com.example.news;

public class NewsObject {


    /**
     * source : {"id":null,"name":"Chinatimes.com"}
     * author : 蘇士亨
     * title : 台17直播主赴日遭性侵 日警方被爆冷處理吃案 - 中時電子報 Chinatimes.com
     * description : 一位台籍謝姓女直播主，在日本擁有84萬粉絲，人氣直逼線上偶像，不過卻驚爆遭當地黑道演員性侵，並且拍下性侵影片要脅，而這名演員是45歲藝名為「或布理萬」的演員馬場龍一，專門演出二線黑道角色，還曾與綜藝天王田村淳與男星江口洋介合作過。根據日媒報導，演員「或布理萬」去年與老婆參加萬聖節活動時，認識台籍謝姓女直播主，便藉談工作為由性侵得逞，除了拍下性侵過程，威脅販售給地下成人網站，還逼迫她搬家方便監控，並監一位台籍謝姓女直播主，在日本擁有84萬粉絲，人氣直逼線上偶像，不過卻驚爆遭當地黑道演員性侵，並且拍下性侵影片要脅，而…
     * url : https://www.chinatimes.com/realtimenews/20190528001517-260404
     * urlToImage : https://images.chinatimes.com/newsphoto/2019-05-28/900/20190528001776.jpg
     * publishedAt : 2019-05-28T02:18:52Z
     * content :
     */

    private SourceBean source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static class SourceBean {
        /**
         * id : null
         * name : Chinatimes.com
         */

        private Object id;
        private String name;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

