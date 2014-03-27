/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.api;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import kwikdesk.TestUtils;
import kwikdesk.http.HttpClient;
import kwikdesk.utils.JsonUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ApiTest {

  private Api api = new Api();

  @Mock private HttpClient mockHttpClient;

  @Before
  public void setUp() {
    initMocks(this);
    api.setHttpClient(mockHttpClient);
  }

  @Test
  public void testSearch() {
    String q = "test";
    String url = format("%s?q=%s", Api.ApiPath.SEARCH, q);
    when(mockHttpClient.get(url)).thenReturn(TestUtils.readFromRawResourceFile("/search_response.json"));
    SearchResponse response = api.search(q);
    verify(mockHttpClient, times(1)).get(url);
    assertEquals(response.getError().intValue(), 0);
    assertEquals(response.getResults().size(), 1);
    assertEquals(response.getResults().get(0).getContent(), "The message that contains the search #term");
  }

  @Test
  public void testMessage() {
    Message message = new Message("test");
    String messageJSON = JsonUtils.toJson(message);
    when(mockHttpClient.post(Api.ApiPath.MESSAGES, messageJSON)).thenReturn(TestUtils.readFromRawResourceFile("/message_response.json"));
    MessageResponse response = api.message(message);
    verify(mockHttpClient, times(1)).post(Api.ApiPath.MESSAGES, messageJSON);
    assertEquals(response.getError().intValue(), 0);
  }

}
