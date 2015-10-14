# 分布式系统

### 未加载到文件

```
Caused by: org.xmlpull.v1.XmlPullParserException: caused by: org.xmlpull.v1.XmlPullParserException: resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available
	at org.xmlpull.v1.XmlPullParserFactory.newInstance(XmlPullParserFactory.java:294)
	at org.xmlpull.v1.XmlPullParserFactory.newInstance(XmlPullParserFactory.java:259)
	at test.TestLab$1.createParser(TestLab.java:30)
	... 3 more
```

解决方法：

[[xmlpull]XmlPull常见错误](http://www.cnblogs.com/zhengyun_ustc/archive/2005/09/28/xmlpullerror1.html)

```
下载的kxml2.jar加到你的项目中即可。这时候再调用

XmlPullParserFactory factory = XmlPullParserFactory.newInstance(

                            System.getProperty(XmlPullParserFactory.PROPERTY_NAME),

                   Thread.currentThread().getContextClassLoader().getClass() );

就通过了。
```

### java.util.ConcurrentModificationException

```
public static void removeUser(DSUsers dsUsers, DSUser user){
		List<DSUser> existedUsers = dsUsers.getUsers();
		String name = user.getName();
		for (DSUser dsUser : existedUsers) {
			if(dsUser.getName().equals(name)){
				existedUsers.remove(dsUser);
			}
		}
	}
```


解决方法：

```
在使用iterator.hasNext()操作迭代器的时候，如果此时迭代的对象发生改变，比如插入了新数据，或者有数据被删除。

则使用会报以下异常：
java.util.ConcurrentModificationException
        at java.util.HashMap$HashIterator.nextEntry(HashMap.java:793)
        at java.util.HashMap$KeyIterator.next(HashMap.java:828)
```

```
public static void removeUser(DSUsers dsUsers, DSUser user){
		List<DSUser> existedUsers = dsUsers.getUsers();
		String name = user.getName();
		for (DSUser dsUser : existedUsers) {
			if(dsUser.getName().equals(name)){
				existedUsers.remove(dsUser);
			}
		}
	}
```


### 第三方库

* [FasterXML/jackson-dataformat-xml](https://github.com/FasterXML/jackson-dataformat-xml)