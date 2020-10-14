# WebService

## 简介

Web Service技术，**能使得运行在不同机器上的不同应用无需借助附加，专门的软件或硬件， 就可相互交换数据或集成。**

**简单的说，WebService就是一种跨编程语言和跨操作系统平台的远程调用技术。**

## 原理

WebService 平台的三大技术：**XML、SOAP、WSDL**

* WebService采用**Http协议**来在客户端和服务端之间**传输**数据。WebService**使用XML来封装数据**，**XML主要的优点在于它是跨平台的**

* WebService通过HTTP协议发送请求和接收结果时，发送的请求内容和结果内容都采用XML格式封装，并增加了一些特定的HTTP消息头，以说明HTTP消息的内容格式，这些**特定的HTTP消息头和XML内容格式就是SOAP协议规定的**。

* WebService服务器端首先要通过一个WSDL文件来说明自己有什么服务可以对外调用。简单的说，**WSDL就像是一个说明书，用于描述WebService及其方法、参数和返回值**。 WSDL文件**保存在Web服务器上**，通过一个url地址就可以访问到它。客户端要调用一个WebService服务之前，要知道该服务的WSDL文件的地址。

  WebService服务提供商可以通过两种方式来**暴露它的WSDL文件地址**：

  1.注册到UDDI服务器，以便被人查找；

  2.直接告诉给客户端调用者。

WebService**交互的过程**就是,**WebService遵循SOAP协议通过XML封装数据，然后由Http协议来传输数据。**



## WSDL

**WSDL(Web Services Description Language), web服务描述语言，他是webservice服务端使用说明书，说明服务端接口、方法、参数和返回值，WSDL是随服务发布成功，自动生成，无需编写。**

文档结构

![这里写图片描述](https://img-blog.csdn.net/20170724161959032?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYzk5NDYzOTA0/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

**Service：相关端口的集合，包括其关联的接口、操作、消息等。**

**Binding：特定端口类型的具体协议和数据格式规范**

**portType: 服务端点，描述 web service可被执行的操作方法，以及相关的消息，通过binding指向portType**

**message: 定义一个操作（方法）的数据参数**

**types: 定义 web service 使用的全部数据类型**

阅读方式：**WSDL文档应该从下往上阅读**

1. 先看service标签，看相应port的binding属性，然后通过值查找上面的binding标签。

2. 通过binding标签可以获得具体协议等信息，然后查看binding的type属性

3. 通过binding的type属性，查找对应的portType，可以获得可操作的方法和参数、返回值等。

4. 通过portType下的operation标签的message属性，可以向上查找message获取具体的数据参数信息。

## SOAP

**SOAP即简单对象访问协议，他是使用http发送的XML格式的数据，它可以跨平台，跨防火墙，SOAP不是webservice的专有协议。**

**SOAP=http+xml**

**SOAP结构**

1. 必需的 Envelope 元素，可把此 XML 文档标识为一条 SOAP 消息
2. 可选的 Header 元素，包含头部信息
3. 必需的 Body 元素，包含所有的调用和响应信息
4. 可选的 Fault 元素，提供有关在处理此消息所发生错误的信息

```ping
<?xml version="1.0"?>
<soap:Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">

<soap:Header>
..
</soap:Header>

<soap:Body>
...
	<soap:Fault>
	...
	</soap:Fault>
</soap:Bdoy>

</soap:Envelop>
```

