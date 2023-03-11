docker run -d --name mysql \
              -e MYSQL_ROOT_PASSWORD=root \
              -v /Users/seokgyuhwan/IdeaProjects/modernjavainaction/docker/setup/mysql-data:/var/lib/mysql \
              -v /Users/seokgyuhwan/IdeaProjects/modernjavainaction/docker/setup/mysql-init-files:/docker-entrypoint-initdb.d \
              -p 33066:3306 \
              --add-host=host.docker.internal:host-gateway \
              --restart unless-stopped mysql