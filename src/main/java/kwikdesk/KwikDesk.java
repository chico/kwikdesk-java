/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk;

import kwikdesk.api.Api;

/**
 * KwikDesk is the main interface to the KwikDesk API.<p>
 *
 */
public class KwikDesk {

  public final static String VERSION = "1.0.0";

  public final static Api api = new Api();

  public static final String API_BASE = "https://api.kwikdesk.com";

  protected KwikDesk() {}

}
