<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.5/styles/default.min.css">
        <link rel="stylesheet" href="css/prism.css">

        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
        <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/prism.js"></script>

        <style>
            body {
                padding-top: 40px;
                padding-bottom: 50px;
            }
            .lpa-sdk {
                padding: 40px 15px;
                text-align: center;
            }
            .input-group {
                margin-bottom:10px;
            }
            #go-home {
                cursor:pointer;
            }
            code, samp, kbd {
          	font-family: "Courier New", Courier, monospace, sans-serif;
          	text-align: left;
          	color: #555;
          	}
            pre code {
            	line-height: 1.6em;
            	font-size: 11px;
            	}
            pre {
            	padding: 0.1em 0.5em 0.3em 0.7em;
            	border-left: 11px solid #ccc;
            	margin: 1.7em 0 1.7em 0.3em;
            	overflow: auto;
            	width: 93%;
            	}
            /* target IE7 and IE6 */
            *:first-child+html pre {
            	padding-bottom: 2em;
            	overflow-y: hidden;
            	overflow: visible;
            	overflow-x: auto;
            	}
            * html pre {
            	padding-bottom: 2em;
            	overflow: visible;
            	overflow-x: auto;
            	}
            .jumbotroncolor {
                background:rgba(0, 153, 153, 0.3);
            }
            .jumbotroncodecolor {
                background:rgba(255, 204, 153, 0.4);
            }
            #wordwrap {
                 white-space: pre-wrap;      /* CSS3 */
                 white-space: -moz-pre-wrap; /* Firefox */
                 white-space: pre-wrap;     /* Opera <7 */
                 white-space: -o-pre-wrap;   /* Opera 7 */
                 word-wrap: break-word;      /* IE */
                 font-size: 15px !important;
            }
        </style></head>
        <%@ page import="java.io.IOException" %>
        <%@ page import="javax.servlet.ServletException" %>
        <%@ page import="javax.servlet.http.HttpServlet" %>
        <%@ page import="javax.servlet.http.HttpServletRequest" %>
        <%@ page import="javax.servlet.http.HttpServletResponse" %>
        <%@ page import="java.io.PrintWriter" %>
        <%@ page import="java.util.UUID" %>

        <%@ page import="com.amazon.pay.Client" %>
        <%@ page import="com.amazon.pay.Config" %>
        <%@ page import="com.amazon.pay.impl.PayClient" %>
        <%@ page import="com.amazon.pay.impl.PayConfig" %>
        <%@ page import="com.amazon.pay.types.Region" %>
        <%@ page import="com.amazon.pay.types.CurrencyCode" %>
        <%@ page import="com.amazon.pay.response.parser.*" %>
        <%@ page import="com.amazon.pay.request.*" %>
    <%@ page import="com.amazon.pay.exceptions.AmazonClientException" %>
    <%@ page import="com.amazon.pay.types.Environment" %>
    <%@ page import="com.amazon.pay.impl.PayConfiguration" %>

    <body>
<%

String consentToken = request.getParameter("consent_token");
String orderReferenceId = request.getParameter("oro_id");
String checkoutSessionId = request.getParameter("checkout_session_id");
String amount = "1.29";

Config configkey = new PayConfig()
      .withSellerId("A2Y3FXLHM8H7PR")
      .withAccessKey("AKIAJELS4TOLKNEDSBLA")
      .withSecretKey("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")
      .withSandboxMode(true)
      .withRegion(Region.US)
      .withCurrencyCode(CurrencyCode.USD);

    PayConfiguration payConfiguration = null;
    try {
        payConfiguration = new PayConfiguration()
                .setPublicKeyId("SANDBOX-AHQPTIXXJWXUV2PEQZF4RT2E")
                .setRegion(Region.NA)
                .setPrivateKey("-----BEGIN PRIVATE KEY-----\n" +
                        "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdgodoqgluYJGO\n" +
                        "cKtav21H5qkJ9w+kPN99dVoKjxf9BS2HvwTRZ8EhY7ypiEY5QqF/cE9C9ZrYy+eS\n" +
                        "o4gYK/2UgNx5Bo+Df+ofJs4k7g30ym22AjwM/uTfPYIdAv8lPoMuINYAgv7mr4ZN\n" +
                        "wXjwp8YDu/nR4AnuewZS6NI8V8v6a/9kwIJcvt2GL5FeYWahTYx7VfrZcTdrcVKc\n" +
                        "Fpvctgnd3UuiyFIJQd72zYQsz+fbrJdZDquhb2oJzDBoMnbV58/Eql/WEGcCvGMk\n" +
                        "OMkp3wSjG3DpGldnEfe14209Tyv66NB95Xn/L53dDVThmBUKte2QL9vZAqyScC4t\n" +
                        "EjpfXNVnAgMBAAECggEAMba6IGnSsjjemDOtkeXriw8deVy2XiMscv+wHLcPXjfd\n" +
                        "KAQ9dA6oYW6GZIfzii0ipgN/sOWuKxEolRryYJa54b5OWBCfCWU9MvnfhL5yPzoJ\n" +
                        "KLJJ29wzxtY2FAwXFd1GMDAC+4RdCdiKrk4LawG5OQKCliB9Yf0IgPClMpCPfAlN\n" +
                        "eR4H2uY8WiJYBvOgb23mJXVpn08AyOahAPc4d/gIds2KyclW97OsR6GIIu4cxW5U\n" +
                        "TpUt8/H0uRBefg1DO94OuJj8CN80kAFUbyE8w0mvWNlmYVBXiDSed7LT741YyDdB\n" +
                        "xQCkVpqyHrQZK3S/Tfx2yS4lXW2Mwl3p7mRUNPR6oQKBgQDMxt5XweeYDNfOeO6S\n" +
                        "LsFXhNIzdMnnbyHNWgvI4IqnsgGJNAVhVjvbLFkv0x0I6hkzD60igTfhY6s62ftq\n" +
                        "SSA2e4OH5euBJzHoJcn+KW341bI4OcxG/guhepmvh+Bp8lCpC3HVQbVmaGMiCnBt\n" +
                        "Cc7jH0//ELgcPIkEt1kMJ01NsQKBgQDE6N03YLvhQo64voR/iMI4tV9RXZdocSX/\n" +
                        "9bdK2GvIj5wgZoR0zS2+DDLc2m6YdHbeN52A8ZW4W88b6pGTqIxPVJDvpwkSLIG/\n" +
                        "9dXf/1v8iTjEHh/HghWjRN0O+l03g1pC5ON7dnZ7gc46H4TjdjGfQXmK1UAHh+5p\n" +
                        "IZZYw7qilwKBgDqseKS4gH1GoMceS21DTE6hVgE8Y2WWqB7IwDusas4l6N7BMxFy\n" +
                        "ve/Mwzk6ykT1nobM5RTP5Y0FG9jfAHSxwzMZLNTRgisdaeVUfo3+nO4BfPEzTl7B\n" +
                        "B+Aa2tI6ooh4z7e/+bva+fj/y/fC+fekKc1V+Xvh9H7SsYfSaQdcc3/hAoGBALJF\n" +
                        "uXJXrAHnRlvQcRkd8elxm9iIiXnPZv3zsnyasAqmqk1TQ3yT/mPfm3UEdbilSLEr\n" +
                        "XPfOwSRmSn4VwrMSl+WCxK2UZswDa30lzvq7sMZUXgaA13jDN1/YCuNynE6UJ3YE\n" +
                        "0EeJGv/6p4FL4/4jlg1/M9ET/KJU2O5psDqxChoFAoGATQ0D/BIIGIwj1hG/e7ug\n" +
                        "HFD0bZ6FBOIRWtbTZqTrOZ83NzlDk5leZ0UX9uW3xLu3im84jE1Ttk2PIS4moTaj\n" +
                        "A36hZHrsWe9lm3BwhyVEDiLqs/OanNUwU6K4dfvqX66JT3Ulpdaop31deB69D2tL\n" +
                        "Gbyx2i0TR0fSdQI2ml0fOlI=\n" +
                        "-----END PRIVATE KEY-----")
                .setEnvironment(Environment.SANDBOX);
    } catch (AmazonClientException e) {
        e.printStackTrace();
    }

    PayClient payClient = new PayClient(payConfiguration);

    String payload = "{\"storeId\":\"amzn1.application-oa2-client.456a4c3b15d24aae96256d2f82afdd73\",\"webCheckoutDetails\":{\"checkoutReviewReturnUrl\":\"http://localhost:8080/ApayMerchantWebsite_war_exploded/Widgets.jsp\",\"checkoutResultReturnUrl\":\"http://localhost:8080/ApayMerchantWebsite_war_exploded/index.jsp\"}}";
    String signature = payClient.generateButtonSignature(payload);

    System.out.println("<p>Calling generate button signature </p> "+signature);
%>
<div class="container">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand start-over" href="#">Amazon Pay JAVA SDK Simple Checkout</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a class="start-over" href=".">Start Over</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="jumbotron jumbotroncolor" style="padding-top:25px;" id="api-content">
        <div id="section-content">

<h2>Confirm</h2>
<p>Congratulations! You are now a proud owner of the official Amazon Pay
JAVA Software Development Kit!</p>
<p>Click <a href="https://github.com/amzn/amazon-pay-sdk-java" target="_blank">here</a> for Amazon Pay JAVA SDK to get the latest jar.</p>


<p>At this point we will make the <em>Confirm</em> API call to confirm the order
reference and a subsequent <em>Authorize</em> and <em>Capture</em> API call.
If you used a test account associated with your email address you should receive
an email.</p>

        </div>
        <%
        System.out.println("<pre><div id='wordwrap'><b>Order Reference ID</b> = <i>" + orderReferenceId + "</i><br /><b>Consent Token</b> = <i>" + consentToken + "</i>" +
                "<br /><b>Checkout Session Id </b> = <i>" + checkoutSessionId + "</div></n></pre>");
            System.out.println("</n>");
        %>
    </div>
    <div class="jumbotron jumbotroncodecolor" style="padding-top:25px;" id="api-calls">
    <h3>Code</h3>
<%
try {
            Client client = new PayClient(configkey);


    System.out.println("<p>Making a GetOrderReferenceDetails API Call. Usually you call GetOrderReferenceDetails before calling a SetOrderReferenceDetails to check Order details and also get a Zipcode/shipping_address to calculate shipping tax.</p>");

            final GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest  = new GetOrderReferenceDetailsRequest(checkoutSessionId);
//            getOrderReferenceDetailsRequest.setAccessToken(consentToken);
            final GetOrderReferenceDetailsResponseData responsOrderRef = payClient.getOrderReferenceDetails(getOrderReferenceDetailsRequest);
    System.out.println("<pre id='get'>" + responsOrderRef.toXML().replace("<", "&lt;").replace(">", "&gt;") + "</pre>");


            SetOrderReferenceDetailsRequest setOrderReferenceDetailsRequest = new SetOrderReferenceDetailsRequest(checkoutSessionId, amount);
            setOrderReferenceDetailsRequest.setCustomInformation("Java SDK OneTime Checkout Sample");
            setOrderReferenceDetailsRequest.setStoreName("Java Cosmos Store");
            setOrderReferenceDetailsRequest.setSellerNote("1st Amazon Pay OneTime Checkout Order");
//            client.setOrderReferenceDetails(setOrderReferenceDetailsRequest);
            final SetOrderReferenceDetailsResponseData setOrderReferenceDetailsResponseData = payClient.setOrderReferenceDetails(setOrderReferenceDetailsRequest);
    System.out.println("<pre id='set'>" + setOrderReferenceDetailsResponseData.toXML().replace("<", "&lt;").replace(">", "&gt;") + "</pre>");

            ConfirmOrderReferenceRequest confirmOrderReferenceRequest = new ConfirmOrderReferenceRequest(orderReferenceId);
            client.confirmOrderReference(confirmOrderReferenceRequest);


            String uniqueAuthorizationRefereneceId = UUID.randomUUID().toString().replace("-", "");
            AuthorizeRequest authorizeRequest = new AuthorizeRequest(orderReferenceId,
                    uniqueAuthorizationRefereneceId, amount);
            authorizeRequest.setTransactionTimeout("0");
            authorizeRequest.setCaptureNow(true);
            AuthorizeResponseData authResponse = client.authorize(authorizeRequest);

    System.out.println("<p>The <i>Authorize</i> API call will authorize the order reference.<br />The Capture API call will capture the funds for the given order reference id. If you want to make a separate <i>Capture</i> API call, you can set the <strong>CaptureNow</strong> parameter to <strong>false</strong> and then make a Capture call to collect funds.</p><pre id='confirm'>" + authResponse.toXML().replace("<", "&lt;").replace(">", "&gt;") + "</pre>");

    System.out.println("<p>To get <i>Amazon Authorization Id</i>, add the following code snippet.</p><pre>String amazonAuthorizationId = authResponse.getDetails().getAmazonAuthorizationId();<br /></pre>");


            final GetOrderReferenceDetailsRequest getOrderReferenceDetailsRequest2  = new GetOrderReferenceDetailsRequest(orderReferenceId);
            final GetOrderReferenceDetailsResponseData orderrefResponse_2 = client.getOrderReferenceDetails(getOrderReferenceDetailsRequest2);
    System.out.println("<pre id='confirm'>" + orderrefResponse_2.toXML().replace("<", "&lt;").replace(">", "&gt;") + "</pre>");

        } catch (Exception e) {
            e.printStackTrace();
    System.out.println(e.getMessage());
        }

%>
</div>
</div>
</body>
</body>
</html>
