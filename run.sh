#!/usr/bin/env bash

# git pull
git pull origin master

# build
./gradlew build

# process kill
echo "check current process"
CURRENT_PID="\$(jps -l | grep begin-docker | awk '{print \$1}')"
if [ ! -z "\$CURRENT_PID" ]; then
    echo "  > begin-docker kill"
    kill '$CURRENT_PID'
    sleep 10
else
    echo "  > 현재 실행중인 프로세스가 없습니다."
fi

# run
nohup java -jar -Dspring.profiles.active=real ./build/libs/begin-docker.jar