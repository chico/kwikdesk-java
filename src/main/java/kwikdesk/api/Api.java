/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.api;

import static java.lang.String.format;
import static kwikdesk.KwikDesk.API_BASE;
import static kwikdesk.utils.JsonUtils.fromJson;
import static kwikdesk.utils.JsonUtils.toJson;
import kwikdesk.http.HttpClient;
import kwikdesk.utils.Utils;

public class Api {

  public interface ApiPath {
    public static final String SEARCH = format("%s/search", API_BASE);
    public static final String MESSAGES = format("%s/messages", API_BASE);
  }

  protected HttpClient httpClient = HttpClient.DEFAULT;

  public Api() {
  }

  public SearchResponse search(String q) {
    return fromJson(httpClient.get(format("%s?q=%s", ApiPath.SEARCH, Utils.encode(q))), SearchResponse.class);
  }

  public MessageResponse message(Message message) {
    return fromJson(httpClient.post(ApiPath.MESSAGES, toJson(message)), MessageResponse.class);
  }

  protected void setHttpClient(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

}
