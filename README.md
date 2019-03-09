
1.分布式架构的搭建。
  1.1：测试，访问http://localhost:8080/item/562379 返回对应json字符串，成功。
  
2.工程改造为基于soa架构，实现商品列表。
   步骤
     服务层：
        第一步：把e3-manager的pom文件中删除e3-manager-web模块。
        第二步：把e3-manager-web文件夹移动到e3-manager同一级目录。
        第三步：e3-manager-service的pom文件修改打包方式
        <packaging>war</packaging>
        第四步：在e3-manager-service工程中添加web.xml文件
        第五步：把e3-manager-web的配置文件复制到e3-manager-service中。
        删除springmvc.xml
        第六步：web.xml 中只配置spring容器。删除前端控制器
        第七步：发布服务
            1、在e3-manager-Service工程中添加dubbo依赖的jar包。
            2、在spring的配置文件中添加dubbo的约束，然后使用dubbo:service发布服务。
     表现层：
        第一步：删除mybatis、和spring的配置文件。只保留springmvc.xml
        第二步：修改e3-manager-web的pom文件，
        1、修改parent为e3-parent
        2、添加spring和springmvc的jar包的依赖
        3、删除e3-mangager-service的依赖
        4、添加dubbo的依赖
