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
    int x     = 0;
    int child = fork();
    if (child < 0) {
        printf("error\n");
    } else if (child == 0) {
        printf("hello\n");
        x += 1;
    } else {
        while (x != 1)
            ;
        printf("goodbye\n");
    }
}