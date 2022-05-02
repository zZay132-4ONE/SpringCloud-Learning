# SpringCloud - Learning

>- **TITLE:** SpringCloud - Learning
>- **AUTHOR:** ZZAY

# 1. Basics

> This section includes some basic introductions or scripts of the project.

- **Commons：**
  - [api-commons](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-api-commons)
- **Project Deployment：**
  - [SQL initializations](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/docs/sql)

# 2. Modules

> This section includes different modules which respectively use different tools.

- **Eureka - Service Registry & Service Discovery：**

  >Eureka is a REST based service which is primarily used for **acquiring information about services that you would want to communicate with**. 
  >
  >This REST service is also known as **Eureka Server**.
  >
  >The Services that register in Eureka Server to obtain information about each other are called **Eureka Clients**.

  - [Eureka Server 7001](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-eureka-server7001)
  - [Eureka Server 7002](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-eureka-server7002)
  - [payment-service Provider 8001 (Eureka)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-eureka-provider-payment8001)
  - [payment-service Provider 8002 (Eureka)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-eureka-provider-payment8002)
  - [order-service Consumer 80 (Eureka)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-eureka-consumer-order80)

- **Zookeeper - Service Registry & Service Discovery：**

  >ZooKeeper is an open source Apache project that provides a **centralized service for providing configuration information, naming, synchronization and group services over large clusters in distributed systems**. 
  >
  >The goal is to make these systems easier to manage with improved, more reliable propagation of changes.

  - [payment-service Provider 8004 (Zookeeper)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-zk-provider-payment8004)
  - [order-service Consumer 80 (Zookeeper)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-zk-consumer-order80)

- **Consul - Service Registry & Service Discovery：**

  >Consul provides many different features that are used to **provide consistent and available information about your infrastructure**. 
  >
  >This includes **service and node discovery mechanisms**, **a tagging system**, **health checks**, **consensus-based election routines**, **system-wide key/value storage**, and more.

  - [payment-service Provider 8006 (Consul)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-consul-provider-payment8006)
  - [order-service Consumer 80 (Consul)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-consul-consumer-order80)

- **OpenFeign - Declarative REST Web Service Client：**

  >OpenFeign, originally known as Feign and sponsored by Netflix, is designed to allow developers to use a **declarative way to build HTTP clients** by means of **creating annotated interfaces without writing any boilerplate code**.

  - [order-service Consumer 80 (OpenFeign)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-openfeign-consumer-order80)
  - [order-service Consumer 80 (OpenFeign + Hystrix)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-openfeign-hystrix-consumer-order80)

- **Hystrix - Service Degradation & Service Fusing：**

  > Hystrix helps by **providing protection and control over latency and failure from dependencies**, most commonly those accessed over network. 
  >
  > It helps stop cascading failures and allows you to fail fast and rapidly recover, or fallback and gracefully degrade.

  - [payment-service Provider 8001 (Eureka + Hystrix)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-hystrix-provider-payment8001)
  - [order-service Consumer 80 (Eureka + Hystrix)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-openfeign-hystrix-consumer-order80)
  - [hystrix-dashboard 9001 (Hystrix Dashboard)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-hystrix-consumer-dashboard9001)

- **Zuul - Gateway：**

  > Zuul is an edge service that **proxies requests to multiple backing services**. It provides a unified “front door” to your system, which allows a browser, mobile app, or other user interface to consume services from multiple hosts without managing cross-origin resource sharing (CORS) and authentication for each one.

  - [gateway 9527 (Zuul)](https://gitee.com/zzay0132/spring-cloud-learning/tree/master/cloud-zuul-gateway9527)
