#include <assert.h>
#include <fcntl.h>  // ! 有这个才能调用open函数!
#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h> /*提供类型pid_t,size_t的定义*/
#include <sys/wait.h>
#include <unistd.h>

int main() {
    int fd    = open("a.txt", O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);
    int child = fork();
    if (child < 0) {  // 打开失败
        printf("error\n");
    } else if (child == 0) {  // 子进程
        char buffer[30];
        sprintf(buffer, "hello world - 1\n");
        for (size_t i = 0; i < 100; i++) {
            write(fd, buffer, strlen(buffer));
        }
    } else {  // 父进程
        char buffer[30];
        sprintf(buffer, "hello world - 2\n");
        for (size_t i = 0; i < 100; i++) {
            write(fd, buffer, strlen(buffer));
        }
    }
    close(fd);
}