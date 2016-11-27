# CASApiClientAndroid
Just Android Api cilent for CAS 2016 [Conferencia Agile Spain 2016]

CASApiClientAndroid is an Android library writing in Java for [CAS 2016 API]

Usage
-----
To start using the library just need to create valid CASApiClientConfiguration:
```java
CASApiConfig casApiConfig = new CASApiConfig.Builder().debug().build();
```
Once you have a valid CAS configuration, you can retrieve information from CAS API.

###Sessions Api
``SessionApiClient`` contains the operations used to retrieve sessions from the CAS Api.
```java
SessionApiClient sessionApiClient = new SessionApiClient(casApiConfig);
Collection<SessionDto> all = sessionApiClient.getAll();
```

###Speakers Api
``SpeakerApiClient`` contains the operations used to retrieve speakers from the CAS Api.
```java
SpeakerApiClient speakerApiClient = new SpeakerApiClient(casApiConfig);
Collection<SpeakerDto> all = speakerApiClient.getAll();
```

###Rooms Api
``RoomApiClient`` contains the operations used to retrieve rooms from the CAS Api.
```java
RoomApiClient roomApiClient = new RoomApiClient(casApiConfig);
Collection<RoomDto> all = roomApiClient.getAll();
```

###Tags Api
``TagApiClient`` contains the operations used to retrieve tags from the CAS Api.
```java
TagApiClient tagApiClient = new TagApiClient(casApiConfig);
Collection<TagDto> all = tagApiClient.getAll();
```


Adding it to your project
-----
Clone and add it like module (not available from jcenter or maven)


Libraries used
-----
* [OkHttp] [okHttp]
* [Retrofit] [retrofit]


Contribute
-----
Feel free to add new features, changes, etc. And use it to make an Android application for the Conference ;)


[okHttp]: https://github.com/square/okhttp
[retrofit]: https://github.com/square/retrofit
[Conferencia Agile Spain 2016]: http://cas2016.agile-spain.org/
[CAS 2016 API]: https://2016api.azurewebsites.net
