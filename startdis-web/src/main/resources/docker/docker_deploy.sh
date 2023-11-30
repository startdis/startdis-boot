docker stop startdis-web
docker rm -f startdis-web
docker rmi startdis-web
docker build -t startdis-web .
docker images
docker run --restart=always -t -dit -p 18081:18081 --name startdis-web startdis-web
docker ps
