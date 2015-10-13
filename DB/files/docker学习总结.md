# Docker入门学习总结

### 什么是docker
* docker的英文本意是码头工人，也就是搬运工，这种搬运工搬运的是集装箱（Container），集装箱里面装的可不是商品货物，而是任意类型的App，Docker把App（叫Payload）装在Container内，通过Linux Container技术的包装将App变成一种标准化的、可移植的、自管理的组件，这种组件可以在你的latop上开发、调试、运行，最终非常方便和一致地运行在production环境下。
* 号称"build once, configure once and run anywhere"

### docker的作用
* 对于运维来说，Docker提供了一种可移植的标准化部署过程，使得规模化、自动化、异构化的部署成为可能甚至是轻松简单的事情；而对于开发者来说，Docker提供了一种开发环境的管理方法，包括映像、构建、共享等功能，而后者是本文的主题。

### CentOs7下安装Docker

```
// 1. CentOS7 系统 CentOS-Extras 库中已带 Docker，可以直接安装
yum install docker

// 2. 安装之后启动 Docker 服务，并让它随系统启动自动加载。
service docker start

chkconfig docker on

// 3. 验证安装成功
docker info 

// 应该输出以下类似信息：
Containers: 3
Images: 5
Storage Driver: devicemapper
 Pool Name: docker-253:1-25307428-pool
 Pool Blocksize: 65.54 kB
 Backing Filesystem: xfs
 Data file: /dev/loop0
 Metadata file: /dev/loop1
 Data Space Used: 315.8 MB
 Data Space Total: 107.4 GB
 Data Space Available: 5.133 GB
 Metadata Space Used: 970.8 kB
 Metadata Space Total: 2.147 GB
 Metadata Space Available: 2.147 GB
 Udev Sync Supported: true
 Data loop file: /var/lib/docker/devicemapper/devicemapper/data
 Metadata loop file: /var/lib/docker/devicemapper/devicemapper/metadata
 Library Version: 1.02.93-RHEL7 (2015-01-28)
Execution Driver: native-0.2
Kernel Version: 3.10.0-123.el7.x86_64
Operating System: CentOS Linux 7 (Core)
CPUs: 1
Total Memory: 994.4 MiB
Name: localhost.localdomain
ID: PVZD:ODG4:5B3Z:MNBB:FRAU:7SWK:2QBO:PHQ3:F3J5:LN5U:7KMR:YT73
```
### 



### 参考资料
* [开发者可以使用Docker做什么？](http://dockone.io/article/378)
* [Docker Use Cases](http://rominirani.com/2015/04/09/docker-use-cases/)
* [利用Docker构建开发环境](http://tech.uc.cn/?p=2726)
* [Docker入门教程（一）介绍](http://dockone.io/article/101)
* [Docker Tutorials -- Part 1 : Docker Onboarding](https://www.youtube.com/watch?v=gNP9vJ3gMDo&feature=youtu.be)
* [CentOS install docker](https://docs.docker.com/installation/centos/)
* [Docker在PHP项目开发环境中的应用](http://dockone.io/article/481)

### 摘录
* 用户的核心诉求一直是比较简单的，降低信息技术（IT）的运营成本，提高资源利用率，提高安全性和可靠性等等