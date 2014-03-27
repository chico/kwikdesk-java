# KwikDesk Java Client Library

The KwikDesk Java client provides a simple interface to the [KwikDesk API](https://developer.kwikdesk.com).

## Requirements

Java 6 or later.

## Install

	mvn install
	mvn test
	
## Usage

	SearchResponse response = KwikDesk.api.search("#kwikdesk");
	KwikDesk.api.message("This is the message I want to post #kwikdesk");
