package itmo.soa.services;

public class UrlService {

    private static final String baseUrl = "http://localhost:8080/";
    private static final String dragonsUrl = baseUrl + "dragons/";
    private static final String cavesUrl = baseUrl + "caves/";

    public static String getFirstServiceUrlDragons(){
        return dragonsUrl;
    }

    public static String getFirstServiceUrlCaves(){
        return dragonsUrl;
    }


}
